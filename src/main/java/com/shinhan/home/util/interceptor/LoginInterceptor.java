package com.shinhan.home.util.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import com.shinhan.home.util.common.SessionUtil;
import com.shinhan.home.model.dto.ShinhanUserTbDTO;

public class LoginInterceptor implements HandlerInterceptor {

    private final SessionUtil sessionUtil;

    public LoginInterceptor(SessionUtil sessionUtil) {
        this.sessionUtil = sessionUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	//System.out.println("[Interceptor] 요청 URI: " + request.getRequestURI());
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/login");
            return false;
        }

        String sessionId = session.getId();
        String userIdx = (String) session.getAttribute("userIdx");
        if (userIdx == null || sessionUtil.getSessionIdCheck(userIdx, sessionId)) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
