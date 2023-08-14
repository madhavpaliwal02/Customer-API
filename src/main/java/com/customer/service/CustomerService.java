package com.customer.service;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerService {
    /* Create a Customer */
    public Customer createCustomer(Customer customer);

    /* Get all Customers */
    public List<Customer> getAllCustomers();

    /* Get a Customer */
    public Customer getCustomer(String customerId);

    /* Update a Customer */
    public Customer updateCustomer(String customerId, Customer customer);

    /* Delete a Customer */
    public void deleteCustomer(String customerId);
}
