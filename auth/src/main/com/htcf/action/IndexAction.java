package com.htcf.action;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.Message;
import com.htcf.entity.Notice;
import com.htcf.entity.Sjzd;
import com.htcf.service.IIndexService;
import com.htcf.service.IMessageService;
import com.htcf.service.INoticeService;
import com.htcf.service.ISjzdService;
import com.htcf.service.IUserService;



@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	

	@Autowired
	private IUserService userService;
	
	@Autowired
	private INoticeService noticeService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private IIndexService indexService;
	
	@Autowired
	private ISjzdService sjzdService;
	
	
	private List<Notice> noticeList=new ArrayList<Notice>();
	
	private Message message1=new Message();
	
	private String sldwZztGraph;	//收录单位柱状图

	private String ryztPieGraph;	//人员状态饼图
	
	private String mzPieGraph;	//民族饼图
	
	private String rylbPieGraph;	//人员类别饼图
	
	private String lhsqPieGraph;	//来沪事由
	
	private String zzdlxPieGraph;	//暂住地图

	private String chart ;	//放大的图像
	
	private String xhcount ;	//循环遍历
	
	
	public String init(){
//		HttpServletRequest request= this.getHttpServletRequest();
//		pageBean=this.processPageBean(request);
//		
//		//显示最新通知
//		noticeList=noticeService.retrieveLatestNotices(pageBean);
//		
//		//显示最新消息
//	    // message1=messageService.fetchLatestMessage();
//		
//		sldwZztGraph = getZztSldwGraph();
//		ryztPieGraph = getPieRyztGraph();
		return "content";
	}
	
	//获取上一张饼图
	public String beforeChart(){
		//获取民族
		mzPieGraph = getPieMzGraph();
		//获取人员类别饼图
		rylbPieGraph = getPieRylbGraph();
		//获取来沪事由饼图
		lhsqPieGraph = getPieLhsqGraph();
		//获取暂住地类型图
		zzdlxPieGraph =getPieZzdlxGraph();
		//获取人员状态饼图
		ryztPieGraph = getPieRyztGraph();
		String[] pies={ryztPieGraph,mzPieGraph,rylbPieGraph,lhsqPieGraph,zzdlxPieGraph};
		//获取
		HttpServletResponse response = ServletActionContext.getResponse();
		StringBuffer sb = new StringBuffer();
		try {
			pies[Integer.valueOf(xhcount)] = URLEncoder.encode(URLEncoder.encode(pies[Integer.valueOf(xhcount)], "UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		sb.append(pies[Integer.valueOf(xhcount)]);
		//打印到界面
		try {
			response.getWriter().print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//获取暂住地图
	public String getPieZzdlxGraph(){
		List<Sjzd> sjzdList = this.sjzdService.getSjzdListByFid("474");
		List<String> sjzdStr = new ArrayList<String>();
		for(Sjzd sjzd:sjzdList){
			sjzdStr.add(sjzd.getContent());
		}
		System.out.println("数据字典str***********"+sjzdStr.toString());
		String jbxxCountStr = this.indexService.getJbxxCount("");
		long jbxxCount = Long.valueOf(jbxxCountStr);
		String[] colors ={
			"FFCCFF","66FFCC","EFEFEF","EEEEDD","CCCC99","33CC99",
			"66CC66","669933","669966","339900","666600","999999",
			"9999BB","00CCCC","00FF99","99AAEE","FFCCAA","CCAAFF",
			"CCBBCC","CCEEDD","FFEEFF","AAFFCC","11EFEF","22EEDD","EECC99","66CC99",
			"66EF66","EF9933","FA9966","AF0099","6AF600","AA9999",
			"9E59BB","00E3CC","00F499","9A5AEE","FFEEAA","DDAAFF",
			"CBABCC","ACAEDD","FFCCFF","66FFCC","EFEFEF","EEEEDD","CCCC99","33CC99",
			"66CC66","669933","669966","339900","666600","999999",
			"9999BB","00CCCC","00FF99","99AAEE","FFCCAA","CCAAFF",
			"CCBBCC","CCEEDD","FFEEFF","AAFFCC","11EFEF","22EEDD","EECC99","66CC99",
			"66EF66","EF9933","FA9966","AF0099","6AF600","AA9999",
			"9E59BB","00E3CC","00F499","9A5AEE","FFEEAA","DDAAFF",
			"CBABCC","ACAEDD",
			};
		Map<String,String> maps = this.indexService.getJbxxCountByZzdlx("");
		StringBuffer ryztPieSb=new StringBuffer();
		ryztPieSb.append("<graph shadowAlpha='50' showPercentValues='1'  baseFontSize='12'  caption='暂住地类型数据图'  decimalPrecision='2' formatNumberScale='0'>");
		int count = 0;
		int sum = 0;
		for(String key:maps.keySet()){
			System.out.println("key************"+key);
			if(sjzdStr.contains(key.trim())){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
		}
		ryztPieSb.append("<set name='其他' value='"+(jbxxCount-sum)+"' color='"+colors[count]+"' />");
		ryztPieSb.append("</graph>");
        String str = ryztPieSb.toString();
        System.out.println("********************"+str);
        return str;
	}
	
	
	
	//获取来沪事由图
	public String getPieLhsqGraph(){
		List<Sjzd> sjzdList = this.sjzdService.getSjzdListByFid("447");
		List<String> sjzdStr = new ArrayList<String>();
		for(Sjzd sjzd:sjzdList){
			sjzdStr.add(sjzd.getContent());
		}
		System.out.println("数据字典str***********"+sjzdStr.toString());
		String jbxxCountStr = this.indexService.getJbxxCount("");
		long jbxxCount = Long.valueOf(jbxxCountStr);
		String[] colors ={
			"FFCCFF","66FFCC","EFEFEF","EEEEDD","CCCC99","33CC99",
			"66CC66","669933","669966","339900","666600","999999",
			"9999BB","00CCCC","00FF99","99AAEE","FFCCAA","CCAAFF",
			"CCBBCC","CCEEDD","FFEEFF","AAFFCC","11EFEF","22EEDD","EECC99","66CC99",
			"66EF66","EF9933","FA9966","AF0099","6AF600","AA9999",
			"9E59BB","00E3CC","00F499","9A5AEE","FFEEAA","DDAAFF",
			"CBABCC","ACAEDD"
			};
		Map<String,String> maps = this.indexService.getJbxxCountByLhsy("");
		StringBuffer ryztPieSb=new StringBuffer();
		ryztPieSb.append("<graph shadowAlpha='50' showPercentValues='1' baseFontSize='12'  caption='来沪事由数据图'  decimalPrecision='2' formatNumberScale='0'>");
		int count = 0;
		int sum = 0;
		for(String key:maps.keySet()){
			System.out.println("key************"+key);
			if(sjzdStr.contains(key.trim())){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
		}
		ryztPieSb.append("<set name='其他' value='"+(jbxxCount-sum)+"' color='"+colors[count]+"' />");
		ryztPieSb.append("</graph>");
        String str = ryztPieSb.toString();
        System.out.println("********************"+str);
        return str;
	}
	
	
	//获取人员类别图
	public String getPieRylbGraph(){
		String jbxxCountStr = this.indexService.getJbxxCount("");
		long jbxxCount = Long.valueOf(jbxxCountStr);
		String[] colors ={
			"FFCCFF","66FFCC","EFEFEF","EEEEDD","CCCC99","33CC99",
			"66CC66","669933","669966","339900","666600","999999",
			"9999BB","00CCCC","00FF99","99AAEE","FFCCAA","CCAAFF",
			"CCBBCC","CCEEDD"
			};
		Map<String,String> maps = this.indexService.getJbxxCountByRylb("");
		StringBuffer ryztPieSb=new StringBuffer();
		ryztPieSb.append("<graph shadowAlpha='50' showPercentValues='1' baseFontSize='12'  caption='人员类别数据图'  decimalPrecision='2' formatNumberScale='0'>");
		int count = 0;
		int sum = 0;
		for(String key:maps.keySet()){
			if(("维族人员").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("22国人员").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("出生地为新疆的其他境外人员").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("藏族人员").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("其他人员").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("境内维族").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("境内其他").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("境外敏感国家").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("境外其他").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
		}
		ryztPieSb.append("<set name='其他' value='"+(jbxxCount-sum)+"' color='"+colors[count]+"' />");
		ryztPieSb.append("</graph>");
        String str = ryztPieSb.toString();
        System.out.println("********************"+str);
        return str;
	}
	
	
	//获取民族人员状态图
	public String getPieMzGraph(){
		String jbxxCountStr = this.indexService.getJbxxCount("");
		long jbxxCount = Long.valueOf(jbxxCountStr);
		String[] colors ={
			"FFCCFF","66FFCC","EFEFEF","EEEEDD","CCCC99","33CC99",
			"66CC66","669933","669966","339900","666600","999999",
			"9999BB","00CCCC","00FF99","99AAEE","FFCCAA","CCAAFF",
			"CCBBCC","CCEEDD"
			};
		Map<String,String> maps = this.indexService.getJbxxCountByMz("");
		StringBuffer ryztPieSb=new StringBuffer();
		ryztPieSb.append("<graph shadowAlpha='50' showPercentValues='1' baseFontSize='12'   caption='民族数据图'  decimalPrecision='2' formatNumberScale='0'>");
		int count = 0;
		int sum = 0;
		for(String key:maps.keySet()){
			if(("维吾尔族").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("乌兹别克族").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("哈萨克族").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("柯尔克孜族").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("蒙古族").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
			if(("回族").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				count++;
			}
		}
		ryztPieSb.append("<set name='其他' value='"+(jbxxCount-sum)+"' color='"+colors[count]+"' />");
		ryztPieSb.append("</graph>");
        String str = ryztPieSb.toString();
        System.out.println("********************"+str);
        return str;
	}
	
	
	//获取人员状态饼图
	public String getPieRyztGraph(){
		String jbxxCountStr = this.indexService.getJbxxCount("");
		long jbxxCount = Long.valueOf(jbxxCountStr);
		String[] colors ={
			"99CCFF","66EEFF","AACCFF","9999FF",
			"6666CC","0066CC","3366CC","990099","CC99FF","CCAAFF",
			"CCBBCC","CCEEDD","FFCCFF","66FFCC","EFEFEF","EEEEDD","CCCC99","33CC99",
			"66CC66","669933"
			};
		Map<String,String> maps = this.indexService.getJbxxCountByRyzt("");
		StringBuffer ryztPieSb=new StringBuffer();
		ryztPieSb.append("<graph shadowAlpha='50' showPercentValues='1'  baseFontSize='12' showPercentValues='1' caption='人员状态数据图'  decimalPrecision='2' formatNumberScale='0'>");
		int count = 0;
		int sum = 0;
		for(String key:maps.keySet()){
			if(("本市常口").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}	
				System.out.println("本市常口"+ count);
				count++;
			}
			if(("流动暂住").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				System.out.println("流"+ count);
				count++;
			}
			if(("居无定所").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				System.out.println("居无定所"+ count);
				count++;
			}
			if(("大专院校").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				System.out.println("大"+ count);
				count++;
			}
			if(("内高班").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				System.out.println("内"+ count);
				count++;
			}
			if(("监所在押").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				System.out.println("监所"+ count);
				count++;
			}
			if(("临时过境").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				System.out.println("临时"+ count);
				count++;
			}
			if(("长期居住").equals(key)){
				ryztPieSb.append("<set name='"+key+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />");
				try{
					sum+= Integer.valueOf(maps.get(key));
				}catch (Exception e) {
					sum+=0;
				}
				System.out.println("长"+ count);
				count++;
			}
		}
		ryztPieSb.append("<set name='其他' value='"+(jbxxCount-sum)+"' color='"+colors[count]+"' />");
		ryztPieSb.append("</graph>");
        String str = ryztPieSb.toString();
        return str;
	}
	
	//获取收录单位柱状图
	public String getZztSldwGraph(){
		String jbxxCountStr = this.indexService.getJbxxCount("");
		long jbxxCount = Long.valueOf(jbxxCountStr);
		String[] colors ={
			"FFCCFF","66FFCC","EFEFEF","EEEEDD","CCCC99","33CC99",
			"66CC66","669933","669966","339900","666600","999999",
			"9999BB","00CCCC","00FF99","99AAEE","FFCCAA","CCAAFF",
			"CCBBCC","CCEEDD","FF99BB","00EEAA","AADD99","DDEEEE","AABBAA","CCBBEE",
			"CCBBDD","CCFFDD"
			};
		Map<String,String> maps = this.indexService.getJbxxCountBySldw("");
		StringBuffer zztSldwSb=new StringBuffer();
		zztSldwSb.append("<graph shadowAlpha='50'  baseFontSize='12'  caption='收录单位采集数据图&nbsp;&nbsp;总数（"+jbxxCount+"）'  decimalPrecision='2' formatNumberScale='0'>");
		int count = 0;
		String setArray[] = new String[20];
		for(String key:maps.keySet()){
			if("反恐".equals(key.substring(0,2))) continue;
			if("浦东".equals(key.substring(0,2))){
				setArray[0] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("黄浦".equals(key.substring(0,2))){
				setArray[1] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("徐汇".equals(key.substring(0,2))){
				setArray[2] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("长宁".equals(key.substring(0,2))){
				setArray[3] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("静安".equals(key.substring(0,2))){
				setArray[4] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("普陀".equals(key.substring(0,2))){
				setArray[5] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("闸北".equals(key.substring(0,2))){
				setArray[6] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("虹口".equals(key.substring(0,2))){
				setArray[7] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("杨浦".equals(key.substring(0,2))){
				setArray[8] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("宝山".equals(key.substring(0,2))){
				setArray[9] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("闵行".equals(key.substring(0,2))){
				setArray[10] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("嘉定".equals(key.substring(0,2))){
				setArray[11] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("金山".equals(key.substring(0,2))){
				setArray[12] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("松江".equals(key.substring(0,2))){
				setArray[13] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("奉贤".equals(key.substring(0,2))){
				setArray[14] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("青浦".equals(key.substring(0,2))){
				setArray[15] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			if("崇明".equals(key.substring(0,2))){
				setArray[16] = "<set name='"+key.substring(0,2)+"' value='"+maps.get(key)+"' color='"+colors[count]+"' />";
			}
			count++;
		}
		for(int i=0;i<setArray.length;i++){
			zztSldwSb.append(setArray[i]);
		}
		zztSldwSb.append("</graph>");
        String str = zztSldwSb.toString();
        System.out.println(str);
        return str;
	}

	
	
	/**getter方法和setter方法*/
	public Message getMessage1() {
		return message1;
	}



	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	public void setMessage1(Message message1) {
		this.message1 = message1;
	}

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	public INoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public IIndexService getIndexService() {
		return indexService;
	}
	public void setIndexService(IIndexService indexService) {
		this.indexService = indexService;
	}
	public String getSldwZztGraph() {
		return sldwZztGraph;
	}

	public void setSldwZztGraph(String sldwZztGraph) {
		this.sldwZztGraph = sldwZztGraph;
	}


	public String getRyztPieGraph() {
		return ryztPieGraph;
	}


	public void setRyztPieGraph(String ryztPieGraph) {
		this.ryztPieGraph = ryztPieGraph;
	}
	public String getChart() {
		return chart;
	}
	public void setChart(String chart) {
		this.chart = chart;
	}

	public String getMzPieGraph() {
		return mzPieGraph;
	}

	public void setMzPieGraph(String mzPieGraph) {
		this.mzPieGraph = mzPieGraph;
	}

	public String getRylbPieGraph() {
		return rylbPieGraph;
	}

	public void setRylbPieGraph(String rylbPieGraph) {
		this.rylbPieGraph = rylbPieGraph;
	}

	public String getLhsqPieGraph() {
		return lhsqPieGraph;
	}

	public void setLhsqPieGraph(String lhsqPieGraph) {
		this.lhsqPieGraph = lhsqPieGraph;
	}

	public ISjzdService getSjzdService() {
		return sjzdService;
	}

	public void setSjzdService(ISjzdService sjzdService) {
		this.sjzdService = sjzdService;
	}

	public String getZzdlxPieGraph() {
		return zzdlxPieGraph;
	}

	public void setZzdlxPieGraph(String zzdlxPieGraph) {
		this.zzdlxPieGraph = zzdlxPieGraph;
	}

	public String getXhcount() {
		return xhcount;
	}

	public void setXhcount(String xhcount) {
		this.xhcount = xhcount;
	}
}
