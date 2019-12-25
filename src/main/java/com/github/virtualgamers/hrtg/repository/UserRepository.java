package com.github.virtualgamers.hrtg.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.github.virtualgamers.hrtg.model.User;

public interface UserRepository extends CrudRepository<User, String> {

    /**
     * @return {@link User} by username
     */
    Optional<User> findByUsername(String username);
}
