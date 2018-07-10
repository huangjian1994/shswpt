<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="jsp/common.jsp" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String rootpath = "";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="shortcut icon" href="favicon.ico" />
<title>上海市水务海洋视频资源共享平</title>
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0" />
  <frame src="maintop.jsp"  name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
   <frame src="self-video.jsp" cols="187,*" frameborder="no" border="0" framespacinpg="0" name="middle" id="middle" title="bottomFrame" / >
</noframes>
</html>