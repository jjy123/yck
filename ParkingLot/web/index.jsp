<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>停车系统后台管理</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" />
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">停车场收费系统</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          ${user.name}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">个人中心</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/servlet/LoginOutServlet">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      	 <li class="layui-nav-item layui-nav-itemed">
      	 	 <a class="" href="javascript:;">首页</a>
      	 	</li>
        <li class="layui-nav-item">
          <a class="" href="javascript:;">账号管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;" id="modity">修改密码</a></dd>
            <dd><a href="javascript:;" id="adduser">添加管理员</a></dd>
            <dd><a href="javascript:;" id="removeuser">删除管理员</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">停车场操作</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;" id="approach">进场操作</a></dd>
            <dd><a href="javascript:;" id="appearance">出场操作</a></dd>
            <!-- <dd><a href="javascript:;">收费标准</a></dd> -->
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">停车场信息查询</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;" id="approachinfo">停车场车辆信息</a></dd>
            <dd><a href="javascript:;" id="appearanceinfo">历史车辆信息</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;text-align: center;" id="common">
    	${message}
    </div>
  </div>
  <div class="layui-footer">
    <!-- 底部固定区域 -->
  </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js" ></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
	$('#modity').on('click',function(){
		$('#common').load('${pageContext.request.contextPath}/modity.jsp');
	});
	$('#adduser').on('click',function(){
		$('#common').load('${pageContext.request.contextPath}/adduser.jsp');
	});
	$('#removeuser').on('click',function(){
		$('#common').load('${pageContext.request.contextPath}/removeuser.jsp');
	});
	$('#approach').on('click',function(){
		$('#common').load('${pageContext.request.contextPath}/approach.jsp');
	});
	$('#appearance').on('click',function(){
		$('#common').load('${pageContext.request.contextPath}/appearance.jsp');
	});
	$('#approachinfo').on('click',function(){
		$('#common').load('${pageContext.request.contextPath}/approachinfo.jsp');
	});
	$('#appearanceinfo').on('click',function(){
		$('#common').load('${pageContext.request.contextPath}/appearanceinfo.jsp');
	});
</script>
</body>
</html>