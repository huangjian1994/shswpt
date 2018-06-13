package com.htcf.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.htcf.entity.User;
import com.htcf.util.PageBean;

public abstract class BaseAction  implements RequestAware,SessionAware {
	

	private static final long serialVersionUID = 1L;
	
	
	protected PageBean pageBean;


	protected  Map<String, Object> request;

	
	protected Map<String, Object> session;

	
	protected String method;
	
	
	protected String message;
	
	
	
	
	/* 
	 * 上传
	 * @author yinying
	 *    @create 2013-10-14
	 */
	public  String upload(String fileName,File upload){
		System.out.println("进入上传。。。。 ");
		FileInputStream fis = null;   //为了关闭资源
		FileOutputStream fos = null;	
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;	
		String path = null;
		try {
			
			fis = new FileInputStream(upload);
			bis = new BufferedInputStream(fis);				  
		    String realPath = ServletActionContext.getServletContext().getRealPath("/standardFiles/bzgl");
		    System.out.println("文件路径：" + realPath);
		    System.out.println("文件详细路径：" + realPath + File.separator + fileName);
		    path = realPath + File.separator + fileName;
		  
			File serFile = new File(realPath);
			//判断服务器上该目录是否存在，不存在则创建目录
			if(!serFile.exists()){
				serFile.mkdirs();
			}		
			//封装成IO流对象，以便输出文件内容
			fos = new FileOutputStream(realPath + File.separator + fileName); //从内存走					
			bos = new BufferedOutputStream(fos);  //从内存往硬盘走				
			int count = bis.read();
			//如果没有读取到文件末行
			while(count != -1){
				//把读取到的一行  输出到硬盘上
				bos.write(count);
				count = bis.read();
			}
			//上传文件完毕，关闭IO流资源
			if(bis != null){
				bis.close();
			}
			if(bos != null){
				bos.close();
			}							
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		System.out.println("路径：" + path);
		//将文件名、类型、路径上传到数据库
		return path;
	}

	public User getSessionUser(){
		return (User)session.get("user");
		
		
	}

	
		
	
	protected final HttpServletResponse getHttpServletResponse() {
		return ServletActionContext.getResponse();
		

	}


	protected final HttpServletRequest getHttpServletRequest() {
		return ServletActionContext.getRequest();
		

	}
	
	protected final HttpSession getHttpSession (){
		return ServletActionContext.getRequest().getSession();
	

	}
	
	public String getContextPath() {
		return ServletActionContext.getRequest().getContextPath();
	}


	

	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}


	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	// 处理分页Bean
	protected PageBean processPageBean(HttpServletRequest request) {
		PageBean pageBean = new PageBean();
		pageBean.setRequest(request);// 初始化分页bean
		
		return pageBean;
	}

	
	public BaseAction() {
		
		
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public PageBean getPageBean() {
		return pageBean;
	}


	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	



	
}
