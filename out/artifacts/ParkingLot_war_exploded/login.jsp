<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录界面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css"/>
	</head>
	<style type="text/css">
		body{
		 padding-top:80px;
		}
	</style>
	<body>
		<center>
		<h1 style="color:#666;">停车管理系统登录界面</h1>
		<div class="" style="width: 30%;text-align: left;padding:20px; margin-top: 20px;border: 1px solid #ccc;">
		<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/servlet/UserServlet/login" method="post">
			<!--用户名框-->
			  <div class="layui-form-item">
		    <label class="layui-form-label">用户名：</label>
		    <div class="layui-input-block">
		      <input type="text" name="name" placeholder="请输入用户名"class="layui-input">
		    </div>
		  	</div>
		  	<!--密码框-->
		  	  <div class="layui-form-item">
		    <label class="layui-form-label">密码：</label>
		    <div class="layui-input-block">
		      <input type="password" name="password" placeholder="请输入密码"class="layui-input">
		    </div>
		  	</div>
		  	<!--登录-->
		  	  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn">登录</button>
			       <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
		</form>
		</center>
	</body>
	</div>
	<script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
</html>
