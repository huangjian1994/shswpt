package com.htcf.service;

import java.util.List;

public interface SsuService {
	
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
	* @Description：查询自建设备，返回列表
	*@author:hj
	*@2017-4-11上午10:48:41
	*@param 
	*@return
	 */
	public List<?> fetchSelf();

	/**
	 * 
	* @Description：查询共享设备，返回列表
	*@author:hj
	*@2017-4-11上午11:03:59
	*@param 
	*@return
	 */
	public List<?> fetchShare();
	
	/**
	 * 
	* @Description：查询父节点
	*@author:hj
	*@2017-4-12下午03:49:56
	*@param 
	*@return
	 */
	public List<Object[]> fetF();
	
	/**
	 * 
	* @Description：树形列表查询自建视频设备单位
	*@author:hj
	*@2017-4-13下午03:44:52
	*@param 
	*@return
	 */
	public List<Object[]> fetchSelfList();
	
	/**
	 * 
	* @Description：树形列表查询共享视频设备单位
	*@author:hj
	*@2017-4-17上午10:45:50
	*@param 
	*@return
	 */
	public List<Object[]> fetchSareList();
	
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
	 *@author:hj
	 *@Time2017-4-23下午06:53:06 
	 *@param Dwdm
	 *@return
	 */
	public String fetchzjgs(String Dwdm);
	
	/**
	 * @Description：根据单位代码查出个数（共享）
	 *@author:hj
	 *@Time2017-4-23下午06:53:06 
	 *@param Dwdm
	 *@return
	 */
	public String fetchgxgs(String Dwdm);
	
	/**
	 * 
	* @Description：查询分享设备树
	*@author:hj
	*@2017-4-11上午10:48:41
	*@param 
	*@return
	 */
	public List<?> fetchFxTree();
	
	
	/**
	 * 
	* @Description：查询自建和共享设备中查询属于重大工程的设备
	*@author:hj
	*@2017-5-12下午03:03:54
	*@param 
	*@return
	 */
	public List<?> fetZdgc();
	
	/**
	 * 
	* @Description：查询自建和共享设备中查询属于防汛重点的设备
	*@author:hj
	*@2017-5-12下午03:03:54
	*@param 
	*@return
	 */
	public List<?> fetFxzd();
	
	/**
	 * 
	* @Description：查询自建和共享设备中查询属于一线海塘的设备
	*@author:hj
	*@2017-5-12下午03:03:54
	*@param 
	*@return
	 */
	public List<?> fetYxht();
	
	/**
	 * 
	* @Description：查询自建和共享设备中查询属于中国对外博览的设备
	*@author:hj
	*@2017-5-12下午03:03:54
	*@param 
	*@return
	 */
	public List<?> fetZwbl();
	
	/**
	 * 
	* @Description：查询分区设备
	*@author:hj
	*@2018-3-28上午10:03:54
	*@param 
	*@return
	 */
	public List<?> fetFqsp();

	/**
	 * @Description：共享设备查询 质检站设备
	 *@author:
	 *@Time2017-5-10下午01:58:47
	 *@return
	 */
	List<?> fetZjz();
}
