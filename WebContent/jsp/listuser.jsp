<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/libs/modernizr.min.js"></script>
</head>

<body>
	<!--/sidebar-->

	<div class="result-wrap">

		<div class="result-content">
			<table class="result-tab" width="100%">
				<tr>
					<td>客户姓名</td>
					<td>密码</td>
					<td>手机号码</td>
					<td>邮箱</td>
					<td>地址</td>
					<td>职位</td>
					<td>操作</td>
				</tr>
				<c:forEach var="u" items="${requestScope.list}">
				<tr>
					<td>${u.name }</td>
					<td>${u.password }</td>
					<td>${u.cellphone }</td>
					<td>${u.email }</td>
					<td>${u.address }</td>
					<td>${u.position }</td>
					<td>
						<a class="link-update" href="${pageContext.request.contextPath }/servlet/EditUserServlet?name=${u.name }">修改</a>
						<a class="link-del" href="javascript:void(0)" onclick="del('${u.name}')">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>

	
			<script type="text/javascript">
				function del(name) {
					if (window.confirm("您确认删除码？？")) {
						location.href = '${pageContext.request.contextPath}/servlet/DelUserServlet?name='+ name;
					}
				}
			</script>
		</div>
	</div>
</body>
</html>



