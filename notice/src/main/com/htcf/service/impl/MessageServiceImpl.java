package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.IMessageDAO;
import com.htcf.entity.Message;
import com.htcf.service.IMessageService;
import com.htcf.util.PageBean;

@Service(value="messageService")
public class MessageServiceImpl  implements IMessageService{

	@Autowired
	private IMessageDAO messageDAO;
	
	

	public List<Message> retrieveMessagesByConditions(Message message,
			PageBean pageBean) {
	
		
		return messageDAO.retrieveMessagesByConditions(message,pageBean);
	}

	
	public Message fetchLatestMessage() {
		
		return messageDAO.fetchLatestMessage();
	}
	
	
	public IMessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(IMessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}


	
}
