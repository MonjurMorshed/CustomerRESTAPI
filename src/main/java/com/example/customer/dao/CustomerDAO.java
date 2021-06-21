package com.example.customer.dao;

import java.util.List;

import com.example.customer.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAllCustomers();
	
	public Customer findById(int customerId);
	
	public void saveCustomer(Customer theCustomer);
	
	public void deleteById(int customerId);
	
}
