package com.example.ticketbooking.utils;

import com.example.ticketbooking.model.Ticket;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketPool {
    private final ConcurrentLinkedQueue<Ticket> tickets = new ConcurrentLinkedQueue<>();
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized boolean addTicket(Ticket ticket) {
        if (tickets.size() >= maxCapacity) {
            return false;
        }
        tickets.add(ticket);
        return true;
    }

    public synchronized Ticket removeTicket() {
        return tickets.poll();
    }

    public int getTicketCount() {
        return tickets.size();
    }
}
