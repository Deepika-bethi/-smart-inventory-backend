package com.example.inventory.repository;

import com.example.inventory.entity.Pro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRepository extends JpaRepository<Pro, Long> {
}
