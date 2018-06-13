package com.htcf.dao;

import java.util.List;

import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.RoleMenu;

public interface IRoleMenuDAO {
	
	
	/**
	 * 添加角色菜单关联
	 * 
	 * @param roleMenu 关联对象
	 * 
	 */
	void addRoleMenu (RoleMenu roleMenu);
	
	
	/**
	 * 根据菜单查询所有的关联对象
	 * @param menu  菜单对象
	 * @return 关联集合
	 */
	List<RoleMenu> retrieveRoleMenusByMenu(Menu menu);

	
	
	/**
	 * 删除关联对象
	 * @param roleMenu 关联对象
	 */
	void deleteRoleMenu(RoleMenu roleMenu);


	
	/**
	 * 根据角色查询角色菜单
	 * @param role 角色
	 * @return
	 */
	List<RoleMenu> retrieveRoleMenusByRole(Role role);

	
}
