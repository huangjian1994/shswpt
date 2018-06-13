package com.htcf.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.htcf.dao.ISjzdDAO;
import com.htcf.entity.Sjzd;
import com.htcf.service.ISjzdService;


@Service(value="sjzdService")
public class SjzdServiceImpl implements ISjzdService {
	@Autowired
	private ISjzdDAO sjzdDAO;

	/**
	 * 根据fid查询字典列表
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public List<Sjzd> getSjzdListByFid(String fid) {
		// TODO Auto-generated method stub
		return this.sjzdDAO.getSjzdListByFid(fid);
	}
	
	
	/**
	 * 根据id查询字典
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public Sjzd getSjzdListById(String id){
		return this.sjzdDAO.getSjzdListById(id);
	}
	
	/**
	 * 根据fid查询字典列表，并按照content降序排列
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public List<Sjzd> getSjzdListByFidAsc(String fid){
		return this.sjzdDAO.getSjzdListByFidAsc(fid);
	}
	
	/**
	 * 根据layer查询字典列表
	 * @param layer	字典级别
	 * @return 
	 */
	public List<Sjzd> getSjzdListByLayer(String layer){
		return this.sjzdDAO.getSjzdListByLayer(layer);
	}
	

	/**
	 * 保存数据字典实体
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public boolean saveSjzd(Sjzd sjzd){
		return this.sjzdDAO.saveSjzd(sjzd);
	}

	/**
	 * 修改数据字典实体
	 * 
	 * @param sjzd
	 * 
	 * @return 
	 */
	public boolean updateSjzd(Sjzd sjzd){
		return this.sjzdDAO.updateSjzd(sjzd);
	}
	
	
	/**
	 * 删除数据字典实体
	 * 
	 * @param sjzd
	 * 
	 * @return 
	 */
	public boolean deleteSjzd(Sjzd sjzd){
		return this.sjzdDAO.deleteSjzd(sjzd);
	}
	
	/**
	 * 根据内容来查询数据字典列表
	 * 
	 * @param content
	 * 
	 * @return 
	 */
	public List<Sjzd> getListByContent(String content){
		return this.sjzdDAO.getListByContent(content);
	}
}
