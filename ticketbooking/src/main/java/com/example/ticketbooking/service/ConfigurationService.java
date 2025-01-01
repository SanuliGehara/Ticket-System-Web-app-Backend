package com.example.ticketbooking.service;

import com.example.ticketbooking.model.Configuration;
import com.example.ticketbooking.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfigurationService {
    private final ConfigurationRepository configurationRepository;
    private Configuration configuration;
//    private boolean isRunning = false;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
        // Load existing configuration if it exists
        this.configuration = configurationRepository.findAll().stream().findFirst().orElse(null);

    }

    // Retrieve the current configuration
    public Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration(); //Initialize new configuration
            System.out.println("No Configuration found! Starting from default configuration...");
        }
        return configuration;
    }

    // Set the configuration (can only be done once)
    public Configuration initializeConfiguration(Configuration newConfig) {
        if (configuration != null) {
            System.out.println("Delete last config");
            configurationRepository.deleteAll();
        }
        this.configuration = configurationRepository.save(newConfig);
//        System.out.println(configuration.getIsRunning());
        return this.configuration;
    }

    // Update totalTicketBooked for a purchase
    public Configuration updateTotalTicketsBooked(int ticketsBooked) {
        Optional<Configuration> optionalConfig = configurationRepository.findAll().stream().findFirst();

        if (optionalConfig.isEmpty()) {
            throw new RuntimeException("Configuration record not found!");
        }

        Configuration config = optionalConfig.get();
        config.setTotalTicketBooked(config.getTotalTicketBooked() + ticketsBooked);
        return configurationRepository.save(config);
    }

    // Update totalTickets in configuration for a release
    public Configuration updateTotalTickets(int ticketsReleased) {
        Optional<Configuration> optionalConfig = configurationRepository.findAll().stream().findFirst();

        if (optionalConfig.isEmpty()) {
            throw new RuntimeException("Configuration record not found!");
        }

        Configuration config = optionalConfig.get();
        config.setTotalTickets(config.getTotalTickets() + ticketsReleased);
        return configurationRepository.save(config);
    }

    // Start the application
    public String startApplication() {
        if (configuration.getIsRunning()) {
            return "Application is already running!";
        }
        configuration.setRunning(true);
        configurationRepository.save(configuration); // update the isRunning field in db

        System.out.println("Application started.");
        return "Application started successfully!";
    }

    // Stop the application
    public String stopApplication() {
        if (!configuration.getIsRunning()) {
            return "Application is not running!";
        }
        configuration.setRunning(false);
        configurationRepository.save(configuration);

        System.out.println("Application stopped.");
        return "Application stopped successfully!";
    }
}