package com.shinhan.home.model.repository.custom;

import com.shinhan.home.model.dto.querydto.ShinhanAudioInfoTbQueryDTO;

public interface ShinhanAudioInfoRepositoryCustom {
	
	ShinhanAudioInfoTbQueryDTO findAudioInfo(Integer audioIdx);
}
