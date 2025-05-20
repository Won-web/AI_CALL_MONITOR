package com.shinhan.home.model.service;

import java.util.List;

import com.shinhan.home.model.dto.RunAudioInfoTbDTO;

public interface RunAudioInfoService {
	
	List<RunAudioInfoTbDTO> getAllRunAudioInfo();
	
	RunAudioInfoTbDTO getRunAudioInfo(String audioIdx);
	
	int addAudioInfo(RunAudioInfoTbDTO dto);
	
	void chgAudioInfo(RunAudioInfoTbDTO dto);
}
