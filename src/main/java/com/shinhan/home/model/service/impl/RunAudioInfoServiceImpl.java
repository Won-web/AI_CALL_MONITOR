package com.shinhan.home.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shinhan.home.model.dto.RunAudioInfoTbDTO;
import com.shinhan.home.model.dto.querydto.RunAudioInfoTbQueryDTO;
import com.shinhan.home.model.entity.RunAudioInfoTbEntity;
import com.shinhan.home.model.repository.RunAudioInfoRepository;
import com.shinhan.home.model.repository.custom.RunAudioInfoRepositoryCustom;
import com.shinhan.home.model.service.RunAudioInfoService;
import com.shinhan.home.util.ParseUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
 

@Service
@RequiredArgsConstructor
public class RunAudioInfoServiceImpl implements RunAudioInfoService {
	
	private final RunAudioInfoRepository runAudioInfoRepository; 
	private final RunAudioInfoRepositoryCustom runAudioInfoRepositoryCustom;

	@Override
	public List<RunAudioInfoTbDTO> getAllRunAudioInfo() {
		List<RunAudioInfoTbQueryDTO> runAudioInfoTbQueryDTOList = runAudioInfoRepository.findAll().stream()
		        .map(entity -> RunAudioInfoTbQueryDTO.builder()
		            .audioIdx(entity.getAudioIdx())
		            .audioId(entity.getAudioId())
		            .audioEncodedName(entity.getAudioEncodedName())
		            .audioExt(entity.getAudioExt())
		            .audioUrl(entity.getAudioUrl())
		            .audioContents(entity.getAudioContents())
		            .audioSurmmary(entity.getAudioSurmmary())
		            .regDt(entity.getRegDt())
		            .build())
		        .collect(Collectors.toList());

		List<RunAudioInfoTbDTO> runAudioInfoTbList = runAudioInfoTbQueryDTOList.stream()
		        .map(RunAudioInfoTbDTO::fromQueryDTO)
		        .collect(Collectors.toList());
		
		return runAudioInfoTbList;
	}
	
	@Override
	public RunAudioInfoTbDTO getRunAudioInfo(String audioIdxStr) {
		Integer audioIdx = ParseUtil.parseInt(audioIdxStr);
		RunAudioInfoTbQueryDTO queryDTO = runAudioInfoRepositoryCustom.findAudioInfo(audioIdx);
		RunAudioInfoTbDTO dto = RunAudioInfoTbDTO.fromQueryDTO(queryDTO);
		
		return dto;
	}

	@Override
	public int addAudioInfo(RunAudioInfoTbDTO dto) {
		try {
			RunAudioInfoTbQueryDTO queryDTO = RunAudioInfoTbQueryDTO.fromDTO(dto);
			queryDTO.setRegDt(LocalDateTime.now());
			RunAudioInfoTbEntity entity = queryDTO.toEntity();
			runAudioInfoRepository.save(entity);
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public void chgAudioInfo(RunAudioInfoTbDTO dto) {
		RunAudioInfoTbQueryDTO queryDTO = RunAudioInfoTbQueryDTO.fromDTO(dto);
		RunAudioInfoTbEntity entity = runAudioInfoRepository.findById(queryDTO.getAudioIdx())
				.orElseThrow(() -> new RuntimeException("해당 사용자가 없습니다."));
		
		entity.updateFromQueryDto(queryDTO);
	}

}
