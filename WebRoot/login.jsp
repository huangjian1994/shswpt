<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="jsp/common.jsp" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<<<<<<< .mine
	<head>
		<meta charset="UTF-8">
		<title>水务视频资源整合平台</title>
		<link rel="stylesheet" href="${contextPath}/css/reset.css">
        <link rel="stylesheet" href="${contextPath}/css/supersized.css">
        <link rel="stylesheet" href="${contextPath}/css/login.css">
        <script type="text/javascript" src="${contextPath}/js/jquery.js"></script>
        <script src="${contextPath}/js/supersized.3.2.7.min.js"></script>
        <script src="${contextPath}/js/supersized-init.js"></script>
        <script src="${contextPath}/js/login.js"></script>
        <style>
        	body,html{
				width:100%;
				height:100%;
			}       	
        				
        </style>
	</head>	
||||||| .r50
	<head>
		<meta charset="UTF-8">
		<title>水务视频资源整合平台</title>
		<link rel="stylesheet" href="${contextPath}/css/reset.css">
        <link rel="stylesheet" href="${contextPath}/css/supersized.css">
        <link rel="stylesheet" href="${contextPath}/css/login.css">
        <script type="text/javascript" src="${contextPath}/js/jquery.js"></script>
        <script src="${contextPath}/js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
        <!--<script src="${contextPath}/js/relogin.js"></script>-->
        <script src="${contextPath}/js/login.js"></script>
        <style>
        	body,html{
				width:100%;
				height:100%;
			}       	
        				
        </style>
	</head>	
=======
  <head>
    
    <%
    	String  original="";
    
    	Object result=request.getAttribute("original");
    	
    	if(result==null){
    		System.out.println("before");
    		//request.getRequestDispatcher("/random").forward(request,response);
    		
    	}else{
    		System.out.println("after");
    		original=result.toString();
    	}
    %>
    <title>水务视频管理平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		*{margin:0px;padding:0px}
		body{margin:0px;padding:0px}
		td{border:0px solid red}
		table{border-collapse:collapse;}
		#loginPane{position:absolute;left:52%;top:46%;height:157px;width:385px;background-color:#D8E3E9;border: 2px solid white }
		#title_tab{height:34px}
		#sz_tab,#yh_tab{width:100%;height:35px;text-align:center;border-top:5px solid #1B8EBF }
		img{border:0px}
		.btn{font-family:Microsoft YaHei ! important;width:75px;height:28px;background:url("${contextPath}/images/login/btn.png");color:white;border: 0px;font-size: 18px;font-weight: bold;}
		.yh .label{width:100px;}
		.text{width:150px;background-color: white;height:24px;}
		a{text-decoration: none}
		.checkStyle{font-family:Microsoft YaHei ! important;width:18px;height:18px;color:white;
		border: 0px;font-size: 18px;font-weight: bold;}
		
		.bgDiv{width:996px;height:592px;background:url("${contextPath}/images/login1.png");background-position: center center;background-repeat: no-repeat;}
	</style>
>>>>>>> .r1
	<script type="text/javascript">


		if("${message}"){
			alert("${message}");
		}

		
		function showTable(showId,hiddenId){
				$("#"+showId).attr("src","${contextPath}/images/login/"+showId+"_2.png");
				$("#"+hiddenId).attr("src","${contextPath}/images/login/"+hiddenId+"_1.png");
				$("#"+showId+"_tab").css("display","block");
				$("#"+hiddenId+"_tab").css("display","none");

			}


		function validate(){
				if(!$("#loginForm_user_userName").val()){

						alert("用户名不能为空");

						return false;
				}
				if(!$("#loginForm_user_password").val()){

					alert("密码不能为空");

					return false;
			}

				return true;

			}
<<<<<<< .mine
	</script>
	</head>
	<body oncontextmenu="return false">
		<div id="all" style="display:none;">
			<div class="page-container" style="display:none;"> 
			<h1>上海市水务海洋视频资源共享平台</h1>     
	            <s:form id="loginForm"  action="/user/user_login.do" theme="simple" onsubmit="return validate()" >
					<div>
						<input type="text" name="user.user_name" id="loginForm_user_userName" class="username" placeholder="请输入用户名：" autocomplete="off"/>
					</div>
	                <div>
						<input type="password" name="user.user_password" id="loginForm_user_password" class="password" placeholder="密码：" oncontextmenu="return false" onpaste="return false" />
	                </div>
	                <button class="button" type="submit" id="login" />登录</button>
	            </s:form>            
	        </div>
		</div>
				
		<script>			
			window.onload = function(){
				$(".connect").animate({"left":"8%"}, 600);
				$(".page-container").fadeIn();
			}		
||||||| .r50
	</script>
	</head>
	<body oncontextmenu="return false">	
		<div id="all" style="display:none;">
			<div class="page-container" style="display:none;"> 
			<h1>上海市水务海洋视频资源共享平台</h1>     
	            <s:form id="loginForm" action="/user/user_login.do" theme="simple" onsubmit="return validate()" >
					<div>
						<input type="text" name="user.user_name" id="loginForm_user_userName" class="username" placeholder="请输入用户名：" autocomplete="off"/>
					</div>
	                <div>
						<input type="password" name="user.user_password" id="loginForm_user_password" class="password" placeholder="密码：" oncontextmenu="return false" onpaste="return false" />
	                </div>
	                <button class="button" type="submit" id="login" />登录</button>
	            </s:form>            
	        </div>
		</div>
				
		<script>			
			window.onload = function(){
				$(".connect").animate({"left":"8%"}, 600);
				$(".page-container").fadeIn();
			}		
=======


		function SignIn(){
			document.signInForm.action = "${contextPath}/user/user_loginSignIn.do";
			document.signInForm.target = "_self";
			document.signInForm.submit();
		}
		

>>>>>>> .r1
		</script>

  </head>
  <body style="width: 100%;height: 100%;background-color: #1C6FBF;text-align:center;">
  <object classid="clsid:707C7D52-85A8-4584-8954-573EFCE77488" id="JITDSignOcx" width="0" codebase="./JITDSign.cab#version=2,0,24,19"></object>
  <div class="bgDiv" style="width: 100%;height: 95%;float:left;">
  <div style="margin-top: 22%;margin-left: 55%;float:left;">
   			<!-- 
   			<s:form id="signInForm"  theme="simple" >
   				<table>
	   				<tr height="30px"><td colspan="3">&nbsp;</td></tr>
	   				<tr>
	   					<td class="label"><p style="line-height: 28px;color: #2760A9;"><strong>身份证：</strong></p></td>
	   					<td><s:textfield name="user.userId" cssClass="text"></s:textfield></td>
	   				</tr>
	   				<tr>
	   					<td class="label" ><p style="line-height:1px;"></p></td>
	   					<td align="left" colspan="2">
	   					<input type="button" value="SignIn" class="btn" onclick="SignIn()" >
	   					</td>
	   				</tr>
	   			</table>
   			</s:form>
   			 -->
   			<s:form id="loginForm" action="/user/user_login.do" theme="simple" onsubmit="return validate()" >		
	   			<table>
	   				<tr height="30px"><td colspan="3">&nbsp;</td></tr>
	   				<tr>
	   					<td class="label"><p style="line-height: 28px;color: #2760A9;"><strong>用户名：</strong></p></td>
	   					<td><s:textfield name="user.userName" cssClass="text"></s:textfield></td>
	   				</tr>
	   				<tr>
	   					<td><br/></td>
	   					<td><br/></td>
	   				</tr>
	   				<tr>
	   					<td class="label" ><p style="line-height:28px;color: #2760A9;"><strong>密码：</strong></p></td>
	   					<td>
	   						<s:password name="user.password" cssClass="text"></s:password>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td><br/></td>
	   					<td><br/></td>
	   				</tr>
	   				<tr>
	   					<td class="label" ><p style="line-height:1px;"></p></td>
	   					<td align="left" colspan="2">
	   					<input type="submit" value="登录" class="btn">
	   					&nbsp;
	   					<a href="http://10.14.158.233/LinkLogin/LinkLogin.aspx?appId=21">
	   					<font color="red" size="-1">统一身份认证登录</font>
	   					</a>
	   					<!-- 
	   					&nbsp;
	   					<input type="checkbox" name="user.isSystem" class="checkStyle">
	   					<font color="red" size="-1">进入考试</font>
	   					 -->
	   					</td>
	   				</tr>
	   				<tr height="30px"><td colspan="3">&nbsp;</td></tr>
	   			</table>
   			</s:form>  
  </div>
  </div>
  </body>
</html>
