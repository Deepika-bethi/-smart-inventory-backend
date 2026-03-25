// // package com.example.inventory.entity;

// // import jakarta.persistence.*;

// // @Entity
// // @Table(name = "items")
// // public class Pro {
// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;
    
// //     private String name;
// //     private Double price;
// //     private Integer quantity;
// //     private String status;

// //     // Default constructor (REQUIRED)
// //     public Pro() {}

// //     // Getters & Setters (ALL REQUIRED)
// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }
    
// //     public String getName() { return name; }
// //     public void setName(String name) { this.name = name; }
    
// //     public Double getPrice() { return price; }
// //     public void setPrice(Double price) { this.price = price; }
    
// //     public Integer getQuantity() { return quantity; }
// //     public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
// //     public String getStatus() { return status; }
// //     public void setStatus(String status) { this.status = status; }
// // }

// package com.example.inventory.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "items")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Pro {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @Column(name = "name")
//     private String name;
    
//     @Column(name = "price")
//     private Double price;
    
//     @Column(name = "quantity")
//     private Integer quantity;
// }


package com.example.inventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Pro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Double price;
    private Integer quantity;
    
    // Default constructor
    public Pro() {}
    
    // Parameterized constructor
    public Pro(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
