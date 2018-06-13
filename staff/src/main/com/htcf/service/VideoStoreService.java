package com.htcf.service;

import java.util.List;

import com.htcf.entity.Video;
import com.htcf.util.PageBean;

public interface VideoStoreService {

	/**
	 * 
	Description :保存实体
	@param
	@return
	@throws
	@Author：yinying
	@Create 2017-04-25
	 */
    public void addEntity(Object obj);
    
    /**
     * 
    Description :查出库中的视频
    @param pageBean
    @return List
    @throws
    @Author：yinying
    @Create 2017-04-25
     */
    public List<?> fetchVideoList(Video video,PageBean pageBean);
    
    /**
     * 
    Description :videoList
    @param zjID
    @return Video
    @throws
    @Author：yinying
    @Create 2017-04-26
     */
    public Video fetchVideoDetail(String zjID);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
