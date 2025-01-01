package com.example.ticketbooking.controller;

import com.example.ticketbooking.model.Vendor;
import com.example.ticketbooking.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // Add new vendor to vendor table in sign up
    @PostMapping("/add")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }

    @PatchMapping("/{id}/updateTickets")
    public Vendor updateVendorTickets(@PathVariable String id,
                                      @RequestParam int totNumOfTicketReleased,
                                      @RequestParam String lastReleasedTime) {
        return vendorService.updateVendorTickets(id, totNumOfTicketReleased, lastReleasedTime);
    }
}

