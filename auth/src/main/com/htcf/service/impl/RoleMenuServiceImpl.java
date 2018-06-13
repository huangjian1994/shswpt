package com.htcf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.htcf.dao.IRoleMenuDAO;
import com.htcf.service.IRoleMenuService;

@Service(value="roleMenuService")
public class RoleMenuServiceImpl implements IRoleMenuService {

	
	@Autowired
	private IRoleMenuDAO roleMenuDAO;
	
	
	
	
	
	
	
	public IRoleMenuDAO getRoleMenuDAO() {
		return roleMenuDAO;
	}

	public void setRoleMenuDAO(IRoleMenuDAO roleMenuDAO) {
		this.roleMenuDAO = roleMenuDAO;
	}

}
