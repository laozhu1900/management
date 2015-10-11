package com.jar.service.impl;

import java.util.List;

import com.jar.dao.CustomerDao;
import com.jar.dao.UserDao;
import com.jar.domain.Customer;
import com.jar.factory.DaoFactory;
import com.jar.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerdao = DaoFactory.getInstance().createDao(
			CustomerDao.class);

	public void add(Customer c) {

		customerdao.add(c);
	}

	public void update(Customer c) {

		customerdao.update(c);
	}

	public void delete(String name) {

		customerdao.delete(name);
	}

	public Customer findCustomer(String name) {

		return customerdao.findCustomer(name);
	}

	public List<Customer> getAllCustomer() {
		return customerdao.getAll();
	}

	public List<Customer> getAllCustomerByType(String type) {

		return customerdao.getAllByType(type);
	}

	public List<Customer> getAllCustomerByLevel(String level) {

		return customerdao.getAllBytLevel(level);
	}

}
