package com.shinhan.home.util.common;

import java.util.concurrent.TimeUnit;

import jakarta.servlet.http.HttpSession;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.shinhan.home.model.dto.ShinhanUserTbDTO;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class SessionUtil {

    private final RedisTemplate<String, Object> redisTemplate;

    public SessionUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean getSessionIdCheck(String userIdx, String sessionId) {
    	ShinhanUserTbDTO userInfo = (ShinhanUserTbDTO) redisTemplate.opsForValue().get("Shinhan-" + userIdx);
        if(userInfo != null) {
			// 회원 정보가 있으면 세션 아이디 비교 후 다르면 중복 아이디(ture)
			if(!userInfo.getSessionId().equals(sessionId)) {
				return true;
			}
		}
        return false;
    }

    public void chgUserInfo(String userIdx) {
    	ShinhanUserTbDTO userInfo = (ShinhanUserTbDTO) redisTemplate.opsForValue().get("Shinhan-" + userIdx);
    	HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    	if (userInfo != null) {
	        userInfo.setSessionId(session.getId());
	        redisTemplate.opsForValue().set("Shinhan-" + userIdx, userInfo, 10000, TimeUnit.HOURS);
    	}    
    }

    public boolean delUserInfo(String userIdx, String sessionId) {
    	ShinhanUserTbDTO userInfo = (ShinhanUserTbDTO) redisTemplate.opsForValue().get("Shinhan-" + userIdx);
        if(userInfo != null) {
			if(userInfo.getSessionId().equals(sessionId)) {
				redisTemplate.delete(userIdx);
				return true;
			}
		}
		return false;
    }

    public void setUserInfo(HttpSession session, ShinhanUserTbDTO input) {
    	session.setAttribute("userIdx", input.getUserIdx());
        session.setAttribute("name", input.getUserNm());

        ShinhanUserTbDTO redisUser = new ShinhanUserTbDTO();
        redisUser.setUserIdx(input.getUserIdx());
        redisUser.setSessionId(session.getId());

        redisTemplate.opsForValue().set("Shinhan-" + input.getUserIdx(), input, 120, TimeUnit.MINUTES);
    }

    public ShinhanUserTbDTO getUserInfo(String userIdx) {
        return (ShinhanUserTbDTO) redisTemplate.opsForValue().get("Shinhan-" + userIdx);
    }

    public String getSessionId(HttpSession session) {
        return (session != null) ? session.getId() : null;
    }

    public void setEmailKey(String key, String userIdx) {
        redisTemplate.opsForValue().set(key, userIdx, 1440, TimeUnit.MINUTES);
    }

    public boolean getEmailKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public void delEmailKey(String key) {
        redisTemplate.delete(key);
    }
}
