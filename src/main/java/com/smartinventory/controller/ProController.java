package com.smartinventory.controller;

import com.example.inventory.entity.Pro;
import com.smartinventory.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pro")
@CrossOrigin(origins = "*")
public class ProController {

    @Autowired
    private ProService proService;

    @GetMapping
    public List<Pro> getAll() {
        return proService.findAll();
    }

    @PostMapping
    public Pro save(@RequestBody Pro pro) {
        return proService.save(pro);
    }
}
