package com.tobilko.settings.authentication;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(
        path = "authentication",
        collectionResourceRel = "authentication-configurations"
)
public interface AuthenticationConfigurationRepository extends PagingAndSortingRepository<AuthenticationConfiguration, Long> {

    Optional<AuthenticationConfiguration> findFirstBy();

}