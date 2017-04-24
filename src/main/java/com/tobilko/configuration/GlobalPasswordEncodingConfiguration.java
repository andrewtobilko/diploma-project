package com.tobilko.configuration;

import com.tobilko.settings.ConfigurationState;
import com.tobilko.settings.encoding.PasswordEncodingConfiguration;
import com.tobilko.settings.encoding.PasswordEncodingConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class GlobalPasswordEncodingConfiguration {

    private final PasswordEncodingConfigurationRepository repository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return fetchPasswordEncoderFromConfiguration();
    }

    private PasswordEncoder fetchPasswordEncoderFromConfiguration() {
        Optional<PasswordEncodingConfiguration> optional = repository.findFirstBy();

        return optional
                .map(this::fetchPasswordEncoderFromConfigurationIfOptionEnabled)
                .orElseGet(this::getDefaultPasswordEncoder);
    }

    private PasswordEncoder fetchPasswordEncoderFromConfigurationIfOptionEnabled(PasswordEncodingConfiguration configuration) {
        ConfigurationState state = configuration.getState();

        return state.equals(ConfigurationState.ENABLED) ?
                configuration.getMethod().getINSTANCE() :
                getDefaultPasswordEncoder();
    }

    private PasswordEncoder getDefaultPasswordEncoder() {
        return new StandardPasswordEncoder();
    }

}
