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
import com.jar.service.impl.CustomerServiceImpl;


public class SearchCustomerServlet extends HttpServlet {
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String name = request.getParameter("name");//获取表单中的信息
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		Customer customer = new Customer();
		CustomerService service = new CustomerServiceImpl();
		customer = service.findCustomer(name);
		request.setAttribute("customer", customer);
		
		request.getRequestDispatcher("/jsp/searchcustomerresult.jsp").forward(request, response); 
	}

}
