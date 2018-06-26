<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String rootpath = "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="shortcut icon" href="../favicon.ico" />
<title>测试页面，页面正在设计中</title>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>/js/jquery-1.4.4.js" /></script>
<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	body{
	 width:990px;
	 height:700px;
	 border:1px solid blue;
	 margin: 0 5px 5px 5px;
	}
	div{
		font-size: 30px;
		margin: 200px 0 0 150px;
	}
</style>
</head>
<body>
	<div>
   		登录成功，请稍候访问……
   	</div>
</body>
</html>
