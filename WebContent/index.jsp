<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>企业客户信息管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/supersized.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style2.css">
		
		<style type="text/css">
			#s1{
				color: red;
			}
			
		</style>
     
    </head>

    <body>
		<h1 class="title">企业员工信息管理系统</h1>
        <div class="page-container">
            
            <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
                <input type="text" name="name" class="username" placeholder="请输入您的用户名！">
                <input type="password" name="password" class="password" placeholder="请输入您的用户密码！"><span id="s1">${login_error}</span>
       			
                
                <button type="submit" class="submit_button">登录</button>
              
                <button  class="submit_button1" type="button" onclick="window.location.href='${pageContext.request.contextPath }/jsp/register.jsp'">注册</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>
		
        <!-- Javascript -->
        <script src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js" ></script>
        <script src="${pageContext.request.contextPath }/js/supersized.3.2.7.min.js" ></script>
        <script src="${pageContext.request.contextPath }/js/supersized-init.js" ></script>
        <script src="${pageContext.request.contextPath }/js/scripts.js" ></script>

    </body>
</html>