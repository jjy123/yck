<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>出场操作</title>
		<link rel="stylesheet" href="layui/css/layui.css" />
	</head>
	<body>
		<h2>出场操作</h2>
		<div class="" style="">
		<form class="layui-form layui-form-pane" method="post" action="${pageContext.request.contextPath}/servlet/InfoServlet/appearance">
			<!--卡号-->
			  <div class="layui-form-item">
		    <label class="layui-form-label">卡号：</label>
		    <div class="layui-input-block">
		      <input type="text" name="cardnum" placeholder="请输入卡号"class="layui-input">
		    </div>
		  	</div>
		  	<!--车牌号-->
		  	  <div class="layui-form-item">
		    <label class="layui-form-label">车牌号：</label>
		    <div class="layui-input-block">
		      <input type="text" name="licensenum" placeholder="请输入车牌号"class="layui-input">
		    </div>
		  	</div>
		  		<!--入场时间-->
		  	  <div class="layui-form-item">
		    <label class="layui-form-label">出场时间：</label>
		    <div class="layui-input-block">
		      <input type="datetime-local" name="endtime" class="layui-input" placeholder="时间格式：yyyy-MM-dd hh:mm">
		    </div>
		  	</div>
		  	<!--费用-->
		  	  <div class="layui-form-item">
		    <label class="layui-form-label">费用：</label>
		    <div class="layui-input-block">
		      <input type="number" name="amount" class="layui-input" placeholder="费用">
		    </div>
		  	</div>
		  	<!--操作员-->
		  	  <div class="layui-form-item">
		    <label class="layui-form-label">操作员：</label>
		    <div class="layui-input-block">
		      <input type="text" name="manager" placeholder="请输入操作员"class="layui-input" value="${user.name}">
		    </div>
		  	</div>
		  	  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn">出场</button>
			       <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
		</form>
	</body>
	<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
</html>

