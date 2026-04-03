package com.example.CampusEase.controller;

import com.example.CampusEase.config.JwtUtil;
import com.example.CampusEase.model.User;
import com.example.CampusEase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user.getUsername(), user.getPassword(), user.getRole());
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existing = userService.findByUsername(user.getUsername());

        if (existing == null) {
            return "User not found!";
        }

        if (!passwordEncoder.matches(user.getPassword(), existing.getPassword())) {
            return "Invalid password!";
        }

        // Generate and return JWT token
        return jwtUtil.generateToken(existing.getUsername());
    }
}
