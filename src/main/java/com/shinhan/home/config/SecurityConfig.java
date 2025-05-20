package com.shinhan.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // CSRF ?��?��?�� �? ?��?�� ???�� 방식?�� 쿠키�? ?��?��
            .csrf(csrf -> csrf
                .ignoringRequestMatchers(
                	"/run/user/login"
                ) 
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // JavaScript?��?�� ?��?�� ?��?�� ?�� ?���? ?��?��
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/run/user/login", "/assets/css/**", "/assets/js/**", "/assets/images/**").permitAll()
                .requestMatchers("/api/lecture/analyze").permitAll()
                .anyRequest().permitAll()
            )
            .formLogin().disable();

        return http.build();
    }
}
