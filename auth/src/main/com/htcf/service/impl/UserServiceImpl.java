package com.htcf.service.impl;



import java.util.List;

import com.htcf.dao.IUserDAO;
import com.htcf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcf.dao.IRoleDAO;
import com.htcf.dao.IUserRoleDAO;
import com.htcf.entity.Role;
import com.htcf.entity.User;
import com.htcf.entity.UserForm;
import com.htcf.entity.UserRole;
import com.htcf.util.Operate;
import com.htcf.util.PageBean;
import com.htcf.util.StringUtil;


@Service(value="userService")
public class UserServiceImpl implements IUserService {

	
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IRoleDAO roleDAO;
	
	@Autowired
	private IUserRoleDAO userRoleDAO;
	
	
	
	@Operate(description="根据编号查询用户")
	public User fetchUserById(User user) {
		return userDAO.fetchUsersById(user);
	
	}
	
	//用户登录方法
	@Operate(description="根据用户名查询用户")
	public User fetchUsersByName(User user) {
		return userDAO.fetchUsersByName(user);
	}
	public UserForm fetchUserByName(User user){
		return userDAO.fetchUserByName(user);
	}
	
	@Operate(description="条件查询")
	public List<Object[]> retrieveUsersByCondtions(User user,PageBean pageBean){
		return userDAO.retrieveUsersByConditions(user, pageBean);
		
	}
	

	@Operate(description="添加用户")
	public void addUser(User user,String roleIds) {
		
		UserRole ur=null;
		
		if(StringUtil.isNotBlank(roleIds)){
			
			List<Role> roleList=roleDAO.retrieveRolesByIds(roleIds);
			
			for(Role role:roleList){
				
				ur=new UserRole();
				ur.setUser(user);
				ur.setRole(role);
				
				userRoleDAO.addUserRole(ur);
			
			}
				
			
		}
		userDAO.addUser(user);
		
	}
	
	
	@Operate(description="修改用户")
	public void editUser(User user,String roleIds) {
		
		    UserRole ur=null;
			
			List<UserRole> userRoles=roleDAO.retrieveUserRolesByUser(user);
			
			if(userRoles !=null){
				
				for(UserRole userRole:userRoles){
					
					userRoleDAO.deleteUserRole(userRole);
				
				}
				
			}
			
			
			if(StringUtil.isNotBlank(roleIds)){
				
				List<Role> roleList=roleDAO.retrieveRolesByIds(roleIds);
				
				for(Role role:roleList){
					
					ur=new UserRole();
					ur.setUser(user);
					ur.setRole(role);
					
					
				    userRoleDAO.addUserRole(ur);
				
				}

			}
			
			userDAO.editUser(user);
		
	}

	@Operate(description="删除用户")
	public void deleteUser(User user) {
		
		List<UserRole> userRoles=roleDAO.retrieveUserRolesByUser(user);
		
		for(UserRole userRole:userRoles){
			
			userRoleDAO.deleteUserRole(userRole);
			
		}
		userDAO.deleteUser(user);
		
	}
	
	//根据ID查出详情
	@Operate(description="根据ID查出详情")
	public List<?> fetchUserByID(User user){
		return userDAO.fetchUserByID(user);
	}
	
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IRoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(IRoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public IUserRoleDAO getUserRoleDAO() {
		return userRoleDAO;
	}

	public void setUserRoleDAO(IUserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	@Operate(description="新增用户")
	public void addUser(User user) {
		userDAO.addUser(user);
		
	}

	public void editUser(User user) {
		userDAO.editUser(user);
		
	}

	public User fetchUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.fetchUser(user);
	}

	public User fetchUsersByUserID(User user) {
		return userDAO.fetchUsersByUserID(user);
	}
	//根据身份证获取实体
	public UserForm fetchUserByUserID(User user){
		return userDAO.fetchUserByUserID(user);
	}
	public boolean updatePwd(String userid,String pwd2) {
		return userDAO.updatePwd(userid,pwd2);
		
	}

}
