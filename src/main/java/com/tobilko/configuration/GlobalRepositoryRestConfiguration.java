package com.tobilko.configuration;

import com.tobilko.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class GlobalRepositoryRestConfiguration extends RepositoryRestConfigurerAdapter {

    private final GeneralConfiguration generalConfiguration;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        generalConfiguration.configureCORSRegistry(config.getCorsRegistry());
        config.exposeIdsFor(User.class);
    }

}