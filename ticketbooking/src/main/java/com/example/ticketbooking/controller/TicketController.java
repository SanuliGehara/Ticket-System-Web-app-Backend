package com.example.ticketbooking.controller;

import com.example.ticketbooking.model.Ticket;
import com.example.ticketbooking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping("/add")
    public boolean addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @PostMapping("/buy")
    public String buyTickets(@RequestParam int numberOfTickets) {
        return ticketService.purchaseTickets(numberOfTickets);
    }
    // should be patch
    @PutMapping("/book")
    public Ticket bookTicket() {
        return ticketService.bookTicket();
    }
}
