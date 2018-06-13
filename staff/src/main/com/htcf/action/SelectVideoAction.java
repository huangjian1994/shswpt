package com.htcf.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.SelectVideo;
import com.htcf.entity.Users;
import com.htcf.service.SelectVideoService;
import com.htcf.service.VideoStoreService;
@Controller("selectVideoAction")
@Scope("prototype")
public class SelectVideoAction extends BaseAction{  
	private static final long serialVersionUID = 1L;  
   
	@Autowired
    private SelectVideoService selectVideoService;
    
    @Autowired
	private VideoStoreService videoStoreService;
    
    private List list;
    
    
    private SelectVideo video = new SelectVideo();
    private Users user = new Users();
    //List
	private List<?> videoList;
	private List<?> userList;
	


	//http://localhost:8080
    public String fetchVideo(){
		HttpServletRequest request= this.getHttpServletRequest();
		pageBean=this.processPageBean(request);
		pageBean.setPageRecord(10);
		videoList = selectVideoService.fetchVideoList(video,pageBean);
		//12341
		//request.setAttribute("videoList", videoList);
		request.getSession().setAttribute("videoList", videoList);
		return "videoSelect";
	}
    
    public String fetchUser(){
		HttpServletRequest request= this.getHttpServletRequest();
		pageBean=this.processPageBean(request);
		pageBean.setPageRecord(10);
		userList = selectVideoService.fetchUserList(user,pageBean);
		//12341
		//request.setAttribute("videoList", videoList);
		request.getSession().setAttribute("videoList", videoList);
		return "userSelect";
	}

	/**
	 * 
	Description :获取手机视频信息
	@param
	@return
	@throws
	@Author：jiliangliang
	@Create 2017-07-18
	 */
    public String selectVideoStore(){
    	HttpServletRequest request= this.getHttpServletRequest();
		pageBean=this.processPageBean(request);
		pageBean.setPageRecord(10);
		videoList = selectVideoService.fetchVideoList(video,pageBean);
		//12341
		//request.setAttribute("videoList", videoList);
    	return "selectvideostore";
    }
    
    public String index(){
    	HttpServletRequest request= this.getHttpServletRequest();
    	videoList = selectVideoService.fetchVideoList(null,null);
    	request.getSession().setAttribute("videoList", videoList);
    	return "index";
    }
    
    public String detail(){
    	HttpServletRequest request= this.getHttpServletRequest();
    	request.getSession().setAttribute("url", request.getParameter("url"));
    	return "detail";
    }
    
    public String selectvideojsp(){
    	System.out.println("come in");
		HttpServletRequest request= this.getHttpServletRequest();
		pageBean=this.processPageBean(request);
		pageBean.setPageRecord(10);
		videoList = selectVideoService.fetchVideoList(null,null);
		System.out.println("come in" + videoList);
		List videoList_ = new ArrayList();
		
    	return "selectvideojsp";
    }
    
    public void gjson(){
    	 HttpServletResponse response=ServletActionContext.getResponse();
    	   /*
    	    * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
    	    * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
    	    * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
    	     * */
    	   response.setContentType("text/html;charset=utf-8");
    	   //response.setCharacterEncoding("UTF-8");
    	     PrintWriter out;
			try {
				out = response.getWriter();
				 //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
	    	     //String jsonString="{\"user\":{\"id\":\"123\",\"name\":\"张三\",\"say\":\"Hello , i am a action to print a json!\",\"password\":\"JSON\"},\"success\":true}";
	    	     videoList = selectVideoService.fetchVideoList(null,null);
	    	     JSONArray json = JSONArray.fromObject(videoList);
	    	     System.err.print("------------"+json);
	    	     out.println(json);
	    	     out.flush();
	    	     out.close();
			} catch (IOException e) {
			}  
			//return "ok";
    }
    
	public String  findVideo(){
		  list.add("a");
		  list.add("b");
		  list.add("c");
    	return "success";
	}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public SelectVideoService getSelectVideoService() {
		return selectVideoService;
	}

	public void setSelectVideoService(SelectVideoService selectVideoService) {
		this.selectVideoService = selectVideoService;
	}

	public VideoStoreService getVideoStoreService() {
		return videoStoreService;
	}

	public void setVideoStoreService(VideoStoreService videoStoreService) {
		this.videoStoreService = videoStoreService;
	}

	public SelectVideo getVideo() {
		return video;
	}

	public void setVideo(SelectVideo video) {
		this.video = video;
	}

	public List<?> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<?> videoList) {
		this.videoList = videoList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public void setUserList(List<?> userList) {
		this.userList = userList;
	}



	public List<?> getUserList() {
		return userList;
	}
	
    public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}  