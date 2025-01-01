package com.example.ticketbooking.controller;

import com.example.ticketbooking.model.Configuration;
import com.example.ticketbooking.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuration")

public class ConfigurationController {
    private final ConfigurationService configurationService;

    @Autowired
    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    // Retrieve the current configuration
    @GetMapping
    public Configuration getConfiguration() {
        return configurationService.getConfiguration();
    }

    // Set the initial configuration (allowed only once)
    @PostMapping("/initialize")
    public Configuration initializeConfiguration(@RequestBody Configuration newConfig) {
        return configurationService.initializeConfiguration(newConfig);
    }

    // Update total booked tickets, after a customer purchase ticket
    @PostMapping("/update")
    public Configuration updateTotalTicketsBooked(@RequestParam int numberOfTickets) {
        return configurationService.updateTotalTicketsBooked(numberOfTickets);
    }

    // Update total tickets, after a vendor release ticket
    @PostMapping("/updateRelease")
    public Configuration updateTotalTickets(@RequestParam int totalReleased) {
        return configurationService.updateTotalTickets(totalReleased);
    }

    // Start the application
    @PutMapping("/start")
    public String startApplication() {
        return configurationService.startApplication();
    }

    // Stop the application
    @PutMapping("/stop")
    public String stopApplication() {
        return configurationService.stopApplication();
    }
}
