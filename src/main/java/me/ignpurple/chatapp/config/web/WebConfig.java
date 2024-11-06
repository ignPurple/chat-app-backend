package me.ignpurple.chatapp.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("https://chat.driftmc.net/", "http://192.168.0.10:3000") // Specific origin for security
            .allowedMethods("GET", "POST", "OPTIONS", "PUT")  // Allow needed HTTP methods
            .allowedHeaders("*") // Allow all headers
            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
            .allowCredentials(true)  // Allow credentials (cookies, headers)
            .maxAge(3600);  // Cache pre-flight response for 1 hour
    }
}