<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String basePath1 = request.getScheme()+"://"+request.getServerName();
	String rootpath = "";
%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<script type="text/javascript" charset="utf-8" src="<%=basePath %>/js/jquery.js" /></script>
<!--  
<script type="text/javascript" charset="utf-8" src="${contextPath}/js/jquery-1.4.4.js" /></script>
-->
<!--<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/easeui/themes/default/easyui.css">-->
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/easeui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/rylr.css">
<script type="text/javascript" src="<%=basePath %>/js/easyui-lang-zh_CN.js"></script>
<%
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
%>
<!--  
 <script type="text/javascript">
	$(document).ready(function(){
	$("tr:even").addClass("s_oushuhang");//偶数行的背景色
	$("tr:odd").addClass("s_jishuhang");//奇数行的背景色
	$(".t2").delegate("tr","hover",function(){
	$(this).toggleClass("s_mouseover");
	});
	$(".t1").delegate("tr","hover",function(){
	$(this).toggleClass("s_mouseover");
	});
	});
</script>
-->