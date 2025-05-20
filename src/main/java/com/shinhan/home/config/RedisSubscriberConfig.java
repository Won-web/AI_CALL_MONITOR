package com.shinhan.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import lombok.RequiredArgsConstructor;
import com.shinhan.home.util.common.RedisMessageListener;

@Configuration
@RequiredArgsConstructor
public class RedisSubscriberConfig {
	
	private final RedisConnectionFactory connectionFactory;
    private final RedisMessageListener redisMessageListener;

    @Bean
    public RedisMessageListenerContainer redisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        MessageListenerAdapter adapter = new MessageListenerAdapter(redisMessageListener, "handleMessage");
        System.out.println("리스?�� ?��?�� ?��?��");
        container.addMessageListener(adapter, new ChannelTopic("ai_message"));

        return container;
    }

}
