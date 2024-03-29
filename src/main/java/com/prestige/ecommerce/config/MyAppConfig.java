package com.prestige.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    @Value("http://localhost:4200")
    private String[] theAllowedOrigins;

    @Value("/api")
    private String basePath;


}
