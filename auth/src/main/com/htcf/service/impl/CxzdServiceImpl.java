package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.ICxzdDAO;
import com.htcf.entity.Cxzd;
import com.htcf.service.ICxzdService;
import com.htcf.util.PageBean;

@Service(value="cxzdService")
public class CxzdServiceImpl implements ICxzdService {
	@Autowired
	private ICxzdDAO cxzdDAO;
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
	public List getCxzdList(PageBean pageBean){
		return this.cxzdDAO.getCxzdList(pageBean);
	}

	
	/**
	 * 
	 *Description:保存查询字段
	 * @return
	 * @author:wsg
	 * @2014-5-15上午10:46:02
	 */
	public boolean saveInfo(Cxzd cxzd){
		return this.cxzdDAO.saveInfo(cxzd);
	}
}
