package com.tobilko.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@RequiredArgsConstructor
public class GlobalMVCConfiguration extends WebMvcConfigurerAdapter {

    private final GeneralConfiguration generalConfiguration;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        generalConfiguration.configureCORSRegistry(registry);
    }

}
