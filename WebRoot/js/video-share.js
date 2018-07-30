var isFirst = true;
//树加载
var urlzw1 = "http://"+ document.location.hostname + ":8080/";
function refresh() {
	$.ajax({
		type: "post",
		url: urlzw1+"shswpt/ssu/ssu_fetchSysfx.do",
		async: true,
		datatype: "json",
		cache: false,
		success: function(json) {
			var data = eval(json);
			if(!isFirst) {
				$(".project-list").empty();
			}
			arrSearch = [];
			//console.log(data);
			//去除重复方法
			var arrData = [];
			for(var i = 0; i < data.length; i++) {
				if(data[i][1] == null || data[i][1] == "") {
					continue;
				}else{
					arrData.push(data[i][9]);
				}
				
			}
			//console.log(arrData);

			function removeDuplicate() {
				var h = {}; //定义一个hash表  
				var arr = []; //定义一个临时数组  
				for(var i = 0; i < arrData.length; i++) { //循环遍历当前数组  
					//对元素进行判断，看是否已经存在表中，如果存在则跳过，否则存入临时数组  
					if(!h[arrData[i]]) {
						//存入hash表  
						h[arrData[i]] = true;
						//把当前数组元素存入到临时数组中  
						arr.push(arrData[i]);
					}
				}
				return arr;
			}
			arrReData = removeDuplicate();
			arrReData.sort().reverse();
			//console.log(arrReData);
			//创建树
			function creatTree() {
				isFirst = false;
				$(".project-list").append("<div class='panel-group' id='accordion'></div>");
				var dropdown = document.getElementById("accordion");
				for(var i = 0; i < arrReData.length; i++) {
					var panel = document.createElement("div");
					panel.className = "panel panel-default";
					var panelHeading = document.createElement("div");
					panelHeading.className = "panel-heading";
					var h4 = document.createElement("h2");
					h4.className = "panel-title";
					var menu = document.createElement("a");
					if(arrReData[i] == null) {
						menu.innerHTML = "其他";
					} else {
						menu.innerHTML = arrReData[i];
					}
					h4.appendChild(menu);
					panelHeading.appendChild(h4);
					panel.appendChild(panelHeading);
					var collapse = document.createElement("div");
					collapse.className = "panel-collapse collapse";
					var panelBody = document.createElement("div");
					panelBody.className = "panel-body";
					var ul = document.createElement("ul");
					ul.className = "ulist"
					panelBody.appendChild(ul);
					collapse.appendChild(panelBody);
					panel.appendChild(collapse);
					dropdown.appendChild(panel);
				}
				var ulist = document.getElementsByClassName("ulist");
				for(var i = 0; i < arrData.length; i++) {
					var arr = [];
					arr.push(data[i][1]);
					var li = document.createElement("li");
					li.className = "list" + i;
					var a = document.createElement("a");
					a.href = "#";
					if(data[i][5] == "是") {
						a.innerHTML = "<i class='iconfont icon-shexiangtou red'>" + "</i>" + "&nbsp" + data[i][1];
					} else {
						a.innerHTML = "<i class='iconfont icon-shexiangtou black'>" + "</i>" + "&nbsp" + data[i][1];
					}
					(function(indexI) {
						li.onclick = function() {
							passId = data[indexI][2];
							console.log(passId);
							window.open('videoshareDetail.jsp?textCameraID=' + data[indexI][2], 'td', 'height=430,width=480,top=500,left=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
						}
					})(i);
					li.appendChild(a);
					for(var j = 0; j < arrReData.length; j++) {
						if(data[i][9] == arrReData[j]) {
							ulist[j].appendChild(li);
							arr.push(j);
						}
					}
					arrSearch.push(arr);
				}
				for(var i = 0; i < $("#accordion h2 a").length; i++) {
					var id1 = "collapse" + i;
					$("#accordion .collapse").eq(i).attr("id", id1);
					$("#accordion h2 a").eq(i).attr("data-toggle", "collapse");
					$("#accordion h2 a").eq(i).attr("href", "#" + id1);
					$("#accordion h2 a").eq(i).attr("data-parent", "#accordion")
				}
			}
			creatTree();
			//搜索框功能
			search = function() {
				//console.log(arrSearch);
				var val = $(".input-group .input-sm").val();
				//console.log(val);
				//去除空格
				function trim(s) {
					return s.replace(/(^\s*)|(\s*$)/g, "");
				}
				val = trim(val);
				//console.log(val);
				var arr2 = [];
				var arr3 = [];
				for(var i = 0; i < arrSearch.length; i++) {
					if(arrSearch[i][0] == null){
						continue;
					}else{
						if(arrSearch[i][0].indexOf(val) != -1) {
							arr2.push(arrSearch[i][1]);
						} else {
							arr3.push(i);
						}
					}
					
				}
				//console.log(arr3);

				for(var i = 0; i < arrData.length; i++) {
					var lis = "#accordion .ulist .list" + i;
					$(lis).css("display", "block");
				}
				for(var i = 0; i < arr3.length; i++) {
					var lis1 = "#accordion .ulist .list" + arr3[i];
					$(lis1).css("display", "none");
				}

				function removeDuplicate1() {
					var h = {}; //定义一个hash表
					var arr = []; //定义一个临时数组
					for(var i = 0; i < arr2.length; i++) { //循环遍历当前数组
						//对元素进行判断，看是否已经存在表中，如果存在则跳过，否则存入临时数组
						if(!h[arr2[i]]) {
							//存入hash表  3 2
							h[arr2[i]] = true;
							//把当前数组元素存入到临时数组中
							arr.push(arr2[i]);
						}
					}
					return arr;
				}
				var arrReSearch = removeDuplicate1();
				//console.log(arrReSearch);
				for(var j = 0; j < arrReData.length; j++) {
					$("#accordion h2 a").eq(j).attr("aria-expanded", "false");
					$("#accordion h2 a").eq(j).addClass("collapsed");
					$("#accordion .panel-collapse").eq(j).attr("aria-expanded", "false");
					$("#accordion .panel-collapse").eq(j).removeClass("in");
					$("#accordion .panel-collapse").eq(j).css("height", "0");
				}
				for(var i = 0; i < arrReSearch.length; i++) {
					$("#accordion h2 a").eq(arrReSearch[i]).attr("aria-expanded", "true");
					$("#accordion h2 a").eq(arrReSearch[i]).removeClass("collapsed");
					$("#accordion .panel-collapse").eq(arrReSearch[i]).attr("aria-expanded", "true");
					$("#accordion .panel-collapse").eq(arrReSearch[i]).addClass("in");
					$("#accordion .panel-collapse").eq(arrReSearch[i]).css("height", "auto");
				}
			}

		}
	});
}
refresh();

function reset() {
	//console.log(1);
	refresh();
}