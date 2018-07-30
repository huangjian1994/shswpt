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

$.ajax({ //质检站
    async: false,
    type: 'post',
    url: urlzw1 + '/shswpt/ssu/ssu_fetchZjz.do',
    datatype: "json",
    cache: false,
    success: function(json) {
        //var json1 = json;
        //document.getElementById("dd").value=json;
        zjzData = eval(json);
    }
});

var map;
require([
    "esri/Color",
    "esri/tasks/query","esri/tasks/QueryTask",

    "esri/map", "esri/dijit/Scalebar", "esri/dijit/BasemapGallery", "esri/dijit/Basemap",

    "esri/layers/ArcGISTiledMapServiceLayer", "esri/layers/ArcGISDynamicMapServiceLayer",
    "esri/layers/GraphicsLayer", "esri/layers/ClusterLayer",

    "esri/request", "esri/graphic", "esri/geometry/Extent", "esri/SpatialReference",
    "esri/geometry/Point", "esri/geometry/webMercatorUtils",

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
    esriRequest, Graphic, Extent, SpatialReference, Point, webMercatorUtils,
    Draw,
    SimpleMarkerSymbol, SimpleFillSymbol,SimpleLineSymbol, PictureMarkerSymbol, ClassBreaksRenderer,
    PopupTemplate

) {
    map = new Map("MyMapDiv", {
        logo: false,
        zoom:3,
        minZoom: 3,
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

    /**************启动BasemapGallery组件***************/
    //底图1
    if (urlzw == '10.107.67.108') {
        var purplishBlueTiledLayer = new ArcGISTiledMapServiceLayer("http://10.107.67.82/arcgis/rest/services/shsw_JCDXT2016/MapServer");
    } else {
        var purplishBlueTiledLayer = new ArcGISTiledMapServiceLayer("http://31.16.1.101/arcgis/rest/services/shsw_JCDXT2016/MapServer");
    }
    var purplishBlueBasemap = new Basemap({
        layers: [purplishBlueTiledLayer],
        title: "地形图",
        thumbnailUrl: "images/map.png"
    });

    //底图2.3
    if (urlzw == '10.107.67.108') {
        var colorTiledLayer = new ArcGISTiledMapServiceLayer("http://10.107.67.82/ArcGIS/rest/services/shsw_HKYX_2012/MapServer");

    } else {
        var colorTiledLayer = new ArcGISTiledMapServiceLayer("http://31.16.1.101/ArcGIS/rest/services/shsw_HKYX_2012/MapServer");
    }
    var colorBasemap = new Basemap({
        layers: [colorTiledLayer],
        title: "平面图",
        thumbnailUrl: "images/shanghai1.png"
    });

    var basemapGallery = new BasemapGallery({
        showArcGISBasemaps: false,
        map: map,
        basemaps: [purplishBlueBasemap, colorBasemap]
    }, "basemapGallery");
    basemapGallery.startup();

    basemapGallery.on("selection-change", function() {
        var basemap = basemapGallery.getSelected();
    });
    /*****************启动BasemapGallery组件结束**************/


    /********************打开地图加载所有点*******************/
    var clusterLayer;
    map.on("load", function() {
    	map.centerAt(new Point(-4000,-20000,defLayer.spatialReference));
        showZjz();//加载所有点zjzData
    });
    /******************打开地图加载所有点结束*****************/
    
    
    /******************显示质检站所有点*****************/
    var zjzLayer = new GraphicsLayer();
    map.addLayer(zjzLayer);
    var picBaseUrl = "images/";
    var green = new PictureMarkerSymbol(picBaseUrl + "ballmachine.png", 40, 40).setOffset(0, 15);
    var red = new PictureMarkerSymbol(picBaseUrl + "devideo.png", 40, 40).setOffset(0, 15);
    function showZjz(){
    	for(var i = 0;i<zjzData.length;i++){
    		var data = zjzData[i];
    		var point = new Point(data[7],data[8]);
    		if(data[5] == '否'){
    			symbol = green;
    		}else{
    			symbol = red;
    		}
    		var attr = {"name": data[1],
                    "code": data[2],
                    "approve": data[3],
                    "date": data[4],
                    "useful": data[5],
                    "address": data[6],
                    "x": data[7],
                    "y": data[8],
                    "user": data[9],
                    "type": data[10],
                    "dm": data[11],
                    "dwdm": data[12],
                    "ssgc": data[13],
                    "zt": data[13]};
    		var graphic = new Graphic(point,symbol,attr,null);
    		zjzLayer.add(graphic);
    	}
    }
    /******************显示质检站点结束*****************/

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
        var graphics  =  zjzLayer.graphics;

        //判断是否选中
                
        for (var  i =  0; i < graphics.length; i++) {              
            if (freepolygon.geometry.contains(graphics[i].geometry)) {
            	var attr = graphics[i].attributes;
//                for (var j = 0; j < attr.subGra.length; j++) {
//                    var box = attr.subGra[j];
//                    selected.push(box);
//                }
            	selected.push(attr);             
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
            var graphics = zjzLayer.graphics;
            var search = document.getElementById("search").value;
            for (i = 0; i < graphics.length; i++) {
            	var attr = graphics[i].attributes;
                if (attr.name.indexOf(search) >= 0) {
                    searchresult.push(attr);
                }
            }
            showDivFun(searchresult, "search");
        }
    }
    /*********************回车模糊查询结束*********************/

});


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
        var box = boxresult[j];
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
                    video(boxresult[indexj].code, boxresult[indexj].user);
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