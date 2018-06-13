package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.htcf.dao.SelectVideoDao;
import com.htcf.entity.SelectVideo;
import com.htcf.entity.Users;
import com.htcf.util.PageBean;

@Repository(value="selectVideoDao")
public class SelectVideoDaoImpl extends BaseDAOImpl<Object, Serializable> implements SelectVideoDao{

	/**
	 * 
	Description :保存实体
	@param
	@return
	@throws
	@Author：yinying
	@Create 2017-04-25
	 */
//    public void addEntity(Object obj){
//    	this.save(obj);
//    }
    /**
     * 
    Description :查出库中的视频
    @param pageBean
    @return List
    @throws
    @Author：
    @Create 2017-04-25
     */
    public List<?> fetchVideoList(SelectVideo video,PageBean pageBean){
    	String sql=" from SelectVideo";
  	
    	List<?> l = this.findPageByJPQL(sql, null);
   	
    	System.out.println(l.size());
		if(l != null && l.size()!=0){
			return l;
		}
		return null;
    }
    
    /**
     * 
    Description :查出所有人员权限
    @param pageBean
    @return List
    @throws
    @Author：
    @Create 2018-04-25
     */
    public List<?> fetchUserList(Users user,PageBean pageBean){
    	String sql=" from Users";
  	
    	List<?> l = this.findPageByJPQL(sql, null);
   	
    	System.out.println(l.size());
		if(l != null && l.size()!=0){
			return l;
		}
		return null;
    }

	public List selectSchoolItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public List selectSchoolItem1() {
		// TODO Auto-generated method stub
		return null;
	}

	public List selectSchoolItem11() {
		// TODO Auto-generated method stub
		return null;
	}
    
    /**
     * 
    Description :videoList
    @param zjID
    @return Video
    @throws
    @Author：
    @Create 2017-04-26
     */
//    public Video fetchVideoDetail(String zjID){
//    	String sql=" from Video where id="+zjID+" ";
//    	List<?> l = this.findByJPQL(sql, null);
//    	Video video = new Video();
//    	if(l != null && l.size()!=0){
//    		video = (Video) l.get(0);
//    	}
//    	return video;
//    }
}
