package com.example.ocp_be.repository;

import com.example.ocp_be.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository {

    Role save(Role role);

    Optional<Role> findById(long id);

    void deleteById(long id);

}
