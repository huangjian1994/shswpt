package com.htcf.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.htcf.dao.IRoleDAO;
import com.htcf.entity.Role;
import com.htcf.entity.User;
import com.htcf.entity.UserRole;
import com.htcf.util.PageBean;
import com.htcf.util.StringUtil;

@Repository(value="roleDAO")
public class RoleDAOImpl  extends BaseDAOImpl<Role,Serializable>  implements IRoleDAO {

	
	public void addRole(Role role) {
		save(role);
		
	}

	public Role fetchRoleById(Role role) {
		return  this.getById(role.getId());
	}

	public void deleteRole(Role role) {
		delete(getById(role.getId()));
		
	}
	
	
	public List<Role> retrieveRolesByUser(User user) {
		String jpql="select ur.role  from UserRole ur where ur.user.id=:uid ";
		Map<String,Object> args=new HashMap<String,Object>();
		args.put("uid", user.getId());
		List<Role> roleList=super.findByJPQL(jpql, args);
		return roleList;
	}

	public List<Role> retrieveRolesByName(Role role, PageBean pageBean) {
		
		StringBuffer jpql=new StringBuffer("select role from Role role where role.isSystem is null ");
		Map<String,Object> args =new HashMap<String,Object>();
		if(StringUtil.isNotBlank(role.getRoleName())){
			jpql.append(" and  role.roleName like :roleName");
			args.put("roleName", "%"+role.getRoleName()+"%");
			
		}
		
		return this.findPageByJPQL(jpql.toString(), args, pageBean);
	}

	public List<Role> retrieveRolesByIds(String ids) {
		
		StringBuffer jpql=new StringBuffer("from Role role where  role.isSystem is null");
		
		Map<String,Object> args =new HashMap<String,Object>();
		
		if(StringUtil.isNotBlank(ids)){
			
			jpql.append(" and  role.id in ("+ids+")");
			//args.put("roleIds", "("+ids+")");
		}
		return this.findByJPQL(jpql.toString(), args);
	}

	public List<UserRole> retrieveUserRolesByUser(User user) {
		
		StringBuffer jpql=new StringBuffer("from UserRole ur where 1=1");
		
		Map<String,Object> args =new HashMap<String,Object>();
		
		if(user !=null && user.getId()!=null){
			
			jpql.append(" and ur.user.id=:userId");
			
			args.put("userId", user.getId());
			
			
		}
		
		return this.findByJPQL(jpql.toString(), args);
	}

	public Role fetchRole(Role role) {
		

		StringBuffer jpql=new StringBuffer("from Role r where r.roleName=:roleName");
		
		Map<String,Object> args =new HashMap<String,Object>();
		args.put("roleName", role.getRoleName());
		if(role.getId()!=null){
			jpql.append(" and r.id<> :roleId");
			args.put("roleId", role.getId());
			
		}
		List<Role> roleList=this.findByJPQL(jpql.toString(), args);
		
		if(roleList !=null && !roleList.isEmpty()){
			
			return roleList.get(0);
		}
		
		return null;
	}

	public List<Role> retrieveRolesByName() {
	

		StringBuffer jpql=new StringBuffer("from Role r where r.roleName ='系统内置角色' or r.roleName ='管理员'");
		
		Map<String,Object> args =new HashMap<String,Object>();
		
		List<Role> roleList=this.findByJPQL(jpql.toString(), args);
		
		return roleList;
	}

	
}
