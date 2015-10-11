<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/libs/modernizr.min.js"></script>
</head>
<body>

		<div class="result-wrap">
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<td>客户名称</td>
						<td>客户类型</td>
						<td>联系人</td>
						<td>手机号码</td>
						<td>客户级别</td>
						<td>备注</td>
						<td>操作</td>
						
					</tr>
					<c:forEach var="customer" items="${requestScope.list}">
						<tr class="${status.count%2==0?'even':'odd' }">
							<td>${customer.name }</td>
							<td>${customer.type }</td>
							<td>${customer.charger }</td>
							<td>${customer.cellphone }</td>
							<td>${customer.level }</td>
							<td>${customer.introduction }</td>
							<td>
								<a class="link-update" href="${pageContext.request.contextPath }/servlet/EditCustomerServlet?name=${customer.name }">修改</a>
								<a class="link-del" href="javascript:void(0)" onclick="del('${customer.name}')">删除</a>
							</td>
							
						</tr>
					</c:forEach>


				</table>
				
				<%-- <a href="/jsp/add.jsp">新增用户</a>--%>
				<script type="text/javascript">
					function del(name) {
						if (window.confirm("您确认删除码？？")) {
							location.href = '${pageContext.request.contextPath}/servlet/DelCustomerServlet?name='+ name;
						}
					}
				</script>
			</div>
		</div>
</body>
</html>



