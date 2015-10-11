package com.jar.service;

import java.util.List;

import com.jar.domain.Customer;
import com.jar.domain.User;
import com.jar.exception.UserExistException;

public interface UserService {

	
	//ע�����½
	User login(String name,String password);
	
	void register(User user) throws UserExistException;
	
	
	//�޸�
	void addUser(User user);
	
	void updateUser(User user);

	void deleteUser(String name);

	User findUser(String name);

	List<User> getAllUser();
	
	
//	public PageBean pageQuery(QueryInfo queryInfo);
	
}
