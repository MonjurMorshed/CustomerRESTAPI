package com.example.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.customer.dao.CustomerDAO;
import com.example.customer.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO theCustomerDAO) {
		this.customerDAO = theCustomerDAO;
	}
	
	
	@Override
	@Transactional
	public List<Customer> findAllCustomers() {
		return this.customerDAO.findAllCustomers();
	}

	@Override
	@Transactional
	public Customer findById(int customerId) {
		return this.customerDAO.findById(customerId);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		this.customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int customerId) {
		this.customerDAO.deleteById(customerId);
	}

}
