<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加用户的视图</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script><link rel="stylesheet" type="text/css"
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
   	
   	<!--/sidebar-->

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><span class="crumb-step">&gt;</span>添加用户</div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form id="form" action="${pageContext.request.contextPath }/servlet/AddCustomerServlet" method="post" onsubmit="return makepre()" type="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120"><i class="require-red">*</i>客户类型</th>
                            <td>
                                <select name="type" id="catid" class="required">
                                    <option value="">请选择</option>
                                    <option value="个人">个人</option><option value="公司单位">公司单位</option>
                                </select>
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>名称</th>
                                <td>
                                    <input class="common-text required"  name="name" size="50"  type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>联系人</th>
                                <td><input class="common-text" name="charger" size="50"  type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>手机号码</th>
                                <td><input class="common-text" name="cellphone" size="50"  type="text"></td>
                            </tr>
                            <tr>
								<th><i class="require-red">*</i>会员等级</th>
					   			<td>
					   				<label><input name="level" type="radio" value="普通用户" />普通用户 </label> 
					   				<label><input name="level" type="radio" value="高级用户" />高级用户</label> 
					   				<label><input name="level" type="radio" value="VIP用户"/>VIP用户</label> 
					   			</td>
							</tr>
							<tr>
                                <th><i class="require-red">*</i>备注</th>
                                <td><textarea name="introduction" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10"></textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    <!--/main-->
  </body>
</html>
