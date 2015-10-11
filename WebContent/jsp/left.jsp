<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                   
                    <ul class="sub-menu">
                    	 <a href="#"><i class="icon-font">&#xe003;</i>用户管理</a>
                    	 
                        <li><a href="${pageContext.request.contextPath }/servlet/ListUserServlet" target="right"><i class="icon-font">&#xe008;</i>用户信息管理</a></li>
                         <a href="#"><i class="icon-font">&#xe003;</i>员工管理</a>
                        <li><a href="${pageContext.request.contextPath }/servlet/ListCustomerServlet" target="right"><i class="icon-font">&#xe005;</i>员工信息管理</a></li>
                         <li><a href="${pageContext.request.contextPath }/jsp/searchcustomer.jsp" target="right"><i class="icon-font">&#xe005;</i>查询员工信息</a></li>
                          <li><a href="${pageContext.request.contextPath }/jsp/addcustomer.jsp" target="right"><i class="icon-font">&#xe005;</i>个人员工添加</a></li>
                          
                       
                   	
                        
                        
                   		
                    </ul>
                </li>  
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>个人修改</a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath }/servlet/EditServlet?id=${user.id }" target="right"><i class="icon-font">&#xe017;</i>设置</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
  </div>
</body>
</html>