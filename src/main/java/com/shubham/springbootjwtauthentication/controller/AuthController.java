package com.shubham.springbootjwtauthentication.controller;

import com.shubham.springbootjwtauthentication.dto.JwtResponse;
import com.shubham.springbootjwtauthentication.dto.LoginRequest;
import com.shubham.springbootjwtauthentication.dto.RegisterRequest;
import com.shubham.springbootjwtauthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}