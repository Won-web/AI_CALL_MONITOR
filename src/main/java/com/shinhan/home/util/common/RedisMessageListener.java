package com.shinhan.home.util.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class RedisMessageListener implements MessageListener {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final RedisTemplate<String, Object> redisTemplate;
	
	@Lazy
	private final SimpMessagingTemplate messagingTemplate;
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
    public void onMessage(Message message, byte[] pattern) {
		String body = new String(message.getBody(), StandardCharsets.UTF_8);
	    
		try {
            JsonNode json = objectMapper.readTree(body);
            int userId = json.get("userId").asInt();
            String msgText = json.get("message").asText();
            
            // WebSocket 전송
            messagingTemplate.convertAndSend("/topic/ai/" + userId, body);

            // Redis에 캐싱
            String redisKey = "AI-MSG-" + userId;
            redisTemplate.opsForValue().set(redisKey, msgText);

            logger.info("AI 메시지 WebSocket 전달 완료: /topic/ai/{} → {}", userId, body);

        } catch (Exception e) {
        	logger.error("Redis 메시지 처리 중 오류", e);
        }
    }
}
