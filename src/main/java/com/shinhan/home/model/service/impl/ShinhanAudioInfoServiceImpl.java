package com.shinhan.home.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shinhan.home.model.dto.ShinhanAudioInfoTbDTO;
import com.shinhan.home.model.dto.querydto.ShinhanAudioInfoTbQueryDTO;
import com.shinhan.home.model.entity.ShinhanAudioInfoTbEntity;
import com.shinhan.home.model.repository.ShinhanAudioInfoRepository;
import com.shinhan.home.model.repository.custom.ShinhanAudioInfoRepositoryCustom;
import com.shinhan.home.model.service.ShinhanAudioInfoService;
import com.shinhan.home.util.ParseUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
 

@Service
@RequiredArgsConstructor
public class ShinhanAudioInfoServiceImpl implements ShinhanAudioInfoService {
	
	private final ShinhanAudioInfoRepository ShinhanAudioInfoRepository; 
	private final ShinhanAudioInfoRepositoryCustom ShinhanAudioInfoRepositoryCustom;

	@Override
	public List<ShinhanAudioInfoTbDTO> getAllShinhanAudioInfo() {
		List<ShinhanAudioInfoTbQueryDTO> ShinhanAudioInfoTbQueryDTOList = ShinhanAudioInfoRepository.findAll().stream()
		        .map(entity -> ShinhanAudioInfoTbQueryDTO.builder()
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

		List<ShinhanAudioInfoTbDTO> ShinhanAudioInfoTbList = ShinhanAudioInfoTbQueryDTOList.stream()
		        .map(ShinhanAudioInfoTbDTO::fromQueryDTO)
		        .collect(Collectors.toList());
		
		return ShinhanAudioInfoTbList;
	}
	
	@Override
	public ShinhanAudioInfoTbDTO getShinhanAudioInfo(String audioIdxStr) {
		Integer audioIdx = ParseUtil.parseInt(audioIdxStr);
		ShinhanAudioInfoTbQueryDTO queryDTO = ShinhanAudioInfoRepositoryCustom.findAudioInfo(audioIdx);
		ShinhanAudioInfoTbDTO dto = ShinhanAudioInfoTbDTO.fromQueryDTO(queryDTO);
		
		return dto;
	}

	@Override
	public int addAudioInfo(ShinhanAudioInfoTbDTO dto) {
		try {
			ShinhanAudioInfoTbQueryDTO queryDTO = ShinhanAudioInfoTbQueryDTO.fromDTO(dto);
			queryDTO.setRegDt(LocalDateTime.now());
			ShinhanAudioInfoTbEntity entity = queryDTO.toEntity();
			ShinhanAudioInfoRepository.save(entity);
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public void chgAudioInfo(ShinhanAudioInfoTbDTO dto) {
		ShinhanAudioInfoTbQueryDTO queryDTO = ShinhanAudioInfoTbQueryDTO.fromDTO(dto);
		ShinhanAudioInfoTbEntity entity = ShinhanAudioInfoRepository.findById(queryDTO.getAudioIdx())
				.orElseThrow(() -> new RuntimeException("해당 사용자가 없습니다."));
		
		entity.updateFromQueryDto(queryDTO);
	}

}
