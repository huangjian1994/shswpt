<!DOCTYPE html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String rootpath = "";
%>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" href="favicon.ico">
		<title>视频上传</title>
		<style type="text/css">
			body {
				font-size: 14px;
				background: url(../images/bg.jpg) repeat;
			}
			
			span {
				font-size: 19px;
				font-weight: bold;
			}
			
			input {
				vertical-align: middle;
				margin: 20px 0;
				padding: 0
			}
			
			.file-box {
				width: 260px;
				margin: 20px;
			}
			
			.txt {
				height: 22px;
				border: 1px solid #cdcdcd;
				width: 180px;
			}
			
			.btn {
				background-color: #fcd0ac;
				border: 1px solid #fcd0ac;
				height: 40px;
				width: 80px;
				border-radius: 4px;
				margin-left: 40px;
				font-size: 17px;
				font-weight: bold;
			}
			
			.file {
				position: absolute;
				top: 0;
				right: 80px;
				height: 24px;
				filter: alpha(opacity:0);
				opacity: 0;
				width: 260px
			}
			
			.layout {
				width: 300px;
				height: 450px;
				background: url(../images/bg2.jpg);
				background-size: 100% 100%;
				margin: 0 auto;
				position: absolute;
				left: 50%;
				top: 50%;
				margin-left: -150px;
				margin-top: -225px;
			}
			.layout .file-box div input{
				margin-left: 3px;
			}
		</style>
	</head>

	<body>
		<div class="layout">
			<div class="file-box">
				<form action="" method="post" enctype="multipart/form-data">
					<span>路径：</span>
					<input type='file' name='textfield' id='textfield' class='txt' value='选择文件' />
					<input type="file" name="fileField" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value" />
					<span>索引：</span>
					<div style="vertical-align:middle">
						<input type="checkbox" name="" value="黄浦区 " />&nbsp;黄浦区
						<input type="checkbox" name="" value="徐汇区 " />&nbsp;徐汇区
						<input type="checkbox" name="" value="长宁区 " />&nbsp;长宁区
						<input type="checkbox" name="" value="静安区 " />&nbsp;静安区
					</div>
					<div style="vertical-align:middle">
						<input type="checkbox" name="" value="普陀区 " />&nbsp;普陀区
						<input type="checkbox" name="" value="虹口区 " />&nbsp;虹口区
						<input type="checkbox" name="" value="杨浦区 " />&nbsp;杨浦区
						<input type="checkbox" name="" value="闵行区 " />&nbsp;闵行区
					</div>
					<div style="vertical-align:middle">
						<input type="checkbox" name="" value="宝山区 " />&nbsp;宝山区
						<input type="checkbox" name="" value="嘉定区 " />&nbsp;嘉定区
						<input type="checkbox" name="" value="浦东区 " />&nbsp;浦东区
						<input type="checkbox" name="" value="金山区 " />&nbsp;金山区
					</div>
					<div style="vertical-align:middle">
						<input type="checkbox" name="" value="松江区 " />&nbsp;松江区
						<input type="checkbox" name="" value="青浦区 " />&nbsp;青浦区
						<input type="checkbox" name="" value="奉贤区 " />&nbsp;奉贤区
						<input type="checkbox" name="" value="崇明区 " />&nbsp;崇明区
					</div>
					<!--<input type="text" name="submit"  class='txt' />-->
					<input type="button" name="submit" class='btn' value='确定' style="display: block;float: left;" />
					<input type="button" name="submit" class='btn' value='取消' style="display: block;float: left;" />
				</form>
			</div>
		</div>
	</body>

</html>