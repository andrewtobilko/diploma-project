package com.tobilko.settings.cors;

import com.tobilko.settings.ConfigurationState;
import com.tobilko.settings.ConfigurationURLStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

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

    @Transactional
    public void removeSpecificURLForActiveState(String url, ConfigurationState state) {
        repository.findFirstBy().ifPresent(configuration -> {
            ConfigurationURLStorage storage = configuration.getMap().get(state);

            // todo
            if (storage != null) {
                List<String> urls = storage.getUrls();
                if (urls != null) {
                    urls.remove(url);
                }
            }

            repository.save(configuration);
        });
    }

}
