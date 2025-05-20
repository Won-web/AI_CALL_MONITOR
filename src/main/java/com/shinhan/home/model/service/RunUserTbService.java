package com.shinhan.home.model.service;

import com.shinhan.home.model.dto.RunUserTbDTO;

public interface RunUserTbService {
	
    public RunUserTbDTO getLoginUserByEmail(String emailId);
    
    public void chgRunUserTb(RunUserTbDTO dto);
    
}