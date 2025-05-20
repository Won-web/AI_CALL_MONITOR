package com.shinhan.home.model.service;

import java.util.List;

import com.shinhan.home.model.dto.RunCategoryATbDTO;

public interface RunCategoryATbService {
	
	RunCategoryATbDTO getCategoryAById(Integer cateaIdx);
    List<RunCategoryATbDTO> getAllCategoryA();
    void addOrChgCategoryATb(RunCategoryATbDTO dto);

}
