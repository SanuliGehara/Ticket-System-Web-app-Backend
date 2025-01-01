package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByUsernameAndPassword(String username, String password);
}
