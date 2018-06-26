<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="../common.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String rootpath = "";
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>CheckBox Tree - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/easyui/demo.css">
	<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/easyui/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
	function goUploadVideo(){
			alert("1111");
			//判空
			document.myVideoForm.action="<%=basePath%>/videostore/videostore_uploadVideo.do";
	        document.myVideoForm.target="_self";
	        document.myVideoForm.submit();
		}

</script>
<body>
<form name="myVideoForm"  method="post" >
	<div style="margin:20px 0;">
		<a href="#" class="easyui-linkbutton" onclick="getChecked()">GetChecked</a> 
	</div>

	<div class="easyui-panel" style="padding:5px">
		<ul id="tt" class="easyui-tree" data-options="url:'<%=basePath %>/jsp/test/tree_data1.json',method:'get',animate:true,checkbox:true"></ul>
	</div>
	<input type="button" onclick="goUploadVideo()" class="btn" name="sc" value="上传"  />
</form>	
	<script type="text/javascript">
		function getChecked(){
			var nodes = $('#tt').tree('getChecked');
			var s = '';
			for(var i=0; i<nodes.length; i++){
				if (s != '') s += ',';
				s += nodes[i].text;
			}
			alert(s);
		}
	</script>
	
</body>
</html>