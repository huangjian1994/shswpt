<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<script type="text/javascript" charset="utf-8" src="${contextPath}/js/my.js" ></script>
<script type="text/javascript" charset="utf-8" src="${contextPath}/js/jquery.js"></script>


<%
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
%>
