arrCount = [];
var timer;
var urlzw1 = "http://"+ document.location.hostname + ":8080/";

var addr = "http://"+window.location.host;
//显示点位(好像没啥用!!!!)
function showPoint(obj){
	countLinstener = 0;
	if(obj == "中国对外进口博览会"){
		bzq();
	}else{
		zdfl = obj;
		pointLoad();
	}
}
//页面无操作的回调函数
var countLinstener = 0;
var timerLinstener = setInterval(function () {
    countLinstener++;
    //console.log(countLinstener);
    if (countLinstener == 7200) {
        layer.closeAll();
    }
}, 1000);
//搜索框默认值设置
$(document).ready(function () {
    $('#search').val("请输入相应设备名称");
    $('#search').focus(function () {
        //获得焦点时，如果值为默认值，则设置为空
        if ($(this).val() == "请输入相应设备名称") {
            $(this).val("");
        }
    });
    $('#search').blur(function () {
        //失去焦点时，如果值为空，则设置为默认值
        if ($(this).val() == "") {
            $(this).val("请输入相应设备名称");
        }
    });
});
//视频列表显示
function videoShow(index,obj){	
	$(index).css("left","0px");
	countLinstener = 0;
	zdfl = obj;
	pointLoad();
}
function closeVideo(index){
	$(index).parent().css("left","-240px")
}
// 树加载
$(function () {
    var count = 0; // 计数下拉列表的个数
    //点击波浪效果
    for (var i = 0; i < $("#dLeft .ulist li").length; i++) {
        $("#dLeft .ulist li").eq(i).on("click", function () {
            $(this).ripple({color: 'rgba(14,98,221,0.7)'});
        })
    }
    // 左侧导航栏标题显示
    function listShow(id){
    	$("#"+id).mouseover(function(){
        	$("."+id).show();
        })
        $("#"+id).mouseout(function(){
        	$("."+id).hide();
        })
    }
    listShow("sply");
    listShow("spzt");
    
    /*for (var i = 0; i < $(".nav-list").length; i++) {
        (function (indexI) {
            $(".nav-list").eq(indexI).on("click", function () {
                $(".droplist").eq(indexI).css("left", "0px");
            })
            $(".close").eq(indexI).on("click",function(event){
            	$(".droplist").eq(indexI).css("left", "-240px");
                event.stopPropagation();;
            })
            //自动闭合
        })(i)
    }*/
    //var timerDt = setTimeout(function () {
          //  $("#MyMapDiv .dijitTitlePaneTextNode").text("");
           // $("#MyMapDiv .dijitTitlePaneTextNode").append("<img src='images/bg-dt.png' style='width:50px;height:30px;'/>");
       // }
   // , 20);

    function zdgcload(url, idIndex, id, clickData) { // url:方法路径 idIndex:下拉标签ID id:插入的ID
        $.ajax({
            type: "post",
            url: url,
            async: true,
            datatype: "json",
            cache: false,
            success: function (json) {
                var data = eval(json);
                console.log(data);
                var arrData = []; // 保存设备名称
                for (var i = 0; i < data.length; i++) {
                    if (id == "zdgc-insert" || id == "fxzd-insert") {
                        arrData.push(data[i][14]);
                    } else {
                        arrData.push(data[i][9]);
                    }

                }

                // 去除重复方法
                function removeDuplicate() {
                    var h = {}; // 定义一个hash表
                    var arr = []; // 定义一个临时数组
                    for (var i = 0; i < arrData.length; i++) { // 循环遍历当前数组
                        // 对元素进行判断，看是否已经存在表中，如果存在则跳过，否则存入临时数组
                        if (!h[arrData[i]]) {
                            // 存入hash表
                            h[arrData[i]] = true;
                            // 把当前数组元素存入到临时数组中
                            arr.push(arrData[i]);
                        }
                    }
                    return arr;
                }

                arrReData = removeDuplicate(); // 单位类别
                arrReData.sort().reverse();
                for (var i = 0; i < arrReData.length; i++) {
                    if (arrReData[i] == "信息中心") {
                        arrReData.splice(i, 1);
                        arrReData.unshift("信息中心");
                    }
                }
                //console.log(idIndex, arrReData);
                // 创建树
                var dropdown = document.createElement("div");
                dropdown.className = "panel-group";
                dropdown.id = idIndex;
                var zdgc = document.getElementById(id);
                zdgc.appendChild(dropdown);
                for (var i = 0; i < arrReData.length; i++) {
                    // 判断分类视频数量
                    var arr = [];
                    var arrC = [];
                    if (id == "zdgc-insert" || id == "fxzd-insert") {
                        for (var j = 0; j < arrData.length; j++) {
                            if (data[j][14] == arrReData[i] &&
                                data[j][1] != null) {
                                arr.push(j);
                            }
                        }
                    } else {
                        for (var j = 0; j < arrData.length; j++) {
                            if (data[j][9] == arrReData[i] &&
                                data[j][1] != null) {
                                arr.push(j);
                            }
                        }
                    }

                    arrC.push(idIndex, arrReData[i], arr.length);
                    arrCount.push(arrC);
                    var panel = document.createElement("div");
                    panel.className = "panel panel-default";
                    panel.style.border = "0px";
                    var panelHeading = document.createElement("div");
                    panelHeading.className = "panel-heading";
                    panelHeading.onclick = function(){
                    	if($(this).next(".panel-collapse").css("display") == "none"){
                    		$(this).children().children(".mulu").css("transform","rotate(-90deg)");
                    	}else{
                    		$(this).children().children(".mulu").css("transform","rotate(90deg)");
                    	}
                    }
                    var h4 = document.createElement("h2");
                    h4.className = "panel-title";
                    var menu = document.createElement("a");
                    menu.style.textDecoration = "none";                    

                    if (arrReData[i] == null || arrReData[i] == "") {
                        menu.innerHTML = "其他" + "(" + arr.length + ")";
                    } else {
                        menu.innerHTML = arrReData[i] + "(" +
                            arr.length + ")";
                    }
                    menu.onclick = function () {
                        countLinstener = 0;
                        zdfl = clickData;
                        pointLoad();
                        if(zdfl == "分区视频"){
                        	showQux(this.innerText);
                        }   
                    }
                    //$("<img class='mulu' src='images/mulu.png'/>").appendTo(h4);
                    h4.appendChild(menu);
                    $("<img class='mulu' style='float:right;' src='images/youjt.png'/>").appendTo(h4);
                    panelHeading.appendChild(h4);
                    panel.appendChild(panelHeading);
                    var collapse = document.createElement("div");
                    collapse.className = "panel-collapse collapse";
                    var panelBody = document.createElement("div");
                    panelBody.className = "panel-body";
                    panelBody.style.padding = "0px";
                    var ul = document.createElement("ul");
                    ul.className = "ulist";
                    ul.style.marginBottom = "55px";
                    panelBody.appendChild(ul);
                    collapse.appendChild(panelBody);
                    panel.appendChild(collapse);
                    dropdown.appendChild(panel);
                }
                for (var i = 0; i < arrData.length; i++) {
                    if (data[i][1] == null || data[i][1] == "") {
                        continue;
                    }
                    var li = document.createElement("li");
                    //li.style.marginLeft = "10px";
                    //li.style.marginTop = "5px";
                    li.style.listStyle = "none";

                    var a = document.createElement("a");
                    a.className = "list";
                    a.href = "#";
                    // 判断摄像头好坏
                    if (data[i][5] == "是") {
                        a.innerHTML = "<img src='images/sxt2.png' class='img-size'>"
                            + "&nbsp" + data[i][1];
                    } else {
                        a.innerHTML = "<img src='images/sxt1.png' class='img-size'>"
                            + "&nbsp" + data[i][1];
                    }

                 // 点击保存通道ID,地图居中
                    (function (indexI) {
                        li.onclick = function () {
                            countLinstener = 0;
                            juzhongx = data[indexI][7];
                            juzhongy = data[indexI][8];
                            JuZhong(juzhongx,juzhongy); // 点位地图居中
							if(data[indexI][5] == "否"){
                            video(data[indexI][2],data[indexI][9]);}
                        }
                    })(i);
                    li.appendChild(a);
                    var videoCount = 0;
                    if (id == "zdgc-insert" || id == "fxzd-insert") {
                        for (var j = 0; j < arrReData.length; j++) {
                            if (data[i][14] == arrReData[j] &&
                                data[i][1] != null) {
                                var uList = "#" + idIndex + " .ulist";
                                $(uList).eq(j).append(li);
                            }
                        }
                    } else {
                        for (var j = 0; j < arrReData.length; j++) {
                            if (data[i][9] == arrReData[j] &&
                                data[i][1] != null) {
                                var uList = "#" + idIndex + " .ulist";
                                $(uList).eq(j).append(li);
                            }
                        }
                    }

                }
                var idNew = "#" + idIndex + " h2 a";
                for (var i = 0; i < $(idNew).length; i++) {
                    var id1 = "collapse" + count;
                    $("#" + idIndex + " .collapse").eq(i).attr("id",
                        id1);
                    $(idNew).eq(i).attr("data-toggle", "collapse");
                    $(idNew).eq(i).attr("href", "#" + id1);
                    $(idNew).eq(i).attr("data-parent", "#" + idIndex);
                    if ($("#" + idIndex + " .ulist").eq(i).find("li").length == 0) {
                        $("#" + idIndex + " .collapse").eq(i).css(
                            "display", "none");
                    }
                    count++;
                }
            }
        })
    }

    // url:方法路径 idIndex:下拉标签ID id:插入的ID
    
    zdgcload(addr + "/shswpt/ssu/ssu_fetchSysfx.do", "a5",
        "qbsp-insert", "显示全部视频");
    zdgcload(addr + "/shswpt/ssu/ssu_fetchSelf.do", "a0",
        "zjsp-insert", "自建视频");
    zdgcload(addr + "/shswpt/ssu/ssu_fetchShare.do", "a1",
        "gxsp-insert", "共享视频");
    zdgcload(addr + "/shswpt/ssu/ssu_fetchZdgc.do", "a2",
        "zdgc-insert", "重大工程");
    zdgcload(addr + "/shswpt/ssu/ssu_fetchFxzd.do", "a3",
        "fxzd-insert", "防汛重点");
    zdgcload(addr + "/shswpt/ssu/ssu_fetchYxht.do", "a4",
        "yxht-insert", "中小河道整治");
    zdgcload(addr + "/shswpt/ssu/ssu_fetchFqsp.do", "a6",
            "fqsp-insert", "分区视频");
    zdgcload(addr + "/shswpt/ssu/ssu_fetchZwbl.do", "a7",
            "zwbl-insert", "中国对外进口博览会");
    zdgcload(addr + "/shswpt/ssu/ssu_fetchZjz.do", "a8",
            "zjz-insert", "重大危险源");

})

