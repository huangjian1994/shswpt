package com.htcf.dao;

import java.util.List;

import com.htcf.entity.Role;
import com.htcf.entity.UserRole;

public interface IUserRoleDAO {

	void addUserRole(UserRole ur);

	void deleteUserRole(UserRole userRole);
	
	List<UserRole> retrieveUserRolesByRole(Role role);
}
