<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="rylrCommon.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理</title>
     <%response.setHeader("Pragma","cache");response.setHeader("Cache-Control","cache");response.setDateHeader("Expires",10);%>
	<meta http-equiv="pragma" content="cache">
	<meta http-equiv="cache-control" content="cache">
	<meta http-equiv="expires" content="10">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="${contextPath}/css/cssNew.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		.t2 tr td{
			border-color:#c9c7c7;
			background-color: white;
		}
	</style>
	<script type="text/javascript">
		//打开窗口
		$(function(){
		$.ajax({
			type:'post',
			url:'<%=basePath%>/ssu/ssu_getTree.do',
			datatype : "json",
			cache:false,
			success:function(json){
			//alert("json="+json);
			//document.getElementById("dd").value=json;
			var data = eval(json);
			$('#tt2').tree({data:data});
			}
		});
		});
	</script>
  </head>
  
  <body class="easyui-layout" style="background-color: white">
		<!-- 树型列表 -->
   		<div id="p" collapsible="false" title="" region="west" split="true" style="width: 211px;height: 750px;overflow: hidden;padding-left: 0px">
			<div id="treeDiv">
				<div id="p1" class="easyui-panel" title="设备列表" collapsible="false" minimizable="false" maximizable=false closable="false" style="width:205px;height:735px;padding:10px;background:white;border:1px solid #c9c7c7;">
					<!-- 树形结构 -->
					<ul id="tt2"></ul>
				</div>
			</div>
   		</div>
   		<!-- 内容界面 
   		<div title="" region="center" style="width:800px;background-color:white;overflow: hidden">
   				<div style="width:800px;height:800px;padding: 0px">
						<div id="p" class="easyui-panel" title="设备播放"  collapsible="false" minimizable="false" maximizable=false closable="false" style="width:635px;height:735px;padding:5px;background:white;">
							<iframe border="0" style="width:100%;height:100%;" frameborder="0" scrolling="no" id="infoFrame" src="" name="infoFrame"></iframe>
						</div>
				</div>
   		</div>
   		-->
   		<%--弹出对话框--%>
		<div id="w" class="easyui-window" collapsible="false" closed="true" modal="true" resizable="false" minimizable="false" maximizable="false" >
			<div class="easyui-layout" fit="true">
				<div region="center" border="false" style="background:#e0ecff;border:1px solid #ccc;">
					<iframe  id="popUp" src="" frameborder="0" width="100%" height="99%" style="overflow-x:hidden"></iframe>
				</div>
			</div>
		</div>
   		
  </body>
</html>