package com.htcf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 消息表
 * @author LIUYL
 *
 */
@Entity
@Table(name="BASE_MESSAGE")
public class Message  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5707069711032065787L;



	//编号
	@Id
	@GeneratedValue
	private Long id;
	
	
	
	//显示信息
	@Column(length=40)
	private String title;
	
	@Column()
	private String createTime;
	
	

	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	//链接资源
	@Column(length=30)
	private String resourceURL;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getResourceURL() {
		return resourceURL;
	}


	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}




	
	
}
