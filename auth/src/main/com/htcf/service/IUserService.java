package com.htcf.service;


import java.util.List;

import com.htcf.entity.User;
import com.htcf.entity.UserForm;
import com.htcf.util.PageBean;

public interface IUserService {
	
	public User fetchUsersByName(User user);
	public UserForm fetchUserByName(User user);
	public User fetchUsersByUserID(User user);
	//根据身份证获取实体
	public UserForm fetchUserByUserID(User user);
	public List<Object[]> retrieveUsersByCondtions(User user,PageBean pageBean);
	

	public void editUser(User user,String roleIds);

	public void addUser(User user,String roleIds);

	public void deleteUser(User user);

	public User fetchUserById(User user);

	public void addUser(User user);

	public void editUser(User user);

	public User fetchUser(User user);

	public boolean updatePwd(String userid,String pwd2);//修改密码

	//根据ID查出详情
	public List<?> fetchUserByID(User user);
}
