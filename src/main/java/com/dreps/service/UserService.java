package com.dreps.service;

import com.dreps.Model.UserModel;
import com.dreps.repository.UserRepository;

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

}
