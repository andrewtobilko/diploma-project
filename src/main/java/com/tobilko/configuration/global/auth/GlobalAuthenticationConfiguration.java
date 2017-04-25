//package com.tobilko.configuration.global.auth;
//
//import com.tobilko.configuration.global.auth.provider.CustomAuthenticationProvider;
//import com.tobilko.settings.ConfigurationState;
//import com.tobilko.settings.authentication.AuthenticationConfigurationRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//@Configuration
//@RequiredArgsConstructor
//public class GlobalAuthenticationConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final AuthenticationConfigurationRepository repository;
//
//    private final CustomAuthenticationProvider authProvider;
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        if (isAuthenticationConfigurationEnabled()) {
//            auth.authenticationProvider(authProvider);
//        }
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                    .and()
//                .httpBasic();
//    }
//
//    private boolean isAuthenticationConfigurationEnabled() {
//        return repository
//                .findFirstBy()
//                .map(configuration -> configuration.getState().equals(ConfigurationState.ENABLED))
//                .orElse(false);
//    }
//
//}
