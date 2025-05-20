package com.shinhan.home.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.shinhan.home.model.repository",        
    repositoryImplementationPostfix = "Impl"                 
)
public class JpaRepositoryConfig {
}
