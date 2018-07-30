//全局变量
var zoom = null,
    symbol = null,
    infoTemplate = null;
var boxresult = new Array(); //框选结果
var searchresult = new Array(); //查询结果
var urlzw1 = "http://" + window.location.host;
var urlzw = document.location.hostname;
//默认参数def
var defcenterX = -5723.131578801142,
    defcenterY = -12022.181448897456;

var defurl = "http://31.16.1.101/arcgis/rest/services/shsw_JCDXT2016/MapServer";
var defurl1 = "http://10.107.67.82/arcgis/rest/services/shsw_JCDXT2016/MapServer";
var data = null;
var shareData = null;

$.ajax({ //全部视频
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchSysfx.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //alert(json);
        //var json1 = json;
        //document.getElementById("dd").value=json;
        qbspData = eval(json);
        //alert(data);
        //$('#tt2').tree({data:data});
    }
});
$.ajax({ //自建视频
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchSelf.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //alert(json);
        //var json1 = json;
        //document.getElementById("dd").value=json;
        zjspData = eval(json);
        //alert(data);
        //$('#tt2').tree({data:data});
    }
});

$.ajax({ //共享视频
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchShare.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //var json1 = json;
        //document.getElementById("dd").value=json;
        gxspData = eval(json);
        //      alert(gxspData);
        //$('#tt2').tree({data:data});
    }
});

$.ajax({ //重大工程
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchZdgc.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //var json1 = json;
        //document.getElementById("dd").value=json;
        zdgcData = eval(json);
        //alert(shareData);
        //$('#tt2').tree({data:data});
    }
});

$.ajax({ //防汛重点
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchFxzd.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //var json1 = json;
        //document.getElementById("dd").value=json;
        fxzdData = eval(json);
        //alert(shareData);
        //$('#tt2').tree({data:data});
    }
});

$.ajax({ //中小河道
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchYxht.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //var json1 = json;
        //document.getElementById("dd").value=json;
        yxhtData = eval(json);
        //      alert(shareData);
        //$('#tt2').tree({data:data});
    }
});
$.ajax({ //分区视频
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchFqsp.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //alert(json);
        //var json1 = json;
        //document.getElementById("dd").value=json;
        fqspData = eval(json);
        //alert(data);
        //$('#tt2').tree({data:data});
    }
});

$.ajax({ //中国对外博览会
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchZwbl.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //alert(json);
        //var json1 = json;
        //document.getElementById("dd").value=json;
        blhData = eval(json);
        //alert(data);
        //$('#tt2').tree({data:data});
    }
});
var data;

function selectData() {
    data = null;
    if (zdfl == "显示全部视频") {
        data = qbspData;
    } else if (zdfl == "自建视频") {
        data = zjspData;
    } else if (zdfl == "共享视频") {
        data = gxspData;
    } else if (zdfl == "重大工程") {
        data = zdgcData;
    } else if (zdfl == "防汛重点") {
        data = fxzdData;
    } else if (zdfl == "中小河道整治") {
        data = yxhtData;
    } else if (zdfl == "分区视频") {
        data = fqspData;
    }else if (zdfl == "中国对外进口博览会") {
        data = blhData;
    }
    return data;
}

var map;
require([
    "esri/Color",
    "esri/tasks/query","esri/tasks/QueryTask",

    "esri/map", "esri/dijit/Scalebar", "esri/dijit/BasemapGallery", "esri/dijit/Basemap",

    "esri/layers/ArcGISTiledMapServiceLayer", "esri/layers/ArcGISDynamicMapServiceLayer",
    "esri/layers/GraphicsLayer", "esri/layers/ClusterLayer",

    "esri/request", "esri/graphic", "esri/geometry/Extent", "esri/SpatialReference",
    "esri/geometry/Point","esri/geometry/Polyline", "esri/geometry/webMercatorUtils",

    "esri/toolbars/draw",

    "esri/symbols/SimpleMarkerSymbol",
    "esri/symbols/SimpleFillSymbol",
    "esri/symbols/SimpleLineSymbol",
    "esri/symbols/PictureMarkerSymbol",
    "esri/renderers/ClassBreaksRenderer",
    "esri/dijit/PopupTemplate",

    //  "dijit/layout/BorderContainer", 
    //  "dijit/layout/ContentPane", 

    "dojo/domReady!"
], function(
    Color, Query,QueryTask,
    Map, ScaleBar, BasemapGallery, Basemap,
    ArcGISTiledMapServiceLayer, ArcGISDynamicMapServiceLayer, GraphicsLayer, ClusterLayer,
    esriRequest, Graphic, Extent, SpatialReference, Point,Polyline, webMercatorUtils,
    Draw,
    SimpleMarkerSymbol, SimpleFillSymbol,SimpleLineSymbol, PictureMarkerSymbol, ClassBreaksRenderer,
    PopupTemplate

) {
    map = new Map("MyMapDiv", {
        logo: false,
        zoom:3,
//        minZoom: 3,
        maxZoom: 9,
        slider: false
    });
    //比例尺
    var scaleBar = new ScaleBar({
        map: map,
        attachTo: "bottom-left",
        scalebarUnit: "metric"
    });
    //加载默认底图defLayer
    if (urlzw == '10.107.67.108') {
        var defLayer = new ArcGISTiledMapServiceLayer(defurl1);
    } else {
        var defLayer = new ArcGISTiledMapServiceLayer(defurl);
    }
    map.addLayer(defLayer);

//    /**************启动BasemapGallery组件***************/
//    var serverToken = "";
//    addCHYMap();
//	function getToken()
//	{
//	    var host =  window.location.host;
//	    var clientUrl = 'ref.http://' + host;
//	    if(urlzw == '10.107.67.108'){
//	    	var tokenurl = 'http://10.107.67.82/RemoteTokenServer?request=getToken&username=waterdepart&password=11111111&clientid=' + clientUrl + '&expiration=500';
//	    }else{
//	    	var tokenurl = 'http://10.108.3.36/RemoteTokenServer?request=getToken&username=waterdepart&password=11111111&clientid=' + clientUrl + '&expiration=500';
//	    }
//	    
//	    var xmlHttp = CreateXMLHttp();
//	    xmlHttp.open('GET', tokenurl, false);
////		xmlHttp.send();
//		var token = xmlHttp.responseText;
//		token = token.substring(0, token.lastIndexOf("\r\n"));
//		token = "?token=" + token;
//		serverToken = token;
//		return serverToken;
//	}
//	
//	function CreateXMLHttp(){
//        var xmlHttp = false;
//        if (window.XMLHttpRequest){
//　　　     		xmlHttp = new XMLHttpRequest();
//　　    	}else if (window.ActiveXObject){
//　　        		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
//　      	}else{
//            xmlHttp = null;
//       }    
//        return xmlHttp;
//    }
//	function addCHYMap(){
//		var serverToken = getToken();
//	    //底图1
//	    if(urlzw == '10.107.67.108'){
//	    	var purplishBlueTiledLayer = new ArcGISTiledMapServiceLayer("http://10.107.67.82/OneMapServer/rest/services/Air2018/MapServer"+serverToken);
//	    }else{
//	        var purplishBlueTiledLayer = new ArcGISTiledMapServiceLayer("http://10.108.3.36/OneMapServer/rest/services/Air2018/MapServer"+serverToken);
//	    }
//	    purplishBlueBasemap = new Basemap({
//	        layers: [purplishBlueTiledLayer],
//	        title: "2018卫星地图",
//	        thumbnailUrl: "images/shanghai1.png"
//	    });
//
//	    //底图2
//	    if(urlzw == '10.107.67.108'){
//	        var colorTiledLayer = new ArcGISTiledMapServiceLayer(defurl1);
//	    }else{
//	        var colorTiledLayer = new ArcGISTiledMapServiceLayer(defurl);
//	    }
//	    colorBasemap = new Basemap({
//	          layers: [colorTiledLayer],
//	          title: "政务地图",
//	          thumbnailUrl: "images/map.png"
//	    });
//	}
//	 var basemapGallery = new BasemapGallery({
//	    	showArcGISBasemaps: false,
//	        map: map,
//	        basemaps: [purplishBlueBasemap, colorBasemap]
//	    }, "basemapGallery");
//	 basemapGallery.startup();
//	        
//	 basemapGallery.on("selection-change", function () {
//		 var basemap = basemapGallery.getSelected();
//	 });
//
///*****************启动BasemapGallery组件结束**************/
    /**************启动BasemapGallery组件***************/
    //底图1
    if (urlzw == '10.107.67.108') {
        var purplishBlueTiledLayer = new ArcGISTiledMapServiceLayer("http://10.107.67.82/arcgis/rest/services/shsw_JCDXT2016/MapServer");
    } else {
        var purplishBlueTiledLayer = new ArcGISTiledMapServiceLayer("http://31.16.1.101/arcgis/rest/services/shsw_JCDXT2016/MapServer");
    }
    var purplishBlueBasemap = new Basemap({
        layers: [purplishBlueTiledLayer],
        title: "卫星图",
        thumbnailUrl: "images/map.png"
    });

    //底图2.3
    if (urlzw == '10.107.67.108') {
        var colorTiledLayer = new ArcGISDynamicMapServiceLayer("http://10.107.67.82/ArcGIS/rest/services/shsw_HKYX_2018/MapServer");

    } else {
        var colorTiledLayer = new ArcGISDynamicMapServiceLayer("http://31.16.1.101/ArcGIS/rest/services/shsw_HKYX_2018/MapServer");
    }
    var colorBasemap = new Basemap({
        layers: [colorTiledLayer],
        title: "地图",
        thumbnailUrl: "images/shanghai1.png"
    });

    var basemapGallery = new BasemapGallery({
        showArcGISBasemaps: false,
        map: map,
        basemaps: [purplishBlueBasemap, colorBasemap]
    }, "basemapGallery");
    basemapGallery.startup();
    basemapGallery.on("error", function(msg) { //失败时触发
        console.log("basemap gallery error:  ", msg);
    });
    /*****************启动BasemapGallery组件结束**************/


    /********************打开地图加载所有点*******************/
    var clusterLayer;
    map.on("load", function() {
    	map.centerAt(new Point(-4000,-20000,defLayer.spatialReference));
    	//初始加载自建和共享视频
        var resp = zjspData.concat(gxspData); 
        clusterdata(resp);
        var timerDt = setTimeout(function () {
            $("#MyMapDiv .dijitTitlePaneTextNode").text("");
            $("#MyMapDiv .dijitTitlePaneTextNode").append("<img src='images/bg-dt.png' style='width:50px;height:30px;'/>");
          }
      , 20);
    });
    /******************打开地图加载所有点结束*****************/


    /**********************分类加载视频点********************/
    pointLoad = function() {
        map.removeLayer(clusterLayer);
        map.removeLayer(bzqLayer);
        quxLayer.hide();
        
        if(zdfl == "中国对外进口博览会"){
        	bzq();
        }
        var cartimer;
        if(zdfl == "指挥车"){
        	searchcoord();
        	cartimer = setInterval(function() {
        		searchcoord();
        	}, 3600);
        }else{
        	if(cartimer){
        		clearInterval(cartimer);
        	}
        	CarptLayer.clear();
        	CarlineLayer.clear();
        }
        var resp = selectData();
        clusterdata(resp);
        //      map.removeLayer(phonely);
    }
    /***********************分类加载结束*********************/


    /***********************显示手机点位*********************/
    var phonely = new GraphicsLayer();
    map.addLayer(phonely);
    phone = function(longitude, latitude) {
        var coord = lbTOxy(longitude, latitude);
        phonely.clear();
        var symbol = "images/phoneup.png";
        var graphic = new Graphic(
            new Point(coord[0], coord[1]),
            new PictureMarkerSymbol(symbol, 50, 50)
        );
        phonely.add(graphic);
        var juzhongx = targetX;
        var juzhongy = targetY;
        JuZhong(juzhongx, juzhongy);
    }
    /***********************手机点位结束*********************/


    /***********************圈选显示结果*********************/
    var drawToolbar  =  new  esri.toolbars.Draw(map);
    box = function() {
        map.setMapCursor("crosshair");
        drawToolbar.activate(esri.toolbars.Draw.FREEHAND_POLYGON); 
        document.oncontextmenu = function(e) {
            var e = evt || window.event;

            if (e.preventDefault) {
                e.preventDefault();
            }

            if (e.stopPropagation) {
                e.stopPropagation();
            } else {
                e.returnValue = false; // 解决IE8右键弹出
                e.cancelBubble = true;
            }
        }; //阻止默认右键菜单
        document.onmousedown = function(e) {
            var e = e || window.event;
            if (e.button == 2) {
                map.setMapCursor("default");
                drawToolbar.deactivate();
            } else {
                drawToolbar.on("draw-end", function(results) {
                    queryGra(results);
                });
            }
        } 
    }

    function queryGra(freepolygon) {
        map.setMapCursor("default");
        drawToolbar.deactivate();

        //定义选中点数组
        var selected = [];
        //        var boxresult = new Array();
                
        var  graphics  =  clusterLayer.graphics;

        //判断是否选中
                
        for (var  i = 0; i < graphics.length; i++) {              
            if (freepolygon.geometry.contains(graphics[i].geometry)) {
                if (graphics[i].attributes.type == "point") {
                    var attr = graphics[i].attributes;
                    for (var j = 0; j < attr.subGra.length; j++) {
                        var box = attr.subGra[j];
                        selected.push(box);
                    }
                }             
            }  
        }
        showDivFun(selected, "draw");
    }
    /***********************圈选显示结束*********************/


    /***********************居中显示结束*********************/
    JuZhong = function(juzhongx, juzhongy) {
        var point = null;
        point = new esri.geometry.Point(juzhongx, juzhongy, map.spatialReference);
        map.setZoom(7);
        map.centerAt(point);
    }
    /***********************居中显示结束*********************/


    /**********************回车模糊查询***********************/
    Search = function() {
        if (event.keyCode == 13) {
            var searchresult = [];
            var graphics = clusterLayer.graphics;
            var search = document.getElementById("search").value;
            for (i = 0; i < graphics.length; i++) {
                if (graphics[i].attributes.type == "point") {
                    var gras = graphics[i].attributes.subGra;
                    for (var j = 0; j < gras.length; j++) {
                        var attr = gras[j].attributes;
                        if (attr.name.indexOf(search) >= 0) {
                            searchresult.push(gras[j]);
                        }
                    }
                }
            }
            showDivFun(searchresult, "search");
        }
    }
    /*********************回车模糊查询结束*********************/


    /***********************点位聚合方法*********************/
    //处理clusterLayer数据方法
    function clusterdata(resp) {
        var cameraInfo = [];
        var wgs = defLayer.spatialReference;
        if(resp!= null){
        	for (var i = 0; i < resp.length; i++) {
                var p = resp[i];
                if (p[7] != null) {
                    var latlng = new Point(parseFloat(p[7]), parseFloat(p[8]), wgs);
                    var attributes = {
                        "name": p[1],
                        "code": p[2],
                        "approve": p[3],
                        "date": p[4],
                        "useful": p[5],
                        "address": p[6],
                        "longitude": p[7],
                        "latitude": p[8],
                        "user": p[9],
                        "type": p[10],
                        "dm": p[11],
                        "dwdm": p[12],
                        "ssgc": p[13]
                    };
                    var cam = {
                        "x": latlng.x,
                        "y": latlng.y,
                        "attributes": attributes
                    };
                    cameraInfo.push(cam);
                }
            }
            addClusters(cameraInfo);
        }
    }
    //加载clusterLayer
    function addClusters(cameraInfo) {
        // popupTemplate to work with attributes specific to this dataset
        var popupTemplate = new PopupTemplate();

        // cluster layer that uses OpenLayers style clustering
        clusterLayer = new ClusterLayer({
            "data": cameraInfo,
            "distance": 30,
            "id": "clusters",
            "labelColor": "#fff",
            "labelOffset": 10,
            "resolution": map.extent.getWidth() / map.width,
            "singleColor": "#888",
            "sr": defLayer.spatialReference
        });

        var defaultSym = new SimpleMarkerSymbol().setSize(4);
        var renderer = new ClassBreaksRenderer(defaultSym, "useful");

        var picBaseUrl = "images/";

        var green = new PictureMarkerSymbol(picBaseUrl + "ballmachine.png", 40, 40).setOffset(0, 15);
        var red = new PictureMarkerSymbol(picBaseUrl + "devideo.png", 40, 40).setOffset(0, 15);

        renderer.addBreak(0, 5, red);
        renderer.addBreak(5, 10, green);
        clusterLayer.setRenderer(renderer);
        map.addLayer(clusterLayer);

        //点位点击方法
        clusterLayer.on("click", function(event) {
            var graphics = event.graphic.attributes.subGra;
            if (graphics.length == 1) {
                var stats11 = graphics[0].attributes.code;
                var stats12 = graphics[0].attributes.user;

                if (graphics[0].attributes.useful == "否") {
                    video(stats11, stats12);
                }
            } else if (graphics.length > 1) {
                showDivFun(graphics, "click");
            }
        });
        //点位经过提示
        clusterLayer.on("mouse-over",function(event){
        	  var graphics = event.graphic.attributes.subGra;
        	  if(graphics.length == 1){
        		  console.log(graphics[0].attributes.name);
                map.infoWindow.setContent(graphics[0].attributes.name);
                map.infoWindow.resize(100, 60)
                map.infoWindow.show(event.mapPoint);
        	  }else if(graphics.length > 1){
                map.infoWindow.setContent("请点击");
                map.infoWindow.resize(100, 60)
                map.infoWindow.show(event.mapPoint);
        	  } 
        });
        clusterLayer.on("mouse-out",function(event){
        	  map.infoWindow.hide();
        });
    }
 
    function cleanUp() {
        map.infoWindow.hide();
        clusterLayer.clearSingles();
    }

    function error(err) {
        console.log("something failed: ", err);
    }
    /*******************点位聚合方法结束*********************/
    /*******************区县显示方法*********************/
    var quxLayer = new GraphicsLayer();
    map.addLayer(quxLayer);
    var quxselect = 0;
    defLayer.on("load",function(){
    	queryQux();
    }); 
    
    function queryQux(){
    	var queryTask = new QueryTask(defurl + "/49");
    	var query = new Query();
    	query.where = "OBJECTID >= 0";
    	query.outFields = ["*"];
    	query.returnGeometry = true;
    	queryTask.execute(query,function(queryRes){
    		console.log(queryRes);
    		var quxs = queryRes.features;
    		for(var i = 0;i<quxs.length;i++){
    			var graphic = quxs[i];
    			quxLayer.add(graphic);
    		}
    	});
    	
    }
    showQux = function(text){
    	quxLayer.show();
    	var str = text.substring(0, 2);
    	console.log(str);
    	var symbol = new SimpleLineSymbol(
    		    SimpleLineSymbol.STYLE_SOLID,
    		    new Color([255,0,0]),
    		    3
    		  );
    	var quxs = quxLayer.graphics;
    	for(var i = 0;i<quxs.length;i++){
    		var xstring = quxs[i].attributes["区县名称"];
    		if(xstring.indexOf(str) != -1){
    			quxs[i].setSymbol(symbol);
    		}else{
    			quxs[i].setSymbol(null);
    		}
    	}
    	
    }
    /*******************区县显示结束*********************/
    
    /*******************保障区显示方法*********************/
    var bzqurl = "http://31.16.1.101/arcgis/rest/services/shsw_Jbhfxft/MapServer";
    var bzqLayer = new ArcGISDynamicMapServiceLayer(bzqurl);
    function bzq(){
        bzqLayer.opacity = 0.5;
	    map.addLayer(bzqLayer);
	    var bzqvisible = [0,1,2,3,4,5,6,7,8,9,20,21,22,23];
	    bzqLayer.setVisibleLayers(bzqvisible);
	    map.setZoom(5);
	    var cpoint = new Point(-15000,-2300,defLayer.spatialReference);
	    map.centerAt(cpoint);
    }
    /*******************保障区显示结束*********************/
    
    /*******************巡查车展示方法*********************/
    var CarptLayer = new GraphicsLayer();
    var CarlineLayer = new GraphicsLayer();
    map.addLayer(CarptLayer);
    map.addLayer(CarlineLayer);
    
    var psym = new SimpleMarkerSymbol(SimpleMarkerSymbol.STYLE_SQUARE, 10,
		    new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID,
		    	    new Color([255,0,0]), 1),
		    	    new Color([0,255,0,0.25]));
	var carlsym = new SimpleLineSymbol(
		    SimpleLineSymbol.STYLE_DASH,
		    new Color([255,0,0]),
		    3);
	
    function searchcoord(){
    	$.ajax({
			async:false,
			type:'post',
			data:{deviceCode:'1000021'},
			url: urlzw1+'/shswpt/ssu/ssu_getZhcGps.do',
			cache:false,
			success:function(json){
				var gpsData = JSON.parse(json);
                gpsData = gpsData.data;
				var tempdata = eval(gpsData);
				var data = tempdata[6];
//				console.log(data);
				showCar(data);
			}
		});
    }
   
    function showCar(data){
    	var coord = lbTOxy(data.mapX,data.mapY);
    	var pt = new Point(coord[0],coord[1],defLayer.spatialReference);
    	var attr = {
    			name:data.carNum,
    			speed:data.speed
    	};
    	var Car = new Graphic(pt,psym,attr,null);
		CarptLayer.add(Car);
		map.centerAt(pt);
		
		if(CarptLayer.graphics.length == 2){
    		var stgeo = CarptLayer.graphics[0].geometry;
    		var secgeo = CarptLayer.graphics[1].geometry;
    		
    		var line = new Polyline([[secgeo.x, secgeo.y],[stgeo.x, stgeo.y]]);
    		var Line = new Graphic(line,carlsym,attr,null);
    		CarlineLayer.add(Line);
    	}else if(CarptLayer.graphics.length > 2){
    		var templ = CarlineLayer.graphics[0].geometry;
    		templ.paths[0].push([coord[0],coord[1]]);
    		CarlineLayer.clear();
    		var goLine = new Graphic(templ,carlsym,attr,null);
    		CarlineLayer.add(goLine);
    	}  	
    }
  //点位点击方法
    CarptLayer.on("click", function(event) {
    	var graphics = event.graphic.attributes;
        map.infoWindow.setContent(
        		"名称："+graphics.name+"<br/>"
        		+"速度："+graphics.speed+"<br/>"
        		+"<button code ='1000000@001$1$0$0' onclick='video(this.code)'>视频1</button>"+" "
        		+"<button code ='1000000@001$1$0$1' onclick='video(this.code)'>视频2</button>"+" "
        		+"<button code ='1000000@001$1$0$2' onclick='video(this.code)'>视频3</button>");
        map.infoWindow.resize(180, 90);
        map.infoWindow.show(event.mapPoint); 
       
    });
    
   
    /*******************巡查车展示结束*********************/
    
    /*******************雨情联动显示*********************/
    //加载雨情站点
    var yuqLayer = new GraphicsLayer();
    map.addLayer(yuqLayer);
    JCpoint();
    function JCpoint(){
    	var popupt = new PopupTemplate();
    	popupt.setContent("名称: ${mc}");
    	
    	var point1 = new Point(25735.5652,-42450.0029);
    	var attr = {"mc":"五四农场","code":"1000021$1$0$0"};
    	var gra1 = new Graphic(point1,psym,attr,null);
    	yuqLayer.add(gra1);
    	var point2 = new Point(-22051.2982,-25094.1811);
    	var attr = {"mc":"岳阳","code":"1000009$1$0$0"};
    	var gra2 = new Graphic(point2,psym,attr,null);
    	yuqLayer.add(gra2);
    }
    
    var timerDt = setTimeout(function () {
    	YuQing();
      }, 200);
    
    function YuQing(){
        $.ajax({ //全部视频
            async: false,
            type: 'get',
            url: "http://31.16.1.178/DataService/JsonService.svc/GetYuLiangShiShi/1/岳阳,五四农场",
            datatype: "json",
            cache: false,
            success: function(json) {
                yuqData = eval(json);
                for(var i = 0;i<yuqData.length;i++){
                	if(yuqData[i].BIAOZHUJIBIE < 7){//正式改为4
                		for(var k = 0;k<yuqLayer.graphics.length;k++){
                			if(yuqLayer.graphics[k].attributes.mc == yuqData[i].STATIONNAME){
//                				alert(yuqLayer.graphics[k].attributes.code);
                				//录制方法
                			}
                		}
                	}
                }
            }
        });
    }

    /*******************雨情联动结束*********************/
});


//坐标转换
function lbTOxy(Aa, Bb){
    var a = 6378245.0; //'椭球体长半轴				 
    var b = 6356863.0188;; // '椭球体短半轴				 
    var f = (a - b) / a;; //'扁率				 
    var e1 = Math.sqrt(2 * f - MZ(f, 2)); // '第一偏心率				 
    var e2 = e1 / Math.sqrt(1 - MZ(e1, 2)); //'第二偏心率				 
    var falseE = 8.0; //EastOffset东偏移 			 
    var falseN = -3457143.04; //NorthOffset北偏移
    var L0 = 121.4671519444444; //CentralMeridian中央经				 
    var W0 = 0.0; //OriginLatitude原点纬线				 
    var k0 = 1; //'比例因子							 
    var PI = 3.14159265358979;
    /*
     * 输入参数分别是：经度、纬度
     */
    var BR = (Bb - W0) * PI / 180; //纬度弧长				 
    var lo = (Aa - L0) * PI / 180; //经差弧度				 
    var N = a / Math.sqrt(1 - MZ((e1 * Math.sin(BR)), 2)) //卯酉圈曲率半径
    //求解参数s
    var B0;
    var B2;
    var B4;
    var B6;
    var B8;
    var C = MZ(a, 2) / b;
    B0 = 1 - 3 * MZ(e2, 2) / 4 + 45 * MZ(e2, 4) / 64 - 175 * MZ(e2, 6) / 256 + 11025 * MZ(e2, 8) / 16384;
    B2 = B0 - 1
    B4 = 15 / 32 * MZ(e2, 4) - 175 / 384 * MZ(e2, 6) + 3675 / 8192 * MZ(e2, 8);
    B6 = 0 - 35 / 96 * MZ(e2, 6) + 735 / 2048 * MZ(e2, 8);
    B8 = 315 / 1024 * MZ(e2, 8);
    s = C * (B0 * BR + Math.sin(BR) * (B2 * Math.cos(BR) + B4 * MZ((Math.cos(BR)), 3) + B6 * MZ((Math.cos(BR)), 5) + B8 * MZ((Math.cos(BR)), 7)))

    var t = Math.tan(BR);
    var g = e2 * Math.cos(BR); 
    var XR = s + MZ(lo, 2) / 2 * N * Math.sin(BR) * Math.cos(BR) + MZ(lo, 4) * N * Math.sin(BR) * MZ((Math.cos(BR)), 3) / 24 * (5 - MZ(t, 2) + 9 * MZ(g, 2) + 4 * MZ(g, 4)) + MZ(lo, 6) * N * Math.sin(BR) * MZ((Math.cos(BR)), 5) * (61 - 58 * MZ(t, 2) + MZ(t, 4)) / 720; 
    var YR = lo * N * Math.cos(BR) + MZ(lo, 3) * N / 6 * MZ((Math.cos(BR)), 3) * (1 - MZ(t, 2) + MZ(g, 2)) + MZ(lo, 5) * N / 120 * MZ((Math.cos(BR)), 5) * (5 - 18 * MZ(t, 2) + MZ(t, 4) + 14 * MZ(g, 2) - 58 * MZ(g, 2) * MZ(t, 2));
    mapX = YR + falseE;
    mapY = XR + falseN; 
    return [mapX, mapY]; 
}
function MZ(x, y) {
    var res = Math.pow(x, y);
    return res;
}


//关闭查询结果
function closeSearch() {
    document.getElementById('searchdiv').style.display = 'none';
}

//框选结果展示
function showDivFun(boxresult, type) {
    var a = 0; //在线视频数
    var b = 0; //离线视频数
    document.getElementById('boxdiv').style.display = 'block';
    //显示
    $("#table2").empty();
    var html = '<tr>' +
        '<td style="width:150px;">设备</td>' +
        '<td style="width:74px;">来源</td>' +
        '<td style="width:100px;">操作</td>' +
        '</tr>';
    $("#table2").html(html);
    for (j = 0; j < boxresult.length; j++) {
        var box = boxresult[j].attributes;
        var trrr = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var td3 = document.createElement("td");
        if(!/^\d+$/.test(j/2)){
        	trrr.style.backgroundColor = "#efefef";
        }
        trrr.setAttribute("x", boxresult[j].x);
        trrr.setAttribute("y", boxresult[j].y);
        trrr.onclick = function() {
            JuZhong(trrr.getAttribute("x"), trrr.getAttribute("y"));
        }
        td1.style.whiteSpace = "nowrap";
        td2.style.whiteSpace = "nowrap";
        td1.innerHTML = box.name;
        td2.innerHTML = box.user;
        if (box.useful == "否") {
            a++;
            var player = document.createElement("img");
            player.src = "images/player.png";
            player.style.width = "35px";
            player.style.cursor = "pointer";
            //btn.type = "button";
            (function(indexj) {
                player.onclick = function() {
                	 if(type == "draw"){
                		 video(boxresult[indexj].attributes.code, boxresult[indexj].attributes.user);
                	 }else if(type == "search"){
                	     video(boxresult[indexj].attributes.code, boxresult[indexj].attributes.user);
                	 }else if(type == "click"){
                	     video(boxresult[indexj].code, boxresult[indexj].user);
                	 }
                }
            })(j)
            td3.appendChild(player);
        } else {
            b++;
        }
        trrr.appendChild(td1);
        trrr.appendChild(td2);
        trrr.appendChild(td3);
        $("#table2").append(trrr);
    }
	
    var drawA = "您所选的区域有在线视频"+ a +"个,离线视频" + b + "个";
    var searchA = "您查询的设备有在线视频"+ a +"个,离线视频" + b + "个";
    var clickA = "您选择的位置有在线视频"+ a +"个,离线视频" + b + "个";
    if(type == "draw"){
        $("#boxdiv .panel-heading span").text(drawA);
    }else if(type == "search"){
        $("#boxdiv .panel-heading span").text(searchA);
    }else if(type == "click"){
        $("#boxdiv .panel-heading span").text(clickA);
    }
}
//关闭框选结果
function closeBox() {
    document.getElementById('boxdiv').style.display = 'none';
}