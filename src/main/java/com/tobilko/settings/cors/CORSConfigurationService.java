package com.tobilko.settings.cors;

import com.tobilko.settings.ConfigurationState;
import com.tobilko.settings.ConfigurationURLStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CORSConfigurationService {

    private final CORSConfigurationRepository repository;

    @Transactional
    public void putCORSConfiguration(CORSConfiguration update) {
        CORSConfiguration configuration = repository.findFirstBy().orElse(update);

        repository.save(configuration.equals(update) ? configuration : mergeEntityAndReturn(configuration, update));
    }

    private CORSConfiguration mergeEntityAndReturn(CORSConfiguration entity, CORSConfiguration with) {
        entity.setState(with.getState());
        mergeCORSConfigurationMaps(entity.getMap(), with.getMap());

        return entity;
    }

    private void mergeCORSConfigurationMaps(Map<ConfigurationState, ConfigurationURLStorage> map,
                                            Map<ConfigurationState, ConfigurationURLStorage> with) {
        for (ConfigurationState state : with.keySet()) {
            map.put(state, with.get(state));
        }
    }

}
