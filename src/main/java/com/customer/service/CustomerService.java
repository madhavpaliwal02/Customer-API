package com.customer.service;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerService {

	public boolean createCustomer(Customer customer);

	public List<Customer> getCustomer();

	public Customer getCustomer(String id);

	public boolean updateCustomer(String id, Customer customer);

	public boolean deleteCustomer(String id);
}
