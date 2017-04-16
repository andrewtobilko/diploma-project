package com.tobilko.settings.cors;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cors")
public interface CORSConfigurationRepository extends PagingAndSortingRepository<CORSConfiguration, Long> {}
