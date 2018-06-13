package com.htcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.IMenuDAO;
import com.htcf.dao.IRoleDAO;
import com.htcf.dao.IRoleMenuDAO;
import com.htcf.dao.IUserRoleDAO;
import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.RoleMenu;
import com.htcf.entity.User;
import com.htcf.entity.UserRole;
import com.htcf.service.IRoleService;
import com.htcf.util.PageBean;

@Service(value="roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDAO roleDAO;
	
	@Autowired
	private IMenuDAO menuDAO;
	
	@Autowired
	private IRoleMenuDAO menuRoleDAO;
	
	@Autowired
	private IUserRoleDAO ur;
	

	
	public Role fetchRoleById(Role role) {
		return  roleDAO.fetchRoleById(role);
	}
	
	
	public List<Role> retrieveRolesByUser(User user) {
		return roleDAO.retrieveRolesByUser(user);
		
	}

	public List<Role> retrieveRolesByName(Role role, PageBean pageBean) {
		return roleDAO.retrieveRolesByName(role,pageBean);
	}

	public void addRoleAuth(Role role,String ids) {
		
		roleDAO.addRole(role);

		List<Menu> menuList=menuDAO.retrieveMenusByIds(ids);
		
		RoleMenu roleMenu=null;
		
		for (Menu menu : menuList) {
			
			roleMenu=new RoleMenu();
			roleMenu.setMenu(menu);
			roleMenu.setRole(role);
			menuRoleDAO.addRoleMenu(roleMenu);
		}
	
	}

	public void editRoleAuth(Role role,String ids) {
		
		roleDAO.update(role);
		
		List<RoleMenu> roleMenuList=menuRoleDAO.retrieveRoleMenusByRole(role);
		
		if(roleMenuList.size()>0){
			
			for (RoleMenu roleMenu : roleMenuList) {
				
				menuRoleDAO.deleteRoleMenu(roleMenu);
			}
			
		}
		
		List<Menu> menuList=menuDAO.retrieveMenusByIds(ids);
		
		RoleMenu roleMenu=null;
		
		for (Menu menu : menuList) {
			
			roleMenu=new RoleMenu();
			roleMenu.setMenu(menu);
			roleMenu.setRole(role);
			menuRoleDAO.addRoleMenu(roleMenu);
		}
		
	}
	


	public IRoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(IRoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public IMenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(IMenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	public IRoleMenuDAO getMenuRoleDAO() {
		return menuRoleDAO;
	}

	public void setMenuRoleDAO(IRoleMenuDAO menuRoleDAO) {
		this.menuRoleDAO = menuRoleDAO;
	}


	public void deleteRole(Role role) {
		
		List<RoleMenu> roleMenuList=menuRoleDAO.retrieveRoleMenusByRole(role);
		
		for (RoleMenu roleMenu : roleMenuList) {
			menuRoleDAO.deleteRoleMenu(roleMenu);
		}
		 
		List<UserRole> urList=ur.retrieveUserRolesByRole(role);
		
		for (UserRole userRole : urList) {
			ur.deleteUserRole(userRole);
		}
		roleDAO.deleteRole(role);
		
	}


	public IUserRoleDAO getUr() {
		return ur;
	}


	public void setUr(IUserRoleDAO ur) {
		this.ur = ur;
	}


	public List<Role> retrieveAllRoles() {
		return roleDAO.retrieveRolesByIds("");
		
	}


	public Role fetchRole(Role role) {
	
		return roleDAO. fetchRole(role);
	}




}
