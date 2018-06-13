package com.htcf.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 数据字典表
 * @author LIUYL
 *
 */

@Entity
@Table(name="BASE_DICTIONARY")
public class Dictionary implements Serializable {

	private static final long serialVersionUID = 1844918308565623082L;



	@Id
	@GeneratedValue
	private Long id;
	
	
	
	@Column(nullable=false,length=20)
	private String key;
	
	
	@Column(length=50)
	private String value;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	

}
