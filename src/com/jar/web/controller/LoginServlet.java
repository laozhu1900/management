package com.jar.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import com.jar.domain.User;
import com.jar.service.UserService;
import com.jar.service.impl.UserServiceImpl;


public class LoginServlet extends HttpServlet {
    

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserServiceImpl service = new UserServiceImpl();
		User user = service.login(name, password);
		
		if(user!=null){
			request.getSession().setAttribute("user", user);
			//让用户登陆成功后，跳转首页
			response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
			return;
		}else{
			request.setAttribute("login_error","用户名或密码错误");
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
//		request.setAttribute("message", "用户名或密码错误！！");
		
//		String str = "用户名或密码错误";
		
//		out.print("<script language='javascript'>alert('input wrong');window.location.href='../index.jsp';</script>");
		
//		request.getRequestDispatcher("../index.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);;
	}

}
