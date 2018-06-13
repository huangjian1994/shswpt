package com.htcf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 通知表
 * @author LIUYL
 *
 */

@Entity
@Table(name="BASE_NOTICE")
public  class Notice implements Serializable  {

	private static final long serialVersionUID = 4829467248387227734L;
	
	
	@Id
	@GeneratedValue
	private String id;
	
	
	//标题
	
	@Column
	private String title;
	
	
	//内容
	@Column(length=2000)
	private String content;
	
	
	//创建人
	@Column
	private String createBy;
	
	
	//创建者编号
	private String userId;
	
	
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	//创建时间
	@Column
	private String createTime;
	

	//单位编号
	@Column(length=20,name="organization_Id")
	private String organizationId;
	
	
	//单位
	@Column(length=50)
	private String organization;
	
	
	//部门编号
	@Column(length=20,name="department_Id")
	private String departmentId;
	
	
	
	//所属部门
	@Column(length=50)
	private String department;






	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getCreateBy() {
		return createBy;
	}



	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}



	public String getCreateTime() {
		return createTime;
	}



	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



	public String getOrganizationId() {
		return organizationId;
	}



	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}



	public String getOrganization() {
		return organization;
	}



	public void setOrganization(String organization) {
		this.organization = organization;
	}



	public String getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}
	
}	

