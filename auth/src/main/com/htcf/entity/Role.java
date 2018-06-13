package com.htcf.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="BASE_ROLE")
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 603492934344787765L;


	/**
	 * 
	 */


	@Id
	@GeneratedValue
	private Long id;
	
	
	//角色名称
	@Column(nullable = false,length=20,unique=true)
	private String roleName;
	


	//是否是系统的
	@Column(length=1)
	private String isSystem;
	
	
	//是否启用
	@Column(length=1)
	private String isenabled;
	
	//描述
	@Column
	private String description;

	

	public String getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}

	public String getIsenabled() {
		return isenabled;
	}

	public void setIsenabled(String isenabled) {
		this.isenabled = isenabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	
}
