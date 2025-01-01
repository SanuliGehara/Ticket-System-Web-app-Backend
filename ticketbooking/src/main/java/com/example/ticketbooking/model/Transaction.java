package com.example.ticketbooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String type; // "PURCHASE" or "RELEASE"
    private String ticketId;
    private String customerId; // Optional, only for PURCHASE
    private String vendorId;   // Optional, only for RELEASE
    private Date transactionDate;

    public Transaction() {}

    public Transaction(String type, String ticketId, String customerId, String vendorId, Date transactionDate) {
        this.type = type;
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.vendorId = vendorId;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
