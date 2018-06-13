package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.IOperateLogDAO;
import com.htcf.entity.OperateLog;
import com.htcf.entity.User;
import com.htcf.service.IOperateLogService;
import com.htcf.util.PageBean;

@Service(value="operateLogService")
public class OperateLogServiceImpl implements IOperateLogService {

	@Autowired
	private IOperateLogDAO operateLogDAO;
	
	public void add(OperateLog operateLog) {
		
		operateLogDAO.addOperateLog(operateLog);
	}
	
	
	public List<Object> retrieveLogs(User user, OperateLog opLog,PageBean pageBean) {
		// TODO Auto-generated method stub
		return operateLogDAO.retrieveLogs(user,opLog,pageBean);
	}
	
	//根据主键查出条件值
	public List<?> fetchOperateLog(OperateLog operateLog){
		return operateLogDAO.fetchOperateLog(operateLog);
	}
	
	public IOperateLogDAO getOperateLogDAO() {
		return operateLogDAO;
	}
	public void setOperateLogDAO(IOperateLogDAO operateLogDAO) {
		this.operateLogDAO = operateLogDAO;
	}


	

}
