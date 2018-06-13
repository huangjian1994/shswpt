package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.htcf.dao.IRoleMenuDAO;
import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.RoleMenu;

@Repository(value="roleMenuDAO")
public class RoleMenuDAOImpl extends BaseDAOImpl<RoleMenu,Serializable> implements IRoleMenuDAO{

	public void addRoleMenu(RoleMenu roleMenu) {
		
		 save(roleMenu);
		
	}
	
	              
	public List<RoleMenu> retrieveRoleMenusByMenu(Menu menu) {
		String jpql="select rm from RoleMenu rm where rm.menu.id=:menuId ";
		Map<String,Object> args=new HashMap<String,Object>();
		args.put("menuId", menu.getId());
		return findByJPQL(jpql, args);
	}


	public void deleteRoleMenu(RoleMenu roleMenu) {
		delete(roleMenu);
		
	}
	
	


	public List<RoleMenu> retrieveRoleMenusByRole(Role role) {
		
		String jpql="from RoleMenu rm where rm.role.id=:roleId";
		Map<String,Object> args=new HashMap<String,Object>();
		args.put("roleId", role.getId());
		return findByJPQL(jpql, args);
	
	}
	
	

	
}
