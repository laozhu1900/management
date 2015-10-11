<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${pageContext.request.contextPath }/jsp/index.jsp" target="_parent">首页</a></li>
                <li>员工管理系统</li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
            	<c:if test="${user!=null}">
	  				欢迎您：${user.name }   &nbsp;&nbsp;&nbsp;  
	  			<a href="${pageContext.request.contextPath }" target="_parent">退出系统</a>  
  				</c:if>
            </ul>
        </div>
    </div>
</div>
</body>
</html>