package com.example.monm.Controllers;

import com.example.monm.Models.Celebrite;
import com.example.monm.Services.CelebriteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/celebrite")

public class CelebriteController {

    @Autowired
     private  CelebriteService celebriteService;



    @GetMapping("/{id}")
    public Optional<Celebrite> getCelebriteById(@PathVariable Integer id){
        try {
            return celebriteService.getCelebriteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT ,reason = "celebrite deleted")

    public void deleteCelebriteById(@PathVariable Integer id){
        try {
            celebriteService.deleteCelebriteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @PostMapping(value="/add",consumes = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED ,reason = "celebrite added")
    public void addCelebrite(@RequestBody Celebrite celebrite){
        try {
            celebriteService.addCelebrite(celebrite);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   @PutMapping(value="/update/{id}",consumes = "application/json")
   @ResponseStatus(value = HttpStatus.CREATED ,reason = "celebrite updated")
   public ResponseEntity<?> updateCelebrite(@RequestBody Celebrite celebrite, @PathVariable Integer id){
    try {
       return celebriteService.updateCelebrite(celebrite, id);
    } catch (Exception e) {
        e.printStackTrace();
    }
       return null;
   }


}
