<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" href="favicon.ico" />
		<title>上海水务海洋视频资源共享平台</title>

		<link href="css/left.css" rel="stylesheet" />
		<link rel="shortcut icon" href="favicon.ico" />
		<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet" />
		<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet" />

		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/prototype.js"></script>
		<script type="text/javascript" src="js/effects.js"></script>
		<script type="text/javascript" src="js/side-bar.js"></script>
		<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery/jquery.js"></script>
		<link rel="stylesheet" href="css/left-nav.css" />
		<link rel="stylesheet" type="text/css" href="zeroModal/zeroModal.css" />
		<script src="js/layer/layer.js"></script>
		<script src="zeroModal/zeroModal.js"></script>
		<link rel="stylesheet" type="text/css" href="http://localhost/arcgis_js_v314_api/library/3.20/3.20/dijit/themes/tundra/tundra.css" />
		<link rel="stylesheet" type="text/css" href="http://localhost/arcgis_js_v314_api/library/3.20/3.20/esri/css/esri.css" />
		<script type="text/Javascript" src="http://localhost/arcgis_js_v314_api/library/3.20/3.20/init.js"></script>
		<link rel="stylesheet" type="text/css" href="iconfont/iconfont.css" />
		<link rel="stylesheet" href="css/16sucai.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/left-nav.css" />
		
		
		<style type="text/css">
			.MapClass {
				width: 100%;
				height: 100%;
				border: 1px solid #000;
			}
			
			.menu {
				position: fixed;
				right: 1000px;
				top: 20px;
				left: 40px;
				width: 90%;
				z-index: 400;
			}
			
			.menu p input {
				height: 30px;
				width: 190px;
			}
			
			.menu span {
				display: block;
			}
		</style>
		<script language=javascript>
		var bLogin = -1;
		function init(){
			var obj = document.getElementById("DPSDK_OCX");
		    gWndId = obj.DPSDK_CreateSmartWnd(0, 0, 100, 100); //初始化控件，创建视频窗
			obj.DPSDK_SetWndCount(gWndId, 4);//将视频窗4分割
			//var obj = document.getElementById("DPSDK_OCX");
			nRet = obj.DPSDK_Login("31.16.10.79", 9000, "admin", "admin");//登陆，参数根据环境自己设置
			//alert("Login" + "  " + nRet);
			if(nRet == 0)
			{
				bLogin = 1;
			}
			nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 0, "1000001$1$0$0", 1, 1, 1);//第一个子窗口打开视频,视频通道号1000605$1$0$0，此字段的获取请参考开发包中附带的《组织树XML解析手册》和《常见问题解答文档》
			//alert("open video"  + "  " + nRet);
			nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 1, "1000002$1$0$0", 1, 1, 1);//第二个子窗口打开视频
			//alert("open video"  + "  " + nRet);
			nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 2, "1000002$1$0$0", 1, 1, 1);//第三个子窗口打开视频
			//alert("open video"  + "  " + nRet);
			nRet = obj.DPSDK_StartRealplayByWndNo(gWndId, 3, "1000004$1$0$0", 1, 1, 1);//第三个子窗口打开视频
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
		<script type="text/Javascript">
			require([ "dojo/parser", "dijit/layout/BorderContainer", "dijit/layout/ContentPane", "dijit/TitlePane", "dojo/domReady!" ], function( parser ) { parser.parse(); });
		</script>
		
		<script type="text/javascript" src="js/Point.js"></script>

		<script>
			/*function video(){
					layer.open({
						  type: 2 //此处以iframe举例
						  ,title: '实时视频'
						  ,area: ['370px', '400px']
						  ,shade: 0
						  ,scrollbar: false
						  ,offset: [ //为了演示，随机坐标
						    Math.random()*(jQuery(window).height()-300)
						    ,Math.random()*(jQuery(window).width()-390)
						  ]
						  ,content: 'video.jsp'
						});
			  }*/
			var x = '1';

			function video() {
				x += 1;
				window.open('jsp/videomoni/video-1.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video1() {
				x += 1;
				window.open('jsp/videomoni/video-2.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video2() {
				x += 1;
				window.open('jsp/videomoni/video-3.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video3() {
				x += 1;
				window.open('jsp/videomoni/video-4.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video4() {
				x += 1;
				window.open('jsp/videomoni/video-5.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video5() {
				x += 1;
				window.open('jsp/videomoni/video-6.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video6() {
				x += 1;
				window.open('jsp/videomoni/video-7.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video7() {
				x += 1;
				window.open('jsp/videomoni/video-8.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video8() {
				x += 1;
				window.open('jsp/videomoni/video-9.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video9() {
				x += 1;
				window.open('jsp/videomoni/video-10.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video10() {
				x += 1;
				window.open('jsp/videomoni/video-11.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video11() {
				x += 1;
				window.open('jsp/videomoni/video-12.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video12() {
				x += 1;
				window.open('jsp/videomoni/video-13.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video13() {
				x += 1;
				window.open('jsp/videomoni/video-14.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video14() {
				x += 1;
				window.open('jsp/videomoni/video-15.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video15() {
				x += 1;
				window.open('jsp/videomoni/video-16.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video16() {
				x += 1;
				window.open('jsp/videomoni/video-17.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video17() {
				x += 1;
				window.open('jsp/videomoni/video-18.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video18() {
				x += 1;
				window.open('jsp/videomoni/video-19.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video19() {
				x += 1;
				window.open('jsp/videomoni/video-20.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video20() {
				x += 1;
				window.open('jsp/videomoni/video-21.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video21() {
				x += 1;
				window.open('jsp/videomoni/video-22.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video22() {
				x += 1;
				window.open('jsp/videomoni/video-23.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video23() {
				x += 1;
				window.open('jsp/videomoni/video-24.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}

			function video24() {
				x += 1;
				window.open('jsp/videomoni/video-25.jsp', x, 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
			}
			/**
				function fenxiang(){
				var u = window.location.href;
				
				layer.open({
				  title: '请复制地址',
				  offset:'50px',
				  shade:'0',
				 content: u
				});
			  }
			*/
			function btn1() {
			//	window.open('fenping.jsp', '100', 'height=800,width=920,top=100,left=980,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
   			/*	 var show1 = document.getElementById("dRight");
    			 if (show1.style.display != 'block') {
      			 show1.style.display = 'block';
   			 } else {
      			 show1.style.display = 'none';
    			}*/
    			layer.open({
				  type: 2,
				  title: '视频查看',
				  shadeClose: true,
				  id: 'LAY_layuipro',
				  shade: 0,
				  offset: 'r',
				  area: ['1400px', '800px'],
				  content: 'video.jsp' //iframe的url
				}); 
		}
		</script>

	</head>

	<body class="tundra">

		<div id="dRight" style="width:600px;height:400px;">
			 
		</div>
		<div id="jiantou2"><img id="img2" src="images/menu.png" style="height:30px;width:30px;position:fixed;right:0px;top:40px;z-index:2147483647;" onclick="btn1()"></img>
		</div>
		<div id="MyMapDiv" class="MapClass">
			<div data-dojo-type="dijit/TitlePane" data-dojo-props="title:'测绘院', closable:false, open:false" style="position:absolute; right:20px; top:10px; z-Index:999;">
				<div data-dojo-type="dijit/layout/ContentPane" style="width:400px; height:120px; overflow:auto;">
					<div id="basemapGallery"></div>
				</div>
			</div>
		</div>

		<div id="dLeft">
			<ul class="nav">
				<li onmouseover="mouseOver()" onmouseout="mouseOut()">
					<a style="padding: 0;" href="#" target="middle"><i class="iconfont icon-icon4"></i></a>
					<ul class="droplist" id="line">
						<div style="height:3px;background:#75cef8;"></div>
						<div class="content" style="height:350px;background:white;color:#012d45;font-weight:bold;text-align:left;padding:0;margin:0;">	
							<div style="height:30px;color:#014e79;background:white;font-weight:bold;font-size:24px;font-family:'黑体';">
								<span>无人机</span>
							</div>
							<div style="height:300px;color:#014e79;font-weight:bold;width:300px;background: url(images/cbg.png) no-repeat;overflow-x: hidden;margin-top: 20px;">
								<div class="item">
									<div class="number">
										<img src="images/item.png"></img>
									</div>
									<a href="#" style="font-size: 20px;">无人机1</a>
								</div>
								<div class="item">
									<div class="number">
										<img src="images/item.png">
									</div>
									<a href="#" style="font-size: 20px;">无人机2</a>
								</div>
							</div>
						</div>
					</ul>
				</li>		
				<li onmouseover="mouseOver1()" onmouseout="mouseOut1()">
					<a style="padding: 0;" href="#" target="middle"><i class="iconfont icon-icon210"></i></a>
					<ul class="droplist" id="line1">
						<div style="height:3px;background:#75cef8;"></div>
						<div class="content" style="height:350px;background:white;color:#012d45;font-weight:bold;text-align:left;padding:0;margin:0;">
							<div style="height:30px;color:#014e79;background:white;font-weight:bold;font-size:24px;font-family:'黑体';">
								<span>自建视频</span>
							</div>
							<div style="height:300px;color:#014e79;font-weight:bold;width:300px;background: url(images/cbg.png) no-repeat;overflow-x: hidden;margin-top: 20px;">
								<div class="item">
									<div class="number">
										<img src="images/item.png"></img>
									</div>
									<a href="#" style="font-size: 20px;">信息中心</a>
								</div>
								<div class="item">
									<div class="number">
										<img src="images/item.png"></img>
									</div>
									<a href="#" style="font-size: 20px;">海洋中心</a>
								</div>
								<div class="item">
									<div class="number">
										<img src="images/item.png"></img>
									</div>
									<a href="#" style="font-size: 20px;">提防处</a>
								</div>
							</div>
						</div>
					</ul>
				</li>				
				<li onmouseover="mouseOver2()" onmouseout="mouseOut2()">
					<a style="padding: 0;" href="#" target="middle"><i class="iconfont icon-shexiangji"></i></a>
					<ul class="droplist" id="line2">
						<div style="height:3px;background:#75cef8;"></div>
						<div class="content" style="height:350px;background:white;color:#012d45;font-weight:bold;text-align:left;padding:0;margin:0;">							
							<div style="height:30px;color:#014e79;background:white;font-weight:bold;font-size:24px;font-family:'黑体';">
								<span>共享视频</span>
							</div>
							<div style="height:300px;color:#014e79;font-weight:bold;width:300px;background: url(images/cbg.png) no-repeat;overflow-x: hidden;margin-top: 20px;">
								<div class="item">
									<div class="number">
										<img src="images/item.png">
									</div>
									<a href="#" style="font-size: 20px;">海事</a>
								</div>
								<div class="item">
									<div class="number">
										<img src="images/item.png">
									</div>
									<a href="#" style="font-size: 20px;">路政</a>
								</div>
							</div>
						</div>
					</ul>
				</li>				
				<li>
					<a style="padding: 0;" href="#" target="middle" title="重大工程"><i class="iconfont icon-gongcheng"></i></a>
				</li>
				<li>
					<a style="padding: 0;" href="#" target="middle" title="防汛重点"><i class="iconfont icon-jingbao"></i></li>
				</a>
			</ul>
		</div>
		  
		<div class="menu">
			<div class="item11">
				<a class="link icon_find"></a>
				<div class="item_content">
					<p><input type="text"></input>
					</p>
				</div>
			</div>
		</div>
		<div id="jiantou" onclick="btn()">
			<img id="img" src="images/jiantou2.png" style="display:block;height:30px;width:30px;margin:0 auto;" />
		</div>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<!--<script src="jquery-css-transform.js" type="text/javascript"></script>
				<script src="jquery-animate-css-rotate-scale.js" type="text/javascript"></script>-->
		
		<script>
			$('.item11').hover(
				function() {
					var $this = $(this);
					expand($this);
				},
				function() {
					var $this = $(this);
					collapse($this);
				}
			);

			function expand($elem) {
				var angle = 0;
				var t = setInterval(function() {
					if(angle == 1440) {
						clearInterval(t);
						return;
					}
					angle += 40;
					$('.link', $elem).stop().animate({
						rotate: '+=-40deg'
					}, 0);
				}, 10);
				$elem.stop().animate({
						width: '268px'
					}, 1000)
					.find('.item_content').fadeIn(400, function() {
						$(this).find('p').stop(true, true).fadeIn(600);
					});
			}

			function collapse($elem) {
				var angle = 1440;
				var t = setInterval(function() {
					if(angle == 0) {
						clearInterval(t);
						return;
					}
					angle -= 40;
					$('.link', $elem).stop().animate({
						rotate: '+=40deg'
					}, 0);
				}, 10);
				$elem.stop().animate({
						width: '52px'
					}, 1000)
					.find('.item_content').stop(true, true).fadeOut().find('p').stop(true, true).fadeOut();
			}
		</script>
		<script type="text/javascript">
			function btn() {
				var show = document.getElementById("dLeft");
				if(show.style.display == '') {
					show.style.display = 'none';
					document.getElementById("img").src = "images/jiantou.png"
				} else {
					show.style.display = '';
					document.getElementById("img").src = "images/jiantou2.png"
				}
			}
		</script>
		<script type="text/javascript">
			function mouseOver() {
				document.getElementById('line').style.display = "block"
			}

			function mouseOut() {
				document.getElementById('line').style.display = "none"
			}

			function mouseOver1() {
				document.getElementById('line1').style.display = "block"
			}

			function mouseOut1() {
				document.getElementById('line1').style.display = "none"
			}

			function mouseOver2() {
				document.getElementById('line2').style.display = "block"
			}

			function mouseOut2() {
				document.getElementById('line2').style.display = "none"
			}
		</script>
	</body>

</html>