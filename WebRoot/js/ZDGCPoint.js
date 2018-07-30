
require([
      "esri/map",
      "esri/layers/ArcGISTiledMapServiceLayer",
      "esri/layers/GraphicsLayer",
      "esri/dijit/InfoWindowLite",
      "esri/InfoTemplate",
      "esri/geometry/Point",
      "esri/graphic",
      "esri/symbols/SimpleMarkerSymbol",
      "esri/symbols/SimpleFillSymbol",
      "esri/symbols/PictureMarkerSymbol",
      "esri/geometry/webMercatorUtils",
      "esri/dijit/OverviewMap",
      "esri/dijit/Scalebar",
      "esri/dijit/BasemapGallery",
      "esri/dijit/Basemap",
      "esri/toolbars/draw",
      "dojo/on",
      "dojo/domReady!"
      
    ], function(
      Map,
      ArcGISTiledMapServiceLayer,
      GraphicsLayer,
      InfoWindowLite,
      InfoTemplate,	
      Point,
      Graphic,
      SimpleMarkerSymbol,
      SimpleFillSymbol,
      PictureMarkerSymbol,
      webMercatorUtils,
      OverviewMap,
      ScaleBar,
      BasemapGallery,
      Basemap,
      Draw,
      on
    ) {
      var map = new Map("MyMapDiv", {"logo": false});
      var tiled = new ArcGISTiledMapServiceLayer("http://31.16.1.101/ArcGIS/rest/services/shsw_JCDXT/MapServer");
      map.addLayer(tiled);
      map.on("load", function () {
      	var overviewMap = new OverviewMap({
        	map: map,
        	visible: true,
        	attachTo: "bottom-right",
        	width: 300,
        	height: 200
     	});
     	overviewMap.startup();
     	
     	var scaleBar = new ScaleBar({
     		map: map,
     		attachTo: "bottom-left",
     		scalebarUnit: "metric"
     	});
     	
     	 /*****启动BasemapGallery组件*****/
        //底图1
        var purplishBlueTiledLayer = new ArcGISTiledMapServiceLayer("http://31.16.1.101/ArcGIS/rest/services/shsw_JCDXT/MapServer");
        var purplishBlueBasemap = new Basemap({
          layers: [purplishBlueTiledLayer],
          title: "地形图",
          thumbnailUrl: "images/map.png"
        });

        //底图2
        var colorTiledLayer = new ArcGISTiledMapServiceLayer("http://31.16.1.101/ArcGIS/rest/services/shsw_HKYX_2012/MapServer");
        var colorBasemap = new Basemap({
          layers: [colorTiledLayer],
          title: "航空影像图",
          thumbnailUrl: "images/map01.png"
        });

       
        var basemapGallery = new BasemapGallery({
          showArcGISBasemaps: false,
          map: map,
          basemaps: [purplishBlueBasemap, colorBasemap]
        }, "basemapGallery");
        basemapGallery.startup();
        
        basemapGallery.on("selection-change", function () {
            var basemap = basemapGallery.getSelected();
            overviewMap.overviewMap.removeAllLayers();
            overviewMap.overviewMap.addLayer(basemap.getLayers()[0]);
          });
     	 
     	
     	//中心点，以及选择切片
     	var pointCentent = new Point(-5723.131578801142, -12022.181448897456, map.spatialReference);
     	map.centerAndZoom(pointCentent, 4);
     	
     	var cameraLayer = new GraphicsLayer();
        map.addLayer(cameraLayer);
        cameraLayer.on("click", function (event) {
         // alert(event.graphic.attributes.deviceID + " " + event.graphic.attributes.deviceType);
          if(event.graphic.attributes.deviceID == "001"){
        	  video11();
          }else if(event.graphic.attributes.deviceID == "002"){
        	  video12();
          }else if(event.graphic.attributes.deviceID == "003"){
        	  video13();
          }else if(event.graphic.attributes.deviceID == "004"){
        	  video16();
          }else if(event.graphic.attributes.deviceID == "005"){
        	  video14();
          }else if(event.graphic.attributes.deviceID == "006"){
        	  video15();
          }else if(event.graphic.attributes.deviceID == "007"){
        	  video();
          }else if(event.graphic.attributes.deviceID == "008"){
        	  video1();
          }else if(event.graphic.attributes.deviceID == "009"){
        	  video2();
          }else if(event.graphic.attributes.deviceID == "0010"){
        	  video3();
          }else if(event.graphic.attributes.deviceID == "0011"){
        	  video4();
          }else if(event.graphic.attributes.deviceID == "0012"){
        	  video5();
          }else if(event.graphic.attributes.deviceID == "0013"){
        	  video6();
          }else if(event.graphic.attributes.deviceID == "0014"){
        	  video17();
          }else if(event.graphic.attributes.deviceID == "0015"){
        	  video17();
          }else if(event.graphic.attributes.deviceID == "0016"){
        	  video8();
          }else if(event.graphic.attributes.deviceID == "0017"){
        	  video9();
          }else if(event.graphic.attributes.deviceID == "0018"){
        	  video10();
          }else if(event.graphic.attributes.deviceID == "0019"){
        	  video18();
          }else if(event.graphic.attributes.deviceID == "0020"){
        	  video19();
          }else if(event.graphic.attributes.deviceID == "0021"){
        	  video20();
          }else if(event.graphic.attributes.deviceID == "0022"){
        	  video21();
          }
        });
        
        cameraLayer.on("mouse-over", function (event) {
            map.infoWindow.setTitle("设备信息");
            map.infoWindow.setContent("设备类型: " + event.graphic.attributes.deviceType + "<br>设备编号: " + event.graphic.attributes.deviceID);
            map.infoWindow.show(event.mapPoint, map.getInfoWindowAnchor(event.screenPoint));
          });

          cameraLayer.on("mouse-out", function (event) {
            map.infoWindow.hide();
          });
     	
     	//全球眼系列  00-  淀东泵闸工程（淀东饮水闸泵闸）
     	var point001 = new Point(-10410.74561762548, -12434.683446748233, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);//点图片大小
        var graphic = new Graphic(point001, symbol);
        graphic.attributes = {
                deviceType: "淀东泵闸工程1",
                deviceID: "001"
              };
        cameraLayer.add(graphic);
     	
      //全球眼系列  00-  淀东泵闸工程（淀东排涝泵闸）
     	var point002 = new Point(-10501.516135570246, -12468.00525721174, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/devideo.png",50,50);//点图片大小
        var graphic = new Graphic(point002, symbol);
        graphic.attributes = {
                deviceType: "淀东泵闸工程2",
                deviceID: "002"
              };
        cameraLayer.add(graphic);
        
      //全球眼系列  00-  华新闸工程
     	var point003 = new Point(-24025.38826334904, 1315.749618476993, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/devideo.png",50,50);//点图片大小
        var graphic = new Graphic(point003, symbol);
        graphic.attributes = {
                deviceType: "华新闸工程",
                deviceID: "003"
              };
        cameraLayer.add(graphic);
        
      //全球眼系列  00-  张马泵站工程（001）
     	var point004 = new Point(-36416.711393922065, -22201.921299326572, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/devideo.png",50,50);//点图片大小
        var graphic = new Graphic(point004, symbol);
        graphic.attributes = {
                deviceType: "张马泵站工程1",
                deviceID: "004"
              };
        cameraLayer.add(graphic);
        
      //全球眼系列  00-  张马泵站工程（002）
     	var point005 = new Point(-36356.711393922065, -22180.921299326572, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);//点图片大小
        var graphic = new Graphic(point005, symbol);
        graphic.attributes = {
                deviceType: "张马泵站工程2",
                deviceID: "005"
              };
        cameraLayer.add(graphic);
        
      //全球眼系列  00-  新石洞水闸工程
     	var point006 = new Point(195.11536714511044, 20229.797638394055, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);//点图片大小
        var graphic = new Graphic(point006, symbol);
        graphic.attributes = {
                deviceType: "新石洞水闸工程",
                deviceID: "006"
              };
        cameraLayer.add(graphic);
        
        /**
     	
     	//点坐标   崇明奚家港
        var point = new Point(37920.93845, 23155.27311, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);//点图片大小
        var graphic = new Graphic(point, symbol);
        graphic.attributes = {
                deviceType: "崇明奚家港",
                deviceID: "007"
              };
        cameraLayer.add(graphic);
        
        //点坐标   凤凰水闸监控点
        var point1 = new Point(32411.44871, 13119.73638, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point1, symbol);
        graphic.attributes = {
                deviceType: "凤凰水闸监控点",
                deviceID: "008"
              };
        cameraLayer.add(graphic);
        
        //点坐标   三沙洪水闸
        var point2 = new Point(-8535.549854, 43655.35995, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point2, symbol);
        graphic.attributes = {
                deviceType: "三沙洪水闸",
                deviceID: "009"
              };
        cameraLayer.add(graphic);
        
        //点坐标   嘉定环城河	
        var point3 = new Point(-21030.1982, 15620.18929, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point3, symbol);
        graphic.attributes = {
                deviceType: "嘉定环城河",
                deviceID: "0010"
              };
        cameraLayer.add(graphic);
        
        //点坐标  奉贤水文站监控点
        var point4 = new Point(-2959.914145, -35870.7407, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point4, symbol);
        graphic.attributes = {
                deviceType: "奉贤水文站监控点",
                deviceID: "0011"
              };
        cameraLayer.add(graphic);
        
        //点坐标   崇西水闸
        var point5 = new Point(-25808.90732, 58183.65984, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point5, symbol);
        graphic.attributes = {
                deviceType: "崇西水闸",
                deviceID: "0012"
              };
        cameraLayer.add(graphic);
        
     	//点坐标  杨树浦水闸
        var point6 = new Point(6161.482223, 2201.686415, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point6, symbol);
        graphic.attributes = {
                deviceType: "杨树浦水闸",
                deviceID: "0013"
              };
        cameraLayer.add(graphic);
        
        
        
        //点坐标  松江通波塘监控点
        var point7 = new Point(-22100.17534, -25241.34868, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point7, symbol);
        graphic.attributes = {
                deviceType: " 松江通波塘监控点",
                deviceID: "0014"
              };
        cameraLayer.add(graphic);
        
        //点坐标  金山水文站监控点
        var point8 = new Point(-9548.481426, -56069.52696, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/devideo.png",50,50);
        var graphic = new Graphic(point8, symbol);
        graphic.attributes = {
                deviceType: "金山水文站监控点",
                deviceID: "0015"
              };
        cameraLayer.add(graphic);
        
        //点坐标  青浦章浜河监控点
        var point9 = new Point(-31557.65245, -9461.918898, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point9, symbol);
        graphic.attributes = {
                deviceType: "青浦章浜河监控点",
                deviceID: "0016"
              };
        cameraLayer.add(graphic);
        
        //点坐标  青浦防办监控点
        var point10 = new Point(-31599.15155, -9074.702112, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point10, symbol);
        graphic.attributes = {
                deviceType: "青浦防办监控点",
                deviceID: "0017"
              };
        cameraLayer.add(graphic);
        
        //点坐标  吴淞水文站    暂时无坐标
        var point11 = new Point(1829.9732630541844,14703.30299996432, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point11, symbol);
        graphic.attributes = {
                deviceType: " 吴淞水文站",
                deviceID: "0018"
              };
        cameraLayer.add(graphic);
        
        //点坐标 徐汇滨江
        var point12 = new Point(-1396.035817, -9257.131846, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/devideo.png",50,50);
        var graphic = new Graphic(point12, symbol);
        graphic.attributes = {
                deviceType: "徐汇滨江",
                deviceID: "0019"
              };
        cameraLayer.add(graphic);
        
        //点坐标 金山池泾水闸     暂时无坐标
        var point13 = new Point(-26904.937269027778,-37824.56562004107, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point13, symbol);
        graphic.attributes = {
                deviceType: "金山池泾水闸",
                deviceID: "0020"
              };
        cameraLayer.add(graphic);    
        
        //点坐标 金山龙泉港监控点
        var point14 = new Point(-8395.260433, -54334.19645, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/devideo.png",50,50);
        var graphic = new Graphic(point14, symbol);
        graphic.attributes = {
                deviceType: "金山龙泉港监控点",
                deviceID: "0021"
              };
        cameraLayer.add(graphic);
        
        //点坐标 闵行防办监控点
        var point15 = new Point(-9022.324187, -13126.81627, map.spatialReference);
        var symbol = new PictureMarkerSymbol("images/ballmachine.png",50,50);
        var graphic = new Graphic(point14, symbol);
        graphic.attributes = {
                deviceType: "闵行防办监控点",
                deviceID: "0022"
              };
        cameraLayer.add(graphic);
        
        */
        
        

        /*
        map.setMapCursor("crosshair"); 加点十字图标
        var drawToolbar = new Draw(map);
        on(drawToolbar, "draw-complete", function(event){
        	var drawGraphic = new Graphic(event.geometry, new SimpleFillSymbol());
        	var drawGraphic = new Graphic(event.geometry, new SimpleMarkerSymbol());
        	cameraLayer.add(drawGraphic);
        	console.log(event.geometry.toJson());
        });
        drawToolbar.activate(Draw.POINT);
        */
      });

    });
		
		

