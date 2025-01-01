package com.example.ticketbooking.service;

import com.example.ticketbooking.model.Ticket;

public class CustomerThread extends Thread {
    private final TicketService ticketService;

    public CustomerThread(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            Ticket ticket = ticketService.bookTicket();
            if (ticket != null) {
                System.out.println(ticket.getCustomerName() + " booked a ticket ");
            } else {
                System.out.println("No tickets available for booking.");
            }
        }
    }
}
