package com.example.monm.Services;

import com.example.monm.Models.User;
import com.example.monm.Repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
    public void updateUser(User user){
        userRepository.save(user);
    }


    public void getUserById(int id) {
    }
}
