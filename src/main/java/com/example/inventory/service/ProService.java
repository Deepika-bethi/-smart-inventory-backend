package com.example.inventory.service;

import com.example.inventory.entity.Pro;
import com.example.inventory.repository.ProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProService {

    @Autowired
    private ProRepository proRepository;

    public List<Pro> findAll() {
        return proRepository.findAll();
    }

    public Pro save(Pro pro) {
        return proRepository.save(pro);
    }
}
