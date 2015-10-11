package com.jar.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jar.domain.Customer;
import com.jar.service.CustomerService;
import com.jar.service.impl.CustomerServiceImpl;
import com.jar.utils.WebUtils;

public class addCustomerServlet extends HttpServlet {

	//给用户提供一个添加界面
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		request.setAttribute("genders", Globals.genders);
//		request.setAttribute("preferences", Globals.preferences);
//		request.setAttribute("level", level);
		
		
//		request.getRequestDispatcher("/WEB-INF/jsp/addcustomer.jsp").forward(request, response);
		doPost(request, response); 
	}

	
	//处理用户的添加请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			request.setCharacterEncoding("UTF-8");
//			String level = request.getParameter("level");
			//表单校验
			//把表单封装到customer对象中
			Customer c = WebUtils.request2Bean(request, Customer.class);
			c.setId(WebUtils.generateID());
			
			CustomerService service = new CustomerServiceImpl();
			service.add(c);
			request.setAttribute("message", "添加成功！！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！~");
			
		}
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
	}
}
