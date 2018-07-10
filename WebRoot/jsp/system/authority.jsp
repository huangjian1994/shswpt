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

		<link rel="shortcut icon" href="<%=basePath %>/favicon.ico">
		<link href="<%=basePath %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="<%=basePath %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/iconfont/iconfont.css">
		<link rel="stylesheet" href="<%=basePath %>/css/16sucai.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="<%=basePath %>/css/left-nav.css" />		
		<link href="<%=basePath %>/css/left.css" rel="stylesheet">
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
	<script type="text/javascript">
		function goUserOpen(id){
	//document.myForm.action="<%=basePath%>/videostore/videostore_fetchVideoDetail.do?zjID="+zjID;
	//document.myForm.target="_self";
	//document.myForm.submit();
	var dizhi="<%=basePath%>/videostore/videostore_fetchVideoDetail.do?ID="+id;
	//document.myForm.target="_blank";
	//document.myForm.submit();
	window.open(dizhi, "displayWindow", "menubar=yes,left=300,top=100,width=400,height=600");
}
		function goUserODetail(id){
			var dizhi="<%=basePath%>/videostore/videostore_fetchUserDetail.do?zjID="+id;
			window.open(dizhi, "displayWindow", "menubar=yes,left=500,top=100,width=400,height=400");
		}
		function goUserEditor(id){
			var dizhi="<%=basePath%>/videostore/videostore_fetchUserEditor.do?zjID="+id;
			window.open(dizhi, "displayWindow", "menubar=yes,left=500,top=100,width=400,height=400");
			
		}
</script>
	</head>

	<body class="gray-bg">
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
			<img id="img" src="../../images/jiantou2.png" style="display:block;height:30px;width:30px;margin:0 auto;" />
		</div>
		<div class="wrapper wrapper-content animated fadeInUp">
			<div class="row" style="margin-left: 6px;">
				<div class="col-sm-12">

					<div class="ibox">
						<div class="ibox-title">
							<h5>权限管理</h5>

						</div>
						<div class="ibox-content">
							<div class="row m-b-sm m-t-sm">
								<div class="col-md-1">
									<button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
								</div>
								<div class="col-md-11">
									<div class="input-group">
										<input type="text" placeholder="请输入用户名称" class="input-sm form-control">
										<span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary" style="margin-right:50px;"> 搜索</button> </span>
										<span class="input-group-btn">
                                        <button style="border-radius:4px;" type="button" class="btn btn-sm btn-primary"> 权限管理</button> </span>
									</div>
								</div>
							</div>

							<div class="project-list" style="weight:90%">

								
								<table class="table table-hover">
								<tr>
								<td class="project-status">
												用户名
                                        </td>
                                        <td class="project-title">
                                          		  用户类型
                                        </td>
                                        <td class="project-title">
                                           	用户单位
                                        </td>
                                        <td class="project-title">
                                           用户分区
                                        </td>
                                        <td class="project-title">
                                           用户职务
                                        </td>
                                        <td class="project-title">
                                          用户专题
                                        </td>
                                        <td class="project-actions">
                      	操作                     	
                                        </td>
                                        </tr>
									<c:forEach items="${ userList }" var="r" varStatus="j">
										<tr>
                                        <td class="project-title">
                                            
												${ r.user_name }
                                        </td>
                                        <td class="project-status">
												<select class="easyui-combobox" name="r.user_name" id="userposition" style="width:180px;">
													<option ${r.user_type=="一般用户"?"selected=selected":""} value="一般用户">一般用户</option>
													<option ${r.user_type=="管理员"?"selected=selected":""} value="管理员">管理员</option>
													<option selected="selected" value="${r.user_type}">${r.user_type}</option>								     
												</select>
                                        </td>
                                        <td class="project-title">
                                           	${ r.user_unity }
                                        </td>
                                        <td class="project-title">
				                                <select class="easyui-combobox" name="r.user_partition" id="userpartition" style="width:180px;">
													<option ${r.user_partition=="全部"?"selected=selected":""} value="全部">全部</option>
													<option ${r.user_partition=="杨浦区"?"selected=selected":""} value="杨浦区">杨浦区</option>
													<option ${r.user_partition=="普陀区"?"selected=selected":""} value="普陀区">普陀区</option>
													<option ${r.user_partition=="静安区"?"selected=selected":""} value="静安区">静安区</option>
													<option ${r.user_partition=="浦东新区"?"selected=selected":""} value="浦东新区">浦东新区</option>
													<option ${r.user_partition=="宝山区"?"selected=selected":""} value="宝山区">宝山区</option>
													<option selected="selected" value="${r.user_partition}">${r.user_partition}</option>								     
												</select>	
                                        </td>
                                        <td class="project-title">
                                           ${ r.user_position }
                                        </td>
                                        <td class="project-title">
					                                   <select class="easyui-combobox" name="r.user_authority" id="userposition" style="width:180px;">
														<option ${r.user_authority=="重大工程"?"selected=selected":""} value="重大工程">重大工程</option>
														<option ${r.user_authority=="防汛重点"?"selected=selected":""} value="防汛重点">防汛重点</option>
														<option ${r.user_authority=="中小河道"?"selected=selected":""} value="中小河道">中小河道</option>
														<option selected="selected" value="${r.user_authority}">${r.user_authority}</option>								     
													</select>	
                                        </td>
                                        <td class="project-actions">
                                        	<button style="border-radius:4px;" type="button" class="btn btn-sm btn-primary"onclick="goUserODetail('${ r.id }')"> 详情</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        
                                        	<button style="border-radius:4px;" type="button" class="btn btn-sm btn-primary"onclick="goUserEditor('${ r.id }')"> 编辑权限</button> </span>
                                        </td>
                                    </tr>
                                  </c:forEach>
                                </table>
                            </div>
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
					document.getElementById("img").src = "../../images/jiantou.png"
				} else {
					show.style.display = '';
					document.getElementById("img").src = "../../images/jiantou2.png"
				}
			}				
		</script>
		
  	<script type="text/javascript">
    function docheck(){
        window.open("load.html","displayWindow","menubar=yes,width=500,height=400");
        }
    function change(){
         window.open("jingbao.html","displayWindow","menubar=yes,width=500,height=400");
           }
    </script>

    </body>


</html>