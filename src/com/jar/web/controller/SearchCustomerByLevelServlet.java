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

public class SearchCustomerByLevelServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String level = new String(request.getParameter("level").getBytes(
					"iso-8859-1"), "utf-8");
			// String type = request.getParameter("type");
			System.out.println(level);
			List<Customer> list = new ArrayList<Customer>();
			CustomerService service = new CustomerServiceImpl();
			list = service.getAllCustomerByLevel(level);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/listcustomerByLevel.jsp")
					.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "查看客户失败！！");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request,
					response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
