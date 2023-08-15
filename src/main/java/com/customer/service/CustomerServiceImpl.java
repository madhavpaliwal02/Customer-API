package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repo.CustomerRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public boolean createCustomer(Customer customer) {
		customerRepo.save(customer);
		return true;
	}

	@Override
	public List<Customer> getCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomer(String id) {
		return customerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer Not Found"));
	}

	@Override
	public boolean updateCustomer(String id, Customer customer) {
		Customer oldCust = getCustomer(id);
		deleteCustomer(id);
		customer.setId(id);
		customerRepo.save(customer);
		return true;
	}

	@Override
	public boolean deleteCustomer(String id) {
		customerRepo.deleteById(id);
		return true;
	}

}
