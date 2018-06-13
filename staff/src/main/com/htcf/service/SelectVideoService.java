package com.htcf.service;

import java.util.List;

import com.htcf.entity.SelectVideo;
import com.htcf.entity.Users;
import com.htcf.util.PageBean;

public interface SelectVideoService {

	/**
	 * 
	Description :保存实体
	@param
	@return
	@throws
	@Author
	@Create 2017-06-20
	 */
//    public void addEntity(Object obj);
    
    /**
     * 
    Description :查出库中的视频
    @param pageBean
    @return List
    @throws
    @Author
    @Create 2017-06-20
     */
    public List<?> fetchVideoList(SelectVideo video,PageBean pageBean);
    public List<?> fetchUserList(Users user,PageBean pageBean);
    
    /**
     * 
    Description :videoList
    @param sjID
    @return Video
    @throws
    @Author：
    @Create 2017-06-20
     */
//    public Video fetchVideoDetail(String sjID);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
