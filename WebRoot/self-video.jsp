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
		<!--<script type="text/javascript" src="js/prototype.js"></script>
		<script type="text/javascript" src="js/effects.js"></script>
		<script type="text/javascript" src="js/side-bar.js"></script>-->
		<link rel="stylesheet" href="<%=basePath %>/css/left-nav.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/zeroModal/zeroModal.css" />
		<link rel="stylesheet" type="text/css"
			href="http://31.16.10.77:80/arcgis_js_v314_api/library/3.20/3.20/dijit/themes/tundra/tundra.css" />
		<link rel="stylesheet" type="text/css"
			href="http://31.16.10.77/arcgis_js_v314_api/library/3.20/3.20/esri/css/esri.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/iconfont/iconfont.css" />
		<link rel="stylesheet" href="<%=basePath %>/css/16sucai.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="<%=basePath %>/css/left-nav.css" />
		<style type="text/css">
            .tundra .dijitTitlePaneTitle{
                background:transparent;
                color:white;
                padding:3px 5px 3px 2px;                
            }
			.menu {
				position: fixed;
				top: 3px;
				opacity:0.6;
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
                width:450px;
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
                width:450px;
                padding:10px;
                max-height:430px;
                background-color:white;
                overflow-x:hidden;
                overflow-y:auto;
            }
            #phone-insert .yiji li{
            	list-style:none;
            }
            #phone-insert .yiji a{
                color:#111111;
            	text-decoration: none;
            }

            #phone-insert .yiji .yiji-menu{
			    padding: 10px 15px;
			    font-size:15px;
			    color:#111111;
			    border-bottom: 1px solid transparent;
			    border-top-left-radius: 3px;
			    border-top-right-radius: 3px;
			    margin-bottom:3px;
			   
			}
			#phone-insert .yiji .yiji-menu:hover,#phone-insert .yiji .erji-menu:hover,#phone-insert .yiji .sanji-menu li:hover{
    			background: #3c8dbc;
    			border-left-color: #3c8dbc;
			}
			#phone-insert .yiji-menu:hover a,#phone-insert .erji-menu:hover a,#phone-insert .sanji-menu:hover a{
                color:white;
            }

            #phone-insert .yiji ul li{
            	padding:10px 0 10px 30px;
            	font-size:16px;
            }
            #phone-insert .yiji  ul ul li{
            	padding:0px 0 0px 40px;
            	font-size:16px;
            }
            #dLeft #phone-insert .yiji ul ul li img{
            	margin-right:2px;
            	width:20px;
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
		<script src="<%=basePath %>/js/self-nav.js"></script>
		<script src="<%=basePath %>/zeroModal/zeroModal.js"></script>
		<script src="<%=basePath %>/js/layer/layer.js"></script>
		<script type="text/Javascript"
			src="http://31.16.10.77:80/arcgis_js_v314_api/library/3.20/3.20/init.js"></script>
		<script type="text/Javascript">
			require( [ "dojo/parser", "dijit/layout/BorderContainer",
					"dijit/layout/ContentPane", "dijit/TitlePane", "dojo/domReady!" ],
					function(parser) {
						parser.parse();
					});
		</script>
		<script type="text/javascript" src="<%=basePath %>/js/Point2.js">
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
			function phonevideo() {
						var w = screenW*(2/5) + "px";
						var h = screenH*(3/5) + "px";
							layer.open( {
								type : 2,
								title : '手机直播',
								shadeClose : true,
								id : 'insert-form',
								shade : 0,
								offset : 'r',
								area : [ w, h ],
					content : 'http://31.16.17.43/xvs-api-js-demo/play.html', //iframe的url
				});
			}
			function btn1() {
			}

			function change1(){
				$("#menu1").toggle();
			}
			function change2(){
				$("#menu3").toggle();
			}
		</script>

	</head>

	<body class="tundra"  style="overflow:-Scroll;overflow-y:hidden" >
		<div style="position:absolute;left:45%;bottom:0;font-size:0.8em;z-index:1000;">
			<span>本系统不断开发完善中 如有问题请联系：52397000-6641</span>
		</div>
		<div id="MyMapDiv" class="MapClass">
   			<div title="圈选" data-dojo-type="dijit/TitlePane" data-dojo-props="title:'底图', closable:false, open:false" style="position: absolute; right: 113px; top: 14px; z-Index: 999;">
   				<div data-dojo-type="dijit/layout/ContentPane" style="width: 400px; height: 120px; overflow: auto;">
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

		<div id="dLeft">
			<ul class="nav" style="margin-top:100pxs;">
				<li id="sply">
					<a class="sp" href="#" onclick="showPoint('显示全部视频')">来<br/>源</a>
					<ul class="sply">
						<!-- <li class="nav-list">
							<a class="click-a" style="padding: 0;" href="#" target="middle" >
								<img src="images/qbsp1.png" alt="显示全部视频" title="显示全部视频"/>
							</a>
						</li> -->
						<li class="nav-list" onclick="videoShow('.zjsp','自建视频')">
	    					<a class="click-a" style="padding: 0;" href="#"	target="middle">
	    						<img src="images/zjsp1.png" alt="自建视频" title="自建视频"/>
	    					</a>
						</li>
		                <li class="nav-list" onclick="videoShow('.gxsp','共享视频')">
							<a class="click-a" style="padding: 0;" href="#"	target="middle">
	                            <img src="images/gxsp1.png" alt="共享视频" title="共享视频"/>
	                        </a>
						</li>
                        <li class="nav-list" onclick="videoShow('.sj','手机')">
                            <a class="click-a" style="padding: 0;" href="#" target="middle">
                                <img src="images/ydd.png" alt="手机" title="移动端"/>
                            </a>
                        </li>
      					<li class="nav-list" onclick="videoShow('.wrj','无人机')">
							<a class="click-a" style="padding: 0;" href="#" target="middle">
								<img src="images/wrj1.png" alt="无人机" title="无人机"/>
							</a>
						</li>
						<li class="nav-list" onclick="videoShow('.zhc','指挥车')">
							<a class="click-a" style="padding: 0;" href="#" target="middle">
								<img src="images/zhc.png" alt="指挥车" title="指挥车"/>
							</a>
						</li>
                        
					</ul>
				</li>
				<li id="spzt">
					<a class="sp" href="#" onclick="showPoint('显示全部视频')">专<br/>题</a>
					<ul class="spzt">
						<li class="nav-list" onclick="videoShow('.zwbl','中国对外进口博览会')">
                            <a class="click-a" style="padding: 0;" href="#" target="middle">
                                <img src="images/dwbl.png" alt="中国对外进口博览会" title="中国对外进口博览会"/>
                            </a>
                        </li>
						<li class="nav-list" onclick="videoShow('.zdgc','重大工程')">
							<a class="click-a" style="padding: 0;" href="#" target="middle">
								<img src="images/zdgc1.png" alt="重大工程" title="重大工程"/>
							</a>
						</li>
						<li class="nav-list" onclick="videoShow('.fxzd','防汛重点')">
							<a class="click-a" style="padding: 0;" href="#" target="middle">
								<img src="images/fxzd1.png" alt="防汛重点区域" title="防汛重点区域" />
							</a>
						</li>
						<li class="nav-list" onclick="videoShow('.zxhdzz','中小河道整治')">
							<a class="click-a" style="padding: 0;" href="#" target="middle">
								<img src="images/zxhdzz.png" alt="中小河道整治" title="中小河道整治"/>
							</a>
						</li>						
                        <li class="nav-list">
                            <a class="click-a" style="padding: 0;" href="zdgc-video.jsp" target="_top">
                                <img src="images/zjz.png" alt="上海市水务重大工程危险源视频监控平台" title="上海市水务重大工程危险源视频监控平台"/>
                            </a>
                        </li>                       
					</ul>
				</li>
				<li id="spfq" onclick="videoShow('.fqsp')">
					<a class="sp" href="#" onclick="showPoint('分区视频')">分<br/>区</a>
				</li>
				<li class="droplist qbsp" id="line7">
					<img class="close" src="<%=basePath %>/images/youjt.png"/>
					<div class="content">
						<div class="title-menu">
							<span>显示全部视频</span>
						</div>
						<div id="qbsp-insert" class="insert">

						</div>
					</div>
				</li>
				<li class="droplist zjsp" id="line">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>自建视频</span>
						</div>
						<div id="zjsp-insert" class="insert">

						</div>
					</div>
				</li>
				<li class="droplist gxsp" id="line1">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>共享视频</span>
						</div>
						<div id="gxsp-insert" class="insert">
						</div>
					</div>
				</li>
				<li class="droplist zdgc" id="line4">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>重大工程</span>
						</div>
						<div id="zdgc-insert" class="insert">

						</div>
					</div>
				</li>
				<li class="droplist fxzd" id="line5">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>防汛重点区域</span>
						</div>
						<div id="fxzd-insert" class="insert">

						</div>
					</div>
				</li>
				<li class="droplist zxhdzz" id="line6">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>中小河道整治</span>
						</div>
						<div id="yxht-insert" class="insert">

						</div>
					</div>
				</li>
				<li class="droplist sj" id="line2">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>移动端</span>
						</div>
						<div id="phone-insert" class="insert">
							${phonelist}
							<div class="phonelist">
								<ul class="yiji">
									<li onclick ="change1()" class="yiji-menu">
                                        <a href="#" class="inactive"> 手机视频 </a>
                                    </li>
									<ul style="display: none;" id ="menu1">
										<li onclick ="phonevideo()" class="erji-menu">
                                            <a href="#" class="inactive active">手机直播</a>
                                        </li>
										<li onclick ="change2()" class="erji-menu">
                                            <a href="#" class="inactive active">手机上传视频</a>
                                        </li>
										<ul style="display:none" class="sanji-menu" id = "menu3" ></ul>
										<script type="text/javascript">
											jQuery.post("http://31.16.10.77:8080/shswpt/selectvideo_gjson.do",function(d){
                                                var li = "";
                                            });
											jQuery.post("http://31.16.10.77:8080/shswpt/selectvideo_gjson.do",function(d){
                                                var li = "";
                                                d = eval("("+d+")");
												jQuery.each(d,function(i,v){
													li = li + "";
												});
												var num=document.getElementById("menu3").innerHTML = li;
												var num=document.getElementById("menu3").getElementsByTagName("li").length;
												document.getElementById("hss").innerHTML=num
                                            });
											function videotest(filepath,longitude,latitude){
												phone(longitude,latitude);
												layer.open( {
													type : 2,
													title : '手机视频',
													shadeClose : true,
													id : 'insert-form',
													shade : 0,
													offset : 'r',
													//maxmin: true, //开启最大化最小化按钮
													area : [ '600px', '500px' ],
													content : '<%=basePath %>/selectvideo_detail.do?url='+filepath
												});
											}
										</script>
									</ul>
									<li class="yiji-menu"><a href="#" class="inactive"> 手机图片 </a></li>
								</ul>
							</div>
						</div>
					</div>
				</li>
				<li class="droplist wrj" id="line3">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>无人机</span>
						</div>
						<div class="insert">
						<ul style="display:none" class="sanji-menu" id = "menu3" >
							<li><a onclick=""><img src='<%=basePath %>/images/sjsp1.png'>无人机通道1</a></li>	
						</ul>
						</div>
					</div>
				</li>
				
				<li class="droplist zhc" id="line2">
					<img class="close" src="<%=basePath %>/images/youjt.png" onclick="closeVideo(this)"/>
					<div class="content">
						<div class="title-menu">
							<span>指挥车</span>
						</div>
						<div id="phone-insert" class="insert">
							<div class="phonelist">
								<ul class="yiji">
									<li onclick ="change1()" class="yiji-menu">
                                        <a href="#" class="inactive"> 指挥车01 </a>
                                    </li>
									<ul style="" id ="menu1">
										<ul style="" class="sanji-menu" id = "menu3" ></ul>
										<li style="cursor:pointer;"><a  onclick="video('1000000@001$1$0$0','指挥车01')">指挥车摄像1</a></li>
										<li style="cursor:pointer;"><a  onclick="video('1000000@001$1$0$1','指挥车01')">指挥车摄像2</a></li>
										<li style="cursor:pointer;"><a  onclick="video('1000000@001$1$0$2','指挥车01')">指挥车摄像3</a></li>
									</ul>
								</ul>
							</div>
						</div>
					</div>
				</li>
				<li class="droplist fqsp" id="line10">
					<img class="close" src="<%=basePath %>/images/youjt.png"/ onclick="closeVideo(this)">
					<div class="content">
						<div class="title-menu">
							<span>分区视频</span>
						</div>
						<div id="fqsp-insert" class="insert">

						</div>
					</div>
				</li>
                <li class="droplist zwbl" id="line11">
                    <img class="close" src="<%=basePath %>/images/youjt.png"/ onclick="closeVideo(this)">
                    <div class="content">
                        <div class="title-menu">
                            <span>中国对外进口博览会</span>
                        </div>
                        <div id="zwbl-insert" class="insert">

                        </div>
                    </div>
                </li>
			</ul>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.inactive').click(function(){
					if($(this).siblings('ul').css('display')=='none'){
						$(this).parent('li').siblings('li').removeClass('inactives');
						$(this).addClass('inactives');
						$(this).siblings('ul').slideDown(100).children('li');
						if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
							$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
							$(this).parents('li').siblings('li').children('ul').slideUp(100);
						}
					}else{
						//控制自身变成+号
						$(this).removeClass('inactives');
						//控制自身菜单下子菜单隐藏
						$(this).siblings('ul').slideUp(100);
						//控制自身子菜单变成+号
						$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
						//控制自身菜单下子菜单隐藏
						$(this).siblings('ul').children('li').children('ul').slideUp(100);
						//控制同级菜单只保持一个是展开的（-号显示）
						$(this).siblings('ul').children('li').children('a').removeClass('inactives');
					}
				})
			});
		</script>
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
		<div id="jiantou" onclick=btn();>
			<img id="img" src="images/jiantou2.png"	style="display: block; height: 30px; width: 30px; margin: 0 auto;" />
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