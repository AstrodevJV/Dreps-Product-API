package com.dreps.service;

import com.dreps.Model.UserModel;
import com.dreps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(UserModel user) {

        String encrypted = passwordEncoder.encode(user.getContrasena());
        user.setContrasena(encrypted);
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
