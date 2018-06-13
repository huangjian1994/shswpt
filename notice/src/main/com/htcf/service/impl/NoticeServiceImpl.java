package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.INoticeDAO;
import com.htcf.entity.Notice;
import com.htcf.service.INoticeService;
import com.htcf.util.PageBean;

@Service(value="noticeService")
public class NoticeServiceImpl implements INoticeService {

	@Autowired
	private INoticeDAO noticeDAO;
	


	public List<Notice> retrieveNoticesByConditions(Notice notice,
			PageBean pageBean) {
		
		return noticeDAO.retrieveNoticesByConditions(notice,pageBean);
		
	}
	
	
	
	public void addNotice(Notice notice) {

		noticeDAO.addNotice(notice);
		
	}

	public void deleteNotice(Notice notice) {
		noticeDAO.deleteNotice(notice);
		
	}
	
	public INoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public Notice fetchNoticeById(Notice notice) {
		return noticeDAO.fetchNoticeById(notice);
		
	}



	public List<Notice> retrieveLatestNotices(PageBean pageBean) {
		
		return noticeDAO.retrieveLatestNotices(pageBean);
	}



	
}
