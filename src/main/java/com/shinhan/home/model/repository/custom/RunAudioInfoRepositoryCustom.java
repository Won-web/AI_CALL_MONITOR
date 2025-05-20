package com.shinhan.home.model.repository.custom;

import com.shinhan.home.model.dto.querydto.RunAudioInfoTbQueryDTO;

public interface RunAudioInfoRepositoryCustom {
	
	RunAudioInfoTbQueryDTO findAudioInfo(Integer audioIdx);
}
