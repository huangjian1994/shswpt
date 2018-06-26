<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'noAuth.jsp' starting page</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	 
    <style type="text/css">
    	*{margin:0px;padding:0px}
		body{margin:0px;padding:0px;width:700px;height:400px;background-color:white;border:1px solid #BEBEBE}
		.main_div{width:680px;margin-left:10px;height:400px;line-height:400px;text-align:center}
    
    </style>
    
  </head>
    <div class="main_div">
    	<p>对不起，你对该模块没有操作权限，请联系管理员！</p>
    </div>
  <body>
   		
  </body>
</html>
