package com.example.ocp_be.controller;

import com.example.ocp_be.entity.Product;
import com.example.ocp_be.entity.exceptions.ProductNotFoundException;
import com.example.ocp_be.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public String addProducts(@ModelAttribute Product product) {
        Product savedProduct = productService.saveProduct(product);
        return "homePage";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.searchProductById(id);
        if (id == null) {
            throw new ProductNotFoundException("You are not allowed to ask for this product");
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = productService.searchProductByName(name);
        if (name == null) {
            throw new ProductNotFoundException("You are not allowed to ask for this product");
        }
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "Product successfully deleted";
    }

}
