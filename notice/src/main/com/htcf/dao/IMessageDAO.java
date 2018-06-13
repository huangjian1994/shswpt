package com.htcf.dao;

import java.util.List;

import com.htcf.entity.Message;
import com.htcf.util.PageBean;

public interface IMessageDAO {

	List<Message> retrieveMessagesByConditions(Message message, PageBean pageBean);

	Message fetchLatestMessage();

}
