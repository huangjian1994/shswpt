package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.VideoStoreDao;
import com.htcf.entity.Users;
import com.htcf.entity.Video;
import com.htcf.service.VideoStoreService;
import com.htcf.util.PageBean;

@Service(value = "videoStoreService")
public class VideoStoreServiceImpl implements VideoStoreService{
	@Autowired
	private VideoStoreDao videoStoreDao;

	/**
	 * 
	Description :保存实体
	@param
	@return
	@throws
	@Author：yinying
	@Create 2017-04-25
	 */
    public void addEntity(Object obj){
    	videoStoreDao.addEntity(obj);
    }
	
    /**
     * 
    Description :查出库中的视频
    @param pageBean
    @return List
    @throws
    @Author：yinying
    @Create 2017-04-25
     */
    public List<?> fetchVideoList(Video video,PageBean pageBean){
    	return videoStoreDao.fetchVideoList(video,pageBean);
    }
    
    /**
     * 
    Description :videoList
    @param zjID
    @return Video
    @throws
    @Author：yinying
    @Create 2017-04-26
     */
    public Video fetchVideoDetail(String zjID){
    	return videoStoreDao.fetchVideoDetail(zjID);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public VideoStoreDao getVideoStoreDao() {
		return videoStoreDao;
	}

	public void setVideoStoreDao(VideoStoreDao videoStoreDao) {
		this.videoStoreDao = videoStoreDao;
	}

	public Users fetchUserDetail(String zjID) {
		return videoStoreDao.fetchUserDetail(zjID);
	}

	public boolean editAuthority(Users users,String zjID) {
		
		return videoStoreDao.editAuthority(users,zjID) ;
	}
	
	
}
