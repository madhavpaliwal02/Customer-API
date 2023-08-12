package com.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.customer.model.Customer;
import com.customer.model.User;

@Controller
public class CustomerCtrl {

	@GetMapping
	public String home() {
		return "index";
	}

	@PostMapping("/login")
	public String loginUser(@ModelAttribute User user, Model model) {
		if (user.getLoginId().equals("admin") && user.getPassword().equals("admin")) {
			model.addAttribute("msg", "Successfully Login");

			// retrieving from db
			model.addAttribute("customer", "");
			return "home";
		}
		model.addAttribute("msg", "Either Email or Password is incorrect");
		return "index";
	}

	@GetMapping("/add")
	public String addCustomer() {
		return "register";
	}

	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute Customer customer, Model model) {

		// Validation
		model.addAttribute("customer", customer);

		// Saving database

		return "home";
	}

	@DeleteMapping("/${id}")
	public String deleteCustomer(@PathVariable int id) {
		// Delete from db
		return "home";
	}

}
