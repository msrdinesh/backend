package com.example.demo;

import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Data;

@Data
public class UserData {
    private String name;
    private String mobile;

    // Getters and setters
}
