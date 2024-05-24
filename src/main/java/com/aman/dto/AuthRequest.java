package com.aman.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;

    // getters and setters
}

