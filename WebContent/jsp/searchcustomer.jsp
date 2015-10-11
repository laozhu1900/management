<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
<title>Insert title here</title>
</head>
<body>


	<h1>请选择查询方式</h1>
	<hr>
	
	</br>


	<form action="${pageContext.request.contextPath}/servlet/SearchCustomerServlet">
		按客户姓名查询： 
		
			<input type="text" id="" size="20" name="name"
				class="common-text">
			<input type="submit" value="提交"
				class="btn btn-primary btn6 mr10">
				
			
	</form>
		
	</br>
		
	<form action="${pageContext.request.contextPath}/servlet/SearchCustomerByTypeServlet">
		按客户类型查询： 
		
			<input type="text" id="" size="20" name="type" class="common-text">
			<input type="submit" value="提交" class="btn btn-primary btn6 mr10">
		
	</form>
	
	</br>
	
	<form action="${pageContext.request.contextPath}/servlet/SearchCustomerByLevelServlet">
		按客户级别查询： 
		
			<input type="text" id="" size="20" name="level" class="common-text">
			<input type="submit" value="提交"class="btn btn-primary btn6 mr10">
		
	</form>
	
	</br>
	
</body>
</html>