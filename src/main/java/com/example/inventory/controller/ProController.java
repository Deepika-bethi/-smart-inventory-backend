package com.example.inventory.controller;

import com.example.inventory.entity.Pro;
import com.example.inventory.repository.ProRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:5174",
    "http://localhost:5175",
    "https://smart-inventory-frontend-lime.vercel.app"
})
@RestController
@RequestMapping("/api/pro")
public class ProController {

    private final ProRepository proRepository;

    public ProController(ProRepository proRepository) {
        this.proRepository = proRepository;
    }

    @GetMapping
    public List<Pro> getAllPro() {
        return proRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pro> getProById(@PathVariable Long id) {
        return proRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pro> savePro(@RequestBody Pro pro) {
        Pro saved = proRepository.save(pro);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pro> updatePro(@PathVariable Long id, @RequestBody Pro pro) {
        return proRepository.findById(id)
                .map(existing -> {
                    existing.setName(pro.getName());
                    Pro updated = proRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePro(@PathVariable Long id) {
        return proRepository.findById(id)
                .map(existing -> {
                    proRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}