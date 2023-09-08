package com.example.ocp_be.repository;

import com.example.ocp_be.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {

    User save(User user);

    Optional<User> findById(long id);

    Optional<User> findByEmail(String email);

    void deleteById(long id);

}
