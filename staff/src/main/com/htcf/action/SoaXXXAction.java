package com.htcf.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.util.RequestUtil;

@Controller("SoaXXXAction")
@Scope("prototype")
public class SoaXXXAction {

	private String account;
	private String tokenId;
	
	//人家访问你的地址，你的域名/项目名/方法?account=XXX&tokenId=XXX
	//进入到这个方法中
	public String goInSys() {
		
		System.out.println("account-----"+account);
		System.out.println("tokenId-----"+tokenId);
		if(account == null || tokenId == null) {
			System.out.println("");
			return "error";
		}
		// 发送get请求,util
		String response = 
			RequestUtil.sendGet("http://31.16.10.180:8080/CXFRest/rest/sample/checkLoginStatus/", String.format("account=%s&tokenId=%s", account, tokenId));
		
		// 分析response
		// 如果那个人是登录状态点击的这个链接，那么会返回。
		// 已登陆：callback({"flag":"login"})
		// 未登陆：callback({"flag":"logout"})
		// 异常：callback({"flag":"error"})
		
		if(response != null && response.contains("login")) {
			// 这个人已经登录到XXX平台了，登录到本系统中
			System.out.println("已登录--------"+response);
			return "index";
		} else if(response != null && response.contains("logout")) {
			// 这个人未登录
			System.out.println("未登录--------"+response);
			return "login";
		} else if(response != null && response.contains("error")) {
			// 出现异常
			System.out.println("出错了--------"+response);
			return "error";
		}
		
		//http://31.16.10.80:8080/CXFRest/rest/sample/checkLoginStatus/account=XXX&tokenId=********
		//account=XXX&tokenId=********
		
		return "login";
	}

	
	public String test(){
		System.out.println("15555555");
		return null;
	}
	
	
	
	
	
	
	/*----------------不就这样么，那就是这样----------------*/
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	
	
}
