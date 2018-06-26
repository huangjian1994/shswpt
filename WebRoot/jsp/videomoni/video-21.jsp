<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<title>实时视频 </title>
<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css">
<link rel="stylesheet" type="text/css" href="control.css">
<script language=javascript>
var bLogin = -1;
function init(){
	var obj = document.getElementById("DPSDK_OCX");
    gWndId = obj.DPSDK_CreateSmartWnd(0, 0, 100, 100); //初始化控件，创建视频窗
	obj.DPSDK_SetWndCount(gWndId, 1);//将视频窗4分割
	var obj = document.getElementById("DPSDK_OCX");
	nRet = obj.DPSDK_Login("31.16.10.79", 9000, "admin", "admin");//登陆，参数根据环境自己设置
	//alert("Login" + "  " + nRet);

	nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 0, "1000016$1$0$0", 1, 1, 1);//第一个子窗口打开视频,视频通道号1000605$1$0$0，此字段的获取请参考开发包中附带的《组织树XML解析手册》和《常见问题解答文档》
	//alert("open video"  + "  " + nRet);
	//nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 1, "1000002$1$0$0", 1, 1, 1);//第二个子窗口打开视频
	//alert("open video"  + "  " + nRet);
	//nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 2, "1000002$1$0$0", 1, 1, 1);//第三个子窗口打开视频
	//alert("open video"  + "  " + nRet);
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

//异步加载组织结构
function ButtonAsyncLoadDGroupInfo_onclick() 
{
    var obj = document.getElementById("DPSDK_OCX");
    obj.DPSDK_SetCompressType(1);
	ShowCallRetInfo(obj.DPSDK_AsyncLoadDGroupInfo(), "异步加载组织结构");
    //alert(obj.DPSDK_GetDGroupStr());
}

function ShowCallRetInfo(nRet, strInfo) 
{
    //if (nRet != 0)
    //{
    //    var obj = document.getElementById("DPSDK_OCX");
    //    alert(strInfo + ": ErrorCode = "+obj.DPSDK_GetLastError());
    //}
	
	var str = "";
	if(nRet == 0)
	{
	     str = strInfo + " 成功！";
	}
	else
	{
	     str = strInfo + "失败！错误码：" + nRet;
	}
	document.getElementById("RetInfo").innerText = str;
}

//云台操作代码
function ButtonPtzDirection_onclick(nDirects)
{
	var obj = document.getElementById("DPSDK_OCX");
    var szCameraId = document.getElementById("textCameraID").value;
    nDirect = nDirects;
    var nStep = document.getElementById("selectPtzDirectionStep").value;
    ShowCallRetInfo(obj.DPSDK_PtzDirection(szCameraId, nDirect, nStep, 0), "方向控制");
}

function ButtonPtzDirection_onclickStop(bStop)
{
	var obj = document.getElementById("DPSDK_OCX");
    var szCameraId = document.getElementById("textCameraID").value;
    var nStep = document.getElementById("selectPtzDirectionStep").value;
    ShowCallRetInfo(obj.DPSDK_PtzDirection(szCameraId, nDirect, nStep, bStop), "方向控制");
}
</script>
</head>

<body onresize=testFunc();  onload="init()" onunload="ButtonLogout_onclick()">
<input type="hidden" id="textCameraID" value="1000016$1$0$0" />
<div style="float:left">
	<div style="width: 90%;height: 30px;overflow: auto;" id="RetInfo">
	</div>
	<object id="DPSDK_OCX" classid="CLSID:D3E383B6-765D-448D-9476-DFD8B499926D" style="width: 450px; height: 380px" codebase="DpsdkOcx.cab#version=1.0.0.0"></object>
</div>
	<div style="border:1px solid white;padding-top:20px;float:right;top:-10px">
	<div class="main_control">
	<span class="suo"><a><img src="img/suo.png" height="24px" style="position:absolute;left:0px;top:0px"></a></span>
	<span class="shubiao"><a><img src="img/shubiao.png" height="30px" ></a></span>
	<span class="dingwei"><a><img src="img/dingwei.png" height="24px" style="position:absolute;left:0px;top:0px"></a></span>
	<div class="cbg">

	<table style="width:100%;height:100%">
		<tr height="24%">
			<td width="24%"></td>
			<td width="14%"></td>
			<td width="24%"><a><img src="img/top.png" height="30px" style="position:absolute;left:0px;top:0px" onclick="return ButtonPtzDirection_onclick(1 )"></a></td>
			<td width="14%"></td>
			<td width="24%"></td>
		</tr>
		<tr height="14%">
			<td></td>
			<td><a><img src="img/topleft.png" height="10px" style="position:absolute;left:0px;top:0px" onclick="return ButtonPtzDirection_onclick(5)"></a></td>
			<td></td>
			<td><a><img src="img/topright.png" height="10px" style="position:absolute;right:0px;top:0px" onclick="return ButtonPtzDirection_onclick(7)"></a></td>
			<td></td>
		</tr>
		<tr height="24%">
			<td><a><img src="img/left.png" height="30px" style="position:absolute;left:0px;top:0px" onclick="return ButtonPtzDirection_onclick(3)"></a></td>
			<td></td>
			<td><a><img src="img/rsearch.png" height="25px" style="position:absolute;left:3px;top:4px" onclick="return ButtonPtzDirection_onclickStop(1)"></a></td>
			<td></td>
			<td><a><img src="img/right.png" height="30px" style="position:absolute;left:0px;top:0px" onclick="return ButtonPtzDirection_onclick(4)"></a></td>
		</tr>
		<tr height="14%">
			<td></td>
			<td><a><img src="img/bottomleft.png" height="10px" style="position:absolute;left:0px;bottom:-15px" onclick="return ButtonPtzDirection_onclick(6)"></a></td>
			<td></td>
			<td><a><img src="img/bottomright.png" height="10px" style="position:absolute;right:0px;bottom:-15px" onclick="return ButtonPtzDirection_onclick(8)"></a></td>
			<td></td>
		</tr>
		<tr height="24%">
			<td></td>
			<td></td>
			<td><a><img src="img/bottom.png" height="30px" style="position:absolute;left:0px;top:0px" onclick="return ButtonPtzDirection_onclick(2)"></a></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	</div>
	<div class="down_">
	   <table style="width:100%;height:100%">
		   <tr>
			   	<td width="33%"><a><img src="img/bigger.png" height="22px" ></a></td>
				<td width="34%"><a><img src="img/biggest.png" height="22px" ></a></td>
				<td width="33%"><a><img src="img/bigger2.png" height="22px" ></a></td>
		   </tr>
	       <tr>
		       	<td><a><img src="img/smaller.png" height="22px" ></a></td>
				<td><a><img src="img/smallest.png" height="22px" ></a></td>
				<td><a><img src="img/smaller2.png" height="22px" ></a></td>
	       </tr>
	   </table>
	</div>
</div>
		
		<div style="display:none">
			云台操作</br>
				步长：
			<select id="selectPtzDirectionStep" >
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
			</select></br>
			<!--<input type="button" id="" value="开始云台" onclick="return ButtonPtzDirection_onclickStop(0)" />-->
			<table >
				<tr>
					<td  width="50px;" align="center"><input type="button" id="" value="左上" onclick="return ButtonPtzDirection_onclick(5)" /></td>
					<td width="50px;" align="center"><input type="button" class="button" id="" value="&nbsp;&nbsp;上&nbsp;&nbsp;" onclick="return ButtonPtzDirection_onclick(1)" /></td>
					<td width="50px;" align="center"><input type="button" id="" value="右上" onclick="return ButtonPtzDirection_onclick(7)" /></td>
				</tr>
				<tr>
					<td align="center"><input type="button" id="" value="&nbsp;&nbsp;左&nbsp;&nbsp;" onclick="return ButtonPtzDirection_onclick(3)" /></td>
					<td align="center"><input type="button" id="" value="停止" onclick="return ButtonPtzDirection_onclickStop(1)" /></td>
					<td align="center"><input type="button" id="" value="&nbsp;&nbsp;右&nbsp;&nbsp;" onclick="return ButtonPtzDirection_onclick(4)" /></td>
				</tr>
				<tr>
					<td align="center"><input type="button" id="" value="左下" onclick="return ButtonPtzDirection_onclick(6)" /></td>
					<td align="center"><input type="button" class="button" id="" value="&nbsp;&nbsp;下&nbsp;&nbsp;" onclick="return ButtonPtzDirection_onclick(2)" /></td>
					<td align="center"><input type="button" id="" value="右下" onclick="return ButtonPtzDirection_onclick(8)" /></br></td>
				</tr>
		</table>
			<input type="button" id="buttonAsyncLoadDGroupInfo" value="异步加载组织结构" class="button" onclick="return ButtonAsyncLoadDGroupInfo_onclick()" />
		</div>
	</div>
<script language=javascript>
function testFunc()
{
var _width=700;//改为你要的网页宽度
var _height=470;//改为你要的网页高度
window.resizeTo(_width,_height);
}
testFunc();
//将这里的 <script> 与 <／script> 及他们之间的代码复制到你的网页上
//记得BODY这个标记里一定要加上 onresize=testFunc(); 这个属性，就像本页的BODY标记一样
//最大化都没用，窗口依然这么大
</script>
</body>
</html>



