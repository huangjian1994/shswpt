package com.htcf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="uav")
public class Uav {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private String id;
	
	@Column(name="UAVVIDEO_NAME")
	private String Name;
	
	@Column(name="UAVVIDEO_CODE")
	private String Code;
	
	@Column(name="UAVVIDEO_APPROVE")
	private String Approve;
	
	@Column(name="UAVVIDEO_DATE")
	private String Date;
	
	@Column(name="UAVVIDEO_USEFUL")
	private String Useful;
	
	@Column(name="UAV_USER")
	private String User;
	
	@Column(name="UAV_TYPE")
	private String Type;
	
	
	
	public Uav(String id,String Name,String Code,String Approve,String Date,
			String Useful,String User,String Type){
		
		super();
		this.id = id;
		this.Name = Name;
		this.Code = Code;
		this.Approve = Approve;
		this.Date = Date;
		this.Useful = Useful;
		this.User = User;
		this.Type = Type;
		
	}
	
	
	
	
	
	public Uav(){}


	
	
	
	
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCode() {
		return Code;
	}


	public void setCode(String code) {
		Code = code;
	}


	public String getApprove() {
		return Approve;
	}


	public void setApprove(String approve) {
		Approve = approve;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getUseful() {
		return Useful;
	}


	public void setUseful(String useful) {
		Useful = useful;
	}


	public String getUser() {
		return User;
	}


	public void setUser(String user) {
		User = user;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}
	
	
	
	
	

}
