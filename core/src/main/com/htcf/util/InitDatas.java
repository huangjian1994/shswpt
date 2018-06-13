package com.htcf.util;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htcf.entity.Menu;
import com.htcf.entity.Role;
import com.htcf.entity.RoleMenu;
import com.htcf.entity.User;
import com.htcf.entity.UserRole;



public class InitDatas {
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/beans.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		
		Session session = sessionFactory.openSession();
		
		//初始化用户和角色
		//initUsersAndRoles(session);
		
		//初始化菜单和功能
		//initMenusAndFunctions(session);
		
		//初始化角色菜单关系
		initMenuAndRoles(session);
		
		
	
		session.close();
		sessionFactory.close();
		context = null;
		
	}

	
	
	
	@Test
	public static void initUsersAndRoles(Session session){

		session.getTransaction().begin();
		//初始化用户
		User user=new User();
		user.setName("系统管理员");
		user.setUserName("system");
		user.setPassword("system");
		user.setDescription("系统内置用户");
		user.setIsSystem("1");
		session.save(user);
		
		
		//初始化角色
		Role role=new Role();
		role.setRoleName("系统管理员");
		role.setIsSystem("1");
		role.setDescription("系统内置角色");
		session.save(role);
		
		
		//建立用户和角色的关联
		UserRole ur=new UserRole();
		ur.setUser(user);
		ur.setRole(role);
		session.persist(ur);
		
		session.getTransaction().commit();
		
		
	}
	
	
	
	

	public static void initMenusAndFunctions(Session session){
		
		session.getTransaction().begin();
		Menu menu=new Menu();
		menu.setCode("systemSet");
		menu.setMenuName("系统管理");
		menu.setMenuLevel(new Long(1));
		menu.setOrderIndex(new Long(100));
		menu.setResourceURL("");
		menu.setDescription("系统管理菜单");
		menu.setIsSystem("1");
		session.save(menu);
		
		Menu menu1=new Menu();
		menu1.setCode("menu");
		menu1.setMenuName("菜单管理");
		menu1.setMenuLevel(new Long(2));
		menu1.setOrderIndex(new Long(1));
		menu1.setResourceURL("/menu/menu_list.do");
		menu1.setDescription("菜单管理菜单");
		menu1.setIsSystem("1");
		menu1.setParent(menu);
		session.save(menu1);
		
		session.getTransaction().commit();
		
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static void initMenuAndRoles(Session session){
		
		session.getTransaction().begin();
		
		RoleMenu rm=null;
		List<Menu> menuList=session.createQuery("from Menu").list();
		List<Role> roleList=session.createQuery("from Role r where r.roleName ='系统内置角色' or r.roleName ='管理员'").list();
		
		if(roleList !=null && !roleList.isEmpty()){
			
			for(Role role:roleList){
				
				if(menuList !=null && !menuList.isEmpty()){
					
					for (Menu menu : menuList) {
						
						rm=new RoleMenu();
						rm.setMenu(menu);
						rm.setRole(role);
						session.save(rm);
						
					}
					
				}
			}
			
		}
		
		
		
		
		session.getTransaction().commit();
	
	}


	
	
}
