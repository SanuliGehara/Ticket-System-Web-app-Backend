package com.example.ticketbooking.service;

import com.example.ticketbooking.model.Ticket;

public class VendorThread extends Thread {
    private final TicketService ticketService;

    public VendorThread(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            Ticket ticket = new Ticket("Customer", "Vendor", 100 + i);
            if (ticketService.addTicket(ticket)) {
                System.out.println(ticket.getVendorName()+ " added ticket " );
            } else {
                System.out.println("Pool full. Vendor could not add ticket.");
            }
        }
    }
}
