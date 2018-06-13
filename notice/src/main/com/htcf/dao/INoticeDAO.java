package com.htcf.dao;

import java.util.List;

import com.htcf.entity.Notice;
import com.htcf.util.PageBean;

public interface INoticeDAO {

	List<Notice> retrieveNoticesByConditions(Notice notice, PageBean pageBean);

	void addNotice(Notice notice);

	Notice fetchNoticeById(Notice notice);

	void deleteNotice(Notice notice);

	List<Notice> retrieveLatestNotices(PageBean pageBean);

}
