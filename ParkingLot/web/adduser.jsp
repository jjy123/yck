<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加管理员</title>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
	</head>
	<body>
		<h2>添加管理员</h2>
		<div class="">
		<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/servlet/UserServlet/addUser" method="post" onsubmit="javascript:location.reload();">
			<!--用户名框-->
			  <div class="layui-form-item">
		    <label class="layui-form-label">姓名：</label>
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
		  	<!--密码框-->
		  	  <div class="layui-form-item">
		    <label class="layui-form-label">确认密码：</label>
		    <div class="layui-input-block">
		      <input type="password" name="conpassword" placeholder="再次确认密码"class="layui-input">
		    </div>
		  	</div>
		  	<!--登录-->
		  	  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn">添加</button>
			       <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
		</form>
	</body>
	<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
</html>
