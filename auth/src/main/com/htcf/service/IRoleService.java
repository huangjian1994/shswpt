package com.htcf.service;

import java.util.List;

import com.htcf.entity.Role;
import com.htcf.entity.User;
import com.htcf.util.PageBean;

public interface IRoleService {
	
	List<Role> retrieveAllRoles();
	
	 List<Role> retrieveRolesByUser(User user);

	 List<Role> retrieveRolesByName(Role role, PageBean pageBean);

	void addRoleAuth(Role role, String ids);

	void editRoleAuth(Role role,String ids);

	Role fetchRoleById(Role role);

	void deleteRole(Role role);

	Role fetchRole(Role role);
	
	
}
