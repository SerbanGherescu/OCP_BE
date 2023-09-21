package com.example.ocp_be.repository;

import com.example.ocp_be.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);

    Optional<Product> findById(long id);

    List<Product> findByNameContainingIgnoreCase(String name);
//    Optional<Product> findByName(String name);

    void deleteById(long id);

}
