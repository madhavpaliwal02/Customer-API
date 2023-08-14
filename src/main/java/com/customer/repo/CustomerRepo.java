package com.customer.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Optional<Customer> findCustomerByEmail(String email);
}
