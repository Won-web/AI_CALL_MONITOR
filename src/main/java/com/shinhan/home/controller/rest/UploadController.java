package com.shinhan.home.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.shinhan.home.util.ParseUtil;
import com.shinhan.home.util.encript.SHA256;
import com.shinhan.home.util.ssh.SSHUploader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import com.shinhan.home.model.dto.ShinhanAudioInfoTbDTO;
import com.shinhan.home.model.dto.querydto.ShinhanAudioInfoTbQueryDTO;
import com.shinhan.home.model.entity.ShinhanAudioInfoTbEntity;
import com.shinhan.home.model.repository.ShinhanAudioInfoRepository;
import com.shinhan.home.model.service.ShinhanAudioInfoService;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFileFormat;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {
	
	private final ShinhanAudioInfoService ShinhanAudioInfoService;
	
	@Value("${file.upload-dir}")
    private String uploadDir;
	
	@Value("${ssh.host}")
    private String sshHost;

    @Value("${ssh.port}")
    private int sshPort;

    @Value("${ssh.username}")
    private String sshUsername;

    @Value("${ssh.pem-path}")
    private String sshPemPath;

    @Value("${ssh.key-passphrase}")
    private String sshKeyPassphrase;

    @Value("${ssh.remote-dir}")
    private String sshRemoteDir;
	
	@PostMapping("/audio")
	public ResponseEntity<?> uploadAudio(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
	        return ResponseEntity.badRequest().body("파일이 비어 있습니다.");
	    }

		try {
	        String originalFileName = file.getOriginalFilename();
	        if (originalFileName == null || !originalFileName.contains(".")) {
	            return ResponseEntity.badRequest().body("유효하지 않은 파일명입니다.");
	        }

	        // 확장자 및 파일명 분리
	        String audioId = originalFileName.substring(0, originalFileName.lastIndexOf("."));
	        String audioExt = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();

	        Path audioDir = Paths.get(uploadDir, "audio");
	        Files.createDirectories(audioDir);

	        String audioEncodedName = SHA256.encrypt(originalFileName + System.currentTimeMillis());
	        String encodedFileName = audioEncodedName + audioExt;
	        Path tempPath = audioDir.resolve(encodedFileName);

	        // 1. 파일 저장
	        file.transferTo(tempPath.toFile());

	        File finalUploadFile = tempPath.toFile(); // EC2로 보낼 실제 파일
	        String finalAudioExt = audioExt;
	        // 2. mp3인 경우 wav로 변환
	        if (".mp3".equals(audioExt)) {
	            String wavFileName = audioEncodedName + ".wav";
	            Path wavPath = audioDir.resolve(wavFileName);
	            File wavFile = convertMp3ToWav(tempPath.toFile(), wavPath.toFile());

	            finalUploadFile = wavFile;
	            finalAudioExt = ".wav";
	        }

	        // 3. EC2 업로드
	        String remoteDir = sshRemoteDir + "/audio_path";
	        String audioUrl = remoteDir+ "/" + finalUploadFile.getName();
	        
	        try {
	        	// 1. 업로드
	            SSHUploader.upload(
	                finalUploadFile.getAbsolutePath(),
	                remoteDir,
	                sshHost,
	                sshPort,
	                sshUsername,
	                sshPemPath,
	                sshKeyPassphrase
	            );
	            // 2. .m4a인 경우 EC2에서 wav 변환
	            if (".m4a".equals(finalAudioExt)) {
	                String remoteM4a = remoteDir + "/" + finalUploadFile.getName();
	                String remoteWav = remoteDir + "/" + audioEncodedName + ".wav";
	                
	                String convertCommand = String.format("ffmpeg -y -i '%s' '%s'", remoteM4a, remoteWav);
	                SSHUploader.executeCommand(
	                    sshHost,
	                    sshPort,
	                    sshUsername,
	                    sshPemPath,
	                    sshKeyPassphrase,
	                    convertCommand
	                );
	                
	                // 2. 변환된 후 원본 m4a 삭제
	                String deleteCommand = String.format("rm -f '%s'", remoteM4a);
	                SSHUploader.executeCommand(
	                    sshHost,
	                    sshPort,
	                    sshUsername,
	                    sshPemPath,
	                    sshKeyPassphrase,
	                    deleteCommand
	                );

	                finalAudioExt = ".wav";
	                audioUrl = remoteWav;

	                finalAudioExt = ".wav";
	                audioUrl = remoteWav;
	            } 

	        } finally {
	            // 업로드 후 임시 파일 삭제
	            if (tempPath.toFile().exists()) {
	                tempPath.toFile().delete();
	            }

	            // mp3 → wav 변환된 경우, wav도 삭제
	            if (!tempPath.toFile().equals(finalUploadFile) && finalUploadFile.exists()) {
	                finalUploadFile.delete();
	            }
	        }

	        // 4. URL 및 DTO 저장

	        ShinhanAudioInfoTbDTO dto = ShinhanAudioInfoTbDTO.builder()
	                .audioId(audioId)
	                .audioExt(finalAudioExt)
	                .audioEncodedName(audioEncodedName)
	                .audioUrl(audioUrl)
	                .regDt(ParseUtil.formatDateTime(LocalDateTime.now()))
	                .build();

	        ShinhanAudioInfoService.addAudioInfo(dto);

	        return ResponseEntity.ok("파일 업로드 및 전송 완료");

	    } catch (Exception e) {
	        System.out.println("실패");
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 실패");
	    }
	}
	
	public File convertMp3ToWav(File mp3File, File wavFile) throws Exception {
	    try (AudioInputStream mp3Stream = AudioSystem.getAudioInputStream(mp3File)) {
	        AudioFormat baseFormat = mp3Stream.getFormat();
	        AudioFormat decodedFormat = new AudioFormat(
	            AudioFormat.Encoding.PCM_SIGNED,
	            baseFormat.getSampleRate(),
	            16,
	            baseFormat.getChannels(),
	            baseFormat.getChannels() * 2,
	            baseFormat.getSampleRate(),
	            false
	        );

	        try (AudioInputStream pcmStream = AudioSystem.getAudioInputStream(decodedFormat, mp3Stream)) {
	            AudioSystem.write(pcmStream, AudioFileFormat.Type.WAVE, wavFile);
	        }
	    }
	    return wavFile;
	}


}
