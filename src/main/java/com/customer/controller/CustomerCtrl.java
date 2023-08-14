package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.model.User;
import com.customer.repo.CustomerRepo;
import com.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerCtrl {

	private final CustomerService customerService;
	private final CustomerRepo customerRepo;

	@GetMapping
	public String home() {
		return "index";
	}

	// Admin login
	@PostMapping("/login")
	public String loginCustomer(@ModelAttribute User user, Model model) {
		if (user.getLogin_Id().equals("admin") &&
				user.getPassword().equals("admin")) {
			model.addAttribute("msg", "Successfully Login");

			// Get all customers
			List<Customer> list = customerService.getAllCustomers();
			model.addAttribute("customer", list);
			return "home";
		}
		model.addAttribute("msg", "Either Login Id or Password is incorrect");
		return "index";
	}

	@GetMapping("/add")
	public String addCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return "register";
	}

	@PostMapping("/signup")
	public String registerCustomer(@ModelAttribute Customer customer, Model model) {
		// Saving database
		customerService.createCustomer(customer);
		return "home";
	}

	@PutMapping("/{customerId}")
	public String updateCustomer(@PathVariable String customerId, @ModelAttribute Customer customer) {
		customerService.updateCustomer(customerId, customer);
		return "home";
	}

	@DeleteMapping("/{customerId}")
	public String deleteCustomer(@PathVariable String customerId) {
		// Delete from db
		customerService.deleteCustomer(customerId);
		return "home";
	}

}
