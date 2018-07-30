/*
 * 自定义的js
 */

function Menu(id,name){
	
			this.id=id;
			this.name=name;
};


		/**
		 * 计时器
		 *
		var maxtime = 0 ;//半个小时，按秒计算，自己调整!
		function CountDown(){
			 if(maxtime>=0){
				 minutes = Math.floor(maxtime/60);
				 seconds = Math.floor(maxtime%60);
				 msg = "已用时间:"+minutes+"分"+seconds+"秒";
				 document.all["TheTimer"].innerHTML=msg;
				 ++maxtime;
			 }else{
				 clearInterval(timer);
			 }
		}
		TheTimer = setInterval("CountDown()",1000);
		*
		**/