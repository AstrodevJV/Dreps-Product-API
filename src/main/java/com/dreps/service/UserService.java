package com.dreps.service;

import com.dreps.Model.UserModel;
import com.dreps.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public boolean login(String email, String password) {

        Optional<UserModel> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            UserModel userModel = user.get();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(password, userModel.getContrasena())) {
                return true;
            }
        }
        return false;
    }


}
