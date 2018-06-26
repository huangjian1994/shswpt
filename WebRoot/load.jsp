<!DOCTYPE html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="jsp/common.jsp" %> 
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
body{ font-size:14px;background:url(images/bg.jpg) repeat;}
span{font-size:19px;font-weight: bold;}
input{ vertical-align:middle; margin:20px 0; padding:0}
.file-box{ width:260px;margin:20px;}
.txt{ height:22px; border:1px solid #cdcdcd; width:180px;}
.btn{ background-color:#fcd0ac;border:1px solid #fcd0ac;height:40px; width:80px;border-radius:4px;margin-left: 40px;font-size: 17px;font-weight: bold;}
.file{ position:absolute; top:0; right:80px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
.layout{width:300px; height:250px;background:url(images/bg2.jpg);margin:0 auto;position: absolute;
 left: 50%;
 top: 50%;
margin-left:-150px;
margin-top:-125px;}
</style>
</head>
<body>
<div class="layout">
<div class="file-box">
  <form action="" method="post" enctype="multipart/form-data">
  <span>路径：</span>
 <input type='file' name='textfield' id='textfield' class='txt'  value='选择文件'/>  
    <input type="file" name="fileField" class="file" id="fileField" size="28" onchange="document.getElementById('textfield').value=this.value" />
 <span>索引：</span>
 <input type="text" name="submit"  class='txt' />
 <input type="button" name="submit"  class='btn' value='确定' />
 <input type="button" name="submit"  class='btn' value='取消' />
  </form>
</div>
</div>
</body>
</html>