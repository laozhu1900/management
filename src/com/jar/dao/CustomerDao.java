package com.jar.dao;

import java.util.List;

import com.jar.domain.Customer;
import com.jar.domain.User;

public interface CustomerDao {

	void add(Customer c);

	void delete(String name);

	void update(Customer c);

	Customer findCustomer(String name);

	List<Customer> getAll();

	
	List<Customer> getAllByType(String type);
	
	List<Customer> getAllBytLevel(String level);
	
	

}
