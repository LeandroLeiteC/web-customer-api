package com.qintess.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.webapi.entity.Customer;
import com.qintess.webapi.exception.CustomerNotFoundException;
import com.qintess.webapi.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	CustomerService cService;

	@GetMapping("")
	public List<Customer> getCustomers() {
		return cService.getCustomers();
	}

	@GetMapping("{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = cService.getCustomer(customerId);

		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException("Customer not found for id=" + customerId);
		}
	}

	@PostMapping("")
	public Customer insertCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		cService.salvarOuAlterar(customer);
		return customer;
	}

	@PutMapping("")
	public Customer updateCustomer(@RequestBody Customer customer) {
		cService.salvarOuAlterar(customer);
		return customer;
	}

	@DeleteMapping("{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer customer = cService.getCustomer(customerId);
		
		if(customer != null) {
			cService.deletar(customerId);
			return "Customer delete id=" + customerId;
		}else {
			throw new CustomerNotFoundException("Customer to delete not found id=" + customerId);
		}
	}
}
