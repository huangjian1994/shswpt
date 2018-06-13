package com.htcf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="in_video")
public class EquipmentSelf {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private String id;
	
	@Column(name="INVIDEO_NAME")
	private String Name;
	
	@Column(name="INVIDEO_CODE")
	private String Code;
	
	@Column(name="INVIDEO_APPROVE")
	private String Approve;
	
	@Column(name="INVIDEO_DATE")
	private String Date;
	
	@Column(name="INVIDEO_USEFUL")
	private String Useful;
	
	@Column(name="INVIDEO_ADDRESS")
	private String Address;
	
	@Column(name="INVIDEO_LONGITUDE")
	private String Longitude;
	
	@Column(name="INVIDEO_LATITUDE")
	private String Latitude;
	
	@Column(name="INVIDEO_USER")
	private String User;
	
	@Column(name="INVIDEO_TYPE")
	private String Type;
	
	@Column(name="dm")
	private String dm;
	
	@Column(name="dwdm")
	private String dwdm;
	
	@Column(name="ssgc")
	private String ssgc;
	
	public EquipmentSelf(){}
	
	public EquipmentSelf(String id,String Name,String Code,String Approve,String Date, String Useful,
			String Address,String Longitude,String Latitude,String User,String Type,String dm,String dwdm,String ssgc){
		
		super();
		this.id = id;
		this.Name = Name;
		this.Code = Code;
		this.Approve = Approve;
		this.Date = Date;
		this.Useful = Useful;
		this.Address = Address;
		this.Longitude = Longitude;
		this.Latitude = Latitude;
		this.User = User;
		this.Type = Type;
		this.dm = dm;
		this.dwdm = dwdm;
		this.ssgc = ssgc;
	}

	
	
	
	/*------------------------------*/
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


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getLongitude() {
		return Longitude;
	}


	public void setLongitude(String longitude) {
		Longitude = longitude;
	}


	public String getLatitude() {
		return Latitude;
	}


	public void setLatitude(String latitude) {
		Latitude = latitude;
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
	
	
	
	
}
