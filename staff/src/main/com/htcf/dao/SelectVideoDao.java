package com.htcf.dao;

import java.util.List;

import com.htcf.entity.SelectVideo;
import com.htcf.entity.Users;
import com.htcf.util.PageBean;

public interface SelectVideoDao {

	public List selectSchoolItem1() ;
	public List selectSchoolItem() ;
	public List selectSchoolItem11();
    //find the videodan
	public List<?> fetchVideoList(SelectVideo video,PageBean pageBean);
	public List<?> fetchUserList(Users user,PageBean pageBean);
}
