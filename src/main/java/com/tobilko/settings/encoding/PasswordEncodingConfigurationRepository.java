package com.tobilko.settings.encoding;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(
        path = "password-encoding",
        collectionResourceRel = "password-encoding-configurations"
)
public interface PasswordEncodingConfigurationRepository extends PagingAndSortingRepository<PasswordEncodingConfiguration, Long> {

    Optional<PasswordEncodingConfiguration> findFirstBy();

}
