<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<title>插件、说明文档下载</title>
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/js/jquery.js" />
		</script>
		<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			html,
			body {
				width: 100%;
				height: 100%;
				margin: 0;
				padding: 0;
			}
			
			.contain {
				width: 100%;
				height: 100%;
				vertical-align: middle;
				background-image: url("../images/erroe-bg.png");
			}			
			.contain div {
				position: absolute;
				left: 50%;
				top: 50%;
				margin-left: -400px;
				margin-top:-250px;
				
			}
			.contain div img {
				width: 800px;				
			}
			.ewm-show{
				display: block;
			    position: absolute;
			    top: 0;
			    left: 0;
			    bottom: 0;
			    right: 0;
			    background: black;
			    opacity: 0.7;
			}
			.ewm-show img{
				width:40px;
				position:absolute;
				right:0;
				top:0;
			}
			 .ewm-img{
			 	display:none;
				position: absolute;
			    left: 50%;
			    top: 50%;
			    margin-left: -146px;
			    margin-top: -93px;
			    z-index:100;
			}
			.contain div ul {
				width:300px;
				position: absolute;
				font-size:25px;				
				left: 244px;
				top: 200px;				
				list-style: none;
				
			}
			
		</style>
	</head>

	<body>
		<div class="contain">
			<div>
				<img src="../images/bg-download.png" />
			</div>
			<div>
				<ul>
					<li>
						<a href="<%=basePath %>/videostore/videostore_downloadCj.do">IE实时视频插件下载</a>
					</li>
					<br />
					<li>
						<a href="<%=basePath %>/videostore/videostore_downloadCzsc.do">系统操作手册下载</a>
					</li>
					<br />
					<li>
						<a class="ewm" href="#">安卓手机app下载</a>
					</li>
				</ul>
			</div>			
		</div>
		<div  class="ewm-show" style="display:none;">
			<img src="<%=basePath%>/images/close.png"/>	
		</div>
		<img class="ewm-img" src="<%=basePath%>/images/ewm.png"/>
	</body>
	<script type="text/javascript">
	$(function(){
			$(".ewm").on("click",function(){
				
				$(".ewm-show").css("display","block");
				$(".ewm-img").css("display","block");
			})
			$(".ewm-show img").on("click",function(){
				$(".ewm-show").css("display","none");
				$(".ewm-img").css("display","none");
			})
		})
	</script>
	
</html>