package com.example.monm.Controllers;

import com.example.monm.Models.Monument;
import com.example.monm.Services.MonumentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/monument")
@AllArgsConstructor
@NoArgsConstructor
public class MonumentController {

    @Autowired
    private  MonumentService monumentService;
    //end point to add new monument
    @PostMapping(value ="/add",consumes = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED,reason = "monument added")
    public HttpServletResponse addMonument(@RequestBody Monument monument, HttpServletResponse response){
        try {
            System.out.println("monument for controller"+monument);
            monumentService.addMonument(monument);
            response.setStatus(201);
        }
        catch (Exception e){
            response.setStatus(400);
        }
        return response;

    }

    //end point to delete monument
    @DeleteMapping(value ="/delete",consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK,reason = "monument deleted")
    public void deleteMonument(@RequestBody Monument monument, HttpServletResponse response) {
        try {
            monumentService.deleteMonument(monument);
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(400);
        }


    }

    //end point to update monument
    @PutMapping(value ="/update",consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateMonument(@RequestBody Monument monument, HttpServletResponse response) {
        try {
            monumentService.updateMonument(monument);
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }

    @GetMapping(value ="/get/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Monument> getMonumentById(@PathVariable Integer id, HttpServletResponse response) {
        try {
            return monumentService.getMonumentById(id);
        } catch (Exception e) {
            response.setStatus(400);
        }
        return null;

    }}



