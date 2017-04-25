package com.tobilko.configuration.global.auth;

import com.tobilko.configuration.global.auth.provider.CustomAuthenticationProvider;
import com.tobilko.settings.authentication.AuthenticationConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class GlobalAuthenticationConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationConfigurationRepository repository;

    private final CustomAuthenticationProvider authProvider;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }

}
