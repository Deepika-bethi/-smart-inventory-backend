package com.example.inventory.dto;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String status;

    public ProductDTO() {}

    public ProductDTO(Long id, String name, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = quantity < 5 ? "LOW STOCK" : "AVAILABLE";
    }

    // Getters & Setters
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
