﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="jsp/rylrCommon.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head style="height:100%; overflow:hidden;">	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" href="favicon.ico" />
		<title>上海水务海洋视频资源共享平台</title>	
		<link href="<%=basePath %>/css/left.css" rel="stylesheet" />
		<link rel="shortcut icon" href="favicon.ico" />
		<link href="<%=basePath %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet" />
		<link rel="stylesheet" href="<%=basePath %>/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=basePath %>/css/left-nav.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/zeroModal/zeroModal.css" />
		<link rel="stylesheet" type="text/css" href="http://31.16.10.77:80/arcgis_js_v314_api/library/3.20/3.20/dijit/themes/tundra/tundra.css" />
		<link rel="stylesheet" type="text/css" href="http://31.16.10.77:80/arcgis_js_v314_api/library/3.20/3.20/esri/css/esri.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/iconfont/iconfont.css" />
		<link rel="stylesheet" href="<%=basePath %>/css/16sucai.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="<%=basePath %>/css/left-nav.css" />
		<style type="text/css">
            .tundra .dijitTitlePaneTitle{
                background:transparent;
                color:white;
                padding:3px 5px 3px 2px;                
            }
			.menu {
				position: fixed;
				top: 92px;
				/* right: 1000px; */
				left: 81%;
				width: 5.3%;
				z-index: 400;
			}
			a{
			   white-space: nowrap
			}
			.menu p input {
				height: 30px;
				width: 190px;
			}

			.menu span {
				display: block;
			}
			.Box{
			    display:none;
                width:350px;
                height:480px;
                top:100px;
                right:50%;
                z-index:999;
                position:absolute; 
                margin: 10px;
    			box-shadow: 0px 0px 1px 1px rgba(161, 159, 159, 0.1);
    			border-radius: 10px;
			}
			.Box .fa{
				display: inline-block;
			    font: normal normal normal 14px/1 FontAwesome;
			    font-size: inherit;
			    text-rendering: auto;
			    -webkit-font-smoothing: antialiased;
			    -moz-osx-font-smoothing: grayscale;
			    transform: translate(0, 0);
			}
			.Box .fa-times{
				border-radius: 15px;
			    color: white;
			    cursor: pointer;
			    padding: 4px 5px;
			    position: absolute;
			    top: 12px;
    			background-color: #67B5B9;
			    right: 5px;
			    z-index: 100;
			    transition: all 0.3s ease;
			}
			.Box .fa-times:hover{
				background-color: #297B7F;
			}
			
			.Box .panel-heading{
				background-color: #39ADB4;
			    border-top-left-radius: 10px;
			    border-top-right-radius: 10px;
			    border-color: #ddd;
			    border-bottom: 1px solid transparent;
			    color: white;
			    padding: 15px;
                border-left:0px;
                padding: 12px 15px;
			    position: relative;
			    font-family: 'Open Sans', sans-serif;
			}
			.Box h2{
				font-size: 1.6em;
				font-family: inherit;
			    font-weight: 500;
			    line-height: 1.1;
			    color: inherit;
			}
            .Box-content{
                width:350px;
                padding:10px;
                max-height:430px;
                background-color:white;
                overflow-x:hidden;
                overflow-y:auto;
            }                       
			@media screen and (max-width: 1380px){
				#dLeft .nav .nav-list .click-a img{
					width: 40px;
					height:40px;
				}
				#dLeft .nav .nav-list{
					margin-top:0;
				}
				#dLeft .nav{
					margin-top:80px;
				}
				.menu{
					left:79%;
				}
			}
			@media screen and (min-width: 1200px) and (max-width:1380px){
				.menu{
					left:77%;
				}
			}
			@media screen and (min-width: 1100px) and (max-width:1200px){
				.menu{
					left:77%;
				}
			}
			@media screen and (min-width: 1000px) and (max-width:1100px){
				.menu{
					left:75%;
				}
			}
			@media screen and (min-width: 900px) and (max-width:1000px){
				.menu{
					left:73%;
				}
			}
			@media screen and (min-width: 800px) and (max-width:900px){
				.menu{
					left:71%;
				}
			}
			@media screen and (min-width: 700px) and (max-width:800px){
				.menu{
					left:69%;
				}
			}
			@media screen and (min-width: 600px) and (max-width:700px){
				.menu{
					left:65%;
				}
			}
			@media screen and (min-width: 500px) and (max-width:600px){
				.menu{
					left:59%;
				}
			}
			@media screen and (min-width: 400px) and (max-width:500px){
				.menu{
					left:51%;
				}
			}
			@media screen and (max-width: 400px) {
				.menu{
					left:45%;
				}
			}
		</style>
		<script type="text/javascript" src="<%=basePath %>/js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>/js/bootstrap.min.js"></script>
		<script src="<%=basePath %>/js/self-zdgc.js"></script>
		<script src="<%=basePath %>/zeroModal/zeroModal.js"></script>
		<script src="<%=basePath %>/js/layer/layer.js"></script>
		<script type="text/Javascript" src="http://31.16.10.77:80/arcgis_js_v314_api/library/3.20/3.20/init.js"></script>
		<script type="text/Javascript">
			require( [ "dojo/parser", "dijit/layout/BorderContainer",
					"dijit/layout/ContentPane", "dijit/TitlePane", "dojo/domReady!" ],
					function(parser) {
						parser.parse();
					});
		</script>
		<script type="text/javascript" src="<%=basePath %>/js/Pointzjz.js">
		</script>

		<script type="text/javascript">
			var jQuery = $;
		</script>
		<script>
			jQuery.noConflict();
			var x = '1';
			//获取当前屏幕分辨率
			function getScreen (){
				var screenArr = [];
				var h = window.screen.height;
				var w = window.screen.width;
				screenArr.push(h,w);
				return screenArr;
			}
			var screenArr = getScreen();
			var screenW = screenArr[1];
			var screenH = (screenW/4)*3;
			console.log(screenW,screenH);
			//打开视频方法
			function video(stat,stat1) {
				var newVideoId = stat;
				var newVideoInfo = stat1;
				var w = screenW*(2/5) + "px";
				var h = screenH*(2/5) + "px";
					layer.open( {
						type : 2,
						title : '视频查看',
						shadeClose : true,
						id : 'insert-form',
						shade : 0,
						offset : 'r',
						area : [ w, h ],
			content : 'video.jsp', //iframe的url
			success:
			function ButtonStartRealplayByWndNo()
					{
						countLinstener = 0;
					    var frameId = document.getElementById('insert-form').getElementsByTagName("iframe")[0].id;
						setTimeout(function() {
						$('#' + frameId)[0].contentWindow.ButtonStartRealplayByWndNo_onclick(newVideoId ,newVideoInfo);
						}, 1000);
					}
				});
				var frameId = document.getElementById('insert-form').getElementsByTagName("iframe")[0].id;
				if(frameId != null)
				$('#' + frameId)[0].contentWindow.ButtonStartRealplayByWndNo_onclick(newVideoId ,newVideoInfo);
			}	
			function change1(){
				$("#menu1").toggle();
			}
			function change2(){
				$("#menu3").toggle();
			}
		</script>

	</head>

	<body class="tundra" style="overflow-y:hidden" >
	    <div id="MyMapDiv" class="MapClass" style="position:absolute;top:88px;width:100%;">
   			<div data-dojo-type="dijit/TitlePane"
   				data-dojo-props="title:'底图', closable:false, open:false"
   				style="position: absolute; right: 113px; top: 14px; z-Index: 999;">
   				<div data-dojo-type="dijit/layout/ContentPane"
   					style="width: 400px; height: 120px; overflow: auto;">
   					<div id="basemapGallery"></div>
   				</div>
   			</div>
   			<div style="position:absolute; right:20px; top:14px;z-Index:999;" title="圈选">
   				<button type="button" id="polygon" onclick="box()" style="padding:3px 5px 3px 2px;width: 74px;height:38px;background-color: transparent;border-radius: 2px;border:1px solid #bfbfbf">
   					<img src="images/qx.png" alt="圈选" title="圈选" style="width: 50px;height: 30px;margin-left:9px;"/>
   				</button>
   		    </div>
    	     <div id="boxdiv" class="Box">
             	<div id="boxtitle" class="Box-title" >
                   	<i class="fa fa-times" onclick="closeBox()"></i>
                   	<div class="panel-heading">
                   		<span class="text-uppercase"></span>
                   	</div>
             	</div>
             	<div class="Box-content">
                  	<table id="table2"  style="text-align:center;margin:0;">
                     	</table>
                	</div>
    		 </div>
		    <div id="searchdiv" class="Box">
		    	  <div id="searchtitle" class="Box-title" onclick="closeSearch()">
	             </div>
	             <div class="Box-content">
	              <table id="showsearch" style="text-align:center;">
                  </table>
                 </div>
		    </div>
		</div>
        <div class="topleft" style="height: 78px;margin-top:20px;">
            <a href="main.jsp" target="_parent"><img src="images/loginlogo3.png" title="系统首页" /></a>
        </div>
        <div style="width: 100%;height:150px;position: absolute;left: 0;top: 0;z-index: -101;font-size: none;">
            <img style="height: 88px;width: 100%;float: left;" src="<%=basePath%>/images/test2.png"/>
        </div>
		<div id="dLeft" style="top:88px;">
			<ul class="nav" style="margin-top:100pxs;">				
				<li class="zzz" onclick="videoShow('.zjz','重大危险源')">
					<a class="sp" href="#" style="padding:8px 0 0 10px;">质<br/>监<br/>站</a>
				</li>
                <li class="zzz">
                    <a class="sp" target="_top" href="main.jsp">返<br/>回</a>
                </li>
				<li class="droplist zjz" id="line1">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>质监站</span>
						</div>
						<div id="zjz-insert" class="insert">

						</div>
					</div>
				</li>				
			</ul>
		</div>
		
		<div class="menu" style="display: block;">
			<div class="item11">
				<a class="link icon_find" onclick="doFind()"></a>
				<div class="item_content">
					<p>
						<input id="search" type="text" value="" onkeydown="Search();"></input>
					</p>
				</div>
			</div>
		</div>
	</body>
	<script src="js/jquery.js"></script>
	<script>
		$('.item11').hover(function() {
			var $this = $(this);
			expand($this);
		}, function() {
			var $this = $(this);
			collapse($this);
		});
		function expand($elem) {
			var angle = 0;
			var t = setInterval(function() {
				if (angle == 1440) {
					clearInterval(t);
					return;
				}
				angle += 40;
				$('.link', $elem).stop().animate( {
					rotate : '+=-40deg'
				}, 0);
			}, 10);
			$elem.stop().animate( {
				width : '268px'
			}, 1000).find('.item_content').fadeIn(400, function() {
				$(this).find('p').stop(true, true).fadeIn(600);
			});
		}
		function collapse($elem) {
			var angle = 1440;
			var t = setInterval(function() {
				if (angle == 0) {
					clearInterval(t);
					return;
				}
				angle -= 40;
				$('.link', $elem).stop().animate( {
					rotate : '+=40deg'
				}, 0);
			}, 10);
			$elem.stop().animate( {
				width : '52px'
			}, 1000).find('.item_content').stop(true, true).fadeOut().find('p')
					.stop(true, true).fadeOut();
		}
	</script>
</html>