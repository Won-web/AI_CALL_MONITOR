package com.shinhan.home.model.service;

import com.shinhan.home.model.dto.RunVideoInfoTbDTO;

public interface RunVideoInfoService {
	
	RunVideoInfoTbDTO getRunVideoInfo(String videoIdx, String videoId);
	
	int addRunVideoInfo(RunVideoInfoTbDTO dto);

}
