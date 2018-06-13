package com.htcf.dao;

import java.util.List;

import com.htcf.entity.Cxzd;
import com.htcf.util.PageBean;

public interface ICxzdDAO {

	/**
	 * 
	 *Description:获取查询字段列表
	 * @return
	 * @author:wsg
	 * @2014-5-15上午10:46:02
	 */
	public List getCxzdList(PageBean pageBean);
	
	/**
	 * 
	 *Description:保存查询字段
	 * @return
	 * @author:wsg
	 * @2014-5-15上午10:46:02
	 */
	public boolean saveInfo(Cxzd cxzd);
}
