package com.example.inventory.controller;

import com.example.inventory.entity.Pro;
import com.example.inventory.repository.ProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "https://smart-inventory-frontend-lime.vercel.app")
@RestController
@RequestMapping("/api/pro")
public class ProController {

    private final ProRepository proRepository;

    @Autowired
    public ProController(ProRepository proRepository) {
        this.proRepository = proRepository;
    }

    @GetMapping
    public List<Pro> getAllPro() {
        return proRepository.findAll();
    }

    @PostMapping
    public Pro savePro(@RequestBody Pro pro) {
        return proRepository.save(pro);
    }

    // Add @GetMapping("/{id}"), @PutMapping, @DeleteMapping as needed
}
