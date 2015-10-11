package com.jar.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jar.domain.User;
import com.jar.service.UserService;
import com.jar.service.impl.UserServiceImpl;
import com.jar.utils.WebUtils;


public class EditUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String name = request.getParameter("name");
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		UserService service = new UserServiceImpl();
		User user = service.findUser(name);
		
		
		
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/jsp/edituser.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	
		try{
			User user = WebUtils.request2Bean(request, User.class);
			UserService service = new UserServiceImpl();
			service.updateUser(user);
			request.setAttribute("message", "更新成功！！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "更新失败！！");
		}
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
	}
}
