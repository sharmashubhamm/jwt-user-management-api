package com.shubham.springbootjwtauthentication.service;

import com.shubham.springbootjwtauthentication.dto.JwtResponse;
import com.shubham.springbootjwtauthentication.dto.LoginRequest;
import com.shubham.springbootjwtauthentication.dto.RegisterRequest;
import com.shubham.springbootjwtauthentication.entity.Role;
import com.shubham.springbootjwtauthentication.entity.User;
import com.shubham.springbootjwtauthentication.repository.UserRepository;
import com.shubham.springbootjwtauthentication.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public JwtResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new JwtResponse(token);
    }
}