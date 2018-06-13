
package com.htcf.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class RandomServlet extends HttpServlet {

	private static final long serialVersionUID = 3923090461076418525L;

	private String tempURL = null,propertiesURL = null;
	
	private Properties props = null;
	
	/** 认证地址 */
	private final String KEY_AUTHURL = "authURL";

	/** 应用标识 */
	private final String KEY_APP_ID = "appId";

	/**
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig cfg) throws ServletException {
		// 初始化程序跳转页面
		tempURL = cfg.getInitParameter("url");
		propertiesURL = cfg.getInitParameter("propertiesURL");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 初始化属性文件路径
//		String parentPath = request.getSession().getServletContext()
//				.getRealPath("/WEB-INF");
		// 产生认证原文
		String randNum = generateRandomNum();

		if (randNum == null || randNum.trim().equals("")) {
			System.out.println("证书认证数据不完整！");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}

		/**************************
		 * 第三步 服务端返回认证原文   *
		 **************************/
		// 设置认证原文到session，用于程序向后传递，通讯报文中使用
		request.getSession().setAttribute("original_data", randNum);

		// 设置认证原文到页面，给页面程序提供参数，用于产生认证请求数据包
		request.setAttribute("original", randNum);

		// 设置跳转页面
		request.getRequestDispatcher(tempURL).forward(request, response);

		return;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doGet(req, resp);
	}
	/**
	 * 产生认证原文
	 */
	private String generateRandomNum() {
		/**************************
		 * 第二步 服务端产生认证原文   *
		 **************************/
		String num = "1234567890abcdefghijklmnopqrstopqrstuvwxyz";
		int size = 6;
		char[] charArray = num.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb
					.append(charArray[((int) (Math.random() * 10000) % charArray.length)]);
		}
		return sb.toString();
	}

	/**
	 * 产生认证原文
	 * @throws Exception 
	 */
//	private String generateRandomNum(String parentPath){
//
//		//认证原文结果
//		String originalResult = "" ;
//	    //认证原文报文对象
//		byte[] messagexml = null;
//		//表示认证原文服务的成功与否，true代表成功，false代表失败
//		boolean isSuccess = true;
//		//错误码
//		String errCode = null;
//		//错误描述
//		String errDesc = null;	
//		//应用标识
//		String applicationID="";
//		//网关地址
//		String authURL = "";
//		//第一步：客户端请求认证原文
//		//第二步：服务端请求认证原文
//		//第三步：网关返回认证原文
//		//第四步：服务端返回认证原文
//
//		/*****************************
//		 * 从配置文件中获得应用标识 *
//		 *****************************/
//
//
//		// 初始化配置文件属性
//		try{
//		InputStream in = new FileInputStream(parentPath + propertiesURL);
//		props = new Properties();
//		props.load(in);
//		applicationID = 	this.getProperties(KEY_APP_ID);
//		authURL = this.getProperties(KEY_AUTHURL);
//		}catch(Exception e){
//			isSuccess = false;
//			errDesc = "从配置文件中获得应用标识，和网关地址发生异常";
//			System.out.println(errDesc);
//		}
//		/**************************
//		 * 第二步 服务端请求认证原文   *
//		 **************************/
//
//		/*** 1 组装认证请求报文数据 ** 开始 **/
//		Document reqDocument = DocumentHelper.createDocument();
//		Element root = reqDocument.addElement("message");
//		Element requestHeadElement = root.addElement("head");
//		Element requestBodyElement = root.addElement("body");
//		/* 组装报文头信息 */
//		//组装报文的版本信息
//		requestHeadElement.addElement("version").setText(
//				"1.0");
//		//组装请求的的服务类型
//		requestHeadElement.addElement("serviceType").setText(
//				"OriginalService");
//
//		/* 组装报文体信息 */
//
//		// 组装应用标识信息
//		requestBodyElement.addElement("appid").setText(applicationID);
//		
//		/*** 1 组装认证原文请求报文数据 ** 完毕 **/	
//		
//		
//		/*** 2 将认证原文请求报文写入输出流 ** 开始 **/
//		StringBuffer reqMessageData = new StringBuffer();
//		try {
//			
//			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//			XMLWriter writer = new XMLWriter(outStream);
//			writer.write(reqDocument);
//			messagexml = outStream.toByteArray();
//			reqMessageData.append("请求内容开始！\n");
//			reqMessageData.append(outStream.toString() + "\n");
//			reqMessageData.append("请求内容结束！\n");
//			System.out.println(reqMessageData.toString() + "\n");
//		} catch (Exception e3) {
//			isSuccess = false;
//			errDesc = "组装请求时出现异常";
//			System.out.println("组装请求时出现异常");
//		}
//		/*** 2 将认证原文请求报文写入输出流 ** 完毕 **/		
//		
//		/****************************************************************
//		 * 创建与网关的HTTP连接，发送认证原文请求报文，并接收认证原文响应报文*
//		 ****************************************************************/
//		/*** 1 创建与网关的HTTP连接 ** 开始 **/
//		int statusCode = 500;
//		HttpClient httpClient = null;
//		PostMethod postMethod = null;
//		if (isSuccess) {
//			// HTTPClient对象
//			httpClient = new HttpClient();
//			postMethod = new PostMethod(authURL);
//
//			// 设置报文传送的编码格式
//			postMethod.setRequestHeader("Content-Type",
//					"text/xml;charset=UTF-8");
//			/*** 2 设置发送认证原文请求内容 ** 开始 **/
//			postMethod.setRequestBody(new ByteArrayInputStream(messagexml));
//			/*** 2 设置发送认证原文请求内容 ** 结束 **/
//			// 执行postMethod
//			try {
//				/*** 3 发送通讯报文与网关通讯 ** 开始 **/
//				statusCode = httpClient.executeMethod(postMethod);
//				/*** 3 发送通讯报文与网关通讯 ** 结束 **/
//			} catch (Exception e2) {
//				isSuccess = false;
//				errCode = String.valueOf(statusCode);
//				errDesc = e2.getMessage();
//				System.out.println("与网关连接出现异常\n");
//			}
//		}
//		/**************************
//		 * 第三步：网关返回认证原文   *
//		 **************************/
//		StringBuffer respMessageData = new StringBuffer();
//		String respMessageXml = null;
//		if (isSuccess) {
//			// 当返回200或500状态时处理业务逻辑
//			if (statusCode == HttpStatus.SC_OK
//					|| statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
//				// 从头中取出转向的地址
//				try {
//					/*** 4 接收通讯报文并处理 ** 开始 **/
//					byte[] inputstr = postMethod.getResponseBody();
//
//					ByteArrayInputStream ByteinputStream = new ByteArrayInputStream(
//							inputstr);
//					ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//					int ch = 0;
//					try {
//						while ((ch = ByteinputStream.read()) != -1) {
//							int upperCh = (char) ch;
//							outStream.write(upperCh);
//						}
//					} catch (Exception e1) {
//						isSuccess = false;
//						errDesc = e1.getMessage();
//					}
//
//					if (isSuccess) {
//						// 200 表示返回处理成功
//						if (statusCode == HttpStatus.SC_OK) {
//							respMessageData.append("响应内容开始！\n");
//							respMessageData.append(new String(outStream
//									.toByteArray(), "UTF-8")
//									+ "\n");
//							respMessageData.append("响应内容开始！\n");
//							respMessageXml = new String(outStream
//									.toByteArray(), "UTF-8");
//						} else {
//							// 500 表示返回失败，发生异常
//							respMessageData.append("响应500内容开始！\n");
//							respMessageData.append(new String(outStream
//									.toByteArray())
//									+ "\n");
//							respMessageData.append("响应500内容结束！\n");
//							isSuccess = false;
//							errCode = String.valueOf(statusCode);
//							errDesc = new String(outStream.toByteArray());
//						}
//						System.out.println(respMessageData.toString()
//								+ "\n");
//					}
//					/*** 4 接收通讯报文并处理 ** 结束 **/
//				} catch (IOException e4) {
//					isSuccess = false;
//					errCode = String.valueOf(statusCode);
//					errDesc = e4.getMessage();
//					System.out.println("读取认证原文响应报文出现异常！");
//				}
//			}
//		}
//
//		/*** 1 创建与网关的HTTP连接 ** 结束 **/
//		
//		Document respDocument = null;
//		Element responseheadElement = null;
//		Element responsebodyElement = null;
//		
//		if (isSuccess) {
//			try{
//			respDocument = DocumentHelper.parseText(respMessageXml);
//			}catch(Exception es){
//				isSuccess = false;
//				errCode = String.valueOf(statusCode);
//				errDesc = es.getMessage();
//				System.out.println("解析认证原文响应报文出现异常！");
//			}
//
//			responseheadElement = respDocument.getRootElement().element("head");
//			responsebodyElement = respDocument.getRootElement().element("body");
//
//			/*** 1 解析报文头 ** 开始 **/
//			if (responseheadElement != null) {
//				boolean state = Boolean.valueOf(
//						responseheadElement.elementTextTrim("messagestate"))
//						.booleanValue();
//				if (state) {
//					isSuccess = false;
//					errCode = responseheadElement.elementTextTrim("messageCode");
//					errDesc = responseheadElement.elementTextTrim("messageDesc");
//					System.out.println("认证原文业务处理失败！\t" + errDesc + "\n");
//				}
//			}
//		}
//
//		if (isSuccess) {
//			System.out.println("解析报文头成功！\n");
//			/* 解析报文体 */
//			// 解析认证原文结果集
//			originalResult = responsebodyElement.elementTextTrim("original");
//	
//			if (originalResult==null || originalResult.equals("")) {
//				errCode = String.valueOf(statusCode);
//				errDesc = "认证原文为空";
//				System.out.println("获取认证原文失败，失败原因：" + errDesc);
//			}
//			}
//		/**************************
//		 * 第四步：服务端返回认证原文 *
//		 **************************/	
//	   return originalResult;
//	   
//  }
	/**
	 * 获取文件中的属性值
	 */
	private String getProperties(String key) {
		return props.get(key) == null ? null : (String) props.get(key);
	}
}
