package com.htcf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UPLOAD_VIDEO")
public class SelectVideo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1834930088007922079L;
	@Id
	@GeneratedValue
	private String VIDEO_ID;
	private String VIDEO_NAME;
	private String LONGITUDE;
	private String LATITUDE;
	private String FILE_SIZE;
	private String VIDEO_DURATION;
	private String AREA_INFO;
	private String EVENT_INFO;
	private String UPLOAD_TIME;
	private String UPLOAD_MAN;
	@Column(name="FILE_PATH")
	private String FILE_PATH;
	
	
	
	public String getVIDEO_ID() {
		return VIDEO_ID;
	}

	public void setVIDEO_ID(String VIDEO_ID) {
		this.VIDEO_ID = VIDEO_ID;
	}

	public String getVIDEO_NAME() {
		return VIDEO_NAME;
	}
	
	public void setVIDEO_NAME(String VIDEO_NAME) {
		this.VIDEO_NAME = VIDEO_NAME;
	}

	public String getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	public String getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(String LATITUDE) {
		this.LATITUDE = LATITUDE;
	}

	public String getFILE_SIZE() {
		return FILE_SIZE;
	}

	public void setFILE_SIZE(String fILESIZE) {
		FILE_SIZE = fILESIZE;
	}

	public String getAREA_INFO() {
		return AREA_INFO;
	}

	public void setAREA_INFO(String aREAINFO) {
		AREA_INFO = aREAINFO;
	}

	public String getEVENT_INFO() {
		return EVENT_INFO;
	}

	public void setEVENT_INFO(String eVENTINFO) {
		EVENT_INFO = eVENTINFO;
	}

	public void setUPLOAD_TIME(String UPLOAD_TIME) {
		this.UPLOAD_TIME = UPLOAD_TIME;
	}

	public String getUPLOAD_TIME() {
		return UPLOAD_TIME;
	}

	public void setUPLOAD_MAN(String uPLOAD_MAN) {
		UPLOAD_MAN = uPLOAD_MAN;
	}

	public String getUPLOAD_MAN() {
		return UPLOAD_MAN;
	}

	public void setVIDEO_DURATION(String VIDEO_DURATION) {
		this.VIDEO_DURATION = VIDEO_DURATION;
	}

	public String getVIDEO_DURATION() {
		return VIDEO_DURATION;
	}

	public void setFILE_PATH(String FILE_PATH) {
		this.FILE_PATH = FILE_PATH;
	}

	public String getFILE_PATH() {
		return FILE_PATH;
	}

}
