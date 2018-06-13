package com.htcf.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	private List<String> outList=new ArrayList<String>();
	
	public List<String> getOutList() {
		return outList;
	}

	public void setOutList(List<String> outList) {
		this.outList = outList;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
			HttpServletRequest req=(HttpServletRequest)request;
			
			//获的发送请求的页面路径
			String requestURL=req.getRequestURI();
			
			//System.out.println("requestURL====="+requestURL);
			
			requestURL=requestURL.substring(requestURL.lastIndexOf("/")+1);
			
			//System.out.println("截取后的requestURL==="+requestURL);
			
			
			if(outList.contains(requestURL)){
				chain.doFilter(request, response);
				return ;
			}
			//判断Session是否为空；
			if(req.getSession().getAttribute("userForm")!=null){
				chain.doFilter(request, response);
			}else{
				HttpServletResponse resp=(HttpServletResponse) response;
				System.out.println("过滤了没登陆的页面");
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		
	}

	public void init(FilterConfig config) throws ServletException {
		
		String outFlterUrl =config.getInitParameter("outFilter");
		
		//System.out.println("outFlterUrl==="+outFlterUrl);
		
		setOutList(Arrays.asList(outFlterUrl.split(",")));
		
		

	}

}
