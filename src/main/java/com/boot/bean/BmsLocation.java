package com.boot.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "BMS_LOCATION")
@Entity
public class BmsLocation implements Serializable  {
	private static final long serialVersionUID = -3246808128744636155L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/*
	–IDENTITY：采用数据库ID自增长的方式来自增主键字段， MySQL, SQL Server, DB2, Derby, Sybase, PostgreSQL,Oracle 不支持这种方式； 
	–AUTO： JPA自动选择合适的策略，是默认选项； 
	–SEQUENCE：通过序列产生主键，通过@SequenceGenerator 注解指定序列名， Oracle、PostgreSQL、DB2,MySql不支持这种方式 
	–TABLE：通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植。
			这种方式虽然通用性最好，所有的关系型数据库都支持，但是由于不能充分利用具体数据库的特性，建议不要优先使用
	*/
	private String id;
	
	@Column(name = "PARENTID")
	private String parentId;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "STEPINFO")
	private String stepInfo;
	
	@Column(name = "LEVELNO")
	private String levelNo;
	
	@Column(name = "BMS_STATUS")
	private String bmsStatus;
	
	@Column(name = "APPLYID")
	private String applyId;

	/**
	 * Transient 不作为数据库字段  忽视
	 */
	@Transient
	private String sessionFlag;


	public String getSessionFlag() {
		return sessionFlag;
	}

	public void setSessionFlag(String sessionFlag) {
		this.sessionFlag = sessionFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStepInfo() {
		return stepInfo;
	}

	public void setStepInfo(String stepInfo) {
		this.stepInfo = stepInfo;
	}

	public String getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(String levelNo) {
		this.levelNo = levelNo;
	}

	public String getBmsStatus() {
		return bmsStatus;
	}

	public void setBmsStatus(String bmsStatus) {
		this.bmsStatus = bmsStatus;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	
}
