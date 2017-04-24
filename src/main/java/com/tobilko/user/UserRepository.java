package com.tobilko.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;
import java.util.List;

@RepositoryRestResource(
        path = "users",
        collectionResourceRel = "users"
)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Transactional
    @RestResource(path = "remove-by-login")
    List<User> removeByLogin(@Param("login") String login);

}
