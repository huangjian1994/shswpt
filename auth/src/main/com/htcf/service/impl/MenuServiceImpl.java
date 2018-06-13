package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.IMenuDAO;
import com.htcf.dao.IRoleDAO;
import com.htcf.dao.IRoleMenuDAO;
import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.RoleMenu;
import com.htcf.entity.User;
import com.htcf.entity.UserForm;
import com.htcf.service.IMenuService;
import com.htcf.util.Operate;
import com.htcf.util.PageBean;

@Service(value="menuService")
public class MenuServiceImpl implements IMenuService {

	
	@Autowired
	private IMenuDAO menuDAO;
	
	@Autowired
	private IRoleMenuDAO roleMenuDAO;
	
	@Autowired
	private IRoleDAO roleDAO;
	


	public IRoleDAO getRoleDAO() {
		return roleDAO;
	}


	public void setRoleDAO(IRoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}


	@Operate(description="添加菜单")
	public void addMenu(Menu menu,List<Role> roleList) {
		
		RoleMenu rm=null;
		
		Long maxOrderIndex=menuDAO.fetchMaxOrderIndex(menu);
		
		menu.setOrderIndex(maxOrderIndex+1);
			
		menuDAO.addMenu(menu);
		
		for (Role role : roleList) {
			
			rm=new RoleMenu();
			rm.setMenu(menu);
			rm.setRole(role);
			
			roleMenuDAO.addRoleMenu(rm);
		}
		
	}
	

	@Operate(description="修改菜单")
	public void eidtMenu(Menu menu) {
		menuDAO.editMenu(menu);
		
	}

	
	public Menu fetchMenuById(Menu menu) {
		return menuDAO.fetchMenuById(menu);
	}

	public List<Menu> retrieveParentMenus(Menu menu) {
		return menuDAO. retrieveParentMenus(menu);
		
	}

	

	public List<Menu> retrieveMenusByUser(UserForm user) {
		return menuDAO.retrieveMenusByUser(user);
	}

	
	public List<Menu> retrieveMenusByRole(Role role) {
		
		return menuDAO.retrieveMenusByRole(role);
	}
	

	public List<Menu> retrieveAllMenus() {
		return menuDAO.retrieveAllMenus();
	}
	
	
	public List<Menu> retrieveMenusByConditions(Menu menu,PageBean pageBean) {
		return menuDAO.retrieveMenusByConditions(menu,pageBean);
		
	}
	
	@Operate(description="删除菜单")
	public void deleteMenu(Menu menu) {
		
		List<RoleMenu> roleMenuList=roleMenuDAO.retrieveRoleMenusByMenu(menu);
		
		for (RoleMenu roleMenu : roleMenuList) {
			
			roleMenuDAO.deleteRoleMenu(roleMenu);
		}
		//先加载从游离态转成持久态
		menu=menuDAO.fetchMenuById(menu);
		
		menuDAO.editMenuIndex(menu);
		menuDAO.deleteMenu(menu);
		
	}

	
	public List<Menu> retrieveMenusByLevel(Menu menu) {
		
		return menuDAO.retrieveMenusByLevel(menu);
	}
	
	
	public IRoleMenuDAO getRoleMenuDAO() {
		return roleMenuDAO;
	}

	public void setRoleMenuDAO(IRoleMenuDAO roleMenuDAO) {
		this.roleMenuDAO = roleMenuDAO;
	}

	
	public IMenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(IMenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}


	public Menu fetchMenu(Menu menu) {
		return menuDAO.fetchMenu(menu);
	}


	public void addMenu(Menu menu) {
			
		//加载管理员角色
		List<Role> roleList=roleDAO.retrieveRolesByName();
		
		RoleMenu rm=null;
		
		Long maxOrderIndex=menuDAO.fetchMaxOrderIndex(menu);
		
		menu.setOrderIndex(maxOrderIndex+1);
			
		menuDAO.addMenu(menu);
		
		for (Role role : roleList) {
			
			rm=new RoleMenu();
			rm.setMenu(menu);
			rm.setRole(role);
			
			roleMenuDAO.addRoleMenu(rm);
		}
		
	}


	/**
	 * 查询父菜单下的子菜单列表
	 * 
	 * @param menu 父菜单
	 * 
	 * @return 菜单列表
	 */
	public List<Menu> retrieveMenusByParentId(Menu menu){
		return this.menuDAO.retrieveMenusByParentId(menu);
	}
	










	

}
