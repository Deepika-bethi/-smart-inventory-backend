package com.example.inventory.controller;

import com.example.inventory.entity.Pro;
import com.example.inventory.repository.ProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pro")
@CrossOrigin(origins = "*")
public class ProController {
    
    @Autowired
    private ProRepository proRepository;
    
    @GetMapping
    public List<Pro> getAllPro() {
        return proRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Pro> createPro(@RequestBody Pro pro) {
        System.out.println("1111111111111111111111111111111111111111111111111111111111111");
        Pro savedPro = proRepository.save(pro);
        System.out.println("1111111111111111111111111111111111111111111111111111111111111");
        return new ResponseEntity<>(savedPro, HttpStatus.CREATED);
    }
}
