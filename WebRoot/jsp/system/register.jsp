<!DOCTYPE html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
  String rootpath = "";
%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
		
		<!--<script type="text/javascript" src="../../js/prototype.js"></script>-->
		<!--<script type="text/javascript" src="../../js/effects.js"></script>-->
		<!--<script type="text/javascript" src="../../js/side-bar.js"></script>-->

		<title></title>
		<style type="text/css">
			.layout {
				width: 600px;
				height: 600px;
				background: #fff;
				margin: 0 auto;
				position: absolute;
				left: 50%;
				top: 50%;
				margin-left: -300px;
				margin-top: -250px;
			}
			
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
		<script type="text/javascript">
      //信息填写完毕，进入注册
    function zc(){
    	document.myForm.action = "<%=basePath%>/register/register_Register.do";
    	//register/register_Register.do
		document.myForm.target = "_self";
		document.myForm.submit();
    
    
    }       
    
   
           
    </script>
	</head>

	<body class="gray-bg">
	<s:form id="myForm"  method="post">
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
			<img id="img" src="<%=basePath%>/images/jiantou2.png" style="display:block;height:30px;width:30px;margin:0 auto;" />
		</div>
		<div class="layout ">
			<div class="project-list " style="width:300px;margin:40px auto; ">
				<h3 style="font-weight:bold; ">创建一个新设备</h3>
				<table class="table table-hover ">
					<tbody>
						<tr>
							<form class="m-t " role="form " action="http://www.zi-han.net/theme/hplus/login.html ">
								<div class="form-group ">
									<input type="text "  name="equipmentName" class="form-control " placeholder="请输入设备名称 ：" required=" ">
								</div>
								<div class="form-group ">
									<input type="text " name="equipmentUser" class="form-control " placeholder="请输入设备所属单位 ：" required=" ">
								</div>
								<div class="form-group ">
									<input type="text " name="ssgc" class="form-control " placeholder="请输入设备所属工程： " required=" ">
								</div>
								<div class="form-group" id="wz">
									<input type="text " name="equipmentLocation" class="form-control " placeholder="请输入设备位置 " required=" ">
								</div>
								<div class="form-group ">
									<input type="text "  name="equipmentCode" class="form-control " placeholder="请输入设备编码 " required=" ">
								</div>
								<div class="form-group ">
									<input type="text "  name="equipmentType"  class="form-control " placeholder="请输入设备型号 " required=" ">
								</div>
			</div>
			 <div class="form-group draggable"><label>类型：</label>
                    <div>
                       <select class="form-control" onclick="xs()"; id="type" name="type" style="width: 252px">
                          <option value="0">自建摄像机</option>
                          <option value="1">共享摄像机</option>
                          <option value="2">无人机</option>
                       </select>
                    </div>
                </div>

			<div class="form-group" id="jd" style="display:block">
                 <input  name="equipmentJd" type="text" class="form-control" placeholder="请输入设备经度：" required="">
             </div>
             <div class="form-group" id="wd" style="display:block">
                 <input  name="equipmentWd" type="text" class="form-control" placeholder="请输入设备纬度：" required="">
             </div>
			<button type="submit " onclick="zc()" class="btn btn-primary block full-width m-b " style="width:100px;margin:0 30px; ">设 备 注 册</button>
			<button type="submit " style="width:100px; " class="btn btn-primary block full-width m-b ">重      置</button>

			</form>
		</div>
		</div>

		<script type="text/javascript ">
			function docheck() {
				window.open("load.html ", "displayWindow ", "menubar=yes,width=500,height=400 ");
			}

			function change() {
				window.open("jingbao.html ", "displayWindow ", "menubar=yes,width=500,height=400 ");
			}
		</script>
		<script type="text/javascript">
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
			 //控制经纬度显示
    function xs(){
    var jd = document.getElementById("jd");
    var wd = document.getElementById("wd");
   	var wz = document.getElementById("wz");
    var w = document.getElementById("type").value; //$F('type');
    //alert(w);
    if(w==2){
    	jd.style.display="none";
    	wd.style.display="none";
    	wz.style.display="none";
    }else{
    	jd.style.display="block";
    	wd.style.display="block";
    	wz.style.display="block";
    }
    }
		</script>
		</s:form>
	</body>

</html>