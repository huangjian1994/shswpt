<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../common.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String rootpath = "";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" charset="utf-8" src="<%=basePath%>/js/jquery-1.4.4.js" /></script>
		<link rel="shortcut icon" href="favicon.ico">
		<title>视频上传</title>
		<style type="text/css">
			body {
				font-size: 14px;
				background: url(<%=basePath%>/images/bg.jpg) repeat;
			}
			
			span {
				font-size: 19px;
				font-weight: bold;
			}
			
			input {
				vertical-align: middle;
				margin: 18px 0;
				padding: 0
			}
			
			.file-box {
				width: 300px;
				margin: 10px;
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
				background: url(<%=basePath%>/images/bg2.jpg);
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
		<script type="text/javascript">
		//上传
		function goUploadVideo(){
			//判空
			if(document.getElementById("video.video_name").value == ""){
				alert("视频名称不允许为空。");
				return false;
			}
			
			var filename=document.myForm.upload.value;
			if(filename==""){
				alert("请先上传文件！");
				return false;
				}
			var hz=filename.substring(filename.length-4,filename.length);
			//限定视频格式
			if(hz!=".wmv" && hz!=".mp4" && hz!=".avi" && hz!=".ogg" && hz!=".webm" && hz!=".3gp" && hz!=".WMV" && hz!=".MP4" && hz!=".AVI"){
				alert("请上传视频格式的文件！");
				return false;
			}
			if(document.getElementById("video.ssq").value == ""){
				alert("所属区不允许为空。");
				return false;
			}
			
			var str=document.getElementsByName("video.video_distrit");
			var objarray=str.length;
			var chestr="";
			for (i=0;i<objarray;i++){
				if(str[i].checked == true){
					chestr+=str[i].value+",";
				}
			}
			if(chestr == ""){
				alert("请选择查询标签索引！");
				return false;
			}
			document.myForm.action="<%=basePath%>/videostore/videostore_uploadVideo.do";
	        document.myForm.target="_self";
	        document.myForm.submit();
	        
		}
		//取消
		function goClose(){
			//前一页面刷新
			setTimeout("window.opener.location.reload()",101);
			setTimeout("window.close()",102);
		}
		</script>
	</head>
	<body>
	<form name="myForm" method="post" enctype="multipart/form-data">
	${uploadMessage }
		<div class="layout">
			<div class="file-box">
			
				&nbsp;&nbsp;<font color="red">*</font>视频名称： 
				<input type="text" name="video.video_name" id="video.video_name" class="txt" value="" />
				<br />
				&nbsp;&nbsp;<font color="red">*</font>请选择视频：
				<input type="file" name="upload" id="upload" class="txt" value="" />
				<br />
				&nbsp;&nbsp;<font color="red">*</font>所属区：
				<select name="video.ssq" id="video.ssq" class="txt">
					<option value="黄浦区">黄浦区</option>
  					
  					<option value="徐汇区">徐汇区</option>
  					
  					<option value="长宁区">长宁区</option>
  					
  					<option value="静安区">静安区</option>
  					
  					<option value="普陀区">普陀区</option>
  					  					
  					<option value="虹口区">虹口区</option>
  					
  					<option value="杨浦区">杨浦区</option>
  					
  					<option value="闵行区">闵行区</option>
  					
  					<option value="宝山区">宝山区</option>
  					
  					<option value="嘉定区">嘉定区</option>
  					
  					<option value="浦东区">浦东区</option>
  					
  					<option value="金山区">金山区</option>
  					
  					<option value="松江区">松江区</option>
  					
  					<option value="奉贤区">奉贤区</option>
  					
  					<option value="青浦区">青浦区</option>
  					
  					<option value="崇明区">崇明区</option>
				
				</select>
				<br /><br />
				&nbsp;&nbsp;<font color="red">*</font>查询标签索引：
				
				
				<div style="vertical-align:middle">
						&nbsp;&nbsp;<input type="checkbox" name="video.video_distrit" value="重大工程工地巡查 " />&nbsp;重大工程工地巡查
						<br />
						&nbsp;&nbsp;<input type="checkbox" name="video.video_distrit" value="中小河道整治 " />&nbsp;中小河道整治
						<br />
						&nbsp;&nbsp;<input type="checkbox" name="video.video_distrit" value="防汛重点区域 " />&nbsp;防汛重点区域
				</div>
					<!-- 
					<div style="vertical-align:middle">
						<input type="radio" name="video.video_distrit" value="普陀区 " />&nbsp;普陀区
						<input type="radio" name="video.video_distrit" value="虹口区 " />&nbsp;虹口区
						<input type="radio" name="video.video_distrit" value="杨浦区 " />&nbsp;杨浦区
						<input type="radio" name="video.video_distrit" value="闵行区 " />&nbsp;闵行区
					</div>
					<div style="vertical-align:middle">
						<input type="radio" name="video.video_distrit" value="宝山区 " />&nbsp;宝山区
						<input type="radio" name="video.video_distrit" value="嘉定区 " />&nbsp;嘉定区
						<input type="radio" name="video.video_distrit" value="浦东区 " />&nbsp;浦东区
						<input type="radio" name="video.video_distrit" value="金山区 " />&nbsp;金山区
					</div>
					<div style="vertical-align:middle">
						<input type="radio" name="video.video_distrit" value="松江区 " />&nbsp;松江区
						<input type="radio" name="video.video_distrit" value="青浦区 " />&nbsp;青浦区
						<input type="radio" name="video.video_distrit" value="奉贤区 " />&nbsp;奉贤区
						<input type="radio" name="video.video_distrit" value="崇明区 " />&nbsp;崇明区
					</div>
					 -->
					 <br />
					<input type="button" onclick="goUploadVideo()" class="btn" id="sc" name="sc" value="上传" style="float: left;" />
					<input type="button" onclick="goClose()" name="qx" class="btn" value="取消" style="float: left;" />
				
			</div>
		</div>
		
	</form>
	</body>

</html>