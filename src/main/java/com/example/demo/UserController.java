package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private GoogleSheetsService googleSheetsService;

    @PostMapping("/submit")
    public String submitUserData(@RequestBody UserData userData) {
        boolean success = googleSheetsService.addToGoogleSheets(userData.getName(), userData.getMobile());
        if (success) {
            return "Data recorded successfully!";
        } else {
            return "An error occurred while recording data.";
        }
    }
}
