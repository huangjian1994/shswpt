package com.htcf.service;

import java.util.List;

import com.htcf.entity.Message;
import com.htcf.util.PageBean;

public interface IMessageService {


	List<Message> retrieveMessagesByConditions(Message message, PageBean pageBean);

	Message fetchLatestMessage();

}
