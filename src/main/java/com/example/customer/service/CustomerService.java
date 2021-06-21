package com.example.customer.service;

import java.util.List;

import com.example.customer.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAllCustomers();
	
	public Customer findById(int customerId);
	
	public void saveCustomer(Customer theCustomer);
	
	public void deleteById(int customerId);
}
