package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.customer.model.Customer;
import com.customer.model.User;
//import com.customer.model.User;
import com.customer.service.CustomerService;

@Controller
public class CustomerCtrl {

	@Autowired
	private CustomerService customerService;

	// Login Page
	@GetMapping("/")
	public String index() {
		return "index";
	}

	// Login
	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {
		if (user.getLogin_id().equals("admin") && user.getPassword().equals("admin")) {
			redirectAttributes.addFlashAttribute("msg", "Login Success");
			return "redirect:/home";
		}
		redirectAttributes.addFlashAttribute("msg", "Login Failure");
		return "index";
	}

	// All Customer
//	@GetMapping({ "/login", "home" })
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("customer", customerService.getCustomer());
		return "home";
	}

	@GetMapping("/add")
	public String addCustomer() {
		return "register";
	}

	// Create Customer
	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute Customer customer, RedirectAttributes requiredAttributes) {
		if (customerService.createCustomer(customer)) {
			requiredAttributes.addFlashAttribute("msg", "Successfully saved Customer");
			return "redirect:/home";
		}
		requiredAttributes.addFlashAttribute("msg", "Customer not saved ! Please try again");
		return "redirect:/register";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable String id, Model model) {
		model.addAttribute("customer", customerService.getCustomer(id));
		return "update";
	}

	// Update Customer
	@PostMapping("/updating/{id}")
	public String updateCustomer(@ModelAttribute Customer customer, @PathVariable String id,
			RedirectAttributes requiredAttributes) {
		if (customerService.updateCustomer(id, customer)) {
			requiredAttributes.addFlashAttribute("msg", "Update Successfully");
			return "redirect:/home";
		}
		requiredAttributes.addFlashAttribute("msg", "Customer not updated ! Please try again");
		return "redirect:/update/" + id;

	}

	// Delete Customer
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable String id, RedirectAttributes requiredAttributes) {
		// Delete from db
		if (customerService.deleteCustomer(id)) {
			requiredAttributes.addFlashAttribute("msg", "Successfully Deleted");
			return "redirect:/home";
		}
		requiredAttributes.addFlashAttribute("msg", "Customer not deleted ! Please try again");
		return "redirect:/home";
	}

}
