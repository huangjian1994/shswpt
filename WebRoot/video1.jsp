<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%--<%@ include file="video1.jsp" %>
--%><!DOCTYPE html>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String rootpath = "";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title></title>
	<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<script type="text/javascript">
//$(function(){
//	alert('success');
//})
</script>

</head>
<body style="background-color: white;overflow-y:hidden;">

   
    <s:form id="myForm"  method="post" enctype="multipart/form-data">

		<div id="content" style="margin: 0px;height:315px;" align="center">

			<!-- 
			播放文件路径使用虚拟路径
			 -->
			 <OBJECT id=WMP height=460 standby=Loading... width=580  classid=clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6>
				<PARAM NAME="URL" VALUE="${url}">
				<PARAM NAME="rate" VALUE="1">
				<PARAM NAME="balance" VALUE="0">
				<PARAM NAME="currentPosition" VALUE="0"><PARAM NAME="playCount" VALUE="1">
				<PARAM NAME="autoStart" VALUE="1">
				<PARAM NAME="currentMarker" VALUE="0">
				<PARAM NAME="invokeURLs" VALUE="-1">
				<PARAM NAME="baseURL" VALUE="">
				<PARAM NAME="volume" VALUE="50">
				<PARAM NAME="defaultFrame" VALUE="">
				<PARAM NAME="mute" VALUE="0">
				<PARAM NAME="uiMode" VALUE="full">
				<PARAM NAME="stretchToFit" VALUE="0">  
				<PARAM NAME="windowlessVideo" VALUE="0">
				<PARAM NAME="enabled" VALUE="-1">
				<PARAM NAME="enableContextMenu" VALUE="-1">
				<PARAM NAME="fullScreen" VALUE="0">
				<PARAM NAME="SAMIStyle" VALUE="">
				<PARAM NAME="SAMILang" VALUE="">
				<PARAM NAME="SAMIFilename" VALUE="">
				<PARAM NAME="captioningID" VALUE="">
			</OBJECT>
		
		</div>
	</s:form>

</body>
</html>

