package com.example.ticketbooking.service;

import com.example.ticketbooking.model.Transaction;
import com.example.ticketbooking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByType(String type) {
        return transactionRepository.findByType(type);
    }

    public Transaction addTransaction(String type, String ticketId, String customerId, String vendorId) {
        Transaction transaction = new Transaction(type, ticketId, customerId, vendorId, new Date());
        return transactionRepository.save(transaction);
    }
}
