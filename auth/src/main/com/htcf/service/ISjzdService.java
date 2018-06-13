package com.htcf.service;


import java.util.List;

import com.htcf.entity.Sjzd;


/**
 *  数据字典接口
 *  
 * @author LIUYL
 *
 */
public interface ISjzdService {
	/**
	 * 根据fid查询字典列表
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	List<Sjzd> getSjzdListByFid(String fid); 

	/**
	 * 根据id查询字典
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public Sjzd getSjzdListById(String id);
	
	/**
	 * 根据fid查询字典列表，并按照content降序排列
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public List<Sjzd> getSjzdListByFidAsc(String fid);


	/**
	 * 根据layer查询字典列表
	 * @param layer	字典级别
	 * @return 
	 */
	public List<Sjzd> getSjzdListByLayer(String layer);


	/**
	 * 保存数据字典实体
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public boolean saveSjzd(Sjzd sjzd); 
	
	/**
	 * 修改数据字典实体
	 * 
	 * @param sjzd
	 * 
	 * @return 
	 */
	public boolean updateSjzd(Sjzd sjzd); 
	
	
	/**
	 * 删除数据字典实体
	 * 
	 * @param sjzd
	 * 
	 * @return 
	 */
	public boolean deleteSjzd(Sjzd sjzd);
	
	/**
	 * 根据内容来查询数据字典列表
	 * 
	 * @param content
	 * 
	 * @return 
	 */
	public List<Sjzd> getListByContent(String content);
}

