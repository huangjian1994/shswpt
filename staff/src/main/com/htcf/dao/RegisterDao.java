package com.htcf.dao;

import java.util.List;

import com.htcf.entity.EquipmentSelf;
import com.htcf.entity.EquipmentShare;
import com.htcf.entity.Uav;

public interface RegisterDao {
	
	/**
	 * @Description：新增共享摄像头设备信息
	 *@author:hj
	 *@Time2017-3-24下午05:15:29 
	 *@param share 共享摄像头设备
	 *@return
	 */
	
	public boolean saveEquipmentShare(EquipmentShare share);
	
	/**
	 * @Description：新增自建摄像头设备信息
	 *@author:hj
	 *@Time2017-3-25下午04:29:08 
	 *@param self 自建摄像头
	 *@return
	 */
	public boolean saveEquipmentSelf(EquipmentSelf self); 
	
	/**
	 * @Description：新增无人机
	 *@author:hj
	 *@Time2017-3-25下午08:31:33 
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
	public List<EquipmentSelf> getSelf(String Address,String User );
	
	public List<EquipmentShare> getShare(String Address,String User );
	
	public List<Uav> getUavS(String Address,String User );

	/**
	 * 
	* @Description：查询区域代码
	*@author:hj
	*@2017-4-13上午11:29:51
	*@param 
	*@return
	 */
	public String fetchDm(String address);
}
