package com.hisign.shuwu.sys.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysUser implements Serializable {

    private static final long serialVersionUID = 424834830L;

    public SysUser() {

    }

    public SysUser(String roleId, String openFlag){
       this.roleId = roleId;
       this.openFlag = openFlag;
    }

    private String id;

    private String userName;

    private String userPwd;

    private String userId;
    private List<String> userIds;
    private String newPassword;

    private String roleNameString;//角色字符串

    private String policeId;

    private String cardId;

    private String userTel;

    private String userUnitZh;

    /**
     * 不包含的用户名
     */
    private String notContainUserName;

    private String userLevel;

    private String defaultModule;

    private String ipFlag;

    private String ipAddress;

    private String remark;

    private String deleteFlag;

    private String transferTime;

    private String createUnit;

    private String createUnitCn;

    private String createDate;

    private String createUserId;

    private String createUser;

    private String modifyUser;

    private String createUserName;

    private String modifyDate;

    private String modifyUserId;

    private String modifyUserName;

    private String techId;

    private Date createDatetime;

    private Date modifyDatetime;

    /**
     * 序号
     */
    private String rownum;

    private String sysUserRoleIds;


    /**
     * 启用状态
     */
    private String openFlag;

    /**
     * 启用状态中文
     */
    private String openFlagZw;

    /**
     * 用户姓名
     */
    private String trueName;

    /**
     * 用户所在单位
     */
    private String userUnit;

    /**
     * 开始条数
     */
    private int begin;

    /**
     * 结束条数
     */
    private int end;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

    private String sortName;

    private String sortOrder;

    private String orderByString;
    /**
     * token编号
     */
    private String token;
    
    private SysUserInfo userInfo;
    /** 单位信息 **/
    private SysOrgInfo orgInfo;

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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRoleNameString() {
		return roleNameString;
	}

	public void setRoleNameString(String roleNameString) {
		this.roleNameString = roleNameString;
	}

	public String getPoliceId() {
		return policeId;
	}

	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserUnitZh() {
		return userUnitZh;
	}

	public void setUserUnitZh(String userUnitZh) {
		this.userUnitZh = userUnitZh;
	}

	public String getNotContainUserName() {
		return notContainUserName;
	}

	public void setNotContainUserName(String notContainUserName) {
		this.notContainUserName = notContainUserName;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getDefaultModule() {
		return defaultModule;
	}

	public void setDefaultModule(String defaultModule) {
		this.defaultModule = defaultModule;
	}

	public String getIpFlag() {
		return ipFlag;
	}

	public void setIpFlag(String ipFlag) {
		this.ipFlag = ipFlag;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(String transferTime) {
		this.transferTime = transferTime;
	}

	public String getCreateUnit() {
		return createUnit;
	}

	public void setCreateUnit(String createUnit) {
		this.createUnit = createUnit;
	}

	public String getCreateUnitCn() {
		return createUnitCn;
	}

	public void setCreateUnitCn(String createUnitCn) {
		this.createUnitCn = createUnitCn;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public String getTechId() {
		return techId;
	}

	public void setTechId(String techId) {
		this.techId = techId;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Date getModifyDatetime() {
		return modifyDatetime;
	}

	public void setModifyDatetime(Date modifyDatetime) {
		this.modifyDatetime = modifyDatetime;
	}

	public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}

	public String getSysUserRoleIds() {
		return sysUserRoleIds;
	}

	public void setSysUserRoleIds(String sysUserRoleIds) {
		this.sysUserRoleIds = sysUserRoleIds;
	}

	public String getOpenFlag() {
		return openFlag;
	}

	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	public String getOpenFlagZw() {
		return openFlagZw;
	}

	public void setOpenFlagZw(String openFlagZw) {
		this.openFlagZw = openFlagZw;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserUnit() {
		return userUnit;
	}

	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getOrderByString() {
		return orderByString;
	}

	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public SysUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(SysUserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @return the orgInfo
	 */
	public SysOrgInfo getOrgInfo() {
		return orgInfo;
	}

	/**
	 * @param orgInfo the orgInfo to set
	 */
	public void setOrgInfo(SysOrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}

	/**
	 * @return the userIds
	 */
	public List<String> getUserIds() {
		return userIds;
	}

	/**
	 * @param userIds the userIds to set
	 */
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	
	
   

   
}