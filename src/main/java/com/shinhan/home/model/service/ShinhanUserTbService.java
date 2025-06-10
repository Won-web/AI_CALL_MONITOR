package com.shinhan.home.model.service;

import com.shinhan.home.model.dto.ShinhanUserTbDTO;

public interface ShinhanUserTbService {
	
    public ShinhanUserTbDTO getLoginUserByEmail(String emailId);
    
    public void chgRunUserTb(ShinhanUserTbDTO dto);
    
}