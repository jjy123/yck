<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>删除管理员</title>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
	</head>
	<body>
		<h2>删除管理员</h2>
		<!--首先获取到管理员列表-->
		<table class="layui-table">
  <thead>
    <tr>
      <th>序号</th>
      <th>名称</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
	<c:if test="${userlist!=null}">
	<c:forEach items="${userlist}" var="user" varStatus="status">
	<tr>
      <td>${status.index}</td>
      <td>${user.name}</td>
      <td><a href="${pageContext.request.contextPath}/servlet/UserServlet/removeUser?id=${user.id}" class="layui-btn layui-btn-xs layui-bg-red">删除</a></td>
    </tr>
	</c:forEach>
    </c:if>
  </tbody>
</table>
	</body>
	<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
</html>
