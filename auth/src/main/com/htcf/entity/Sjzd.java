package com.htcf.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ShfkSjzd entity. @author MyEclipse Persistence Tools
 * Shfk 数据字典实体
 */
@Entity
@Table(name = "BASE_SJZD")
public class Sjzd implements java.io.Serializable {
	// Fields
	private Long id;		
	private Long fid;		//父节点
	private String content;	//内容
	private String bz;	//备注
	private String isLeaf ;	//是否叶子节点
	private Long layer;	//级别
	
	// Constructors

	/** default constructor */
	public Sjzd() {
	}

	/** full constructor */
	public Sjzd(Long fid, String content, String bz,String isLeaf,Long layer) {
		super();
		this.fid = fid;
		this.content = content;
		this.bz = bz;
		this.isLeaf = isLeaf;
		this.layer = layer;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false, precision = 16, scale = 0)
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FID", precision = 16, scale = 0)
	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}
	
	@Column(name = "CONTENT", length = 100)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "BZ", length = 100)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "ISLEAF", length = 10)
	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Column(name = "LAYER", precision = 16, scale = 0)
	public Long getLayer() {
		return layer;
	}

	public void setLayer(Long layer) {
		this.layer = layer;
	}
	
}