package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.SelectVideoDao;
import com.htcf.entity.SelectVideo;
import com.htcf.entity.Users;
import com.htcf.service.SelectVideoService;
import com.htcf.util.PageBean;

@Service(value = "selectVideoService")
public class SelectVideoServiceImpl implements SelectVideoService{

	@Autowired
	private SelectVideoDao selectVideoDao;
	
	public List<?> fetchVideoList(SelectVideo video, PageBean pageBean) {
		// TODO Auto-generated method stub
		return selectVideoDao.fetchVideoList(video, pageBean);
	}

	public List<?> fetchUserList(Users user, PageBean pageBean) {
		// TODO Auto-generated method stub
		return selectVideoDao.fetchUserList(user, pageBean);
	}




}
