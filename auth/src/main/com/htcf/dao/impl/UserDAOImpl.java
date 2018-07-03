package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.htcf.dao.IUserDAO;
import org.springframework.stereotype.Repository;

import com.htcf.entity.User;
import com.htcf.entity.UserForm;
import com.htcf.util.PageBean;
import com.htcf.util.StringUtil;

@Repository(value="userDAO")
public class UserDAOImpl extends BaseDAOImpl<User,Serializable> implements IUserDAO {

	public void addUser(User user) {
		save(user);
	}

	public void deleteUser(User user) {
		
		user=getById(user.getId());
		this.delete(user);
		
	}

	public void editUser(User user) {
		update(user);
		
	}
	

	public User fetchUsersByName(User user) {
//		String jpql="from User u where  u.userName=:userName ";
//		Map<String ,Object> params=new HashMap<String ,Object>();
//		params.put("userName", user.getUserName());
//		List<User> userList =this.findByJPQL(jpql, params);
//		if(userList != null && userList.size()!=0){
//			
//			return userList.get(0);
//		}
//		return null;

		String jpql="select u.username,u.password,u.name,u.position,u.userclassno,u.id,r.rolename  " +
				"from base_user u,base_role r where u.role_id = r.id and u.username='"
			+user.getUserName()+"'";
		List<Object[]> objectList =this.findBySQL(jpql);
		List<User> userList =UchangeO(objectList);
		if(userList != null && userList.size()!=0){
			return userList.get(0);
		}
		return null;
	}
	
	
	public UserForm fetchUserByName(User user) {
		String jpql = "select u.username,u.password,u.name,u.gender,u.user_id,u.policeno," +
				"u.edubackground,u.department,u.department_id,u.id,u.userclassno,c.classname,u.role_id,r.rolename " +
				"from BASE_USER u left join base_class c on c.classno=u.userclassno " +
				" left join BASE_ROLE r on u.role_id=r.id " +
				" where 1=1 and  ( u.username='"+user.getUserName()+"' or u.user_id='"+user.getUserId()+"' )";
//		if(user.getUserName() != null && !user.getUserName().equals("")){
//			
//			System.out.println("用户名登录="+user.getUserName());
//			jpql += " and u.username='"+user.getUserName()+"'";
//		}
//		if(user.getUserId() != null && !user.getUserId().equals("")){
//			System.out.println("身份证号登录="+user.getUserId());
//			jpql += " and u.user_id='"+user.getUserId()+"'";
//		}
		
		List<Object[]> objectList =this.findBySQL(jpql);
		UserForm u = null;
		if(objectList != null && objectList.size() != 0){
			u=new UserForm();
			//for(int i=0;i<objectList.size();i++){
				try{
				u.setUserName(objectList.get(0)[0].toString());
				}catch(Exception e){
					u.setUserName("");
				}
				try{
				u.setPassword(objectList.get(0)[1].toString());
				}catch(Exception e){
					u.setPassword("");
				}
				try{
				u.setName(objectList.get(0)[2].toString());
				}catch(Exception e){
					u.setName("");
				}
				try{
				u.setGender(objectList.get(0)[3].toString());
				}catch(Exception e){
					u.setGender("");
				}
				try{
				u.setUserId(objectList.get(0)[4].toString());
				}catch(Exception e){
					u.setUserId("");
				}
				try{
				u.setPoliceNo(objectList.get(0)[5].toString());
				}catch(Exception e){
					u.setPoliceNo("");
				}
				try{
				u.setEdubackground(objectList.get(0)[6].toString());
				}catch(Exception e){
					u.setEdubackground("");
				}
				try{
				u.setDepartment(objectList.get(0)[7].toString());
				}catch(Exception e){
					u.setDepartment("");
				}
				try{
				u.setDepartmentId(objectList.get(0)[8].toString());
				}catch(Exception e){
					u.setDepartmentId("");
				}
				try{
				u.setId(objectList.get(0)[9].toString());
				}catch(Exception e){
					u.setId("");
				}
				try{
				u.setUserclassno(objectList.get(0)[10].toString());
				}catch(Exception e){
					u.setUserclassno("");
				}
				try{
				u.setUserclassname(objectList.get(0)[11].toString());
				}catch(Exception e){
					u.setUserclassname("");
				}
				try{
				u.setRoleId(objectList.get(0)[12].toString());
				}catch(Exception e){
					u.setRoleId("");
				}
				try{
				u.setRolename(objectList.get(0)[13].toString());
				}catch(Exception e){
					u.setRolename("");
				}
			//}
		}
		
		return u;
	}
	
	public List<User> UchangeO(List<Object[]> objectList){
		List<User> userList =new ArrayList<User>();
		for(int i=0;i<objectList.size();i++){
			User u=new User();
			u.setUserName(objectList.get(i)[0].toString());
			u.setPassword(objectList.get(i)[1].toString());
			u.setName(objectList.get(i)[2].toString());
			if(!"".equals(objectList.get(i)[6])&&
					objectList.get(i)[6]!=null){
				u.setPosition(objectList.get(i)[6].toString());
			}
			if(!"".equals(objectList.get(i)[4])&&
					objectList.get(i)[4]!=null){
				u.setUserclassno(objectList.get(i)[4].toString());
			}
			userList.add(i, u);
		}
		return userList;
	}
	
	
public List<Object[]> retrieveUsersByConditions(User user,PageBean pageBean){
		
//		StringBuffer sql=new StringBuffer("select u.id,u.name,u.address,u.email," +
//				"u.mphone,u.password,u.username,u.department,u.department_id,u.organization," +
//				"u.organization_id,u.policeno,u.user_id,u.description,u.issystem,u.isenabled," +
//				"u.role_id,u.edubackground,u.gender,u.position,u.professionalarea,u.specialty," +
//				"u.userclassno,r.rolename,c.classname " +
//				"from BASE_USER u , BASE_ROLE r ,base_class c  " +
//				"where u.isSystem is null  and u.role_id=r.id  and  c.classno=u.userclassno");
		
		StringBuffer sql=new StringBuffer("select u.id,u.name,u.address,u.email," +
				"u.mphone,u.password,u.username,u.department,u.department_id,u.organization," +
				"u.organization_id,u.policeno,u.user_id,u.description,u.issystem,u.isenabled," +
				"u.role_id,u.edubackground,u.gender,u.position,u.professionalarea,u.specialty," +
				"u.userclassno,r.rolename,c.classname from BASE_USER u " +
				" left join base_class c on c.classno=u.userclassno " +
				" left join BASE_ROLE r on u.role_id=r.id " +
				" where u.isSystem is null ");
		Map <String,Object> args=new HashMap<String,Object>();
		if(user !=null){
			
			if(StringUtil.isNotBlank(user.getName())){
				sql.append(" and u.name like :uname");
				args.put("uname", "%"+user.getName()+"%");
			}
			if(StringUtil.isNotBlank(user.getPoliceNo())){
				sql.append(" and u.policeNo like :policeNo");
				args.put("policeNo", "%"+user.getPoliceNo()+"%");
			}
			System.out.println("user.getUserId()="+user.getUserId());
			if(StringUtil.isNotBlank(user.getUserId())){
				System.out.println("user.getUserId()="+user.getUserId());
				sql.append(" and u.user_id like :userid");
				args.put("userid", "%"+user.getUserId()+"%");
			}
			if(StringUtil.isNotBlank(user.getDepartment())){
				sql.append(" and u.department =:department");
				args.put("department",user.getDepartment());
			}
			if(StringUtil.isNotBlank(user.getOrganizationId())){
				sql.append(" and u.organizationId =:organizationId");
				args.put("organizationId",user.getOrganizationId());
			}
			if(StringUtil.isNotBlank(user.getRoleId())){
				sql.append(" and r.id =:roleId");
				args.put("roleId",user.getRoleId());
			}
			if(StringUtil.isNotBlank(user.getUserclassno())){
				sql.append(" and u.userclassno like :userclassno");
				args.put("userclassno", "%"+user.getUserclassno()+"%");
			}
		}
		sql.append(" order by u.id desc");
			return this.findPageBySQL(sql.toString(), pageBean, args);
	}


	//根据ID查出详情
	public List<?> fetchUserByID(User user){
//		String sql = "select u.username,u.password,u.name,u.gender,u.user_id,u.policeno,u.edubackground,u.department,c.classname,r.rolename " +
//				"from BASE_USER u,BASE_ROLE r,base_class c " +
//				"where u.isSystem is null and u.role_id=r.id and u.id='"+user.getId()+"'" +
//				" and c.classno=u.userclassno" ;
		
		String sql = "select u.username,u.password,u.name,u.gender,u.user_id,u.policeno,u.edubackground,u.department,c.classname,r.rolename " +
		"from BASE_USER u left join base_class c on c.classno=u.userclassno " +
		" left join BASE_ROLE r on u.role_id=r.id " +
		" where u.isSystem is null and u.id='"+user.getId()+"'";
		List<Object[]> l = this.findBySQL(sql);
		if(l != null && l.size()!=0){			
			return l;
		}
		return null;
	}
	
	
	public User fetchUsersById(User user) {
		return getById(user.getId());
	}

	
	public User fetchUser(User user) {
		
		StringBuffer jpql=new StringBuffer("from User u where  u.userName=:userName");
		Map<String ,Object> params=new HashMap<String ,Object>();
		params.put("userName", user.getUserName());
		
		if(user.getId()!=null){
			jpql.append(" and u.id <>:uid");
			
			params.put("uid", user.getId());
		}
		
		List<User> userList =this.findByJPQL(jpql.toString(), params);
		if(userList != null && userList.size()!=0){
			
			return userList.get(0);
		}
		return null;
	}

	//数字证书
	public User fetchUsersByUserID(User user) {
		String jpql="from User u where  u.userId=:userId";
		Map<String ,Object> params=new HashMap<String ,Object>();
		params.put("userId", user.getUserId());
		List<User> userList =this.findByJPQL(jpql, params);
		if(userList != null && userList.size()!=0){
			
			return userList.get(0);
		}
		return null;
	}
	//根据身份证获取实体
	public UserForm fetchUserByUserID(User user) {
		String jpql = "select u.username,u.password,u.name,u.gender,u.user_id,u.policeno," +
				"u.edubackground,u.department,u.department_id,u.id,u.userclassno,c.classname,u.role_id,r.rolename " +
				"from BASE_USER u left join base_class c on c.classno=u.userclassno " +
				" left join BASE_ROLE r on u.role_id=r.id " +
				" where u.user_id='"+user.getUserId()+"'";

		List<Object[]> objectList =this.findBySQL(jpql);
		UserForm u=new UserForm();
		for(int i=0;i<objectList.size();i++){
			u.setUserName(objectList.get(i)[0].toString());
			u.setPassword(objectList.get(i)[1].toString());
			u.setName(objectList.get(i)[2].toString());
			u.setGender(objectList.get(i)[3].toString());
			u.setUserId(objectList.get(i)[4].toString());
			u.setPoliceNo(objectList.get(i)[5].toString());
			u.setEdubackground(objectList.get(i)[6].toString());
			u.setDepartment(objectList.get(i)[7].toString());
			u.setDepartmentId(objectList.get(i)[8].toString());
			u.setId(objectList.get(i)[9].toString());
			u.setUserclassno(objectList.get(i)[10].toString());
			u.setUserclassname(objectList.get(i)[11].toString());
			u.setRoleId(objectList.get(i)[12].toString());
			u.setRolename(objectList.get(i)[13].toString());
		}
		return u;
	}

	public boolean updatePwd(String userid,String pwd2) {
		String sql = "update base_user set password='"+pwd2+"' where id='"+userid+"'";
		System.out.println("-------------------------------"+sql);
		try{
			this.updateBySql(sql);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	





	
}
