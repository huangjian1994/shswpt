package com.htcf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.service.IMenuService;
import com.htcf.service.IRoleService;


@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction {
	
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IMenuService menuService;
	
	private String ids;
	private String rolename;
	
	
	private Role role=new Role();
	
	
	private List<Role> roleList=new ArrayList<Role>();
	
	private List<Menu> menuList=new ArrayList<Menu>();
	
	private List<Menu> roleMenuList=new ArrayList<Menu>();
	
	
	public String add(){
		
		roleService.addRoleAuth(role,ids);
		
		return "toRoleList";
		
	}

	
	public String list(){
		
		HttpServletRequest request= this.getHttpServletRequest();
		pageBean=this.processPageBean(request);
		
		roleList=roleService.retrieveRolesByName(role,pageBean);
		
		
		return "roleList";
		
	}
	
	public String nextStep(){
		
		menuList=menuService.retrieveAllMenus();
		
		return "setAuth";
		
		
	}
	
	
	public String checkRole(){
		System.out.println("角色名="+role.getRoleName());
//		String name ="";
//		try {
		//无效
//			name = java.net.URLDecoder.decode(ServletActionContext.getRequest().getParameter(role.getRoleName()),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 System.out.println("角色名="+name);
		 role=roleService.fetchRole(role);
		 String result="";

		 
	 	HttpServletResponse response=this.getHttpServletResponse();
	 
		response.setContentType("text/plain;charset=utf-8");
		
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result=(role ==null)?"1":"0";
		System.out.println("result="+result);
		out.print(result);
		out.flush();
		return null;
	}
	
	
	
	public String edit(){
		
		if(method !=null && method.equals("init")){

			role=roleService.fetchRoleById(role);
			
		    roleMenuList=menuService.retrieveMenusByRole(role);
			
			menuList=menuService.retrieveAllMenus();

			return "roleEdit";
			
		}else{	
			
			roleService.editRoleAuth(role,ids);
			
		}
		
		return "toRoleList";
		
	}

	
	public String delete(){
		
		roleService.deleteRole(role);
	
		return "toRoleList";
	}
	

	public IRoleService getRoleService() {
		return roleService;
	}



	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public List<Role> getRoleList() {
		return roleList;
	}



	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}



	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<Menu> getRoleMenuList() {
		return roleMenuList;
	}

	public void setRoleMenuList(List<Menu> roleMenuList) {
		this.roleMenuList = roleMenuList;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	

}
