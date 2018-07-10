package com.htcf.service;

import java.util.List;

import com.htcf.entity.EquipmentSelf;
import com.htcf.entity.EquipmentShare;
import com.htcf.entity.Uav;


public interface RegisterService {
	
	/**
	 * @Description：新增自建摄像头设备信息
	 *@author:hj
	 *@Time2017-3-25下午08:29:10 
	 *@param self 自建摄像头
	 *@return
	 */
	public boolean saveEquipmentSelf(EquipmentSelf self);
	
	
	/**
	 * @Description：新增共享摄像头设备信息
	 *@author:hj
	 *@Time2017-3-23下午04:58:37 
	 *@param share 共享摄像头
	 *@return
	 */
	public boolean saveEquipmentShare(EquipmentShare share);
	
	/**
	 * @Description:新增无人机
	 *@author:hj
	 *@Time2017-3-25下午08:29:56 
	 *@param uav 无人机
	 *@return
	 */
	public boolean saveUav(Uav uav);
	
	/**
	 * @Description：查出自建摄像头
	 *@author:hj
	 *@Time2017-3-30下午03:14:16 
	 *@param Address地址
	 *@param User用户或所属工程
	 *@return
	 */
	public List<EquipmentSelf> fetSelf(String Address, String User);
	
	public List<EquipmentShare> fetShare(String Address, String User);
	
	public List<Uav> fetUav(String Address, String User);
	
	/**
	 * 
	* @Description：查询区域代码
	*@author:hj
	*@2017-4-13上午11:26:36
	*@param 
	*@return
	 */
	public String fetchDm(String Address);
}
