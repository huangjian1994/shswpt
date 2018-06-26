<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<title>分屏批量查看器 </title>
<script language=javascript>
var bLogin = 0;
function init(){
	var obj = document.getElementById("DPSDK_OCX");
    gWndId = obj.DPSDK_CreateSmartWnd(0, 0, 100, 100); //初始化控件，创建视频窗
	obj.DPSDK_SetWndCount(gWndId, 4);//将视频窗4分割
	var obj = document.getElementById("DPSDK_OCX");
	nRet = obj.DPSDK_Login("31.16.10.79", 9000, "admin", "admin123");//登陆，参数根据环境自己设置
	//alert("Login" + "  " + nRet);
	if(nRet == 0)
	{
		bLogin = 1;
	}
	nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 0, "1000042$1$0$2", 1, 1, 1);//第一个子窗口打开视频,视频通道号1000605$1$0$0，此字段的获取请参考开发包中附带的《组织树XML解析手册》和《常见问题解答文档》
	//alert("open video"  + "  " + nRet);
	nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 1, "1000042$1$0$3", 1, 1, 1);//第二个子窗口打开视频
	//alert("open video"  + "  " + nRet);
	nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 2, "1000042$1$0$6", 1, 1, 1);//第三个子窗口打开视频
	//alert("open video"  + "  " + nRet);
	//nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 3, "1000047$1$0$3", 1, 1, 1);//第四 个子窗口打开视频
	//sleep 5分钟后，调用登出接口
	//DPSDK_Logout()
}

function ButtonLogout_onclick()
{
    var obj = document.getElementById("DPSDK_OCX");
    if( bLogin == 1)
	{
        var nRet = obj.DPSDK_Logout();
	    bLogin = 0;
	}
}
</script>

</head>

<body onresize=testFunc(); onload="init()" onunload="ButtonLogout_onclick()">
	<object id="DPSDK_OCX" classid="CLSID:D3E383B6-765D-448D-9476-DFD8B499926D" style="width: 600px; height: 500px" codebase="DpsdkOcx.cab#version=1.0.0.0"></object>
</body>
</html>