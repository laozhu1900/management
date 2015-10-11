<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改客户信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/libs/modernizr.min.js"></script>
	<script type="text/javascript">
		function makepre(){
			var pres = document.getElementsByName("pre");
			var preference = "";
			for(var i=0;i<pres.length;i++){
				var input = pres[i];
				if(input.checked==true){
					preference = preference + input.value + ",";
				}
			}
			preference = preference.substr(0,preference.length-1);
			
			var form = document.getElementById("form");
			var input = document.createElement("input");
			input.type = "hidden";
			input.name = "preference";
			input.value = preference;
			
			form.appendChild(input);
			return true;
		}
	</script>
  </head>
  
	<body style="text-align: center;">
   	<br/>
   	<form id="form" action="${pageContext.request.contextPath }/servlet/EditUserServlet" method="post" onsubmit="return makepre()">
   	<div class="result-wrap">

		<div class="result-content">
   	<table class="result-tab" width="100%">
   		<input type="hidden" name="id" value="${user.id }">
   		<tr>
   			<td>用户姓名</td>
   			<td>
   				<input type="text" name="name" value="${user.name }">
   			</td>
   		</tr>
   		
   		<tr>
   			<td>密码</td>
   			<td>
   				<input type="text" name="password" value="${user.password }">
   			</td>
   		</tr>
   		
   		<tr>
   			<td>手机号码</td>
   			<td>
   				<input type="text" name="cellphone"   value=${user.cellphone }>
   			</td>
   		</tr>
   		
   		<tr>
   			<td>邮箱</td>
   			<td>
   				<input type="text" name="email" value="${user.email }">
   			</td>
   		</tr>
   		
   		<tr>
   			<td>地址</td>
   			<td>
   				<input type="text" name="address" value="${user.address }">
   			</td>
   		</tr>
   		
   		
   		<tr>
   			<td>职位</td>
   			<td>
   				<input type="text" name="position" value="${user.position }">
   			</td>
   		</tr>
   		
   		<tr>
	   		<td>
	   		</td>
   			<td>
   				<input class="btn btn-primary btn6 mr10" type="submit" value="确认修改">
   			</td>
   		</tr>
   	</table>
   	</div>
   	</div>
   	</form>
   	
  </body>
</html>
