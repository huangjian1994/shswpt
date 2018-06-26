<!DOCTYPE html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    String rootpath = "";
%>

<html>

	<!-- Mirrored from www.zi-han.net/theme/hplus/projects.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="shortcut icon" href="../../favicon.ico" />
		<title>上海水务海洋视频资源共享平台</title>
		<meta name="keywords" content="">
		<meta name="description" content="">

		<link rel="shortcut icon" href="../../favicon.ico">
		<link href="<%=basePath%>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="<%=basePath%>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/iconfont/iconfont.css">
		<link rel="stylesheet" href="<%=basePath%>/css/16sucai.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="<%=basePath%>/css/left-nav.css" />
		<link href="<%=basePath%>/css/left.css" rel="stylesheet">

	</head>
<script type="text/javascript">
function goFxj(ssq){
	document.getElementById("ssq").value=ssq;
	document.getElementById("videoDistrit").value="";
	document.myForm.action="<%=basePath%>/videostore/videostore_fetchVideo.do";
	document.myForm.target="_self";
	document.myForm.submit();
}

function goCxbq(videoDistrit){
	document.getElementById("ssq").value="";
	document.getElementById("videoDistrit").value=videoDistrit;
	document.myForm.action="<%=basePath%>/videostore/videostore_fetchVideo.do";
	document.myForm.target="_self";
	document.myForm.submit();
}

function goVideoOpen(zjID){
	//document.myForm.action="<%=basePath%>/videostore/videostore_fetchVideoDetail.do?zjID="+zjID;
	//document.myForm.target="_self";
	//document.myForm.submit();
	var dizhi="<%=basePath%>/videostore/videostore_fetchVideoDetail.do?zjID="+zjID;
	//document.myForm.target="_blank";
	//document.myForm.submit();
	window.open(dizhi, "displayWindow", "menubar=yes,left=300,top=100,width=800,height=620");
}

function goVideoSh(zjID){
	document.getElementById("videoDistrit").value=videoDistrit;
	document.myForm.action="<%=basePath%>/videostore/videostore_shtgVideo.do";
	document.myForm.target="_self";
	document.myForm.submit();
}
</script>
	<body class="gray-bg">
	<form name="myForm" method="post">
	<input type="hidden" name="video.video_distrit" id="videoDistrit" value="" />
	<input type="hidden" name="video.ssq" id="ssq" value="" />

		<!--<div id="sideBar" style="z-index:1000;">
    <a href="#" id="sideBarTab"><img src="images/slide-button.gif" alt="sideBar" title="menu" /></a>
    <div id="sideBarContents" style="display:none;">
        <div id="sideBarContentsInner">
            <div class="search" style="width:250px;margin-left:10px;background:#2293fc;">

            <input type="text" style="height:30px !important;width:180px;padding:0px;">
             <span  style="height:25px;display:inline-block;margin:0px;padding:0px;">
            <img src="images/search.png" style="position:relative;top:4px;">
            <strong style="color:white;">搜索</strong>
            </span>
            </div>
            <ul>


            </ul>
        </div>
    </div>
</div>-->
		<div id="dLeft">
			<ul class="nav">
				<li>
					<a style="padding: 0;" href="<%=basePath%>/selectvideo/selectvideo_fetchUser.do" target="middle" title="权限管理"><i class="iconfont icon-top-menu-access"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="<%=basePath%>/jsp/system/register.jsp" target="middle" title="设备注册"><i class="iconfont icon-icon"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="<%=basePath%>/videostore/videostore_shVideo.do" target="middle" title="视频审批"><i class="iconfont icon-shenpi"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="<%=basePath%>/jsp/system/UAV_approve.jsp" target="middle" title="设备审批"><i class="iconfont icon-shenpi"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="<%=basePath%>/jsp/system/video-share.jsp" target="middle" title="共享视频"><i class="iconfont icon-shexiangtou"></i></a>
				</li>
			</ul>
		</div>
		<div id="jiantou" onclick="btn()">
			<img id="img" src="<%=basePath%>/images/jiantou2.png" style="display:block;height:30px;width:30px;margin:0 auto;" />
		</div>

		<div class="wrapper wrapper-content animated fadeInUp">
			<div class="row" style="margin-left: 6px;">
				<div class="col-sm-12">

					<div class="ibox">
						<div class="ibox-title" style="float:left;" >
					<!--
					<a href="<%=basePath%>/jsp/videostore/test.jsp">test.jsp</a>
					 -->
					 <table>
					 	<tr>
					 		<td>
							<ul>
								<li>所属区：</li>
								<li><img src="<%=basePath%>/images/next.gif"></li>
								<li>
									<a href="#" onclick="goFxj('黄浦区')">黄浦区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('徐汇区')">徐汇区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('长宁区')">长宁区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('静安区')">静安区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('普陀区')">普陀区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('虹口区')">虹口区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('杨浦区')">杨浦区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('闵行区')">闵行区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('宝山区')">宝山区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('嘉定区')">嘉定区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('浦东区')">浦东区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('金山区')">金山区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('松江区')">松江区</a>
								</li>
								<li>
									<a href="#" onclick="goFxj('青浦区')">青浦区</a>
								</li>

								<li>
									<a href="#">奉贤区</a>
								</li>
								<li>
									<a href="#">崇明区</a>
								</li>
								<!--
								<li>
									<a href="#">更多</a>
								</li>
								-->
							</ul>
							</td></tr>
							<tr><td>
							<ul style="text-align:left;" align="left">
								<li>分类：</li>
								<li><img src="<%=basePath%>/images/next.gif"></li>
								<li>
									<a href="#" onclick="goCxbq('重大工程工地巡查')">重大工程工地巡查</a>
								</li>
								<li>
									<a href="#" onclick="goCxbq('中小河道整治')">中小河道整治</a>
								</li>
								<li>
									<a href="#" onclick="goCxbq('防汛重点区域')">防汛重点区域</a>
								</li>

								<li>
									<a href="#">更多</a>
								</li>
							</ul>
							</td></tr></table>
						</div>
					</div>

					<div class="ibox-content">
						<div class="row m-b-sm m-t-sm">
							<div class="col-md-11">
								<div class="input-group">
									<input type="text" placeholder="请输入视频名称" name="video.video_name" id="video_name" class="input-sm form-control">
									<span class="input-group-btn">
                                    <button onclick="goFxj('','')" type="button" class="btn btn-sm btn-primary">搜索</button> </span>
								</div>
							</div>
						</div>

						<div class="project-list" style="overflow:hidden;">
							<c:forEach items="${ videoList }" var="r" varStatus="j">
							<div style="width:220px;height:240px;float:left;">
							<table class="table" style="width:210px;">
							<tbody>
								<tr>
									<td class="project-status">
										<a href="#" onclick="goVideoOpen('${ r.id }')">
										<!--
										在Tomcat的conf文件夹下的server.xml中的
										<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000"  redirectPort="8443" />
										增加URIEncoding="UTF-8"
										 -->
										<img alt="image" width="200px" height="130px" src="/shswpt/video/videoPicture/${ r.picture }">
										</a>
										<h6>${ r.video_name }</h6>
										<h6>${ r.video_date }</h6>
										<a href="#" onclick="goVideoOpen('${ r.id }')" >审核通过</a> &nbsp;
										<a href="#">删除</a>
										<!--  <div class="project-look"><a href="">查看</a></div> -->
									</td>
								</tr>
								</tbody>
							</table>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>


		<script type="text/javascript">
			//视频上传
			function docheck1() {
				window.open("<%=basePath%>/jsp/videostore/load.jsp", "displayWindow", "menubar=yes,width=500,height=400");
			}
			function docheck() {
				window.open("<%=basePath%>/jsp/videostore/load.jsp", "displayWindow", "menubar=yes,left=600,top=300,width=500,height=500");
			}
			function change() {
				window.open("jingbao.jsp", "displayWindow", "menubar=yes,width=500,height=400");
			}

			function btn() {
				var show = document.getElementById("dLeft");
				if(show.style.display == '') {
					show.style.display = 'none';
					document.getElementById("img").src = "<%=basePath%>/images/jiantou.png"
				} else {
					show.style.display = '';
					document.getElementById("img").src = "<%=basePath%>/images/jiantou2.png"
				}
			}


		</script>
	</form>
	<div align="center" style="font-size:14px;"><s:property value="pageBean" escapeHtml="false"/></div>

	</body>
</html>