package com.jar.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jar.domain.User;
import com.jar.service.UserService;
import com.jar.service.impl.UserServiceImpl;


//处理用户分页请求
public class ListUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
//			QueryInfo info = WebUtils.request2Bean(request, QueryInfo.class);
			List<User> list = new ArrayList<User>();
			UserService service = new UserServiceImpl();
			list = service.getAllUser();
			request.setAttribute("list", list);
//			PageBean pagebean = service.pageQuery(info);
//			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("/jsp/listuser.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "查看客户失败！！");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
