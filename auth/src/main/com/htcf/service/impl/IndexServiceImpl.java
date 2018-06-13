package com.htcf.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.IIndexDAO;
import com.htcf.service.IIndexService;

@Service(value="indexService")
public class IndexServiceImpl implements IIndexService {
	@Autowired
	private IIndexDAO indexDAO;
	
	/**
	 * 
	 *Description:
	 * @param sldw
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountBySldw(String rylb){
		return indexDAO.getJbxxCountBySldw(rylb);
	}
	
	
	/**
	 * 
	 *Description:人员状态
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByRyzt(String rylb){
		return indexDAO.getJbxxCountByRyzt(rylb);
	}
	
	/**
	 * 
	 *Description:获取基本信息的总人数
	 * @param sldw
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public String getJbxxCount(String rylb){
		return indexDAO.getJbxxCount(rylb);
	}
	
	
	
	/**
	 * 
	 *Description:民族
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByMz(String rylb){
		return indexDAO.getJbxxCountByMz(rylb);
	}
	
	
	/**
	 * 
	 *Description:来沪事由
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByLhsy(String rylb){
		return indexDAO.getJbxxCountByLhsy(rylb);
	}
	
	/**
	 * 
	 *Description:采集时间
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByCjsj(String rylb){
		return indexDAO.getJbxxCountByCjsj(rylb);
	}
	
	
	/**
	 * 
	 *Description:年龄
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByAge(String rylb){
		return indexDAO.getJbxxCountByAge(rylb);
	}
	
	
	/**
	 * 
	 *Description:人员类别
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByRylb(String rylb){
		return indexDAO.getJbxxCountByRylb(rylb);
	}
	
	/**
	 * 
	 *Description:根据暂住地类型
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByZzdlx(String rylb){
		return indexDAO.getJbxxCountByZzdlx(rylb);
	}


}
