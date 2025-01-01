package com.example.ticketbooking.controller;

import com.example.ticketbooking.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String userType,
                                        @RequestParam String username,
                                        @RequestParam String password) {
        boolean isAuthenticated = false;

        // Authenticate vendor and customer
        if ("CUSTOMER".equalsIgnoreCase(userType)) {
            isAuthenticated = authService.authenticateCustomer(username, password);
        } else if ("VENDOR".equalsIgnoreCase(userType)) {
            isAuthenticated = authService.authenticateVendor(username, password);
        }

        if (isAuthenticated) {
            return ResponseEntity.ok("/" + userType.toLowerCase() + "?"+ username);
        } else {
            return ResponseEntity.status(401).body("Wrong username or password");
        }
    }
}
