package com.htcf.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="share_video")
public class EquipmentShare{
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;
	
	@Column(name="OUTVIDEO_NAME")
	private String Name;
	
	@Column(name="OUTVIDEO_CODE")
	private String Code;
	
	@Column(name="OUTVIDEO_APPROVE")
	private String Approve;
	
	@Column(name="OUTVIDEO_DATE")
	private String Date;
	
	@Column(name="OUTVIDEO_USEFUL")
	private String Useful;
	
	@Column(name="OUTVIDEO_ADDRESS")
	private String Address;
	
	@Column(name="OUTVIDEO_LONGITUDE")
	private String Logitude;
	
	@Column(name="OUTVIDEO_LATITUDE")
	private String Latitude;
	
	@Column(name="OUTVIDEO_USER")
	private String User;
	
	@Column(name="OUTVIDEO_TYPE")
	private String Type;
	
	@Column(name="dm")
	private String dm;
	
	@Column(name="dwdm")
	private String dwdm;
	
	@Column(name="ssgc")
	private String ssgc;
	
	public EquipmentShare(String id,String Name,String Code,String Approve,String Date, String Useful,
			String Address,String Logitude,String Latitude,String User,String Type,String dm,String dwdm,String ssgc){
		super();
		this.id = id;
		this.Name = Name;
		this.Code = Code;
		this.Approve = Approve;
		this.Date = Date;
		this.Useful = Useful;
		this.Address = Address;
		this.Logitude = Logitude;
		this.Latitude = Latitude;
		this.User = User;
		this.Type = Type;
		this.dm = dm;
		this.dwdm = dwdm;
		this.ssgc = ssgc;
	}
	
	public EquipmentShare(){
		
		
	}


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
		this.Name = name;
	}


	public String getCode() {
		return Code;
	}


	public void setCode(String code) {
		this.Code = code;
	}


	public String getApprove() {
		return Approve;
	}


	public void setApprove(String approve) {
		this.Approve = approve;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		this.Date = date;
	}


	public String getUseful() {
		return Useful;
	}


	public void setUseful(String useful) {
		this.Useful = useful;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		this.Address = address;
	}


	public String getLogitude() {
		return Logitude;
	}


	public void setLogitude(String logitude) {
		this.Logitude = logitude;
	}


	public String getLatitude() {
		return Latitude;
	}


	public void setLatitude(String latitude) {
		this.Latitude = latitude;
	}


	public String getUser() {
		return User;
	}


	public void setUser(String user) {
		this.User = user;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		this.Type = type;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getDwdm() {
		return dwdm;
	}

	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}

	public String getSsgc() {
		return ssgc;
	}

	public void setSsgc(String ssgc) {
		this.ssgc = ssgc;
	}
	
	
	
	/*----------------------------*/
	
	
}