package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.htcf.dao.ICxzdDAO;
import com.htcf.entity.Cxzd;
import com.htcf.entity.Menu;
import com.htcf.util.PageBean;



@Repository(value="cxzdDAO")
public class CxzdDAOImpl extends BaseDAOImpl<Object,Serializable> implements ICxzdDAO {

	/**
	 * 
	 *Description:获取查询字段列表
	 * @return
	 * @author:wsg
	 * @2014-5-15上午10:46:02
	 */
	public List getCxzdList(PageBean pageBean){
		String sql="SELECT ID,AID,ANAME,ATYPE,MENU,FID FROM SHFK_CXZD";
		return this.findPageBySQL(sql, pageBean);
	}
	
	/**
	 * 
	 *Description:保存查询字段
	 * @return
	 * @author:wsg
	 * @2014-5-15上午10:46:02
	 */
	public boolean saveInfo(Cxzd cxzd){
		try{
			this.save(cxzd);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
