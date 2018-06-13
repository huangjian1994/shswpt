package com.htcf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class Users {
	@Id
	@GeneratedValue
	@Column(name="id")
	private String id;
	
	@Column(name="USER_NAME")
	private String user_name;
	
	@Column(name="USER_PASSWORD")
	private String user_password;
	
	@Column(name="USER_TYPE")
	private String user_type;
	
	@Column(name="USER_AUTHORITY")
	private String user_authority;
	
	@Column(name="USER_PARTITION")
	private String user_partition;
	
	@Column(name="USER_POSITION")
	private String user_position;
	
	@Column(name="USER_UNITY")
	private String user_unity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String userPassword) {
		user_password = userPassword;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String userType) {
		user_type = userType;
	}

	public String getUser_authority() {
		return user_authority;
	}

	public void setUser_authority(String userAuthority) {
		user_authority = userAuthority;
	}

	public String getUser_partition() {
		return user_partition;
	}

	public void setUser_partition(String userPartition) {
		user_partition = userPartition;
	}

	public String getUser_position() {
		return user_position;
	}

	public void setUser_position(String userPosition) {
		user_position = userPosition;
	}

	public String getUser_unity() {
		return user_unity;
	}

	public void setUser_unity(String userUnity) {
		user_unity = userUnity;
	}
	
}
