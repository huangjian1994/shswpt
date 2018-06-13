package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Repository;

import com.htcf.dao.IMenuDAO;
import com.htcf.dao.ISjzdDAO;
import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.Sjzd;
import com.htcf.entity.User;
import com.htcf.util.PageBean;
import com.htcf.util.StringUtil;



@Repository(value="sjzdDAO")
public class SjzdDAOImpl extends BaseDAOImpl<Object,Serializable> implements ISjzdDAO {
	/**
	 * 根据fid查询字典列表
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public List<Sjzd> getSjzdListByFid(String fid) {
		// TODO Auto-generated method stub
		String sql = "from  Sjzd where fid = '"+Long.valueOf(fid)+"'";
		return this.findPageByJPQL(sql, null);
	}
	
	/**
	 * 根据fid查询字典列表，并按照content降序排列
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public List<Sjzd> getSjzdListByFidAsc(String fid) {
		// TODO Auto-generated method stub
		String sql = "from  Sjzd where fid = '"+Long.valueOf(fid)+"' order by content asc";
		return this.findPageByJPQL(sql, null);
	}
	
	/**
	 * 根据id查询字典
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public Sjzd getSjzdListById(String id){
		String sql = "from  Sjzd where id = '"+Long.valueOf(id)+"'";
		List<Sjzd> list = (List<Sjzd>)this.findByJPQL(sql, null);
		Sjzd sjzd = null;
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 根据layer查询字典列表
	 * @param layer	字典级别
	 * @return 
	 */
	public List<Sjzd> getSjzdListByLayer(String layer){
		String sql = "from  Sjzd where layer = '"+layer+"'";
		System.out.println("sql语句:"+sql);
		List<Sjzd> list = (List<Sjzd>)this.findByJPQL(sql, null);
		return list;
	}
	
	/**
	 * 保存数据字典实体
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public boolean saveSjzd(Sjzd sjzd){
		try{
			this.save(sjzd);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 修改数据字典实体
	 * 
	 * @param fid
	 * 
	 * @return 
	 */
	public boolean updateSjzd(Sjzd sjzd){
		try{
			this.update(sjzd);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	} 
	
	/**
	 * 删除数据字典实体
	 * 
	 * @param sjzd
	 * 
	 * @return 
	 */
	public boolean deleteSjzd(Sjzd sjzd){
		try{
			this.delete(sjzd);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 根据内容来查询数据字典列表
	 * 
	 * @param content
	 * 
	 * @return 
	 */
	public List<Sjzd> getListByContent(String content){
		Map<String,Object> args=new HashMap<String,Object>();
		String jpql = "from Sjzd s where s.content like :content";
		args.put("content","%"+content+"%");
		return this.findPageByJPQL(jpql,args,null);
	}

}
