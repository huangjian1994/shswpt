package com.htcf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.htcf.util.DateUtil;

import com.htcf.util.RequestUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.Uav;
import com.htcf.service.SsuService;
import com.htcf.util.StringUtil;

@Controller("SsuAction")
@Scope("prototype")
public class SsuAction extends BaseAction {
	
	@Autowired
	private SsuService ssuService;
	
	private String pid;//父节点
	private String type;//节点类型
	/**
	 * 指挥车设备代码
	 */
	private String deviceCode;
	
	private List<?> uavList;//无人机集合
	private List<?> selfList;//自建视频设备集合
	private List<?> shareList;//共享视频设备集合
	private List<?> FList;//父节点
	private List<?> fxList;//分享设备树
	private List<?> zdgcList;//重大工程
	private List<?> fxzdList;//防汛重点
	private List<?> yxhtList;//一线海塘
	private List<?> fqspList;//分区视频
	private String Gps ;



	//无人机设备
	private Uav uav = new Uav();

	/**
	 * 
	* @Description：查出无人机设备，返回json
	*@author:hj
	*@2017-4-11上午09:48:56
	*@param 
	*@return
	 */
	public String fetchUav(){
		System.out.println("----------------"+1111);
		uavList = this.ssuService.fetchUav();
		System.out.println(uavList.size());
		if(uavList.size()>0){
			System.out.println("有值");
			for(int i = 0 ;i<uavList.size();i++){
				Object[] obj = (Object[])uavList.get(i);
				System.out.println("+++++++++++++++++"+obj[0]);

				System.out.println("+++++++++++++++++"+obj[1]);
			}
		}
		HttpServletResponse response = this.getHttpServletResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除 circle
		JSONArray arr = JSONArray.fromObject(uavList, config);
		out.print(arr.toString());
		out.flush();
		return null;
	}

	/**
	 * 
	* @Description：查出自建设备，返回json
	*@author:hj
	*@2017-4-11上午10:50:06
	*@param 
	*@return
	 */
	public String fetchSelf(){
		//HttpServletResponse response = getHttpServletResponse();
		selfList = this.ssuService.fetchSelf();
		System.out.println(selfList.size());
		StringBuffer sss = new StringBuffer();
		if(selfList.size()>0){
			System.out.println("有值");
			for(int i = 0 ;i<selfList.size();i++){
				Object[] obj = (Object[])selfList.get(i);
//				sss.append("[").
//				append("{id:").append(obj[0]).append(",name:'").append(obj[1]).append("',code:'").append(obj[2])
//				.append("',APPROVE:'").append(obj[3]).append("',DATE:'").append(obj[4]).append("',USEFUL:'").append(obj[5])
//				.append("',ADDRESS:").append(obj[6]).append("',LONGITUDE'").append(obj[7]).append("',LATITUDE:'").append(obj[8])
//				.append("',USER:'").append(obj[9]).append("',TYPE:'").append(obj[10]).append("',dm:'").append(obj[11])
//				.append("',dwdm:'").append(obj[12]).append("',ssgc:'").append(obj[13])
//				.append("'}").append("]");
//				System.out.println("++++拼接的+++++++++++++"+sss);
			}
		}
//		try{
//	    	System.out.println("sb="+sss);
//	    	response.setContentType("text/html;charset=utf-8");
//	    	response.getWriter().println(sss.toString());
//	    }catch (IOException e) {
//	    	e.printStackTrace();
//	    }
		
		HttpServletResponse response = this.getHttpServletResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
		JSONArray arr = JSONArray.fromObject(selfList, config);
		System.out.println("----------------++++++++++"+arr);
		out.print(arr.toString());
		out.flush();
		return null;
	}
	
	/**
	 * @Description：查出共享设备，返回json
	 *@author:
	 *@Time2017-5-10下午01:44:48 
	 *@return
	 */
	public String fetchShare(){
		
		shareList = this.ssuService.fetchShare();
		System.out.println(shareList.size());
		if(shareList.size()>0){
			System.out.println("有值");
			for(int i = 0 ;i<shareList.size();i++){
				Object[] obj = (Object[])shareList.get(i);
				System.out.println("+++++++++++++++++"+obj[0]);

				System.out.println("+++++++++++++++++"+obj[1]);
			}
		}
		HttpServletResponse response = this.getHttpServletResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
		JSONArray arr = JSONArray.fromObject(shareList, config);
		System.out.println("输出json"+arr);
		out.print(arr.toString());
		out.flush();
		return null;
	}
	
	/**
	 * 获取树列表
	* @Description：
	*@author:hj
	*@2017-4-24上午09:59:40
	*@param 
	*@return
	 */
	public String getTree(){
		System.out.println("-----------------getTreeData");
		HttpServletResponse response = getHttpServletResponse();
	    StringBuffer sb = new StringBuffer();
	    FList = ssuService.fetF();
	    System.out.println("wysList="+FList.size());
	    sb.append("[");
	    for (int i = 0; i < FList.size(); i++){
	    		Object[] exam = (Object[]) FList.get(i);
	    		System.out.println("第"+i+"个要素="+exam[0]);
				sb.append("{id:").append(exam[0]).append(",state:'closed',")
				.append("text:'").append(exam[1]).append("',type:1");
				
				if( exam[0].equals("1") ){
					System.out.println("+++++++++++++++++++get");
					List<?> dzList = this.ssuService.fetchSelfList();
					if(dzList !=null && dzList.size() !=0){
						sb.append(",");
						sb.append("children:[");
						for(int j=0;j<dzList.size();j++){
							Object[] dz = (Object[])dzList.get(j);
							String gs = this.ssuService.fetchzjgs(dz[0].toString());//查出个数
							sb.append("{id:").append(dz[0]).append(",state:'closed',")
			        		.append("text:'").append(dz[1]+"["+gs+"]").append("',type:2");
							//查询该节点下的视频设备
							List<?> wzList = this.ssuService.fetSelfobj(dz[0].toString());
							if(wzList !=null && wzList.size() !=0){
//								System.out.println("++++++++++++该节点查询:");
								sb.append(",");
								sb.append("children:[");
								for(int k = 0; k < wzList.size(); k++){
									Object[] objs = (Object[]) wzList.get(k);
//									System.out.println("name="+objs[3]);
//									System.out.println("位置代码dm="+objs[1]);
//									System.out.println("单位代码"+objs[2] );
									sb.append("{id:").append(objs[0]).append(",")
									.append("text:'").append(objs[3]).append("',type:3,lev:'"+objs[4]+"'")
									.append(",approve:'"+objs[7]+"' ");
									//结尾
									if(k!=wzList.size()-1){
										sb.append("},");
									}else{
				    	    			sb.append("}");
					    	    	}
								}
								sb.append("]");
							}else{
								System.out.println("无该单位的。。。。");
							}
							//数据元结尾
				    		if(j!=dzList.size()-1){
				    			sb.append("},");
				    		}else{
				    			sb.append("}");
				    		}
						}
						sb.append("]");
						}else{
							System.out.println("无自建视频。");
						}
				}else if(exam[0].equals("2")){
//					System.out.println("+++++++++++++++++++get");
					List<?> dzList = this.ssuService.fetchSareList();
					if(dzList !=null && dzList.size() !=0){
						sb.append(",");
						sb.append("children:[");
						for(int j=0;j<dzList.size();j++){
							Object[] dz = (Object[])dzList.get(j);
							String gs = this.ssuService.fetchgxgs(dz[0].toString());//查出个数
							sb.append("{id:").append(dz[0]).append(",state:'closed',")
			        		.append("text:'").append(dz[1]+"["+gs+"]").append("',type:2");
							//查询该节点下的视频设备
							List<?> wzList = this.ssuService.fetShareobj(dz[0].toString());
							if(wzList !=null && wzList.size() !=0){
								sb.append(",");
								sb.append("children:[");
								for(int k = 0; k < wzList.size(); k++){
									Object[] objs = (Object[]) wzList.get(k);
//									System.out.println("name="+objs[3]);
//									System.out.println("位置代码dm="+objs[1]);
//									System.out.println("单位代码"+objs[2]);
									sb.append("{id:").append(objs[0]).append(",")
									.append("text:'").append(objs[3]).append("',type:3,lev:'"+objs[4]+"' ")
									.append(",approve:'"+objs[7]+"' ");//,lev:'"+objs[1]+"'
									//结尾
									if(k!=wzList.size()-1){
										sb.append("},");
									}else{
				    	    			sb.append("}");
					    	    	}
								}
								sb.append("]");
							}else{
								System.out.println("无该单位的。。。。");
							}
							
							//数据元结尾
				    		if(j!=dzList.size()-1){
				    			sb.append("},");
				    		}else{
				    			sb.append("}");
				    		}
						}
						sb.append("]");
						}else{
							System.out.println("无共享视频。。。。");
						}
				}
			
				//五要素结尾
	    		if(i!=FList.size()-1){
	    			sb.append("},");
	    		}else{
	    			sb.append("}");
	    		}
	    	}
		    sb.append("]");
		    try{
		    	System.out.println("sb="+sb);
		    	response.setContentType("text/html;charset=utf-8");
		    	response.getWriter().println(sb.toString());
		    }catch (IOException e) {
		    	e.printStackTrace();
		    }
		    return null;
		
	}
	

	/**
	 * @Description：系统管理中的分享，查询设备
	 *@author:
	 *@Time2017-5-10下午01:58:47 
	 *@return
	 */
		public String fetchSysfx(){
			
			fxList = this.ssuService.fetchFxTree();
			
			System.out.println(fxList.size());
			if(fxList.size()>0){
				System.out.println("有分享值");
				for(int i = 0 ;i<fxList.size();i++){
					Object[] obj = (Object[])fxList.get(i);
					System.out.println("+++++++++++++++++"+obj[0]);
	
					System.out.println("+++++++++++++++++"+obj[1]);
				}
			}
			HttpServletResponse response = this.getHttpServletResponse();
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JsonConfig config = new JsonConfig();
			config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
			JSONArray arr = JSONArray.fromObject(fxList, config);
			System.out.println("输出json"+arr);
			out.print(arr.toString());
			out.flush();
			return null;
		}
	
	//测试
	public String test(){
		System.out.println("-------不不不-------");
		System.out.println();
		return "t";
	}
	
	/**
	 * @Description：自建和共享设备查询 重大工程设备
	 *@author:
	 *@Time2017-5-10下午01:58:47 
	 *@return
	 */
		public String fetchZdgc(){
			try {
				zdgcList = this.ssuService.fetZdgc();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			if(zdgcList.size()>0){
				System.out.println(zdgcList.size());
				System.out.println("有分享值");
				for(int i = 0 ;i<zdgcList.size();i++){
					Object[] obj = (Object[])zdgcList.get(i);
					System.out.println("+++++++++++++++++"+obj[0]);
	
					System.out.println("+++++++++++++++++"+obj[1]);
				}
			}
			HttpServletResponse response = this.getHttpServletResponse();
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JsonConfig config = new JsonConfig();
			config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
			JSONArray arr = JSONArray.fromObject(zdgcList, config);
			System.out.println("输出json"+arr);
			out.print(arr.toString());
			out.flush();
			return null;
		}
	
		/**
		 * @Description：自建和共享设备查询 防汛重点设备
		 *@author:
		 *@Time2017-5-10下午01:58:47 
		 *@return
		 */
			public String fetchFxzd(){
				try {
					fxzdList = this.ssuService.fetFxzd();
				} catch (Exception e) {
					e.printStackTrace();
				}
					
				if(fxzdList.size() > 0){
					System.out.println(fxzdList.size());
				}

				HttpServletResponse response = this.getHttpServletResponse();
				response.setContentType("text/plain;charset=utf-8");
				PrintWriter out = null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				JsonConfig config = new JsonConfig();
				config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
				JSONArray arr = JSONArray.fromObject(fxzdList, config);
				System.out.println("输出json"+arr);
				out.print(arr.toString());
				out.flush();
				return null;
			}
	
			/**
			 * @Description：自建和共享设备查询 中小河道设备
			 *@author:
			 *@Time2017-5-10下午01:58:47 
			 *@return
			 */
				public String fetchYxht(){
					try {
						yxhtList = this.ssuService.fetYxht();
					} catch (Exception e) {
						e.printStackTrace();
					}
						
					if(yxhtList.size() >0){
						System.out.println("中小河道"+yxhtList.size());
					}
					HttpServletResponse response = this.getHttpServletResponse();
					response.setContentType("text/plain;charset=utf-8");
					PrintWriter out = null;
					try {
						out = response.getWriter();
					} catch (IOException e) {
						e.printStackTrace();
					}
					JsonConfig config = new JsonConfig();
					config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
					JSONArray arr = JSONArray.fromObject(yxhtList, config);
					System.out.println("输出json"+arr);
					out.print(arr.toString());
					out.flush();
					return null;
				}

	/**
	 * @Description：共享设备查询 质检站设备
	 *@author:
	 *@Time2017-5-10下午01:58:47
	 *@return
	 */
	public String fetchZjz(){
		try {
			zdgcList = this.ssuService.fetZjz();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(zdgcList.size()>0){
			System.out.println(zdgcList.size());
			System.out.println("有");
			for(int i = 0 ;i<zdgcList.size();i++){
				Object[] obj = (Object[])zdgcList.get(i);
				System.out.println("+++++++++++++++++"+obj[0]);

				System.out.println("+++++++++++++++++"+obj[1]);
			}
		}
		HttpServletResponse response = this.getHttpServletResponse();
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
		JSONArray arr = JSONArray.fromObject(zdgcList, config);
		System.out.println("输出json"+arr);
		out.print(arr.toString());
		out.flush();
		return null;
	}

	/**
	 * @Description：自建和共享设备查询 中博对外博览会防汛设备
	 *@author:
	 *@Time2017-5-10下午01:58:47
	 *@return
	 */
		public String fetchZwbl(){
			try {
				zdgcList = this.ssuService.fetZwbl();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(zdgcList.size()>0){
				System.out.println(zdgcList.size());
				System.out.println("有分享值");
				for(int i = 0 ;i<zdgcList.size();i++){
					Object[] obj = (Object[])zdgcList.get(i);
					System.out.println("+++++++++++++++++"+obj[0]);

					System.out.println("+++++++++++++++++"+obj[1]);
				}
			}
			HttpServletResponse response = this.getHttpServletResponse();
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JsonConfig config = new JsonConfig();
			config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
			JSONArray arr = JSONArray.fromObject(zdgcList, config);
			System.out.println("输出json"+arr);
			out.print(arr.toString());
			out.flush();
			return null;
		}
	
		/**
		 * @Description：查询分区设备
		 *@author:
		 *@Time2017-5-10下午01:58:47
		 *@return
		 */
			public String fetchFqsp(){

				fqspList = this.ssuService.fetFqsp();

				System.out.println(fqspList.size());
				if(fqspList.size()>0){
					System.out.println("有分享值");
					for(int i = 0 ;i<fqspList.size();i++){
						Object[] obj = (Object[])fqspList.get(i);
						System.out.println("+++++++++++++++++"+obj[0]);

						System.out.println("+++++++++++++++++"+obj[1]);
					}
				}
				HttpServletResponse response = this.getHttpServletResponse();
				response.setContentType("text/plain;charset=utf-8");
				PrintWriter out = null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				JsonConfig config = new JsonConfig();
				config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle
				JSONArray arr = JSONArray.fromObject(fqspList, config);
				System.out.println("输出jso"+arr);
				out.print(arr.toString());
				out.flush();
				return null;
			}

		/**
		*Description :指挥车GPS信息
		*@param
		*@return
		*@author：hj
		*@Create 2018-7-20 15:34
		*/
		public String getZhcGps()  {

			String intervalTime = "30";
			String endTime = DateUtil.dateToString(new Date(),"yyyy-M-dd HH:mm:ss");
			Calendar now = Calendar.getInstance();
			now.add(Calendar.MINUTE,-1);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
			String beginTime = format.format(now.getTime());
			/*String beginTime = "2018-7-24 18:06:01";
			String endTime = "2018-7-24 18:07:01";*/
			System.out.println("打印开始时间-=========--=-=-=："+beginTime);
			System.out.println("打印结束时间-=========--=-=-=："+endTime);


			if(StringUtil.isNotBlank(deviceCode)){
				try {
					Gps = RequestUtil.sendGet("http://31.16.17.80:8881/emap/api/v1/motion/gpsHistory?",
                           String.format("deviceCode=%s&beginTime=%s&endTime=%s&intervalTime=%s",
                                   deviceCode,
                                   URLEncoder.encode(beginTime,"UTF-8"),
                                   URLEncoder.encode(endTime,"UTF-8"),
                                   intervalTime));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				System.out.println("请求指挥e车地址："+Gps);

			}


			HttpServletResponse response = this.getHttpServletResponse();
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JSONObject object = JSONObject.fromObject(Gps);
			System.out.println("输出jso"+object);
			out.print(object.toString());
			out.flush();
			return null;
		}


	/**
	 *
	 Description :获取当前时间
	 @param
	 @return
	 @throws
	 @Author：yinying
	 @Create 2017-6-16 下午06:27:53
	 */
	public String getDateTime(){
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		System.out.println("系统当前时间："+date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		String datetime = dateFormat.format(date);
		return datetime;
	}

	/**---------------------get  set --------------------------*/
	
	public Uav getUav() {
		return uav;
	}

	public void setUav(Uav uav) {
		this.uav = uav;
	}
	
	

	public SsuService getSsuService() {
		return ssuService;
	}

	
	public void setSsuService(SsuService ssuService) {
		this.ssuService = ssuService;
	}

	public List<?> getUavList() {
		return uavList;
	}

	public void setUavList(List<?> uavList) {
		this.uavList = uavList;
	}


	public List<?> getSelfList() {
		return selfList;
	}


	public void setSelfList(List<?> selfList) {
		this.selfList = selfList;
	}


	public List<?> getShareList() {
		return shareList;
	}


	public void setShareList(List<?> shareList) {
		this.shareList = shareList;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<?> getFList() {
		return FList;
	}

	public void setFList(List<?> fList) {
		FList = fList;
	}

	public List<?> getFxList() {
		return fxList;
	}

	public void setFxList(List<?> fxList) {
		this.fxList = fxList;
	}

	public List<?> getZdgcList() {
		return zdgcList;
	}

	public void setZdgcList(List<?> zdgcList) {
		this.zdgcList = zdgcList;
	}

	public List<?> getFxzdList() {
		return fxzdList;
	}

	public void setFxzdList(List<?> fxzdList) {
		this.fxzdList = fxzdList;
	}

	public List<?> getYxhtList() {
		return yxhtList;
	}

	public void setYxhtList(List<?> yxhtList) {
		this.yxhtList = yxhtList;
	}

	public List<?> getFqspList() {
		return fqspList;
	}

	public void setFqspList(List<?> fqspList) {
		this.fqspList = fqspList;
	}


	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getGps() {
		return Gps;
	}

	public void setGps(String gps) {
		Gps = gps;
	}
}
