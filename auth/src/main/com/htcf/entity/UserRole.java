package com.htcf.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="BASE_USER_ROLE")
public class UserRole implements Serializable{

	private static final long serialVersionUID = -3414674703834976235L;


	@Id
	@GeneratedValue
	private Long id;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	private Role role;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
