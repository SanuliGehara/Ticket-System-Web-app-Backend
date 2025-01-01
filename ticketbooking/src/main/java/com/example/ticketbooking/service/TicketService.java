package com.example.ticketbooking.service;

import com.example.ticketbooking.model.Ticket;
import com.example.ticketbooking.repository.TicketRepository;
import com.example.ticketbooking.utils.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketPool ticketPool;
    private final ConfigurationService configurationService;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ConfigurationService configurationService) {
        this.ticketRepository = ticketRepository;
        this.configurationService = configurationService;
        this.ticketPool = new TicketPool(5);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public boolean addTicket(Ticket ticket) {
        ticket.setAvailable(true); // Ensure the ticket is marked as available
        boolean added = ticketPool.addTicket(ticket);
        if (added) {
            ticketRepository.save(ticket);
        }
        return added;
    }

    public String purchaseTickets(int numberOfTickets) {
        List<Ticket> availableTickets = ticketRepository.findAvailableTickets();

        if (availableTickets.size() < numberOfTickets) {
            return "Not enough tickets available.";
        }

        int count = 0;
        for (Ticket ticket : availableTickets) {
            if (count >= numberOfTickets) {
                break;
            }

            ticket.setAvailable(false); // Mark ticket as unavailable
            ticket.setPrice(1000.00); // set price as 1000
            ticketRepository.save(ticket);
            count++;
        }

//        // Update totalTicketBooked in the configuration
//        configurationService.updateTotalTicketsBooked(count);

        return count + " tickets successfully purchased.";
    }


    public Ticket bookTicket() {
        Ticket ticket = ticketPool.removeTicket();

        if (ticket != null) {
            ticket.setAvailable(false);
            ticketRepository.save(ticket);
        }
        return ticket;
    }
//    public Ticket bookTicket() {
//        Ticket ticket = null;
//        boolean exit = false;
//        do {
//            ticket = ticketPool.removeTicket();
//
//            if (ticket != null && ticket.isAvailable()) {
//
//                ticket.setAvailable(false);
//                exit = true;
//            } else {
//
//            }
//            ticketRepository.save(ticket);
//
//        } while (exit);
//        return ticket;
//    }
}


