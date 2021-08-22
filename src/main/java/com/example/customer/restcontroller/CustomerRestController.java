package com.example.customer.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entity.Customer;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService thecustomerService) {
		this.customerService = thecustomerService;
	} 
	
	@GetMapping
	public List<Customer> findAll(){
		return this.customerService.findAllCustomers();
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		Customer customer = this.customerService.findById(customerId);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer id is not found");
		}
		return customer;
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		this.customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		this.customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity deleteCustomerById(@PathVariable int customerId) {
		Customer cust = this.customerService.findById(customerId);
		if(cust == null) {
			throw new CustomerNotFoundException("Customer has not been found by id = "+customerId);
		}
		this.customerService.deleteById(customerId);
		return new ResponseEntity(HttpStatus.OK);
	}
}
