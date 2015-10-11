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
   	<form id="form" action="${pageContext.request.contextPath }/servlet/EditCustomerServlet" method="post" onsubmit="return makepre()">
   	<div class="result-wrap">

		<div class="result-content">
   	<table class="result-tab" width="100%">
   		<input type="hidden" name="id" value="${customer.id }">
   		<tr>
   			<td>客户名称</td>
   			<td>
   				<input type="text" name="name" value="${customer.name }">
   			</td>
   		</tr>
   		
   		<tr>
   			<td>客户类型</td>
   			<td>
   				<input type="text" name="type" value="${customer.type }">
   			</td>
   		</tr>
   		
   		<tr>
   			<td>联系人</td>
   			<td>
   				<input type="text" name="charger"   value=${customer.charger }>
   			</td>
   		</tr>
   		
   		<tr>
   			<td>手机号码</td>
   			<td>
   				<input type="text" name="cellphone" value="${customer.cellphone }">
   			</td>
   		</tr>
   		
   		<tr>
   			<td>客户级别</td>
   			<td>
   				<input type="text" name="level" value="${customer.level }">
   			</td>
   		</tr>
   		
   		
   		<tr>
   			<td>备注</td>
   			<td>
   				<textarea name="introduction" value="${customer.introduction }" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10"></textarea>
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
