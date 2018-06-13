package com.htcf.dao;

import java.util.List;

import com.htcf.entity.User;
import com.htcf.entity.UserForm;
import com.htcf.util.PageBean;

public interface IUserDAO {

	
	/**
	 * 根据用户名和密码查询用户 
	 * @param user 用户对象
	 * @return 用户
	 */
	public User fetchUsersByName(User user);
	public UserForm fetchUserByName(User user);
	public User fetchUsersByUserID(User user);
	//根据身份证获取实体
	public UserForm fetchUserByUserID(User user);
	
	/**
	 * 删除用户
	 * 
	 * @param user 用户对象
	 */
	public void deleteUser(User user);
	
	
	/**
	 * 添加用户
	 * 
	 * @param user 用户对象
	 */
	public void addUser(User user);

	
	/**
	 * 根据多条件查询的用户
	 * 
	 * @param user 用户对象
	 * @return    用户集合
	 */ 
	//public List<Object[]>  retrieveUsersByConditions(User user,PageBean pageBean);
	
	

	/**
	 * 根据多条件查询的用户
	 * 
	 * @param user 用户对象
	 * @return    用户集合
	 */ 
	public List<Object[]>  retrieveUsersByConditions(User user,PageBean pageBean);

	/**
	 * 修改用户
	 * 
	 * @param user
	 */
	public void editUser(User user);


	/**
	 * 根据编号查询用户
	 * 
	 * @param user
	 * @return
	 */
	public User fetchUsersById(User user);


	/**
	 * 根据条件加载用户
	 * @param user
	 * @return
	 */
	public User fetchUser(User user);
	
	/**
	 * 修改用户使用的密码
	 * @return 
	 * 
	 * 
	 */
	public boolean updatePwd(String userid,String pwd2);
	
	//根据ID查出详情
	public List<?> fetchUserByID(User user);
}
