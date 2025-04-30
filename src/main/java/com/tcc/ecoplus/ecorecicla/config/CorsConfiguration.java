package com.tcc.ecoplus.ecorecicla.config;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurations
public class CorsConfiguration implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping( "/**")
                .allowedOrigins("http://localhost:8686","http://localhost:5173")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","HEAD","PATCH","CONNECT");
    }
}
