package com.htcf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;





@Entity
@Table(name="BASE_MENU")
public class Menu  implements Serializable {

	private static final long serialVersionUID = 1049647513906899034L;

	@Id
	@GeneratedValue
	private Long id;
	
	//菜单编码(将会与显示菜单的图标关联)
	@Column(nullable=false,length=20,unique=true)
	private String code;
	
	//菜单名字
	@Column(nullable = false,length=20,unique=true)
	private String menuName;
	
	//资源路径
	@Column(length=100)
	private String resourceURL;
	

	
	//父级菜单
	//可以设置joinColumn指定外键名
	@ManyToOne()
	@JoinColumn(nullable=true)
	private Menu parent;
	

	//子集菜单
	@OneToMany(mappedBy="parent",cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	@OrderBy(value="orderIndex asc")
	private List<Menu> subList=new ArrayList<Menu>();
	
	
	
	//菜单级别
	@Column(nullable=false)
	private Long MenuLevel;
	
	
	
	@Transient
	private Long preOrderIndex;
	
	
	@Column(nullable=false)
	private Long orderIndex;
	
	
	

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

	//是否是系统的
	@Column(length=1)
	private String isSystem;
	
	
	//是否启用
	@Column(length=1)
	private String isenabled;
	
	//描述
	@Column
	private String description;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getResourceURL() {
		return resourceURL;
	}

	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}


	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	
	public Long getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Long orderIndex) {
		this.orderIndex = orderIndex;
	}


	public Long getPreOrderIndex() {
		return preOrderIndex;
	}

	public void setPreOrderIndex(Long preOrderIndex) {
		this.preOrderIndex = preOrderIndex;
	}

	public Long getMenuLevel() {
		return MenuLevel;
	}

	public void setMenuLevel(Long menuLevel) {
		MenuLevel = menuLevel;
	}

	public void setSubList(List<Menu> subList) {
		this.subList = subList;
	}

	public List<Menu> getSubList() {
		return subList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
