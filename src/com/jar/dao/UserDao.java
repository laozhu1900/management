package com.jar.dao;

import java.util.List;

import com.jar.domain.User;

public interface UserDao {

	
	//注册
	void add(User user);
	
	User find(String name, String password);

	// 查找注册的用户是否在数据库中存在
	boolean find(String name);

	
	
	//修改
	void delete(String name);

	void update(User user);

	User findUser(String name);

	List<User> getAll();
	
	
	
	//分页查询
//	public QueryResult pageQuery(int startindex,int pagesize);
	

	
}
