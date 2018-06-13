package com.htcf.entity;


public class TreadInfo {

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	private String id;
	
	
	//用户名
	private String Name;
	
	//身份证号
	private String userId;
	
	//警号
	private String policeNo;
	
	//单位
	private String organization;
	
	
	//单位编号
	private String organizationId;
	
	//所属部门
	private String department;
	
	
	//登陆Ip
	private String logAddr;
	
	
	//操作sql
	private String sql;
	
	


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	

	public String getPoliceNo() {
		return policeNo;
	}


	public void setPoliceNo(String policeNo) {
		this.policeNo = policeNo;
	}


	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public String getOrganizationId() {
		return organizationId;
	}


	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getLogAddr() {
		return logAddr;
	}


	public void setLogAddr(String logAddr) {
		this.logAddr = logAddr;
	}


	public String getSql() {
		return sql;
	}


	public void setSql(String sql) {
		this.sql = sql;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

}
