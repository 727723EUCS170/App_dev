package com.example.giftapp.controller;

import com.example.giftapp.dto.LoginRequest;
import com.example.giftapp.dto.RegisterRequest;
import com.example.giftapp.model.User;
import com.example.giftapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // TODO: Implement authentication logic with JWT token generation
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (userService.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setName(registerRequest.getName());
        // Password hashing should be done here (e.g., BCrypt)
        user.setPasswordHash(registerRequest.getPassword());
        user.setRole(User.Role.APPLICANT);

        userService.save(user);

        return ResponseEntity.ok("Registration successful");
    }
}
