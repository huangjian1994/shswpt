<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="../common.jsp" %>
<!DOCTYPE html>

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
function downVideo(){
		var videoFileName = document.getElementById("videoFileName").value;
		document.myForm.action="<%=basePath%>/videostore/videostore_sjxzKs.do";
		document.myForm.target="_self";
		document.myForm.submit();
	}
</script>

</head>
<body style="margin:0;padding:0;">	
	<input type="hidden" id="videoFileName" value="/shswpt/video/videoUpload/${video.video_filename}"/>
    <s:form id="myForm"  method="post" enctype="multipart/form-data">

		<div id="content" align="center">
		   	 <!-- 只支持MP4 webm ogg格式 -->

			<!--  <img src="../../images/video-bg.jpg" />-->
			<!-- 
			谷歌不支持，播放文件路径使用虚拟路径
			 -->
			 
			 <object classid="clsid:05589FA1-C356-11CE-BF01-00AA0055595A" id="ActiveMovie1" width="800px" height="600px"> 
				<param name="Appearance" value="0"> 
				<param name="AutoStart" value="0"> 
				<param name="AllowChangeDisplayMode" value="-1"> 
				<param name="AllowHideDisplay" value="0"> 
				<param name="AllowHideControls" value="-1"> 
				<param name="AutoRewind" value="-1"> 
				<param name="Balance" value="0"> 
				<param name="CurrentPosition" value="0"> 
				<param name="DisplayBackColor" value="0"> 
				<param name="DisplayForeColor" value="16777215"> 
				<param name="DisplayMode" value="0"> 
				<param name="Enabled" value="-1"> 
				<param name="EnableContextMenu" value="-1">
				<param name="EnablePositionControls" value="-1"> 
				<param name="EnableSelectionControls" value="0"> 
				<param name="EnableTracker" value="-1"> 
				<param name="Filename" value="/shswpt/video/videoUpload/${video.video_filename}" valuetype="ref"> 
				<param name="FullScreenMode" value="0"> 
				<param name="MovieWindowSize" value="0"> 
				<param name="PlayCount" value="1"> 
				<param name="Rate" value="0"> 
				<param name="SelectionStart" value="-1"> 
				<param name="SelectionEnd" value="-1"> 
				<param name="ShowControls" value="-1"> 
				<param name="ShowDisplay" value="-1"> 
				<param name="ShowPositionControls" value="0"> 
				<param name="ShowTracker" value="-1"> 
				<param name="Volume" value="-480"> 
				</object> 
			
		</div>
		<input type="button" value="视频下载" onclick="downVideo()"/>
	</s:form>
	
</body>
</html>
