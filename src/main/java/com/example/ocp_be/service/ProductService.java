package com.example.ocp_be.service;

import com.example.ocp_be.entity.Product;
import com.example.ocp_be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product searchProductById(Long id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    public List<Product> searchProductsByName(String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);

        return products;
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


}
