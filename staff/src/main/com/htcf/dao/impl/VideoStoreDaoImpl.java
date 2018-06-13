package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.htcf.dao.VideoStoreDao;
import com.htcf.entity.Video;
import com.htcf.util.PageBean;

@Repository(value="videoStoreDao")
public class VideoStoreDaoImpl extends BaseDAOImpl<Object, Serializable> implements VideoStoreDao{

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
    	this.save(obj);
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
    	String sql=" from Video where 1=1 ";
    	if(video.getVideo_name() != null && !video.getVideo_name().equals("")){
    		sql += " and video_name like '%"+video.getVideo_name().trim()+"%'";
    	}
    	if(video.getVideo_distrit() != null && !video.getVideo_distrit().equals("")){
    		sql += " and video_distrit like '%"+video.getVideo_distrit().trim()+"%'";
    	}
    	if(video.getSsq() != null && !video.getSsq().equals("")){
    		sql += " and ssq = '"+video.getSsq().trim()+"'";
    	}
    	sql += " order by video_date desc";
    	List<?> l = this.findPageByJPQL(sql, pageBean);
		if(l != null && l.size()!=0){
			return l;
		}
		return null;
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
    	String sql=" from Video where id="+zjID+" ";
    	List<?> l = this.findByJPQL(sql, null);
    	Video video = new Video();
    	if(l != null && l.size()!=0){
    		video = (Video) l.get(0);
    	}
    	return video;
    }
}
