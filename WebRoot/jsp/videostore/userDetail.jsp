<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="../common.jsp" %>
<!DOCTYPE html>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String rootpath = "";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>详情</title>
	<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<script type="text/javascript">
function downVideo(){
		var videoFileName = document.getElementById("videoFileName").value;
		document.myForm.action="<%=basePath%>/videostore/videostore_sjxzKs.do";
		document.myForm.target="_self";
		document.myForm.submit();
	}
</script>

</head>
<body style="margin:0;padding:0;">	

<form name="myForm" method="post" >


		<div class="formbody">
			<div class="leftinfo" >
			<table class="tableXQ" width="100%" style="border-collapse:separate; border-spacing:0px 10px">
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户名：</td>
							<td width="30%" >${users.user_name}</td>
							
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户类型：</td>
							<td width="30%" id="fjlxTD">${users.user_type}</td>
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户单位：</td>
							<td width="30%" id="fjlxTD">${users.user_unity}</td>
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户分区：</td>
							<td width="30%" id="fjlxTD">${users.user_partition}</td>
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户职务：</td>
							<td width="30%" id="fjlxTD">${users.user_position}</td>
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户专题：</td>
							<td width="30%" id="fjlxTD">${users.user_authority}</td>
						</tr>
						<tr>
							<td colspan="4" style="text-align:center;">
								<input name="fh" type="button" value="关闭" class="scbtn1" onclick="window.close();" />
							</td>
						</tr>
					</table>
			</div>
			
			
		</div>
</form>
		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>


	
</body>
</html>
