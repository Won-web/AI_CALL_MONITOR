package com.shinhan.home.config;


import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@ControllerAdvice
public class GlobalModelAttributeConfig {

    @ModelAttribute
    public void addGlobalAttributes(HttpSession session, Model model) {
        String userNm = (String) session.getAttribute("name");
        String userIdx = (String) session.getAttribute("userIdx");
        if (userNm != null) {
            model.addAttribute("userNm", userNm);
        }
        if (userIdx != null) {
        	model.addAttribute("userIdx", userIdx);
        }
    }
}
