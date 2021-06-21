package com.example.customer.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerLoggingAspect {

	@Before("execution(* com.example.customer.dao.CustomerDAO.findAllCustomers())")
	public void beforeFindAllCustomer() {
		System.out.println("calling findAllCustomers functions from DAO");
	}
}
