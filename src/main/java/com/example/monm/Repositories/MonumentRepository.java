package com.example.monm.Repositories;

import com.example.monm.Models.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, Integer> {
}