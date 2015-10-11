<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/supersized.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style2.css">
        <style type="text/css">
		body{text-align:center;}
		.div{ margin:0 auto; width:400px; height:100px; border:0px solid #F00} 
		
		.message{
			color: red;
		}
	</style>
	
</head>
<body>


<h1 class="title1">用户注册</h1>

	<div class="div"> 
	<form action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post">
		<table id="formtable">
			<tr>
				<td class="td1">姓名：</td>
				<td>
					<input class="userinput" type="text" name="name" value="${form.name }">
					<span class="message">${form.errors.name }</span>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td class="td1">输入密码：</td>
				<td>
					<input class="userinput" type="password" name="password" value="${form.password }">
					<span class="message">${form.errors.password }</span>
				</td>
			</tr>
			
			<tr>
				<td class="td1">确认密码：</td>
				<td>
					<input class="userinput" type="password" name="password2"  value="${form.password2 }">
					<span class="message">${form.errors.password2 }</span>	
				</td>
			</tr>
			
			<tr>
				<td class="td1">手机号码：</td>
				<td>
					<input class="userinput" type="text" name="cellphone" value="${form.cellphone }">
					<span class="message">${form.errors.cellphone}</span>
				</td>
			</tr>
			
			
			<tr>
				<td class="td1">电子邮箱：</td>
				<td>
					<input class="userinput" type="text" name="email"  value="${form.email }">
					<span class="message">${form.errors.email }</span>
				</td>
			</tr>
			
			<tr>
				<td class="td1">您的地址：</td>
				<td>
					<input class="userinput" type="text" name="address" value="${form.address }">
					<span class="message">${form.errors.address }</span>	
				</td>
			</tr>
			
			
			<tr>
				<td class="td1">您的职位：</td>
				<td>
					
					<input class="userinput" type="text" name="position" value="${form.position }"  placeholder="请输入员工或经理">
                   <span class="message">${form.errors.position }</span>	
				</td>
			</tr>
			
			<tr>
				<td class="td1">验证码：</td>
				<td>
					<input class="userinput" type="text" name="client_checkcode">
					<img src="${pageContext.request.contextPath }/servlet/ImageServlet"  onclick="this.src=this.src + '?' + new Date().getTime()" height="23px" width="120px" alt="看不清，换一张" style="cursor: hand;">
				</td>
			</tr>
			
			<tr>
				<td class="td1"></td>
				<td>
					<span class="message">${form.errors.client_checkcode }</span>	
				</td>
			</tr>
			
		</table>
			
			<button type="reset" class="submit_button" >重置</button>
              
            <button  class="submit_button1" type="submit">注册</button>
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