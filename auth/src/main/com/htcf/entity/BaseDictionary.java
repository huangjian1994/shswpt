package com.htcf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BaseDictionary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BASE_DICTIONARY")
public class BaseDictionary implements java.io.Serializable {

	// Fields

	private int id;
	private String key;
	private String value;
	private String dm;

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "VALUE")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name = "dm")
	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}
	
	@Column(name = "zhi")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	

}