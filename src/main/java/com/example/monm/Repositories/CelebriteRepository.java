package com.example.monm.Repositories;

import com.example.monm.Models.Celebrite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CelebriteRepository extends JpaRepository<Celebrite, Integer> {
}