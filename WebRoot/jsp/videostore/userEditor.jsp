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
	<title>编辑权限</title>
	<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<script type="text/javascript">
function downVideo(){
		var videoFileName = document.getElementById("videoFileName").value;
		document.myForm.action="<%=basePath%>/videostore/videostore_sjxzKs.do";
		document.myForm.target="_middle";
		document.myForm.submit();
	}
function editAuthority(){
	var getID=document.getElementById("zjid").value;
	//alert(getID);
	document.myForm.action="<%=basePath%>/videostore/videostore_editAuthority.do?zjID="+getID;
	document.myForm.target="_self";
	document.myForm.submit();
	//前一页面刷新
	setTimeout("window.opener.location.reload()",101);
	setTimeout("window.close()",102);
}
</script>

</head>
<body style="margin:0;padding:0;">	

<form name="myForm" method="post" >


		<div class="formbody">
			<div class="leftinfo" >
			<input type="hidden" value="${zjID}" id="zjid">
			<table class="tableXQ" width="100%" style="border-collapse:separate; border-spacing:0px 10px">
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户名：</td>
							<td width="30%" >${users.user_name}</td>
							
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户类型：</td>
							
							<td class="project-status">
												<select class="easyui-combobox" name="users.user_type" id="userposition" style="width:180px;">
													<option ${users.user_type=="一般用户"?"selected=selected":""} value="一般用户">一般用户</option>
													<option ${users.user_type=="管理员"?"selected=selected":""} value="管理员">管理员</option>
													<option selected="selected" value="${users.user_type}">${users.user_type}</option>								     
												</select>
                             </td>
							
							
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户单位：</td>
							<td width="30%" id="fjlxTD">${users.user_unity}</td>
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户分区：</td>
							 <td class="project-title">
				                                <select class="easyui-combobox" name="users.user_partition" id="userpartition" style="width:180px;">
													<option ${users.user_partition=="全部"?"selected=selected":""} value="全部">全部</option>
													<option ${users.user_partition=="杨浦区"?"selected=selected":""} value="杨浦区">杨浦区</option>
													<option ${users.user_partition=="普陀区"?"selected=selected":""} value="普陀区">普陀区</option>
													<option ${users.user_partition=="静安区"?"selected=selected":""} value="静安区">静安区</option>
													<option ${users.user_partition=="浦东新区"?"selected=selected":""} value="浦东新区">浦东新区</option>
													<option ${users.user_partition=="宝山区"?"selected=selected":""} value="宝山区">宝山区</option>
													<option selected="selected" value="${users.user_partition}">${users.user_partition}</option>								     
												</select>	
                                        </td>
							
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户职务：</td>
							<td width="30%" id="fjlxTD">${users.user_position}</td>
						</tr>
						<tr>
							<td width="20%" style="background-color:#f5f8fa;">用户专题：</td>
							 <td class="project-title">
					                                   <select class="easyui-combobox" name="users.user_authority" id="userposition" style="width:180px;">
														<option ${users.user_authority=="重大工程"?"selected=selected":""} value="重大工程">重大工程</option>
														<option ${users.user_authority=="防汛重点"?"selected=selected":""} value="防汛重点">防汛重点</option>
														<option ${users.user_authority=="中小河道"?"selected=selected":""} value="中小河道">中小河道</option>
														<option selected="selected" value="${users.user_authority}">${users.user_authority}</option>								     
													</select>	
                                        </td>
						</tr>
						<tr>
							<td colspan="4" style="text-align:center;">
								<input name="fh" type="button" value="修改" class="scbtn1" onclick="editAuthority();" />
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
