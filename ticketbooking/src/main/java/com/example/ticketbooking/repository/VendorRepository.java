package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    Optional<Vendor> findByUsernameAndPassword(String username, String password);
}
