package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Repository;


import com.htcf.dao.INoticeDAO;
import com.htcf.entity.Notice;
import com.htcf.util.PageBean;



@Repository(value="noticeDAO")
public class NoticeDAOImpl  extends BaseDAOImpl<Notice,Serializable>implements INoticeDAO {

	public List<Notice> retrieveNoticesByConditions(Notice notice,
			PageBean pageBean) {
	
		StringBuffer jpql=new StringBuffer(" from Notice n where 1=1  ");
		
		Map <String,Object> args=new HashMap<String,Object>();
		
		if(notice !=null){
			
			
			if(StringUtils.isNotBlank(notice.getTitle())){
				jpql.append(" and n.title like :title");
				args.put("title", '%'+notice.getTitle()+'%');
				
			}
			if(StringUtils.isNotBlank(notice.getCreateTime())){
				jpql.append(" and n.createTime like :time");
				args.put("time", '%'+notice.getCreateTime()+'%');
			}
		}
		
		jpql.append(" order by n.createTime desc");
		
		return this.findPageByJPQL(jpql.toString(), args, pageBean);
	}

	
	public void addNotice(Notice notice) {
	
		this.save(notice);
		
	}


	public Notice fetchNoticeById(Notice notice) {
		return  this.getById(notice.getId());
	}


	public void deleteNotice(Notice notice) {
		this.delete(notice);
		
	}


	public List<Notice> retrieveLatestNotices(PageBean pageBean) {
		
		StringBuffer jpql=new StringBuffer(" from Notice n  order by n.createTime desc ");
		
		Map <String,Object> args=new HashMap<String,Object>();
		
		return this.findPageByJPQL(jpql.toString(), args, pageBean);
		
	}
	
	
}
