package com.example.monm.Controllers;

import com.example.monm.Models.Commune;
import com.example.monm.Services.CommuneService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/commune")
public class CommuneController {


    @Autowired
    private CommuneService communeService;

    @GetMapping("/id")
    public Optional<Commune> getCommuneById(Integer id){
        try {
            return communeService.getCommuneById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @PostMapping("/add")
    public ResponseEntity<Commune> addCommune(@RequestBody Commune commune) {
        try {
            communeService.addCommune(commune);
            return new ResponseEntity<>(commune, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/update")
    public void updateCommune(Commune commune){
        try {
            communeService.updateCommune(commune);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
