package com.example.ticketbooking.service;

import com.example.ticketbooking.repository.CustomerRepository;
import com.example.ticketbooking.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public boolean authenticateCustomer(String username, String password) {
        return customerRepository.findByUsernameAndPassword(username, password).isPresent();
    }

    public boolean authenticateVendor(String username, String password) {
        return vendorRepository.findByUsernameAndPassword(username, password).isPresent();
    }
}
