package com.example.ocp_be.repository;

import com.example.ocp_be.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository {

    Category save(Category category);

    Optional<Category> findByName(String name);

    void deleteByName(String name);

}
