package com.example.monm.Controllers;

import com.example.monm.Models.User;
import com.example.monm.Services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {

    private UserService userService;


    @GetMapping("/id")
    public void getUserById(int id){
        try {
            userService.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/add")
    public void addUser(User user){
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
