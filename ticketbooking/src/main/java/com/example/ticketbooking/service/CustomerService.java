package com.example.ticketbooking.service;

import com.example.ticketbooking.enums.UserType;
import com.example.ticketbooking.model.Customer;
import com.example.ticketbooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Add the logic for adding a customer (create account)
    public Customer addCustomer(Customer customer) {
        if(customer.getUserType().equals(UserType.CUSTOMER)) {
            return customerRepository.save(customer);
        }
        System.out.println("Customer cannot be added! Wrong user type selected");
        return null;//Exception handling needed
    }
}
