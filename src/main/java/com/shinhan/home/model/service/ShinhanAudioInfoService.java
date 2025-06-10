package com.shinhan.home.model.service;

import java.util.List;

import com.shinhan.home.model.dto.ShinhanAudioInfoTbDTO;

public interface ShinhanAudioInfoService {
	
	List<ShinhanAudioInfoTbDTO> getAllShinhanAudioInfo();
	
	ShinhanAudioInfoTbDTO getShinhanAudioInfo(String audioIdx);
	
	int addAudioInfo(ShinhanAudioInfoTbDTO dto);
	
	void chgAudioInfo(ShinhanAudioInfoTbDTO dto);
}
