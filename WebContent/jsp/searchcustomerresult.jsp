<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


	查询结果：
	<div class="result-wrap">

		<div class="result-content">
			<table class="result-tab" width="100%">
				<tr>
					<td>客户单位</td>
					<td>客户类型</td>
					<td>联系人</td>
					<td>手机号码</td>
					<td>会员级别</td>
					<td>备注</td>
				</tr>

				<tr>
					<td>${customer.name }</td>
					<td>${customer.type }</td>
					<td>${customer.charger }</td>
					<td>${customer.cellphone }</td>
					<td>${customer.level }</td>
					<td>${customer.introduction }</td>
				</tr>

			</table>
		</div>
	</div>
</body>
</html>