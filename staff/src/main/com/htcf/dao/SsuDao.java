package com.htcf.dao;

import java.util.List;

public interface SsuDao {
	
	/**
	 * 
	* @Description：返回无人机
	*@author:hj
	*@2017-4-7下午02:38:58
	*@param 
	*@return
	 */
	public List<?> fetchUav();
	
	
	/**
	 * 
	* @Description：查询自建设备列表,返回列表
	*@author:hj
	*@2017-4-11上午10:33:38
	*@param 
	*@return
	 */
	public List<?> fetchSelf();
	
	/**
	 * 
	* @Description：查询共性设备，返回列表
	*@author:hj
	*@2017-4-11上午10:57:31
	*@param 
	*@return
	 */
	public List<?> fetShare();
	
	/**
	 * 
	* @Description：查询父节点
	*@author:hj
	*@2017-4-12下午03:51:18
	*@param 
	*@return
	 */
	public List<Object[]> fetF();
	
	/**
	 * 
	* @Description：树形列表查询自建视频设备单位
	*@author:hj
	*@2017-4-13下午03:49:15
	*@param 
	*@return
	 */
	public List<Object[]> fetSelfList();
	
	
	/**
	 * 
	* @Description：树形列表查询共享视频设备单位
	*@author:hj
	*@2017-4-17上午10:44:50
	*@param 
	*@return
	 */
	public List<Object[]> fetShareList();

	/**
	 * 
	* @Description：树形列表查询共享视频设备
	*@author:hj
	*@2017-4-17上午11:05:05
	*@param 
	*@return
	 */
	public List<Object[]> fetShareobj(String dwdm);
	
	/**
	 * 
	* @Description：树形列表查询自建视频设备
	*@author:hj
	*@2017-4-17上午11:05:05
	*@param 
	*@return
	 */
	public List<Object[]> fetSelfobj(String dwdm);
	
	/**
	 * @Description：根据单位代码查出个数（自建）
	 *@author:
	 *@Time2017-4-23下午06:56:27 
	 *@return
	 */
	public String fetchzjgs(String Dwdm);
	
	/**
	 * @Description：根据单位代码查出个数（共享）
	 *@author:
	 *@Time2017-4-23下午06:56:27 
	 *@return
	 */
	public String fetchgxgs(String Dwdm);
	
	/**
	 * @Description：分享设备视频树
	 *@author:
	 *@Time2017-5-11上午10:01:58 
	 *@return
	 */
	public List<?> fetchFxTree();
	
	/**
	 *
	* @Description： 自建和共享设备中查询属于重大工程的设备
	*@author:hj
	*@2017-5-12下午02:46:21
	*@param 
	*@return
	 */
	public List<?> fetchZdgc();
	
	/**
	 *
	* @Description： 自建和共享设备中查询属于防汛重点的设备
	*@author:hj
	*@2017-5-12下午02:46:21
	*@param 
	*@return
	 */
	public List<?> fetchFxzd();
	
	/**
	 *
	* @Description： 自建和共享设备中查询属于一线海塘的设备
	*@author:hj
	*@2017-5-12下午02:46:21
	*@param 
	*@return
	 */
	public List<?> fetchYxht();
	
	/**
	 *
	* @Description： 分区查看视频
	*@author:hj
	*@2018-3-28下午12:46:21
	*@param 
	*@return
	 */
	public List<?> fetchFqsp();
	
	/**
	 *
	* @Description： 自建和共享设备中查询属于中国对外博览会的设备
	*@author:hj
	*@2018-6-14下午02:46:21
	*@param 
	*@return
	 */
	public List<?> fetchZwbl();

	/**
	 * @Description：共享设备查询 质检站设备
	 *@author:
	 *@Time2017-5-10下午01:58:47
	 *@return
	 */
	List<?> fetchZjz();
}
