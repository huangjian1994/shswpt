package com.htcf.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="OPERATELOG")
public class OperateLog implements Serializable{

	private static final long serialVersionUID = 3166791392798655660L;


	@Id
	@GeneratedValue
	@Column(name="Num_ID")
	private String id;
	
	
	//用户身份证号
	@Column(name="User_ID")
	private String userId;
	
	
	@Column(name="User_Name")
	private String userName;
	
	//单位名称
	@Column(name="ORGANIZATION")
	private String organization;
	
	
	//单位机构代码
	@Column(name="Organization_ID")
	private String organizationId;
	
	
	//终端标识
	@Column(name="Terminal_ID")
	private String terminalId;
	
	//操作类型
	@Column(name="operate_Type")
	private Long operateType;
	
	
	//操作时间
	@Column(name="Operate_Time")
	private String opTime;
	
	
	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}



	//操作条件
	@Column(name="Operate_Condition")
	private String operateCondition;
	
	
	//操作结果
	@Column(name="Operate_Result")
	private Long operateResult;
	
	
	//失败原因代码
	@Column(name="Error_Code")
	private String  errorCode;
	
	
	//功能模块名称
	@Column(name="Operate_Name")
	private String operateName;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getOrganization() {
		return organization;
	}



	public void setOrganization(String organization) {
		this.organization = organization;
	}



	public String getOrganizationId() {
		return organizationId;
	}



	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}



	public String getTerminalId() {
		return terminalId;
	}



	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}



	public String getOpTime() {
		return opTime;
	}



	public Long getOperateType() {
		return operateType;
	}



	public void setOperateType(Long operateType) {
		this.operateType = operateType;
	}




	public String getOperateCondition() {
		return operateCondition;
	}



	public void setOperateCondition(String operateCondition) {
		this.operateCondition = operateCondition;
	}



	public Long getOperateResult() {
		return operateResult;
	}



	public void setOperateResult(Long operateResult) {
		this.operateResult = operateResult;
	}



	public String getErrorCode() {
		return errorCode;
	}



	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}



	public String getOperateName() {
		return operateName;
	}



	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}

}
