package com.example.monm.Services;

import com.example.monm.Models.Celebrite;
import com.example.monm.Repositories.CelebriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CelebriteService {
    @Autowired
    private CelebriteRepository celebriteRepository;

    public void addCelebrite(Celebrite celibrite) {
        celebriteRepository.save(celibrite);
    }

    public ResponseEntity<? extends Object> updateCelebrite(Celebrite celebrite, Integer id) {

        Optional<Celebrite> optionalCelebrite = celebriteRepository.findById(id);
        if (!optionalCelebrite.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Celebrite existingCelebrite = optionalCelebrite.get();
        existingCelebrite.setNom(celebrite.getNom());
        existingCelebrite.setPrenom(celebrite.getPrenom());
        existingCelebrite.setNationalite(celebrite.getNationalite());
        celebriteRepository.save(existingCelebrite);

        return new ResponseEntity<>(existingCelebrite, HttpStatus.OK);

    }

    public Optional<Celebrite> getCelebriteById(int id) {
        return celebriteRepository.findById(id);

    }

    public void deleteCelebriteById(int id) {
        celebriteRepository.deleteById(id);
    }
}
