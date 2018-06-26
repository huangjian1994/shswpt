<!DOCTYPE html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    String rootpath = "";
%>

<html>

	<!-- Mirrored from www.zi-han.net/theme/hplus/# by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="shortcut icon" href="../../favicon.ico" />
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
		<style type="text/css">
			tr td ul li {
				list-style: none;
				margin-top: 5px;
			}
		</style>
		<!--<script type="text/javascript" src="../../js/prototype.js"></script>-->
		<!--<script type="text/javascript" src="../../js/effects.js"></script>-->
		<!--<script type="text/javascript" src="../../js/side-bar.js"></script>-->
	</head>

	<body class="gray-bg">
		<!--<div id="sideBar" style="z-index:1000;">
    <a href="#" id="sideBarTab"><img src="images/slide-button.gif" alt="sideBar" title="menu" /></a>
    <div id="sideBarContents" style="display:none;">
        <div id="sideBarContentsInner">
            <div class="search" style="width:250px;margin-left:10px;background:#2293fc;">
           
            <input type="text" style="height:30px !important;width:180px;padding:0px;">
             <span  style="height:25px;display:inline-block;margin:0px;padding:0px;">
            <img src="images/search.jpg" style="position:relative;top:4px;">
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
					<a style="padding: 0;" href="#" onclick="docheck()" title="图片上传"><i class="iconfont icon-msnui-cloud-upload"></i></a>
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
							<ul>
								<li>分类</li>
								<li><img src="../../images/next.gif"></li>
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
									<input type="text" placeholder="请输入图片名称" class="input-sm form-control"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
								</div>
							</div>
						</div>

						<div class="project-list">

							<table class="table">
								<tbody>
									<tr>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw1.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>闵行区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>重大工程</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-5-5</h6>
											<!--  <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw2.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>重大工程</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-5-6</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw3.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>浦东新区</li>
													<li>李四</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>重大工程</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-5-7</h6>
											<!--   <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw4.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>静安区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>重大工程</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-5-8</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw5.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>杨浦区</li>
													<li>刘武</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>重大工程</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-7-5</h6>
											<!--     <div class="project-look"><a href="">查看</a></div> -->
										</td>
									</tr>
									<tr>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw6.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>防汛重点</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-5-9</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw1.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>王二</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>重大工程</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-8-5</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw2.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>宝山区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>防汛重点</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-9-5</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw3.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>防汛重点</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-12-3</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw4.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>赵一</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>重大工程</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-1-5</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
									</tr>
									<tr>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw5.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>防汛重点</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-4-6</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw1.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>防汛重点</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-7-9</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw2.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>重大工程</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-5-3</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw3.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>防汛重点</li>
													<li>道路环境</li>
												</ul>
											</h6>
											<h6>2016-5-1</h6>
											<!-- <div class="project-look"><a href="">查看</a></div> -->
										</td>
										<td class="project-status">
											<a href="#"><img alt="image" width="200px" height="130px" src="../../images/sw4.jpg"></a>
											<h6 style="overflow: hidden;">
												<ul style="float: left;">
													<li>黄浦区</li>
													<li>张三</li>													
												</ul>
												<ul style="float: left;margin-left: 50px;">
													<li>防汛重点</li>
													<li>道路环境</li>
												</ul>
											</h6>
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
			function btn() {
				var show = document.getElementById("dLeft");
				if(show.style.display == '') {
					show.style.display = 'none';
					document.getElementById("img").src = "../../images/jiantou.jpg"
				} else {
					show.style.display = '';
					document.getElementById("img").src = "../../images/jiantou2.jpg"
				}
			}

			function docheck() {
				window.open("../load.jsp", "displayWindow", "menubar=yes,left=600,top=400,width=500,height=500");
			}
		</script>

		<body>

</html>