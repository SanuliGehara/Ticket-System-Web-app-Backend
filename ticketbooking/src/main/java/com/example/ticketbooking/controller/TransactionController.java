package com.example.ticketbooking.controller;

import com.example.ticketbooking.model.Transaction;
import com.example.ticketbooking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/type/{type}")
    public List<Transaction> getTransactionsByType(@PathVariable String type) {
        return transactionService.getTransactionsByType(type);
    }

    @PostMapping("/add")
    public Transaction addTransaction(
            @RequestParam String type,
            @RequestParam String ticketId,
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String vendorId) {
        return transactionService.addTransaction(type, ticketId, customerId, vendorId);
    }
}
