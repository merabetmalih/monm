package com.example.monm.Services;

import com.example.monm.Models.Monument;
import com.example.monm.Repositories.MonumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonumentService {
    @Autowired
    private MonumentRepository monumentRepository;


    public void addMonument(Monument monument){
        System.out.println("monument for service"+monument);
        monumentRepository.save(monument);
    }
    public void deleteMonument(Monument monument){
        monumentRepository.delete(monument);
    }
    public void updateMonument(Monument monument){
        monumentRepository.save(monument);
    }

    public Optional<Monument> getMonumentById(Integer id) {
        return monumentRepository.findById(id);
    }
}
