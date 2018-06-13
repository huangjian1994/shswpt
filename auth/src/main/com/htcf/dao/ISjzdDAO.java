package com.htcf.dao;

import java.util.List;

import com.htcf.entity.Sjzd;


/**
 *  数据字典接口
 *  
 * @author LIUYL
 *
 */
public interface ISjzdDAO {

	/**
	 * 根据fid查询字典列表
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	List<Sjzd> getSjzdListByFid(String fid); 
	
	/**
	 * 根据layer查询字典列表
	 * @param layer	字典级别
	 * @return 
	 */
	List<Sjzd> getSjzdListByLayer(String layer); 
	
	/**
	 * 根据id查询字典
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	Sjzd getSjzdListById(String id); 
	
	/**
	 * 根据fid查询字典列表，并按照content降序排列
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public List<Sjzd> getSjzdListByFidAsc(String fid);


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
