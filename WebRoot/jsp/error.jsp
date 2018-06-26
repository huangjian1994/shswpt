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
		<title>登录失败</title>
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
				background: url(../images/error-bg.png);
				overflow: hidden;
			}
			
			img {
				width: 600px;
				position: absolute;
				left: 0;
				top: 0;
			}
			
			strong {
				position: absolute;
				font-size: 35px;
				font-weight: 600;
				transform: rotate(12deg);
				color: white;
				left: 219px;
				top: 216px;
			}
			
			a{
				position: absolute;
				font-size: 30px;
				font-weight: 300;
				color: coral;
				transform: rotate(13deg);
				left: 203px;
				top: 269px;
				text-decoration: none;
			}
		</style>
	</head>

	<body>
		<div class="contain">
			<div style="position: relative;left: 50%;top: 50%;margin-left: -300px;margin-top: -225px;">
				<img src="../images/login-error.png" alt="" />
				<strong></strong>
				<a href="#"></a>
			</div>
		</div>
	</body>
	<script src="../js/jquery.js"></script>
	<script src="../js/loading.js"></script>
	<script type="text/javascript">
		var imgArr = ["../images/login-error.png","../images/error.png"];
		loading(imgArr, {
			complete: main
		});
		function main(){
			$("strong").text("登录失败");
			$("a").text("请重新登录");
		}
	</script>
</html>