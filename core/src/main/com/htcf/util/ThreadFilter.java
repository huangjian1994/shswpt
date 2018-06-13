package com.htcf.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;

import com.htcf.entity.TreadInfo;
import com.htcf.entity.User;
import com.htcf.entity.UserForm;

public class ThreadFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
			
			HttpServletRequest request=(HttpServletRequest)req;
			
			UserForm user=(UserForm)request.getSession().getAttribute("userForm");
			
			TreadInfo treadInfo=new TreadInfo();
			treadInfo.setLogAddr(req.getRemoteAddr());
			
			if(user !=null){
				BeanUtils.copyProperties(user, treadInfo);
			}
			MyThread.setThread(treadInfo);
			chain.doFilter(req, resp);

	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
