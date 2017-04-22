package com.tobilko.settings.cors;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

public interface CORSConfigurationRepository extends PagingAndSortingRepository<CORSConfiguration, Long> {

    Optional<CORSConfiguration> findTopByEnabled(boolean enabled);

}
