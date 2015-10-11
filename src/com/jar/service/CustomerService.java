package com.jar.service;

import java.util.List;

import com.jar.domain.Customer;

public interface CustomerService {

	void add(Customer c);
	
	void update(Customer c);
	
	void delete(String name);
	
	Customer findCustomer(String name);
	
	List<Customer> getAllCustomer();
	
	List<Customer> getAllCustomerByType(String type);
	
	List<Customer> getAllCustomerByLevel(String level);
	
}
 