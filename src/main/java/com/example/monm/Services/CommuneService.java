package com.example.monm.Services;

import com.example.monm.Models.Commune;
import com.example.monm.Repositories.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommuneService {

    @Autowired
    private CommuneRepository communeRepository;

    public void addCommune(Commune commune) {
        Optional<Commune> existingCommune = communeRepository.findByCodeInsee(commune.getCodeInsee());
        if (existingCommune.isPresent()) {
            System.out.println("Commune already exists");
        }
        communeRepository.save(commune);
    }
    public Commune updateCommune(Commune commune){

        return communeRepository.save(commune);
    }


    public Optional<Commune> getCommuneById(Integer id) {

            return communeRepository.findById(id);

    }
}
