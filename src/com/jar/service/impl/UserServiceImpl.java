package com.jar.service.impl;

import java.util.List;

import com.jar.dao.UserDao;
import com.jar.domain.User;
import com.jar.exception.UserExistException;
import com.jar.factory.DaoFactory;
import com.jar.service.UserService;
import com.jar.utils.ServiceUtils;

public class UserServiceImpl implements UserService {

	// private UserDao userdao =
	// DaoFactory.getInstance().createDao(UserDao.class);

	private UserDao userdao = DaoFactory.getInstance().createDao(UserDao.class);

	// ��web���ṩע�����
	public void register(User user) throws UserExistException {

		// ���жϵ�ǰҪע����û��Ƿ����
		boolean b = userdao.find(user.getName());
		if (b) {
			throw new UserExistException(); // ����Ҫע����û��Ѵ��ڣ����web����һ������ʱ�쳣������web�㴦������쳣�����û�һ���Ѻ���ʾ
		} else {
//			user.setPassword(ServiceUtils.md5(user.getPassword()));
			userdao.add(user);
		}
	}

	// ��webe���ṩ��½���� 
	public User login(String name, String password) { // aaa 123
//		password = ServiceUtils.md5(password);
		return userdao.find(name, password);
	}

	public void addUser(User user) {
		userdao.add(user);
	}

	public void updateUser(User user) {
		userdao.update(user);
	}

	public void deleteUser(String name) {
		userdao.delete(name);
	}

	public User findUser(String name) {
		return userdao.findUser(name);
	}

	public List<User> getAllUser() {
		return userdao.getAll();
	}

	
	/*
	public PageBean pageQuery(QueryInfo queryInfo){
		
		//����dao��ȡ��ҳ������
		QueryResult qr = userdao.pageQuery(queryInfo.getStartindex(), queryInfo.getPagesize());
		
		//����dao��ѯ���������ҳ����ʾ��Ҫpagebean
		PageBean bean = new PageBean();
		bean.setCurrentpage(queryInfo.getCurrentpage());
		bean.setList(qr.getList());
		bean.setPagesize(queryInfo.getPagesize());
		bean.setTotalrecord(qr.getTotalrecord());
		
		return bean;
	}

	 */
	
	// public User login(String name, String password) {
	//
	// return userdao.find(name, password);
	// }

	/*
	 * public User find(String id) {
	 * 
	 * return userdao.find(id); }
	 */

	// public void addUser(User user){
	// userdao.add(user);
	// }
	//
	// public User findUser(String name,String password){
	// return userdao.find(name, password);
	//
	// }
	//
	// public User findUser(String id){
	// return userdao.find(id);
	// }

	// ��web���ṩע�����
	// public void register(User user) throws UserExistException{
	//
	// //���жϵ�ǰҪע����û��Ƿ����
	// boolean b = userdao.find(user.getName());
	// if(b){
	// throw new UserExistException();
	// //����Ҫע����û��Ѵ��ڣ����web����һ������ʱ�쳣������web�㴦������쳣�����û�һ���Ѻ���ʾ
	// }else{
	// user.setPassword(ServiceUtils.md5(user.getPassword()));
	// userdao.add(user);
	// }
	// }
	//
	//
	// public void update(User user) {
	//
	// userdao.update(user);
	// }
	//
	// public void delete(String id) {
	//
	// userdao.delete(id);
	// }

}
