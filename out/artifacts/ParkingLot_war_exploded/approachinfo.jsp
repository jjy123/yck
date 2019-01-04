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
		<title>停车场停车信息</title>
		<link rel="stylesheet" href="layui/css/layui.css" />
	</head>
	<body>
		<h2>停车场停车信息</h2>
		<!--首先获取到管理员列表-->
		<table class="layui-table">
  <thead>
    <tr>
      <th>序号</th>
      <th>卡号</th>
      <th>车牌号</th>
      <th>入场时间</th>
      <th>车辆图片</th>
      <th>操作员</th>
    </tr> 
  </thead>
  <tbody>
  <c:if test="${infolist!=null}">
  <c:forEach items="${infolist}" var="info" varStatus="status">
  <c:if test="${info.state=='0'}">
   <tr>
      <td>${status.index}</td>
      <td>${info.cardnum}</td>
       <td>${info.licensenum}</td>
      <td>${info.starttime}</td>
      <td><img src='${info.url}'/></td>
      <td>${info.manager}</td>
    </tr>
    </c:if>
    </c:forEach>
  </c:if>
   
  </tbody>
</table>
	</body>
	<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
</html>
