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

	//���û��ṩһ����ӽ���
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		request.setAttribute("genders", Globals.genders);
//		request.setAttribute("preferences", Globals.preferences);
//		request.setAttribute("level", level);
		
		
//		request.getRequestDispatcher("/WEB-INF/jsp/addcustomer.jsp").forward(request, response);
		doPost(request, response); 
	}

	
	//�����û����������
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			request.setCharacterEncoding("UTF-8");
//			String level = request.getParameter("level");
			//��У��
			//�ѱ���װ��customer������
			Customer c = WebUtils.request2Bean(request, Customer.class);
			c.setId(WebUtils.generateID());
			
			CustomerService service = new CustomerServiceImpl();
			service.add(c);
			request.setAttribute("message", "��ӳɹ�����");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "���ʧ�ܣ�~");
			
		}
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
	}
}
