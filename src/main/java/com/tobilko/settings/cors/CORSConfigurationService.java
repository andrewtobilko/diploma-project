package com.tobilko.settings.cors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CORSConfigurationService {

    private final CORSConfigurationRepository repository;

    @Transactional
    public void putCORSConfiguration(CORSConfiguration update) {
        Optional<CORSConfiguration> optional = repository.findTopByEnabled(update.isEnabled());
        repository.save(optional.orElse(update));
    }

}
