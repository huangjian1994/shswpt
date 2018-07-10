<!DOCTYPE html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
  String rootpath = "";
%>

<html>

	<!-- Mirrored from www.zi-han.net/theme/hplus/projects.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="../../favicon.ico">

		<title>上海水务海洋视频资源共享平台</title>
		<meta name="keywords" content="">
		<meta name="description" content="">

		<link rel="shortcut icon" href="<%=basePath %>/favicon.ico">
		<link href="<%=basePath %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="<%=basePath %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/iconfont/iconfont.css">
		<link rel="stylesheet" href="<%=basePath %>/css/16sucai.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="<%=basePath %>/css/left-nav.css" />		
		<link href="<%=basePath %>/css/left.css" rel="stylesheet">
		<!--<script type="text/javascript" src="../../js/prototype.js"></script>-->
		<!--<script type="text/javascript" src="../../js/effects.js"></script>-->
		<!--<script type="text/javascript" src="../../js/side-bar.js"></script>-->

		<style type="text/css">
			.menu {
				position: fixed;
				right: 1000px;
				top: 20px;
				left: 40px;
				width: 90%;
				z-index: 400;
			}
			
			.menu p input {
				height: 30px;
				width: 190px;
			}
			
			.menu span {
				display: block;
			}
		</style>
	<script type="text/javascript">
		function goUserOpen(id){
	//document.myForm.action="<%=basePath%>/videostore/videostore_fetchVideoDetail.do?zjID="+zjID;
	//document.myForm.target="_self";
	//document.myForm.submit();
//	var dizhi="<%=basePath%>/videostore/videostore_fetchVideoDetail.do?ID="+id;
	//document.myForm.target="_blank";
	//document.myForm.submit();
	window.open(dizhi, "displayWindow", "menubar=yes,left=300,top=100,width=400,height=600");
}
</script>
	</head>

	<body class="gray-bg">
		<h1>您没有管理员权限!</h1>
    </body>


</html>