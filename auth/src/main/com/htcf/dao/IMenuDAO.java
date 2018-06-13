package com.htcf.dao;

import java.util.List;

import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.User;
import com.htcf.entity.UserForm;
import com.htcf.util.PageBean;


/**
 *  菜单操作接口
 *  
 * @author LIUYL
 *
 */
public interface IMenuDAO {

	
	/**
	 * 查询用户下所有的菜单
	 * 
	 * @param user 用户
	 * 
	 * @return 菜单列表
	 */
	List<Menu> retrieveMenusByUser(UserForm user);
	
	
	/**
	 * 根据条件查询菜单列表
	 * 
	 * @param menu 菜单
	 * 
	 * @param pageBean 分页对象
	 * @return
	 */
	List<Menu> retrieveMenusByConditions(Menu menu,PageBean pageBean);

	
	/**
	 * 添加菜单
	 * @param menu 菜单对象
	 * 
	 */
	void addMenu(Menu menu);

	
	/**
	 * 修改菜单
	 * @param menu 菜单对象
	 * 
	 */
	void editMenu(Menu menu);
	
	
	/**
	 * 删除菜单
	 * @param menu 菜单对象
	 * 
	 */
	
	
	void deleteMenu(Menu menu);

	/**
	 * 根据编号查询菜单
	 * 
	 * @param menu 菜单对象
	 * @return 菜单
	 */
	Menu fetchMenuById(Menu menu);
	
	
	/**
	 * 根据菜单查询最大的序号
	 * @param menu
	 * @return
	 */
	Long fetchMaxOrderIndex(Menu menu);
	
	
	/**
	 * 修改菜单（后面的菜单前移）
	 * @param menu 菜单
	 */
	void editMenuIndex(Menu menu);


	/**
	 * 查询一级查单
	 * @param menu 
	 * @return
	 */
	List<Menu> retrieveParentMenus(Menu menu);


	/**
	 * 根据编号查询
	 * @param role 
	 * @param ids
	 * @return
	 */
	List<Menu> retrieveMenusByIds(String ids);



	
	/**
	 * 查询所有的菜单
	 * @return 菜单列表
	 */
	List<Menu> retrieveAllMenus();

	
	

	/**
	 * 查询角色下所有的菜单
	 * 
	 * @param role 角色
	 * 
	 * @return 菜单列表
	 */
	List<Menu> retrieveMenusByRole(Role role);


	/**
	 * 根据条件加载菜单
	 * @param menu
	 * @return
	 */
	public Menu fetchMenu(Menu menu);


	
	/**
	 * 根据级别查询菜单列表
	 * @param menu
	 * @return
	 */
	List<Menu> retrieveMenusByLevel(Menu menu);

	

	/**
	 * 查询父菜单下的子菜单列表
	 * 
	 * @param menu 父菜单
	 * 
	 * @return 菜单列表
	 */
	List<Menu> retrieveMenusByParentId(Menu menu);




	
}
