package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByType(String type); // Fetch transactions by type
}
