package com.tobilko.settings.cors;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "cors", collectionResourceRel = "cors-configurations")
public interface CORSConfigurationRepository extends PagingAndSortingRepository<CORSConfiguration, Long> {

    Optional<CORSConfiguration> findFirstBy();

}
