package com.jar.dao;

import java.util.List;

import com.jar.domain.User;

public interface UserDao {

	
	//ע��
	void add(User user);
	
	User find(String name, String password);

	// ����ע����û��Ƿ������ݿ��д���
	boolean find(String name);

	
	
	//�޸�
	void delete(String name);

	void update(User user);

	User findUser(String name);

	List<User> getAll();
	
	
	
	//��ҳ��ѯ
//	public QueryResult pageQuery(int startindex,int pagesize);
	

	
}
