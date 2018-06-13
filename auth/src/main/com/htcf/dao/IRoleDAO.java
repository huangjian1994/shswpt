package com.htcf.dao;

import java.util.List;

import com.htcf.entity.Role;
import com.htcf.entity.User;
import com.htcf.entity.UserRole;
import com.htcf.util.PageBean;

public interface IRoleDAO {

	
	/**
	 * 根据用户查询所有的角色
	 * @param user 用户
	 * @return 角色集合
	 */
	List<Role> retrieveRolesByUser(User user);

	
	/**
	 * 根据角色名称查询角色列表
	 * @param role 角色
	 * @param pageBean 分页对象
	 * @return 角色集合
	 */
	List<Role> retrieveRolesByName(Role role, PageBean pageBean);
	
	
	/**
	 * 根据编号查询角色列表
	 * @param ids 角色编号
	 * @return 角色集合
	 */
	List<Role>  retrieveRolesByIds(String ids);


	/**
	 * 根据用户查询用户角色
	 * @param user 用户
	 * @return 用户角色列表
	 */
	List<UserRole> retrieveUserRolesByUser(User user);


	/**
	 * 增加角色
	 * @param role
	 */
	void  addRole(Role role);


	
	/**
	 * 修改角色
	 * @param role
	 */
	void update(Role role);


	/**
	 * 根据编号查询角色
	 * @param role 角色参数
	 * @return 角色对象
	 */ 
	Role fetchRoleById(Role role);


	/**
	 * 删除角色
	 * @param role 角色参数
	 */
	void deleteRole(Role role);


	/**
	 * 根据条件查询角色
	 * @param role
	 * @return
	 */
	Role fetchRole(Role role);
	


	List<Role> retrieveRolesByName();

		
		
	
}
