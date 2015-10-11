package com.jar.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jar.service.CustomerService;
import com.jar.service.impl.CustomerServiceImpl;

public class DelCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//			response.setContentType("text/html;charset=utf-8");
//			request.setCharacterEncoding("utf-8");
			
			String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");

			
//			String name = request.getParameter("name");
			System.out.println(name);
			CustomerService service = new CustomerServiceImpl();
			service.delete(name);
			request.setAttribute("message", "É¾³ý³É¹¦£¡£¡");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "É¾³ýÊ§°Ü");
		}
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
