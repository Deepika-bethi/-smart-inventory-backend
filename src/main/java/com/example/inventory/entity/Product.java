// package com.example.inventory.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "products")
// public class Product {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     private String name;
//     private Double price;
//     private Integer quantity;
//     private String status;
    
//     @Column(name = "created_at")
//     private LocalDateTime createdAt;
    
//     @Column(name = "updated_at")
//     private LocalDateTime updatedAt;

//     public Product() {}

//     // GETTERS & SETTERS
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
    
//     public Double getPrice() { return price; }
//     public void setPrice(Double price) { this.price = price; }
    
//     public Integer getQuantity() { return quantity; }
//     public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }
// }

package com.example.inventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")   // <== changed from products to items
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Double price;
    private Integer quantity;
    private String status;

    // Default constructor (REQUIRED)
    public Product() {}

    // Getters & Setters (ALL REQUIRED)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
