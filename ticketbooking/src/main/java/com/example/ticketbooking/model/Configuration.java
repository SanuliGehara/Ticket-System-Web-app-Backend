package com.example.ticketbooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "configuration")
public class Configuration {
    @Id
    private String id;

    private int maxTicketCapacity;
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int seatsPerRaw;
    private int totalTicketsPerVendor;  // Total tickets a vendor can release
    private int ticketSerial;
    private boolean isRunning;
    private int totalTicketBooked; //total tickets booked in the pool
    private double priceOfATicket;

    public Configuration() {
        this.maxTicketCapacity = 30;
        this.totalTickets = 20;
        this.seatsPerRaw = 6;
        this.ticketReleaseRate = 1000; //  1 second
        this.customerRetrievalRate = 1000;
        this.totalTicketsPerVendor = 8;
        this.ticketSerial = 0;
        this.isRunning = false;
        this.totalTicketBooked = 0;
        this.priceOfATicket = 1000.00;

    }

    public Configuration(int maxTicketCapacity, int ticketReleaseRate, int totalTickets, int customerRetrievalRate, int seatsPerRaw, int totalTicketsPerVendor, boolean isRunning) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
        this.customerRetrievalRate = customerRetrievalRate;
        this.seatsPerRaw = seatsPerRaw;
        this.totalTicketsPerVendor = totalTicketsPerVendor;
        this.ticketSerial = 0;
        this.isRunning = isRunning;
        this.totalTicketBooked = 0;
        this.priceOfATicket = 1000.00;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getSeatsPerRaw() {
        return seatsPerRaw;
    }

    public void setSeatsPerRaw(int seatsPerRaw) {
        this.seatsPerRaw = seatsPerRaw;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setTotalTicketsPerVendor(int totalTicketsPerVendor) {
        this.totalTicketsPerVendor = totalTicketsPerVendor;
    }

    public int getTotalTicketsPerVendor() {
        return totalTicketsPerVendor;
    }

    public int getTicketSerial() {
        return ticketSerial;
    }

    public void setTicketSerial(int ticketSerial) {
        this.ticketSerial = ticketSerial;
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public boolean isRunning() {
//        return isRunning;
//    }

    public int getTotalTicketBooked() {
        return totalTicketBooked;
    }

    public void setTotalTicketBooked(int totalTicketBooked) {
        this.totalTicketBooked = totalTicketBooked;
    }

    public double getPriceOfATicket() {
        return priceOfATicket;
    }

    public void setPriceOfATicket(double priceOfATicket) {
        this.priceOfATicket = priceOfATicket;
    }
}
