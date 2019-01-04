<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>进场操作</title>
		<link rel="stylesheet" href="/layui/css/layui.css" />
		<link rel="stylesheet" href="/css/bootstrap.css" type="text/css"></link>
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script></head>
		<script src="/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<body>
		<h2>进场操作</h2>
		<div class="" style="">
		<form class="layui-form layui-form-pane" method="post" action="${pageContext.request.contextPath}/servlet/InfoServlet/approach">
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
		    <label class="layui-form-label">入场时间：</label>
		    <div class="layui-input-block">
		      <input type="datetime-local" name="starttime" class="layui-input" placeholder="时间格式：yyyy-MM-dd hh:mm">
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
		    <label class="layui-form-label">车辆图片：</label>
		    <div class="layui-input-block">
		    	<div id="test1" class="col-md-3 col-sm-4 col-xs-6 text-center" style="border:1px solid #ccc; width: 35%">
		<div class="thumbnail suolue" style="line-height:100px;color:#CCCCCC;">
			<span class="tishi">点击添加图片</span>
		</div>
	</div>
	<input type="hidden" id="url" name="url" value="">
		    </div>
		  	</div>
		  	<!--登录-->
		  	  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn">入场</button>
			       <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
		</form>
		</div>
	</body>
	<script type="text/javascript">
	var thumbnail;
/*layui实现上传图片缩略图片 并返回图片地址*/
	layui.use('upload', function(){
  var upload = layui.upload;
   
  //执行实例
  var uploadInst = upload.render({
    elem: '#test1' //绑定元素
    ,url: 'http://localhost:8080/ParkingLot/servlet/UpLoadServlet' //上传接口
    ,done: function(res){
      //上传完毕回调
     // alert(res.url);
      $('.suolue').html("");
      thumbnail=res.url;
      $('#url').val(thumbnail);
      $('.suolue').append("<img style='width:100%' src='"+ thumbnail+"'/>");
    }
    ,error: function(){
      //请求异常回调
      alert("请求异常!");
    }
  });
});
</script>
</html>
