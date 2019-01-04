<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改密码</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css"/>
	</head>
	<body>
		<h2>修改密码</h2>
		<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/servlet/UserServlet/modifyUser" onsubmit="javascript:location.reload();">
			<!--用户名框-->
			  <div class="layui-form-item">
		    <label class="layui-form-label">新密码：</label>
		    <div class="layui-input-block">
		      <input type="password" name="password" placeholder="请输入新密码"class="layui-input">
		    </div>
		  	</div>
		  	<!--密码框-->
		  	  <div class="layui-form-item">
		    <label class="layui-form-label">确认密码：</label>
		    <div class="layui-input-block">
		      <input type="password" name="conpassword" placeholder="再次确认密码"class="layui-input">
		    </div>
		  	</div>
		  	<input type="hidden" name="id" value="${user.id}" />
		  	<div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn">确定</button>
			       <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
		 </form>
	</body>
	<script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	
</html>
