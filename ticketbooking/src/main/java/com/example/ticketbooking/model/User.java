package com.example.ticketbooking.model;

import com.example.ticketbooking.enums.UserType;
import org.springframework.data.annotation.Id;

public abstract class User{
    private final String username;
    @Id
    private final String email; //Should be unique;
    private final String password;
    private final UserType userType;

    public User(String username, String email, String password, UserType userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }
}

