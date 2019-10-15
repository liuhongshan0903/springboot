package com.boot.bean;

import java.io.Serializable;
import java.util.Date;

public class BmsUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id; //id
	private String locationid; //所属部门编码
	private String userSex; //性别
	private String userRealName; //真实姓名
	private String userMobile; //手机
	private String userEmail; //邮件
	private String userFax; //传真
	private String userPhone; //电话
	private String userPosition; //住址
	private Date userDate; //登陆日期
	private String userPassans; //安全密码答案
	private String userDesc; //备注
	private String userLoginPassword; //登陆密码
	private String userPassque; //安全密码问题
	private String deptid; //组织机构编号
	private String userLoginName; //登陆名
	private String canVisitLocation; //用户可以访问的区域
	private String canVisitCldLocal; //是否可以访问可访问区域的子区域
	private String loginIpCode; //
	private String loginIpFlag; //
	private String loginIpType; //
	private String userStation; //职位
	private String bmsStatus; //状态：1正常、0删除
	private String applyid; //
	private String webappid; //
	private String usertype; //
	private String edittype; //
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocationid() {
		return this.locationid;
	}
	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}
	public String getUserSex() {
		return this.userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserRealName() {
		return this.userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserMobile() {
		return this.userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserEmail() {
		return this.userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserFax() {
		return this.userFax;
	}
	public void setUserFax(String userFax) {
		this.userFax = userFax;
	}
	public String getUserPhone() {
		return this.userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPosition() {
		return this.userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public Date getUserDate() {
		return this.userDate;
	}
	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
	public String getUserPassans() {
		return this.userPassans;
	}
	public void setUserPassans(String userPassans) {
		this.userPassans = userPassans;
	}
	public String getUserDesc() {
		return this.userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public String getUserLoginPassword() {
		return this.userLoginPassword;
	}
	public void setUserLoginPassword(String userLoginPassword) {
		this.userLoginPassword = userLoginPassword;
	}
	public String getUserPassque() {
		return this.userPassque;
	}
	public void setUserPassque(String userPassque) {
		this.userPassque = userPassque;
	}
	public String getDeptid() {
		return this.deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getUserLoginName() {
		return this.userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getCanVisitLocation() {
		return this.canVisitLocation;
	}
	public void setCanVisitLocation(String canVisitLocation) {
		this.canVisitLocation = canVisitLocation;
	}
	public String getCanVisitCldLocal() {
		return this.canVisitCldLocal;
	}
	public void setCanVisitCldLocal(String canVisitCldLocal) {
		this.canVisitCldLocal = canVisitCldLocal;
	}
	public String getLoginIpCode() {
		return this.loginIpCode;
	}
	public void setLoginIpCode(String loginIpCode) {
		this.loginIpCode = loginIpCode;
	}
	public String getLoginIpFlag() {
		return this.loginIpFlag;
	}
	public void setLoginIpFlag(String loginIpFlag) {
		this.loginIpFlag = loginIpFlag;
	}
	public String getLoginIpType() {
		return this.loginIpType;
	}
	public void setLoginIpType(String loginIpType) {
		this.loginIpType = loginIpType;
	}
	public String getUserStation() {
		return this.userStation;
	}
	public void setUserStation(String userStation) {
		this.userStation = userStation;
	}
	public String getBmsStatus() {
		return this.bmsStatus;
	}
	public void setBmsStatus(String bmsStatus) {
		this.bmsStatus = bmsStatus;
	}
	public String getApplyid() {
		return this.applyid;
	}
	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}
	public String getWebappid() {
		return this.webappid;
	}
	public void setWebappid(String webappid) {
		this.webappid = webappid;
	}
	public String getUsertype() {
		return this.usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getEdittype() {
		return this.edittype;
	}
	public void setEdittype(String edittype) {
		this.edittype = edittype;
	}
	@Override
	public String toString() {
		return "BmsUser [id=" + id + ", locationid=" + locationid + ", userSex=" + userSex + ", userRealName="
				+ userRealName + ", userMobile=" + userMobile + ", userEmail=" + userEmail + ", userFax=" + userFax
				+ ", userPhone=" + userPhone + ", userPosition=" + userPosition + ", userDate=" + userDate
				+ ", userPassans=" + userPassans + ", userDesc=" + userDesc + ", userLoginPassword=" + userLoginPassword
				+ ", userPassque=" + userPassque + ", deptid=" + deptid + ", userLoginName=" + userLoginName
				+ ", canVisitLocation=" + canVisitLocation + ", canVisitCldLocal=" + canVisitCldLocal + ", loginIpCode="
				+ loginIpCode + ", loginIpFlag=" + loginIpFlag + ", loginIpType=" + loginIpType + ", userStation="
				+ userStation + ", bmsStatus=" + bmsStatus + ", applyid=" + applyid + ", webappid=" + webappid
				+ ", usertype=" + usertype + ", edittype=" + edittype + "]";
	}
	
	
}
