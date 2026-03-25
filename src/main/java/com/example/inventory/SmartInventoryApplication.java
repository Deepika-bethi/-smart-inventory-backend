package com.example.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  // ← ADD THIS!
public class SmartInventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartInventoryApplication.class, args);
    }
}
