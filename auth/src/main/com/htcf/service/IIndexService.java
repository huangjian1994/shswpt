package com.htcf.service;


import java.util.Map;



public interface IIndexService {
	
	/**
	 * 
	 *Description:
	 * @param sldw
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountBySldw(String rylb);
	
	
	/**
	 * 
	 *Description:人员状态
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByRyzt(String rylb);
	
	/**
	 * 
	 *Description:获取基本信息的总人数
	 * @param sldw
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public String getJbxxCount(String rylb);
	
	
	
	/**
	 * 
	 *Description:民族
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByMz(String rylb);
	
	
	/**
	 * 
	 *Description:来沪事由
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByLhsy(String rylb);
	
	/**
	 * 
	 *Description:采集时间
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByCjsj(String rylb);
	
	
	/**
	 * 
	 *Description:年龄
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByAge(String rylb);
	
	
	/**
	 * 
	 *Description:人员类别
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByRylb(String rylb);
	
	
	
	/**
	 * 
	 *Description:根据暂住地类型
	 * @param 
	 * @return
	 * @author:wsg
	 * @2014-4-1下午02:29:15
	 */
	public Map<String,String> getJbxxCountByZzdlx(String rylb);

}
