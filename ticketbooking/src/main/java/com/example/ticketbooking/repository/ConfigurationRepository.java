package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigurationRepository extends MongoRepository<Configuration, String> {
}
