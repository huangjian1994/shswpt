package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.SsuDao;
import com.htcf.service.SsuService;
import com.htcf.util.Operate;


@Service(value = "SsuService")
public class SsuServiceImpl implements SsuService {
	
	@Autowired
	private SsuDao ssuDao;
	
	
	
	
	
//	@Operate(description="查询无人机列表展示" )
	public List<?> fetchUav(){
		return ssuDao.fetchUav();
	}




//	@Operate(description="查询自建设备列表展示")
	public List<?> fetchSelf() {
		return ssuDao.fetchSelf();
	}


//	@Operate(description="查询共享设备列表展示")
	public List<?> fetchShare() {
		return ssuDao.fetShare();
	}



//	@Operate(description="查询父节点")
	public List<Object[]> fetF() {
		return ssuDao.fetF();
	}



//	@Operate(description="树形列表查询自建视频设备用户")
	public List<Object[]> fetchSelfList() {
		return ssuDao.fetSelfList();
	}



	//@Operate(description="树形列表查询共享视频设备用户")
	public List<Object[]> fetchSareList() {
		return ssuDao.fetShareList();
	}
	
//	@Operate(description="树形列表查询共享视频设备")
	public List<Object[]> fetShareobj(String dwdm){
		return ssuDao.fetShareobj(dwdm);
	}
	
	//@Operate(description="树形列表查询自建视频设备")
	public List<Object[]> fetSelfobj(String dwdm){
		return ssuDao.fetSelfobj(dwdm);
	}

	
	public String fetchzjgs(String Dwdm) {
		return ssuDao.fetchzjgs(Dwdm);
	}
	public String fetchgxgs(String Dwdm) {
		return ssuDao.fetchgxgs(Dwdm);
	}
	
	//@Operate(description="查询分享设备树展示")
	public List<?> fetchFxTree() {
		return ssuDao.fetchFxTree();
	}
	
	//(description="查询自建和共享设备中查询属于重大工程的设备")
	public List<?> fetZdgc(){
		return ssuDao.fetchZdgc();
	}
	
	//@Operate(description="查询自建和共享设备中查询属于防汛重点的设备")
	public List<?> fetFxzd(){
		return ssuDao.fetchFxzd();
	}
	
	//@Operate(description="查询自建和共享设备中查询属于一线海塘的设备")
	public List<?> fetYxht(){
		return ssuDao.fetchYxht();
	}
	
	//@Operate(description="按分区查询相关设备")
	public List<?> fetFqsp(){
		return ssuDao.fetchFqsp();
	}
}
