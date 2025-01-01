package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    @Query("{ 'isAvailable': true }")
    List<Ticket> findAvailableTickets(); // Fetch tickets where isAvailable = true
}
