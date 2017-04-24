package com.tobilko.settings.encoding;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordEncodingConfigurationService {

    private final PasswordEncodingConfigurationRepository repository;

    public void modifyPasswordEncodingConfiguration(PasswordEncodingConfiguration configuration) {
        repository.findFirstBy().ifPresent(settings -> {
            mergeConfigurations(settings, configuration);

            repository.save(settings);
        });
    }

    private void mergeConfigurations(PasswordEncodingConfiguration settings, PasswordEncodingConfiguration configuration) {
        settings.setMethod(configuration.getMethod());
        settings.setState(configuration.getState());
    }

}
