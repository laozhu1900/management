package com.jar.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jar.domain.Customer;
import com.jar.service.CustomerService;
import com.jar.service.UserService;
import com.jar.service.impl.CustomerServiceImpl;
import com.jar.service.impl.UserServiceImpl;
import com.jar.utils.WebUtils;


//处理用户分页请求
public class ListCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			List<Customer> list = new ArrayList<Customer>();
			CustomerService service = new CustomerServiceImpl();
			list = service.getAllCustomer();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/listcustomer.jsp").forward(request, response);
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
