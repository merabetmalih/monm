package com.example.monm.Repositories;

import com.example.monm.Models.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommuneRepository extends JpaRepository<Commune, Integer> {

    Optional<Commune> findByCodeInsee(int codeInsee);

}