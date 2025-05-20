package com.shinhan.home.model.service;

import java.util.List;

import com.shinhan.home.model.dto.RunSubjectTbDTO;

public interface RunSubjectTbService {
	
	List<RunSubjectTbDTO> getLectureById(Integer lecIdx, Integer userIdx);
}
