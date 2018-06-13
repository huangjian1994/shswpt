package com.htcf.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.Notice;
import com.htcf.entity.User;
import com.htcf.service.INoticeService;

@Controller(value="noticeAction")
@Scope("prototype")
public class NoticeAction extends BaseAction {
	
	@Autowired
	private INoticeService noticeService;
	
	private List<Notice> noticeList=new ArrayList<Notice>();
	
	private Notice notice=new Notice();

	public String list(){
		
		HttpServletRequest request= this.getHttpServletRequest();
		pageBean=this.processPageBean(request);
		noticeList=noticeService.retrieveNoticesByConditions(notice,pageBean);
		
		return "noticeList";
		
	}
	
	
	public String add(){
		
		User user=this.getSessionUser();
		
		notice.setUserId(user.getUserId());
		notice.setCreateBy(user.getName());
		notice.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:dd:ss").format(new Date()));
		notice.setDepartment(user.getDepartment());
		notice.setContent(notice.getContent());
		notice.setDepartmentId(user.getDepartmentId());
		notice.setOrganization(user.getOrganization());
		notice.setOrganizationId(user.getOrganizationId());
		
		noticeService.addNotice(notice);
		
		notice=null;
		
		return "toNoticeList";
		
	};
	
	public String showDetail(){
		notice=noticeService.fetchNoticeById(notice);
		return "detail";
	}

	
	public String delete(){
		noticeService.deleteNotice(notice);
		return "toNoticeList";
	}
	
	
	
	public List<Notice> getNoticeList() {
		return noticeList;
	}



	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}



	public INoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

}
