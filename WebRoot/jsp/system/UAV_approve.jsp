﻿<!DOCTYPE html>

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
		<title>设备审批</title>
		<meta name="keywords" content="设备审批">
		<meta name="description" content="设备审批">

		<link rel="shortcut icon" href="../../favicon.ico">
		<link href="../../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="../../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

		<link href="../../css/left.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="../../iconfont/iconfont.css">
		<link rel="stylesheet" href="../../css/16sucai.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="../../css/left-nav.css" />
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
			
			.menu p input {
				height: 30px;
				width: 190px;
			}
			
			.menu span {
				display: block;
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
							<h5>所有设备</h5>
							<!--  <div class="ibox-tools">
                            <a href="projects.jsp" class="btn btn-primary btn-xs">创建新项目</a>
                        </div> -->
						</div>
						<div class="ibox-content">
							<div class="row m-b-sm m-t-sm">
								<!-- <div class="col-md-1">
                                <button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
                            </div> -->
								<div class="col-md-11">
									<div class="input-group">
										<input type="text" placeholder="请输入设备名称" class="input-sm form-control"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
									</div>
								</div>
							</div>

							<div class="project-list">

								<table class="table table-hover">
									<tbody>
										<tr>
											<td class="project-status">
												<span class="label label-primary">无人机1
                                        <td class="project-title">
                                            <a href="project_detail.jsp">无人机编码</a>
                                            <br/>
                                            <small>启用时间 2014.08.15</small>
                                        </td>
                                        <td class="project-completion">
                                            所在地址： 
                                            
                                        </td>
                                        <td class="project-completion">
                                                所在坐标：
                                        </td>
                                         <td class="project-people">
                                            <div class="project-people">
                                                通过
                                            </div>
                                        </td>
                                        <td class="project-actions">
                                            <a href="#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 审批 </a>
                                            <!-- <a href="projects.jsp#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a> -->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="project-status">
                                            <span class="label label-primary">无人机18
                                        <td class="project-title">
                                            <a href="project_detail.jsp">无人机编码</a>
                                            <br/>
                                            <small>启用时间 2014.08.15</small>
                                        </td>
                                        <td class="project-completion">
                                            所在地址： 
                                            
                                        </td>
                                        <td class="project-completion">
                                                所在坐标：
                                        </td>
                                         <td class="project-people">
                                            <div class="project-people">
                                                通过
                                            </div>
                                        </td>
                                        <td class="project-actions">
                                            <a href="#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 审批 </a>
                                            <!-- <a href="projects.jsp#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a> -->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="project-status">
                                            <span class="label label-primary">摄像机1
                                        <td class="project-title">
                                            <a href="project_detail.jsp">摄像机编码</a>
                                            <br/>
                                            <small>启用时间 2014.08.15</small>
                                        </td>
                                        <td class="project-completion">
                                            所在地址：虹口区武昌路1596
                                            
                                        </td>
                                        <td class="project-completion">
                                                所在坐标：(255,296)
                                        </td>
                                         <td class="project-people">
                                            <div class="project-people">
                                                通过
                                            </div>
                                        </td>
                                        <td class="project-actions">
                                            <a href="#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 审批 </a>
                                            <!-- <a href="projects.jsp#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a> -->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="project-status">
                                            <span class="label label-primary">摄像机32
                                        <td class="project-title">
                                            <a href="project_detail.jsp">摄像机编码</a>
                                            <br/>
                                            <small>启用时间 2014.08.15</small>
                                        </td>
                                        <td class="project-completion">
                                            所在地址：浦东新区南浦大桥 
                                            
                                        </td>
                                        <td class="project-completion">
                                            所在坐标：(192,166)
                                        </td>
                                         <td class="project-people">
                                            <div class="project-people">
                                                通过
                                            </div>
                                        </td>
                                        <td class="project-actions">
                                            <a href="#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 审批 </a>
                                            <!-- <a href="projects.jsp#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a> -->
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
    function docheck(){
        window.open("load.jsp","displayWindow","menubar=yes,width=500,height=400");
        }
    function change(){
         window.open("jingbao.jsp","displayWindow","menubar=yes,width=500,height=400");
           }
    </script>    
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

<!-- Mirrored from www.zi-han.net/theme/hplus/projects.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
</html>