package com.shinhan.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shinhan.home.util.common.SessionUtil;
import com.shinhan.home.util.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@Autowired
    private SessionUtil sessionUtil;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(sessionUtil))
            .addPathPatterns("/**")// ?���? 경로 감시
            .excludePathPatterns(
            	    "/", 
            	    "/login", 
            	    "/logout", 
            	    "/login/**",
            	    "/assets/**", 
            	    "/run/user/login",
            	    "/favicon.ico", 
            	    "/uploads/**",
            	    "/message/audio",
            	    "/api/upload/**",
            	    "/api/audio/**",
            	    "/error"
        	); // ?��?�� 경로
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/uploads/**")
	    		.addResourceLocations("file:" + uploadDir + "/");
	    registry.addResourceHandler("/assets/**") 
        .addResourceLocations("classpath:/static/assets/");
	}
}
