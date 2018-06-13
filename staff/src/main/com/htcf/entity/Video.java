package com.htcf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Video")
public class Video {
	@Id
	@GeneratedValue
	@Column(name="id")
	private String id;
	
	@Column(name="VIDEO_NAME")
	private String video_name;
	
	@Column(name="VIDEO_DATE")
	private String video_date;
	
	@Column(name="VIDEO_PLAYER")
	private String video_plater;
	
	@Column(name="VIDEO_PLAYERID")
	private String video_platerid;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="VIDEO_ADDRESS")
	private String video_address;
	
	@Column(name="VIDEO_APPROVER")
	private String vio_approver;
	
	@Column(name="VIDEO_APPROVE")
	private String video_approve;
	
	@Column(name="VIDEO_DISTRIT")
	private String video_distrit;
	
	@Column(name="VIDEO_ROUTE")
	private String video_route;
	
	@Column(name="LONGITUDE")
	private String longitude;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="PICTURE")
	private String picture;
	
	@Column(name="TAG")
	private String tag;
	
	@Column(name="video_filename")
	private String video_filename;

	@Column(name="video_type")
	private String video_type;
	
	@Column(name="ssq")
	private String ssq;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String videoName) {
		video_name = videoName;
	}

	public String getVideo_date() {
		return video_date;
	}

	public void setVideo_date(String videoDate) {
		video_date = videoDate;
	}

	public String getVideo_plater() {
		return video_plater;
	}

	public void setVideo_plater(String videoPlater) {
		video_plater = videoPlater;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideo_address() {
		return video_address;
	}

	public void setVideo_address(String videoAddress) {
		video_address = videoAddress;
	}

	public String getVio_approver() {
		return vio_approver;
	}

	public void setVio_approver(String vioApprover) {
		vio_approver = vioApprover;
	}

	public String getVideo_approve() {
		return video_approve;
	}

	public void setVideo_approve(String videoApprove) {
		video_approve = videoApprove;
	}

	public String getVideo_distrit() {
		return video_distrit;
	}

	public void setVideo_distrit(String videoDistrit) {
		video_distrit = videoDistrit;
	}

	public String getVideo_route() {
		return video_route;
	}

	public void setVideo_route(String videoRoute) {
		video_route = videoRoute;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getVideo_platerid() {
		return video_platerid;
	}

	public void setVideo_platerid(String videoPlaterid) {
		video_platerid = videoPlaterid;
	}

	public String getVideo_filename() {
		return video_filename;
	}

	public void setVideo_filename(String videoFilename) {
		video_filename = videoFilename;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String videoType) {
		video_type = videoType;
	}

	public String getSsq() {
		return ssq;
	}

	public void setSsq(String ssq) {
		this.ssq = ssq;
	}
	
	
}
