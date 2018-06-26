<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String rootpath = "";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="1;url=../main.jsp" />
		<title>欢迎页</title>
		<style type="text/css">
			* {
				margin: 0;
				padding: 0;
			}
			
			body,
			html {
				width: 100%;
				height: 100%;
			}
			
			.contain {
				width: 100%;
				height: 100%;
			}
			
			img {
				width: 100%;
				height: 100%;
				position: absolute;
				left: 0;
				top: 0;
				bottom: 0;
				right: 0;
			}
			
			strong {
				position: absolute;
				font-size: 50px;
				font-weight: 600;
				color: white;
				left: 100px;
				top: 100px;
			}
			span{
				position: absolute;
				font-size: 30px;
				font-weight: 300;
				color: coral;
				left: 100px;
				top: 160px;
			}
		</style>
	</head>

	<body>
		<div class="contain">
			<img src="../images/bg-new.jpg" />
			<strong></strong>	
			<span></span>
		</div>
	</body>
	<script src="../js/jquery.js"></script>
	<script src="../js/loading.js"></script>
	<script type="text/javascript">
		var imgArr = ["../images/bg-new.jpg"];
		loading(imgArr, {
			complete: main
		});
		function main(){
			$("strong").text("欢迎登录");
			$("span").text("上海水务海洋视频资源共享平台")
		}
	</script>

</html>