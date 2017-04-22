package com.tobilko.configuration;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Service
public class GeneralConfiguration {

    public void configureCORSRegistry(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*");
    }

}
