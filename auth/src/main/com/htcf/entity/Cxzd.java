package com.htcf.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Cxzd entity. @author wsg
 */
public class Cxzd{
	// Fields

	private Long id;
	private String aid;
	private String aname;
	private String atype;
	private String menu;
	private Long sid;

	/** default constructor */
	public Cxzd() {
	}

	/** full constructor */
	public Cxzd(Long id, String aid, String aname, String atype, String menu,
			Long sid) {
		super();
		this.id = id;
		this.aid = aid;
		this.aname = aname;
		this.atype = atype;
		this.menu = menu;
		this.sid = sid;
	}

	
	
	/**getter方法setter方法*/
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	
	

}