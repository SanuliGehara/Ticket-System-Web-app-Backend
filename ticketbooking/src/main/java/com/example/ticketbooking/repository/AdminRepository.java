package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {
}
