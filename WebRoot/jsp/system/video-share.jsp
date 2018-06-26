<!DOCTYPE html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
  String rootpath = "";
%>

<html>

	<!-- Mirrored from www.zi-han.net/theme/hplus/projects.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="../../favicon.ico">

		<title>上海水务海洋视频资源共享平台</title>
		<meta name="keywords" content="">
		<meta name="description" content="">

		<link rel="shortcut icon" href="../../favicon.ico">
		<link href="../../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="../../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="../../iconfont/iconfont.css">
		<link rel="stylesheet" href="../../css/16sucai.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="../../css/left-nav.css" />
		<link href="../../css/left.css" rel="stylesheet">
		<script type="text/javascript" src="../../js/jquery.js"></script>
		<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/video-share.js"></script>
		<!--<script type="text/javascript" src="../../js/prototype.js"></script>-->
		<!--<script type="text/javascript" src="../../js/effects.js"></script>-->
		<!--<script type="text/javascript" src="../../js/side-bar.js"></script>-->

		<style type="text/css">
			.menu {
				position: fixed;
				right: 1000px;
				top: 20px;
				left: 40px;
				width: 90%;
				z-index: 400;
			}
			
			.col-sm-12 {
				width: 60%;
				margin-left: 20%;
				background-color: #f5f5f9;
			}
			.ibox-content{
				background-color: #f5f5f9;
			}
			#accordion h2 {
				font-size: 25px;
			}
			
			#accordion h2 a {
				display: block;
				padding: 3px 20px;
				clear: both;
				font-weight: 400;
				line-height: 1.42857143;
				color: #333;
				white-space: nowrap;
				text-decoration: none;
			}
			#accordion h2 a:hover{
				background-color: #F5F5F5;
			}
			#accordion .panel-heading{
				background-color: white;
			}
			
			
			.ulist li {
				list-style: none;
				margin: 10px 0 0 100px;
			}
			
			#accordion .panel-body ul li a {
				font-size: 22px;
				text-decoration: none;
			}
			
			.menu p input {
				height: 30px;
				width: 190px;
			}
			
			.menu span {
				display: block;
			}
			
			.red {
				color: red;
			}
			
			.black {
				color: black;
			}
		</style>
	</head>

	<body class="gray-bg">
		<div id="dLeft">
			<ul class="nav">
				<li>
					<a style="padding: 0;" href="authority.jsp" target="middle" title="权限管理"><i class="iconfont icon-top-menu-access"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="register.jsp" target="middle" title="设备注册"><i class="iconfont icon-icon"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="projects.jsp" target="middle" title="视频审批"><i class="iconfont icon-shenpi"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="UAV_approve.jsp" target="middle" title="设备审批"><i class="iconfont icon-shenpi"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="video-share.jsp" target="middle" title="共享视频"><i class="iconfont icon-shexiangtou"></i></a>
				</li>
			</ul>
		</div>
		<div id="jiantou" onclick="btn()">
			<img id="img" src="../../images/jiantou2.png" style="display:block;height:30px;width:30px;margin:0 auto;" />
		</div>
		<div class="wrapper wrapper-content animated fadeInUp">
			<div class="row" style="margin-left: 6px;">
				<div class="col-sm-12">
					<div class="ibox">
						<div class="ibox-title">
							<h1>共享视频</h5>
						</div>
						<div class="ibox-content">
							<div class="row m-b-sm m-t-sm">
								<div class="col-md-1">
									<button onclick="reset()" type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
								</div>
								<div class="col-md-11">
									<div class="input-group">
										<input type="text" placeholder="请输入用户名称" class="input-sm form-control">
										<span class="input-group-btn">
                   	 	<button onclick="search()" type="button" class="btn btn-sm btn-primary" style="margin-right:50px;"> 搜索</button> 
										</span>
									</div>
								</div>
							</div>
							<div class="project-list"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			function btn() {
				var show = document.getElementById("dLeft");
				if(show.style.display == '') {
					show.style.display = 'none';
					document.getElementById("img").src = "../../images/jiantou.png"
				} else {
					show.style.display = '';
					document.getElementById("img").src = "../../images/jiantou2.png"
				}
			}
		</script>
	</body>

</html>