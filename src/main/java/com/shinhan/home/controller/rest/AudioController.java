package com.shinhan.home.controller.rest;

import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.shinhan.home.model.dto.RunAudioInfoTbDTO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import com.shinhan.home.model.service.RunAudioInfoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/audio")
public class AudioController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final RunAudioInfoService runAudioInfoService;
	
	private final RestTemplate restTemplate = new RestTemplate();
    private final RedisTemplate<String, Object> redisTemplate;
    
    @Value("${ai.server.url}")
    private String aiServerUrl;
    
    @GetMapping("/getAudioList")
    @ResponseBody
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = Map.class))),
        @ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @ApiResponse(responseCode = "404", description = "데이터 없음"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public Map<String, Object> getAudioList() {
    	Map<String, Object> result = new HashMap<>();
    	
    	List<RunAudioInfoTbDTO> audioList = runAudioInfoService.getAllRunAudioInfo();
    	result.put("audioList", audioList);
    	return result;
    }
    
    @PostMapping("/analyzeAudio")
    @ResponseBody
    public Map<String, Object> analyzeAudio(@RequestBody Map<String, Object> input) {
    	Map<String, Object> result = new HashMap<>();

        // JSON에서 audioIdx 추출
        String audioIdxStr = String.valueOf(input.get("audioIdx"));
        String diarizationStr = String.valueOf(input.get("diarization"));
        RunAudioInfoTbDTO eDTO = runAudioInfoService.getRunAudioInfo(audioIdxStr);
        
        if(null != eDTO.getAudioUrl()) {
        	String audioUrl = eDTO.getAudioEncodedName() + eDTO.getAudioExt();
        	Map<String, Object> resultMap = sendToAiForAnalysis(audioUrl, diarizationStr);
        	if(null == resultMap) {
        		result.put("segments", null);
        		result.put("status", "failed");
                result.put("message", "분석 요청 수신 거부");
        	} else {
        		result.put("segments", resultMap.get("segments"));
            	result.put("status", "success");
                result.put("message", "분석 요청 수신 완료");
        	}
        	
        } else {
        	result.put("segments", null);
        	result.put("status", "failed");
            result.put("message", "파일이 존재하지 않습니다");
        }
        
        return result;
    }
    
//    @PostMapping("/llmCorrect")
//    @ResponseBody
//    public Map<String, Object> analyzeAudio() {
//    	
//    }
    
    
    public Map<String, Object> sendToAiForAnalysis(String audioUrl, String diarization) {
    	RestTemplate restTemplate = new RestTemplate();
        
        String serverIp = getLocalServerIp(); 
//        String fullAudioUrl = audioUrl.startsWith("http")
//            ? audioUrl
//            : serverIp + audioUrl;
        //String fullVideoUrl = "https://player.vimeo.com/external/995262239.m3u8?s=787252e6c02337bfa7576d40139cd60d363d8a0b&oauth2_token_id=1751054304";

        // 인코딩은 GET 요청할 경우에만 필요
        //String encodedUrl = URLEncoder.encode(audioUrl, StandardCharsets.UTF_8);
        // GET 요청을 보낼 경우 예:
        String diarizationUrl = "";
        if(diarization.equals("N")) {
        	diarizationUrl = "/analyzeAudioNoSpeaker?audio_url=";
        } else {
        	diarizationUrl = "/analyzeAudio?audio_url=";
        }
        String aiUrl = aiServerUrl + diarizationUrl + audioUrl;
        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(aiUrl, Map.class);
            Map<String, Object> responseBody = response.getBody();
            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    } 
    
    // 서버 런타임
    public String getLocalServerIp() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String hostAddress = inetAddress.getHostAddress(); // 예: 192.168.0.123
            // 로컬개발 시
            String port = ":18082";
            // 200번 서버에서 동작할 시
            if(hostAddress.contains("192.168.45.200")) {
            	hostAddress = "dev.skyand.co.kr";
            	port = ":8012";
            }
            return "http://" + hostAddress + port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "http://localhost:18082"; // fallback
        }
    }
}
