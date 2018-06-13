package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Repository;

import com.htcf.dao.IMenuDAO;
import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.User;
import com.htcf.entity.UserForm;
import com.htcf.util.PageBean;
import com.htcf.util.StringUtil;



@Repository(value="menuDAO")
public class MenuDAOImpl extends BaseDAOImpl<Menu,Serializable> implements IMenuDAO {

	/*public List<Menu> retrieveMenusByUser(User user) {
		
		//一级菜单列表
		List<Menu> menuList1=null;
		
		//二级菜单列表
		List<Menu> menuList2=null;
		
		//三级菜单列表
		List<Menu> menuList3=null;
	

		
		StringBuffer jpql=new StringBuffer("select  distinct m  from  Menu m , RoleMenu rm,UserRole ur where m.id=rm.menu.id and rm.role.id=ur.role.id and ur.user.id=:uid and  m.parent.id is null order by m.orderIndex asc ");
		
		Map<String,Object> args =new HashMap<String,Object>();
	
		args.put("uid", user.getId());
		

		menuList1=this.findByJPQL(jpql.toString(), args);
		
		if(menuList1 !=null && !menuList1.isEmpty()){
			
			for (Menu menu1 : menuList1) {
				
				
				jpql=new StringBuffer("select  distinct m  from  Menu m , RoleMenu rm,UserRole ur where m.id=rm.menu.id and rm.role.id=ur.role.id and ur.user.id=:uid and  m.parent.id=:pid  order by m.orderIndex asc ");
				
				args =new HashMap<String,Object>();

				args.put("uid", user.getId());
				args.put("pid", menu1.getId());
				
				menuList2=this.findByJPQL(jpql.toString(),args);
				
				menu1.setSubList(menuList2);
				
				
				if(menuList2 !=null && !menuList2.isEmpty()){
					
					for (Menu menu2 : menuList2) {
						
						jpql=new StringBuffer("select  distinct m  from  Menu m , RoleMenu rm,UserRole ur where m.id=rm.menu.id and rm.role.id=ur.role.id and ur.user.id=:uid and  m.parent.id=:pid  order by m.orderIndex asc ");
						
						args =new HashMap<String,Object>();

						args.put("uid", user.getId());
						args.put("pid", menu2.getId());
						
						menuList3=this.findByJPQL(jpql.toString(),args);
						
						menu2.setSubList(menuList3);
						
					}
					
					
				}
				
				
				
			}
		}
		
		return menuList1;
	}*/
	
	
	public List<Menu> retrieveMenusByUser(UserForm user) {
		
		//一级菜单列表
		List<Menu> menuList1=null;
		
		//二级菜单列表
		List<Menu> menuList2=null;
		
		//三级菜单列表
		List<Menu> menuList3=null;
	

		System.out.println("*************user.getId()="+user.getId());
		StringBuffer jpql=new StringBuffer("select distinct m  from Menu m ,RoleMenu rm ,User u  where rm.menu.id=m.id and rm.role.id=u.role.id and m.parent.id is null and u.id=:uid order by m.orderIndex asc ");
		
		Map<String,Object> args =new HashMap<String,Object>();
		Long uid = Long.valueOf(user.getId());
		args.put("uid", uid);
		

		menuList1=this.findByJPQL(jpql.toString(), args);
		
		if(menuList1 !=null && !menuList1.isEmpty()){
			
			for (Menu menu1 : menuList1) {
				
				
				jpql=new StringBuffer("select distinct m  from Menu m ,RoleMenu rm ,User u  where rm.menu.id=m.id and rm.role.id=u.role.id and m.parent.id=:pid and u.id=:uid order by m.orderIndex asc ");
				
				args =new HashMap<String,Object>();
				
				args.put("uid", uid);
				args.put("pid", menu1.getId());
				
				menuList2=this.findByJPQL(jpql.toString(),args);
				
				menu1.setSubList(menuList2);
				
				
				if(menuList2 !=null && !menuList2.isEmpty()){
					
					for (Menu menu2 : menuList2) {
						
						jpql=new StringBuffer("select  distinct m  from Menu m ,RoleMenu rm ,User u  where rm.menu.id=m.id and rm.role.id=u.role.id and m.parent.id=:pid and u.id=:uid order by m.orderIndex asc ");
						
						args =new HashMap<String,Object>();

						args.put("uid", uid);
						args.put("pid", menu2.getId());
						
						menuList3=this.findByJPQL(jpql.toString(),args);
						
						menu2.setSubList(menuList3);
						
					}
					
					
				}
				
				
				
			}
		}
		
		return menuList1;
	}

	public Menu fetchMenu(Menu menu){
		
		StringBuffer jpql=new StringBuffer("select m from Menu m where 1=1 ");
		
		Map<String,Object> args =new HashMap<String,Object>();
		
		if(menu !=null){
			
			if(menu.getId()!=null){
				
				jpql.append(" and m.id <> :menuId");
				args.put("menuId", menu.getId());
			}
			if(StringUtils.isNotBlank(menu.getMenuName())){
				jpql.append(" and m.menuName=:menuName");
				args.put("menuName", menu.getMenuName());
			}
			else if(StringUtils.isNotBlank(menu.getCode())){
				jpql.append(" and m.code=:code");
				args.put("code", menu.getCode());
			}
			
			List<Menu> menuList=this.findByJPQL(jpql.toString(), args);
			
			if(menuList!=null && !menuList.isEmpty()){
				
				return menuList.get(0);
				
			}
			
			return null;
			
		}
		
		
		return null;
		
		
	}
	
	/*public List<Menu> retrieveAllMenus() {
		
		StringBuffer jpql=new StringBuffer("select menu from Menu menu where menu.parent.id is null order by orderIndex asc ");
		
		Map<String,Object> args =new HashMap<String,Object>();
		
		List<Menu> menuList=this.findByJPQL(jpql.toString(), args);
		
		List<Menu> newMenuList=new ArrayList<Menu>();
		
		List<Menu> subMenuList=null;
		
		for (Menu menu : menuList) {
			
			jpql=new StringBuffer("select menu from Menu menu where menu.parent.id=:pid order by orderIndex asc ");
			
			args =new HashMap<String,Object>();
			
			args.put("pid", menu.getId());
			
			subMenuList=this.findByJPQL(jpql.toString(),args);
			
			menu.setSubList(subMenuList);
			
			newMenuList.add(menu);
		}
		return newMenuList;
	}
	*/
	
	

	public List<Menu> retrieveAllMenus() {
		
		StringBuffer jpql=new StringBuffer("from Menu");
		
		Map<String,Object> args =new HashMap<String,Object>();
		
		this.findByJPQL(jpql.toString(),args);
			
		
		return 	this.findByJPQL(jpql.toString(),args);
	}
	
	

	public List<Menu> retrieveMenusByConditions(Menu menu,PageBean pageBean) {
		
		StringBuffer jpql=new StringBuffer("select menu from Menu menu where menu.isSystem  is null ");
		Map<String,Object> args =new HashMap<String,Object>();
		if(menu != null){
			if(StringUtil.isNotBlank(menu.getMenuName())){
				jpql.append(" and  menu.menuName like :menuName");
				args.put("menuName", "%"+menu.getMenuName()+"%");	
			}
			if(menu.getMenuLevel()!=null){
				
				jpql.append(" and  menu.MenuLevel=:level");
				args.put("level", menu.getMenuLevel());	
			}
			//jpql.append("order by menu.orderIndex asc");
			
		}
		
		List<Menu> menuList=this.findPageByJPQL(jpql.toString(), args, pageBean);
		
		return menuList;
	}
	
	
	public void editMenuIndex(Menu menu){
		
		
		Long maxOrderIndex=fetchMaxOrderIndex(menu);
		
		StringBuffer jpql=new StringBuffer("");
	
		Map<String,Object> args=new HashMap<String,Object>();
		
		if(menu.getParent() !=null && menu.getParent().getId() != null &&menu.getParent().getId() !=0){
			
			jpql=new StringBuffer("update Menu m  set m.orderIndex=m.orderIndex-1 where m.orderIndex>:orderIndex  and m.orderIndex<=:maxOrdIndex  and m.parent.id=:parentId");
			args.put("orderIndex", menu.getOrderIndex());
			
			args.put("maxOrdIndex",maxOrderIndex );
			args.put("parentId", menu.getParent().getId());

		}else{
			
			jpql=new StringBuffer("update Menu m  set m.orderIndex=m.orderIndex-1 where m.orderIndex>:orderIndex  and m.orderIndex<=:maxOrdIndex  and m.parent.id is null");
			args.put("orderIndex", menu.getOrderIndex());
			args.put("maxOrdIndex",maxOrderIndex );
			
			
		}
		
		updateByJPQL(jpql.toString(), args);
		
		
	}
	
	
	public Long fetchMaxOrderIndex(Menu menu){
		
		StringBuffer jpql=new StringBuffer("select max(m.orderIndex) from Menu m ");
		
		Long result=new Long(1);
		
		Map<String,Object> args=new HashMap<String,Object>();
		
		if(menu.getParent() !=null && menu.getParent().getId()!=null && menu.getParent().getId() != 0){
			
			jpql.append("where  m.parent.id=:parentId");
			
			
			args.put("parentId", menu.getParent().getId());

		}else{
			
			jpql.append(" where m.parent.id is null and m.orderIndex<100");
			
			
		}
		
		
		List list=findByJPQL(jpql.toString(), args);
		
		
		if(list!=null && list.size()>0 && list.get(0)!=null && list.get(0)!=""){
			
			result=Long.parseLong(list.get(0).toString());
			
		}
		
		return result;
	}


	public void addMenu(Menu menu) {
		
		if(menu.getParent()==null ||menu.getParent().getId() ==null ||menu.getParent().getId()==0){
			
			menu.setParent(null);
		}
		save(menu);
		
	}
	
	public void  deleteMenu(Menu menu){
		delete(menu);
		
	}


	public void editMenu(Menu menu) {
		if(menu.getParent()==null ||menu.getParent().getId() ==null ||menu.getParent().getId()==0){
			
			menu.setParent(null);
		}
		update(menu);
		
	}


	public Menu fetchMenuById(Menu menu) {
		return getById(menu.getId());
		
	}


	public List<Menu> retrieveParentMenus(Menu menu) {
		
		String jpql="from Menu menu where menu.parent is null and menu.MenuLevel=1 order by orderIndex desc";
		List<Menu> menuList=this.findByJPQL(jpql, null);
		return menuList;
	}


	public List<Menu> retrieveMenusByIds(String ids) {
		
		String jpql="from Menu menu where menu.id in("+ids+")order by orderIndex desc";
		
		List<Menu> menuList=this.findByJPQL(jpql, null);
		return menuList;
	}


	public List<Menu> retrieveMenusByRole(Role role) {
			
		StringBuffer jpql=new StringBuffer("select rm.menu from RoleMenu rm where rm.role.id=:roleId");
		
			
		Map<String,Object> args =new HashMap<String,Object>();
			
		args.put("roleId", role.getId());
		
		
		List<Menu> menuList=this.findByJPQL(jpql.toString(), args);
		
		return menuList;
	}

	public List<Menu> retrieveMenusByLevel(Menu menu) {
	
		StringBuffer jpql=new StringBuffer("from Menu m where m.MenuLevel=:level order by orderindex asc");
		
		
		Map<String,Object> args =new HashMap<String,Object>();
			
		args.put("level", menu.getMenuLevel());
		
		
		List<Menu> menuList=this.findByJPQL(jpql.toString(), args);
		
		return menuList;

	}


	/**
	 * 查询父菜单下的子菜单列表
	 * 
	 * @param menu 父菜单
	 * 
	 * @return 菜单列表
	 */
	public List<Menu> retrieveMenusByParentId(Menu menu){
		
		StringBuffer jpql=new StringBuffer("from Menu m where m.parent.id=:id order by orderindex asc");
		
		Map<String,Object> args =new HashMap<String,Object>();
			
		args.put("id", menu.getId());
		
		
		List<Menu> menuList=this.findByJPQL(jpql.toString(), args);
		
		return menuList;
	}

	





	
}
