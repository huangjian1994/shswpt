package com.htcf.service;

import java.util.List;

import com.htcf.entity.Notice;
import com.htcf.util.PageBean;

public interface INoticeService {

	List<Notice> retrieveNoticesByConditions(Notice notice, PageBean pageBean);

	void addNotice(Notice notice);

	Notice fetchNoticeById(Notice notice);

	void deleteNotice(Notice notice);

	List<Notice> retrieveLatestNotices(PageBean pageBean);
	
	

}
