package com.example.ocp_be.repository;

import com.example.ocp_be.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    Optional<Category> findByName(String name);

    void deleteByName(String name);

}
