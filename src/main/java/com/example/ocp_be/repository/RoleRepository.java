package com.example.ocp_be.repository;

import com.example.ocp_be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role save(Role role);

    Optional<Role> findByName(String name);

    void deleteById(Long id);

}
