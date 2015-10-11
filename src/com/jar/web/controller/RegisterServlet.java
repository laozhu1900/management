package com.jar.web.controller;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jar.domain.User;
import com.jar.exception.UserExistException;
import com.jar.service.UserService;
import com.jar.service.impl.UserServiceImpl;
import com.jar.utils.WebUtils;
import com.jar.web.formbean.RegisterForm;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 1.对提交表单的字段进行合法性校验（把表单数据封装到formbean）
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		 String server_checkcode = (String)request.getSession().getAttribute("checkcode");
		 form.setServer_checkcode(server_checkcode);
		boolean b = form.validate();

		// 2.如果校验失败，跳回到表单页面，回显校验失败信息
		if (!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/jsp/register.jsp").forward(
					request, response);
			return;
		}

		// 3.如果校验成功，则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());

		UserService service = new UserServiceImpl();
		try {
			service.register(user);
			// 6.如果serivce处理成功，跳转到网站的全局消息显示页面，为用户注册成功的消息
			request.setAttribute("message", "恭喜您，注册成功！！");
//			request.getRequestDispatcher("/index.jsp").forward(request,response);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("refresh", "3;url='/Management/index.jsp'");
			response.getWriter().write("恭喜你，注册成功，本浏览器将在3秒后。调到首页，如果没有，则点击<a href='/Management/index.jsp'>首页</a>");
//			return;
		} catch (UserExistException e) {
			// 4.如果serivce处理不成功,并且不成功的原因，是因为注册用户已存在的话，则跳回到注册页面，显示注册用户已存在的消息
			form.getErrors().put("username", "注册的用户名已存在！！");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/jsp/register.jsp").forward(
					request, response);
			return;
		} catch (Exception e) {
			// 5.如果serivce处理不成功,并且不成功的原因是其它问题的话，跳转到网站的全局消息显示页面，为用户显示友好错误消息
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！！！");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request,
					response);
			return;
		}

	}
	
	private void test(HttpServletResponse response)throws IOException{
		response.setHeader("refresh", "3");
		
		String data = new Random().nextInt(1000000)+"";
		response.getWriter().write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}