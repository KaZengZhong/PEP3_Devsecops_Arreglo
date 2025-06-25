package com.prestabanco.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:5173",  // Puerto de Vite en desarrollo
                        "http://localhost:8070",  // Puerto de tu frontend
                        "http://host.docker.internal:8070",  // ← NUEVO: Para Docker
                        "*"  // ← NUEVO: Permite cualquier origen (solo desarrollo)
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(false);  // ← CAMBIADO: false para permitir wildcard
    }
}