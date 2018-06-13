package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Repository;

import com.htcf.dao.IMessageDAO;

import com.htcf.entity.Message;
import com.htcf.util.PageBean;

@Repository(value="messageDAO")
public class IMessageDAOImpl  extends BaseDAOImpl<Message,Serializable>implements IMessageDAO{

	public List<Message> retrieveMessagesByConditions(Message message,PageBean pageBean) {
			
		StringBuffer jpql=new StringBuffer(" from Message m where 1=1  ");
		
		Map <String,Object> args=new HashMap<String,Object>();
		
		if(message !=null){
			
			
			if(StringUtils.isNotBlank(message.getTitle())){
				jpql.append(" and m.title like :title");
				args.put("title", '%'+message.getTitle()+'%');
				
			}
			if(StringUtils.isNotBlank(message.getCreateTime())){
				jpql.append(" and m.createTime like :time");
				args.put("time", '%'+message.getCreateTime()+'%');
			}
		}
		
		jpql.append(" order by m.createTime desc");
		
		return this.findPageByJPQL(jpql.toString(), args, pageBean);
			
	}

	public Message fetchLatestMessage() {
		String jpql="select m from  Message m where m.createTime =(select max(t.createTime) from Message t) ";
		List<Message> ms=this.findByJPQL(jpql, null);
		if(ms!=null &&  !ms.isEmpty()){
			
			return ms.get(0);
		}
		return null;
		
	}

}
