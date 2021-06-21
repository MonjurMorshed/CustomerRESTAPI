package com.example.customer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.customer.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	 
	EntityManager entityManager;
	
	@Autowired
	public CustomerDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	public List<Customer> findAllCustomers() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Customer> theQuery = session.createQuery("from Customer",Customer.class);
		
		List<Customer> result = theQuery.getResultList();
		
		return result;
	}

	@Override
	public Customer findById(int customerId) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public void deleteById(int customerId) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", customerId);
		theQuery.executeUpdate();
	}

}
