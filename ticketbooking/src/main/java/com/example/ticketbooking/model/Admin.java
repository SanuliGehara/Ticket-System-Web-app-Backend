package com.example.ticketbooking.model;

import com.example.ticketbooking.enums.UserType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
public class Admin extends User{
    public Admin(String username, String email, String password) {
        super(username, email, password, UserType.ADMIN);
    }
}
