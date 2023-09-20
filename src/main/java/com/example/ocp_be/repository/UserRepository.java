package com.example.ocp_be.repository;

import com.example.ocp_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    void deleteById(Long id);

}
