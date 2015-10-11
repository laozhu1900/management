package com.jar.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jar.domain.Customer;
import com.jar.domain.User;
import com.jar.service.CustomerService;
import com.jar.service.UserService;
import com.jar.service.impl.CustomerServiceImpl;
import com.jar.service.impl.UserServiceImpl;
import com.jar.utils.WebUtils;


public class EditCustomerServlet extends HttpServlet {

	//����id��ȡҪ�޸ĵĿͻ���Ϣ
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
//		request.setCharacterEncoding("GB2312");
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
//		String name = request.getParameter("name");
		CustomerService service = new CustomerServiceImpl();
		Customer customer = service.findCustomer(name);
		
		
//		request.setAttribute("types", Globals.level);
		
		
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/jsp/editcustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	
		//����д�ı����޸���Ϣ��װ��customer������
		try{
			Customer customer = WebUtils.request2Bean(request, Customer.class);
			CustomerService service = new CustomerServiceImpl();
			service.update(customer);
			request.setAttribute("message", "���³ɹ�����");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "����ʧ�ܣ���");
			
		}
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
	}
}
