package com.aiapp.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUserName(String username);
    Boolean existsByUserName(String userName);
}
