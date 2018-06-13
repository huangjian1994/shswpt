package com.htcf.service;

import java.util.List;

import com.htcf.entity.OperateLog;
import com.htcf.entity.User;
import com.htcf.util.PageBean;

public interface IOperateLogService {

	void add(OperateLog op);

	List<Object> retrieveLogs(User user, OperateLog opLog, PageBean pageBean);
	//根据主键查出条件值
	public List<?> fetchOperateLog(OperateLog operateLog);
}
