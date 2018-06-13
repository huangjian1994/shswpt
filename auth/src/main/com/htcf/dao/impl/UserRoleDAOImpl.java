package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.htcf.dao.IUserRoleDAO;
import com.htcf.entity.Role;
import com.htcf.entity.UserRole;

@Repository(value="userRoleDAO")
public class UserRoleDAOImpl extends BaseDAOImpl<UserRole,Serializable> implements IUserRoleDAO  {

	public void addUserRole(UserRole ur) {
		save(ur);
	}
	public void deleteUserRole(UserRole userRole) {
		delete(userRole);
		
	}
	
	public List<UserRole> retrieveUserRolesByRole(Role role) {
		String jpql="select ur from UserRole ur where ur.role.id=:roleId ";
		Map<String,Object> args=new HashMap<String,Object>();
		args.put("roleId", role.getId());
		return findByJPQL(jpql, args);
		
	}
	
	

}
