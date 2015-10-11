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

	// 对web层提供注册服务
	public void register(User user) throws UserExistException {

		// 先判断当前要注册的用户是否存在
		boolean b = userdao.find(user.getName());
		if (b) {
			throw new UserExistException(); // 发现要注册的用户已存在，则给web层抛一个编译时异常，提醒web层处理这个异常，给用户一个友好提示
		} else {
//			user.setPassword(ServiceUtils.md5(user.getPassword()));
			userdao.add(user);
		}
	}

	// 对webe层提供登陆服务 
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
		
		//调用dao获取到页面数据
		QueryResult qr = userdao.pageQuery(queryInfo.getStartindex(), queryInfo.getPagesize());
		
		//根据dao查询结果，生成页面显示需要pagebean
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

	// 对web层提供注册服务
	// public void register(User user) throws UserExistException{
	//
	// //先判断当前要注册的用户是否存在
	// boolean b = userdao.find(user.getName());
	// if(b){
	// throw new UserExistException();
	// //发现要注册的用户已存在，则给web层抛一个编译时异常，提醒web层处理这个异常，给用户一个友好提示
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
