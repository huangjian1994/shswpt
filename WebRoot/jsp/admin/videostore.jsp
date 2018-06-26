<!DOCTYPE html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../jsp/common.jsp" %>
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

		<link rel="shortcut icon" href="favicon.ico" />
		<title>上海水务海洋视频资源共享平台</title>
		<meta name="keywords" content="">
		<meta name="description" content="">

		<link rel="shortcut icon" href="favicon.ico">
		<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css">
		<link rel="stylesheet" href="css/16sucai.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/left-nav.css" />
		<link href="css/left.css" rel="stylesheet">
		<script type="text/javascript" src="js/prototype.js"></script>
		<script type="text/javascript" src="js/effects.js"></script>
		<script type="text/javascript" src="js/side-bar.js"></script>
	</head>

	<body class="gray-bg">
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
				<li onmouseover="mouseOver1()" onmouseout="mouseOut1()">
					<a style="padding: 0;" href="#" title="视频上传" target="middle"><i class="iconfont icon-msnui-cloud-upload"></i></a>					
				</li>				
			</ul>			
		</div>
		<div id="jiantou" onclick="btn()">
			<img id="img" src="images/jiantou2.png" style="display:block;height:30px;width:30px;margin:0 auto;" />
		</div>
		<div class="wrapper wrapper-content animated fadeInUp">
			<div class="row" style="margin-left: 6px;">
				<div class="col-sm-12">

					<div class="ibox">
						<div class="ibox-title">
							<ul>
								<li>分类</li>
								<li><img src="images/next.gif"></li>
								<li>
									<a href="#">重大工程工地巡查</a>
								</li>
								<li>
									<a href="#">中小河道整治</a>
								</li>
								<li>
									<a href="#">防汛重点区域</a>
								</li>
								<li>
									<a href="#">更多</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="ibox-content">
						<div class="row m-b-sm m-t-sm">
							<div class="col-md-11">
								<div class="input-group">
									<input type="text" placeholder="请输入视频名称" class="input-sm form-control"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
								</div>
							</div>
						</div>

						<div class="project-list">

							<table class="table">
								<tbody>
									<tr>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/yiban1.png"></a>
											<h6>道路环境</h6>
											<h6>2016-5-5</h6>
											<!--  <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/yiban2.png"></a>
											<h6>道路环境</h6>
											<h6>2016-5-6</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/yiban3.png"></a>
											<h6>道路环境</h6>
											<h6>2016-5-7</h6>
											<!--   <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/yiban4.png"></a>
											<h6>道路环境</h6>
											<h6>2016-5-8</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/yiban5.png"></a>
											<h6>道路环境</h6>
											<h6>2016-7-5</h6>
											<!--     <div class="project-look"><a href="">查看</a></div> -->
										</td>
									</tr>
									<tr>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/yiban6.png"></a>
											<h6>道路环境</h6>
											<h6>2016-5-9</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/1.jpg"></a>
											<h6>道路环境</h6>
											<h6>2016-8-5</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/2.jpg"></a>
											<h6>道路环境</h6>
											<h6>2016-9-5</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/3.jpg"></a>
											<h6>道路环境</h6>
											<h6>2016-12-3</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/4.jpg"></a>
											<h6>道路环境</h6>
											<h6>2016-1-5</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
									</tr>
									<tr>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/5.jpg"></a>
											<h6>道路环境</h6>
											<h6>2016-4-6</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/video1.png"></a>
											<h6>道路环境</h6>
											<h6>2016-7-9</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/video2.png"></a>
											<h6>道路环境</h6>
											<h6>2016-5-3</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/video3.png"></a>
											<h6>道路环境</h6>
											<h6>2016-5-1</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="projects.jsp"><img alt="image" width="200px" height="130px" src="images/video4.png"></a>
											<h6>道路环境</h6>
											<h6>2016-5-14</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<script type="text/javascript">
			function docheck() {
				window.open("load.jsp", "displayWindow", "menubar=yes,width=500,height=400");
			}

			function change() {
				window.open("jingbao.jsp", "displayWindow", "menubar=yes,width=500,height=400");
			}
		</script>
		<script type="text/javascript">
			function btn() {
				var show = document.getElementById("dLeft");
				if(show.style.display == '') {
					show.style.display = 'none';
					document.getElementById("img").src = "images/jiantou.png"
				} else {
					show.style.display = '';
					document.getElementById("img").src = "images/jiantou2.png"
				}
			}
		</script>
		<script>
			function block() {
				var show = document.getElementById("shenpi-info");
				show.style.display = "block";
			}

			function fanhui() {
				var fanhui = document.getElementById("shenpi-info");
				fanhui.style.display = "none";
			}
		</script>
		<script type="text/javascript">
			function mouseOver() {
				document.getElementById('line').style.display = "block"
			}

			function mouseOut() {
				document.getElementById('line').style.display = "none"
			}

			function mouseOver1() {
				document.getElementById('line1').style.display = "block"
			}

			function mouseOut1() {
				document.getElementById('line1').style.display = "none"
			}

			function mouseOver2() {
				document.getElementById('line2').style.display = "block"
			}

			function mouseOut2() {
				document.getElementById('line2').style.display = "none"
			}
		</script>
		<body>
		
</html>