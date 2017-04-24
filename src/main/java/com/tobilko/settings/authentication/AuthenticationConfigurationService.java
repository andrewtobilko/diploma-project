package com.tobilko.settings.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationConfigurationService {

    private final AuthenticationConfigurationRepository repository;

    @Transactional
    public void putAuthenticationConfiguration(AuthenticationConfiguration update) {
        repository.findFirstBy().ifPresent(configuration -> {
            mergeConfigurations(configuration, update);

            repository.save(configuration);
        });
    }

    private void mergeConfigurations(AuthenticationConfiguration configuration, AuthenticationConfiguration update) {
        configuration.setState(update.getState());
    }

}
