package com.dreps.Controller;



import com.dreps.Model.UserModel;
import com.dreps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<Void> login(@RequestParam String email, @RequestParam String password) {
        boolean valid = userService.login(email, password);
        if (valid) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
