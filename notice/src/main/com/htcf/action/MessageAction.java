package com.htcf.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.Message;
import com.htcf.service.IMessageService;

@Controller(value="messageAction")
@Scope("prototype")
public class MessageAction extends BaseAction {
	
	@Autowired
	private IMessageService messageService;
	
	private List<Message> messageList=new ArrayList<Message>();
	
	private Message message1=new Message();
	



	public String list(){
		
		HttpServletRequest request= this.getHttpServletRequest();
		pageBean=this.processPageBean(request);
		messageList=messageService.retrieveMessagesByConditions(message1,pageBean);
		
		return "messageList";
		
	}
	

	public Message getMessage1() {
		return message1;
	}


	public void setMessage1(Message message1) {
		this.message1 = message1;
	}


	public String getLatestMessage(){
		
		/*message1=messageService.fetchLatestMessage();
		
		System.out.println("getLatestMessage方法执行了");
		
	 	HttpServletResponse response=this.getHttpServletResponse();
	 
		response.setContentType("text/plain;charset=utf-8");
		
		JSONObject json=JSONObject.fromObject(message1);
		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(json.toString());
		
		out.print(json.toString());
		
		out.flush();*/
		
		return null;
	}
	
	
	
	public List<Message> getMessageList() {
		return messageList;
	}




	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}




	public IMessageService getMessageService() {
		return messageService;
	}




	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

}
