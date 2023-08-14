package com.customer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repo.CustomerRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setCustomerId(UUID.randomUUID().toString());
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomer(String customerId) {
        return getAllCustomers().stream().filter(cust -> cust.getCustomerId().equals(customerId))
                .findAny().orElseThrow(() -> new EntityNotFoundException("Customer Not Found"));
    }

    @Override
    public Customer updateCustomer(String customerId, Customer customer) {
        Customer old = getCustomer(customerId);
        customerRepo.delete(old);

        customer.setCustomerId(old.getCustomerId());
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(String customerId) {
        // Getting the customer
        Customer customer = getCustomer(customerId);

        // If no customer found
        if (customer == null)
            throw new EntityNotFoundException("No Customer found");

        // Deleting customer
        customerRepo.delete(customer);
    }

}
