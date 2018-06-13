package com.htcf.service;

import java.util.List;

import com.htcf.entity.Cxzd;
import com.htcf.util.PageBean;

public interface ICxzdService {
	
	/**
	 * 
	 *Description:获取查询字段列表
	 * @param glId
	 * @param glflag
	 * @param gmsfzhm
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
