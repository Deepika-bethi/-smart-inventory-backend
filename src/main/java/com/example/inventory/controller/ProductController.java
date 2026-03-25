package com.example.inventory.controller;

import com.example.inventory.entity.Product;
import com.example.inventory.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private EntityManager entityManager;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    @Transactional
    public Product createProduct(@RequestBody Product product) {
        product.setStatus("OK");
        Product saved = productRepository.save(product);
        entityManager.flush();  // FORCE DB COMMIT!
        entityManager.refresh(saved);  // RELOAD FROM DB
        System.out.println("SAVED TO DB: " + saved.getName() + " ID: " + saved.getId());
        return saved;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        entityManager.flush();
        System.out.println("DELETED ID: " + id);
    }
}
