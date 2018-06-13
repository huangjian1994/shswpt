package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.htcf.dao.RegisterDao;
import com.htcf.entity.EquipmentSelf;
import com.htcf.entity.EquipmentShare;
import com.htcf.entity.Uav;


@Repository(value="RegisterDao")
public class RegisterDaoImpl extends BaseDAOImpl<Object, Serializable> implements RegisterDao{

	
	
	/**
	 * @Description：新增共享摄像头设备信息
	 *@author:hj
	 *@Time2017-3-25下午04:44:20 
	 *@param share 共享摄像头设备
	 *@return
	 */
	public boolean saveEquipmentShare(EquipmentShare share) {
		boolean re = true;
		System.out.println(".....进入Share");
		try {
			this.save(share);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *@Description：新增自建摄像头设备
	 *@author: hj
	 *@Time2017-3-25下午04:37:33 
	 *@param self 自建摄像头
	 *@return
	 */
	public boolean saveEquipmentSelf(EquipmentSelf self) {
		boolean re = true;
		System.out.println(".....进入Self");
		try {
			this.save(self);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * @Description：新增无人机
	 *@author:hj
	 *@Time2017-3-25下午08:31:33 
	 *@param uav 无人机
	 *@return
	 */
	public boolean saveUav(Uav uav) {
		boolean re = true;
		System.out.println(".....进入Uav");
		try {
			this.save(uav);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * @Description：查出自建摄像头
	 *@author:hj
	 *@Time2017-3-30下午03:14:16 
	 *@param Address地址
	 *@param User用户或所属工程
	 *@return
	 */
	public List<EquipmentSelf> getSelf(String Address,String User ){
		String sql = "from EquipmentSelf where invideo_approve = '是' ";
		List<EquipmentSelf> l  = this.findByJPQL(sql, null);
		if(l != null && l.size() != 0){
			return l;
		}
		return (new ArrayList());
		
	}
	
	
	public  List<EquipmentShare> getShare(String Address,String User ){
		String sql = " from EquipmentShare where OUTVIDEO_APPROVE = '是' ";
		List<EquipmentShare> l  = this.findByJPQL(sql, null);
		EquipmentShare share  = new EquipmentShare();
		if(l != null && l.size() != 0){
			return l;
		}
		return (new ArrayList());
		
	}
	
	public List<Uav> getUavS(String Address,String User ){
		String sql = " from Uav where UAVVIDEO_APPROVE = '是' ";
		
		List<Uav> l  = this.findByJPQL(sql, null);
		Uav uav  = new Uav();
		if(l != null && l.size() != 0){
			return l;
		}
		return (new ArrayList());
		
	}

	/**
	 * 
	* @Description：查询位置代码
	*@author:hj
	*@2017-4-13下午02:11:54
	*@param 
	*@return
	 */
	public String fetchDm(String address) {
		String sql="select dm from base_dictionary where value ='"+address+"'";
		List qy = this.findBySQL(sql);
		String dm = qy.get(0).toString();
		return dm;
		
	}

	
	
	
	
	

}
