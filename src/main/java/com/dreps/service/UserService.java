package com.dreps.service;

import com.dreps.Model.UserModel;
import com.dreps.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserModel user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        userRepository.save(user);
    }

    public boolean Login(String email, String password) {
        Optional<UserModel> user = userRepository.findByEmail(email);
        if(user.isPresent()) {

        }

        return false;
    }

}
