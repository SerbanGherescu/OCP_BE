package com.example.ocp_be.repository;

import com.example.ocp_be.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(long id);

    Optional<Product> findByName(String name);

    void deleteById(long id);

}
