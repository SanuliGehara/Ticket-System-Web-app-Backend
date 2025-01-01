package com.example.ticketbooking.model;

import com.example.ticketbooking.enums.UserType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer extends User{
    public Customer(String username, String email, String password) {
        super(username, email, password, UserType.CUSTOMER);
    }
}
