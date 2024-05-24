package com.aman.service;

import com.aman.dto.UserRegistrationRequest;
import com.aman.entity.Role;
import com.aman.entity.User;
import com.aman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(UserRegistrationRequest registrationRequest) {
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setName(registrationRequest.getName());
        user.setRole(Role.valueOf(registrationRequest.getRole() != null ? registrationRequest.getRole() : "CUSTOMER"));
        return userRepository.save(user);
    }

    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }
}