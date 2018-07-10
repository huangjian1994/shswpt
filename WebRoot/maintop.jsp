<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="jsp/common.jsp" %>
		<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
  String rootpath = "";
%>

			<html xmlns="http://www.w3.org/1999/xhtml">

			<head style="overflow: hidden;">
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
				<link rel="shortcut icon" href="favicon.ico" />
				<title>上海水务海洋视频共享平</title>
				<link href="css/style.css" rel="stylesheet" type="text/css" />		
				<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css"/>
				<style type="text/css">
					.topright li a span img{
						opacity: 0.5;
					} 
					.topright li a:hover span img{
						opacity: 1;
					}
				</style>
			</head>

			<body style="height:44px;">	
				<!--<div class="righttop" style="position:absolute;top:0px;right:0px;z-index:-100;">
					<img src="images/bg3.png" style="height:88px;" />
				</div>
				<div class="lefttop" style="position:absolute;top:0px;left:0px;z-index: -100;">
					<img src="images/bg5.png" style="height:88px;" />
				</div>-->
				<div class="topleft" style="height: 78px;">
					<a href="main.jsp" target="_parent"><img src="images/loginlogo5.png" title="系统首页" /></a>
				</div>
				
				<div class="topright" style="height: 78px;">
				<s:property value="#session.user.user_type"/>：<s:property value="#session.user.user_name"/>
					<ul style="padding-top: 0px;">
						<li style="width: 60px;">
							<a href="self-video.jsp" class="inactive" target="middle" style="font-weight: 900;text-align: center;">
								<span><img style="width: 60px;" src="<%=basePath%>/images/icon1.png" title="videostore"  class="helpimg"/></span>
								<span style="width: 60px;">实时视频</span>
							</a>
						</li>
						<li  style="width: 60px;">
							<!-- jsp/videostore/videostore.jsp -->
							<a href="<%=basePath%>/videostore/videostore_fetchVideo.do" class="inactive" target="middle" style="font-weight: 900;text-align: center;">
								<span><img style="width: 60px;" src="<%=basePath%>/images/icon2.png" title="videostore"  class="helpimg"/></span>
								<span style="width: 60px;">视频库</span>
							</a>
						</li>
						<li style="width: 60px;">
							<a href="jsp/picturestore/picturestore.jsp" class="inactive" target="middle" style="font-weight: 900;text-align: center;">
								<span><img style="width: 60px;" src="<%=basePath%>/images/icon3.png" title="sysmanage"  class="helpimg"/></span>
								<span style="width: 60px;">图片库</span>
							</a>
						</li>
						<li style="width: 60px;">
							<a href="<%=basePath%>/selectvideo/selectvideo_fetchUser.do" class="inactive" target="middle" style="font-weight: 900;text-align: center;">
								<span><img style="width: 60px;" src="<%=basePath%>/images/icon5.png" title="sysmanage"  class="helpimg"/></span>
								<span style="width: 60px;">系统管理</span>
							</a>
						</li>
						<!--<li>
							<span><img src="images/help.png" title="帮助"  class="helpimg"/></span>
							<a href="#">帮助</a>
						</li>
						<li>
							<span><img src="images/about.png" title="关于"  class="helpimg"/></span>
							<a href="#">关于</a>
						</li>-->
						<li style="width: 60px;">
							<a href="${contextPath}/jsp/down.jsp" 
							 class="inactive" target="middle" style="font-weight: 900;text-align: center;">
								<span><img style="width: 60px;" src="<%=basePath%>/images/help1.png" title="插件、文档下载"  class="helpimg"/></span>
								<span style="width: 60px;">帮助</span>
							</a>
						</li>
						<li style="width: 60px;">
							<a href="${contextPath}/login.jsp" target="_parent" style="font-weight: 900;text-align: center;">
								<span><img style="width: 60px;" src="<%=basePath%>/images/icon4.png" title="退出"  class="helpimg"/></span>
								<span style="width: 60px;">退出</span>
							</a>
						</li>
					</ul>
				</div>
				<div style="width: 100%;height:88px;position: absolute;left: 0;top: 0;z-index: -101;font-size: none;">
					<img style="height: 88px;width: 100%;float: left;" src="<%=basePath%>/images/bg-new.png"/>
				</div>
			</body>

			</html>