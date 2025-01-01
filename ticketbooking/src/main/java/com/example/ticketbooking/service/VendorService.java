package com.example.ticketbooking.service;

import com.example.ticketbooking.enums.UserType;
import com.example.ticketbooking.model.Vendor;
import com.example.ticketbooking.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Add the logic for adding a vendor (create account)
    public Vendor addVendor(Vendor vendor) {

        if(vendor.getUserType().equals(UserType.VENDOR)) {
            return vendorRepository.save(vendor);
        }
        System.out.println("Vendor cannot be added! Wrong user type selected");
        return null;//Exception handling needed(404 )
    }

    // Update the latest released time and number of tickets released
    public Vendor updateVendorTickets(String id, int totNumOfTicketReleased, String lastReleasedTime) {
        Optional<Vendor> optionalVendor = vendorRepository.findById(id); //check if vendor exists

        try{
            if (optionalVendor.isPresent()) {
                Vendor vendor = optionalVendor.get();
                // update values
                vendor.setTotNumOfTicketReleased(vendor.getTotNumOfTicketReleased() + totNumOfTicketReleased);
                vendor.setLastReleasedTime(lastReleasedTime);

                return vendorRepository.save(vendor); //save to database
            } else {
                throw new RuntimeException("Vendor not found with ID: " + id);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}