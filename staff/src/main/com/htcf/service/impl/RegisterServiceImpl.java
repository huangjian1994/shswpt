package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.RegisterDao;
import com.htcf.entity.EquipmentSelf;
import com.htcf.entity.EquipmentShare;
import com.htcf.entity.Uav;
import com.htcf.service.RegisterService;
import com.htcf.util.Operate;

@Service(value = "RegisterService")
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private RegisterDao registerDao;
	

	@Operate(description = "新增共享摄像头设备信息")
	public boolean saveEquipmentShare(EquipmentShare share) {
		return registerDao.saveEquipmentShare(share);
	}

	@Operate(description="新增自建摄像头设备")
	public boolean saveEquipmentSelf(EquipmentSelf self) {
		return registerDao.saveEquipmentSelf(self);
	}

	@Operate(description="新增无人机设备")
	public boolean saveUav(Uav uav) {
		return registerDao.saveUav(uav);
	}

	@Operate(description="查询自建摄像头设备")
	public List<EquipmentSelf> fetSelf(String Address,String User){
		return registerDao.getSelf(Address, User);
	}

	@Operate(description="查询共享摄像头设备")
	public List<EquipmentShare>  fetShare(String Address,String User){
		return registerDao.getShare(Address, User);
	}
	
	@Operate(description="查询无人机摄像头设备")
	public List<Uav> fetUav(String Address,String User){
		return registerDao.getUavS(Address, User);
	}

	@Operate(description="查询区域代码")
	public String fetchDm(String Address) {
		return registerDao.fetchDm(Address);
	}

	
	
	
	
	
	
	
	
	
	

}
