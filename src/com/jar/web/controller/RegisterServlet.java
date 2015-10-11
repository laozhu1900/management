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

		// 1.���ύ�����ֶν��кϷ���У�飨�ѱ����ݷ�װ��formbean��
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		 String server_checkcode = (String)request.getSession().getAttribute("checkcode");
		 form.setServer_checkcode(server_checkcode);
		boolean b = form.validate();

		// 2.���У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
		if (!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/jsp/register.jsp").forward(
					request, response);
			return;
		}

		// 3.���У��ɹ��������service����ע������
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());

		UserService service = new UserServiceImpl();
		try {
			service.register(user);
			// 6.���serivce����ɹ�����ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û�ע��ɹ�����Ϣ
			request.setAttribute("message", "��ϲ����ע��ɹ�����");
//			request.getRequestDispatcher("/index.jsp").forward(request,response);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("refresh", "3;url='/Management/index.jsp'");
			response.getWriter().write("��ϲ�㣬ע��ɹ��������������3��󡣵�����ҳ�����û�У�����<a href='/Management/index.jsp'>��ҳ</a>");
//			return;
		} catch (UserExistException e) {
			// 4.���serivce�����ɹ�,���Ҳ��ɹ���ԭ������Ϊע���û��Ѵ��ڵĻ��������ص�ע��ҳ�棬��ʾע���û��Ѵ��ڵ���Ϣ
			form.getErrors().put("username", "ע����û����Ѵ��ڣ���");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/jsp/register.jsp").forward(
					request, response);
			return;
		} catch (Exception e) {
			// 5.���serivce�����ɹ�,���Ҳ��ɹ���ԭ������������Ļ�����ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾ�Ѻô�����Ϣ
			e.printStackTrace();
			request.setAttribute("message", "����������δ֪���󣡣���");
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