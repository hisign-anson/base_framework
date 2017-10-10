package com.hisign.framework.sys.api.model;

import java.util.Date;
import java.util.List;

import com.hisign.framework.common.model.BaseModel;

public class SysUserInfo extends BaseModel {
    /** **/
	private static final long serialVersionUID = 5100792519261460572L;
	 /** 用户唯一标识 **/
	private String userId;
	 /** 用户姓名 **/
    private String userName;
    /** 所属机构ID **/
    private String orgId;
    /** 所属机构名称 **/
    private String orgName;
    /** 性别 **/
    private Integer sex;
    /** 身份证号 **/
    private String cid;
    /** 联系电话 **/
    private String phone;
    /** 用户图标  **/
    private String avatar;
    /** 职务 **/
    private String post;
    /** 职务名称 **/
    private String postName;
    /** 生日 **/
    private Date birth;
    /** 通讯地址 **/
    private String address;
    /** 备注 **/
    private String note;
    /** 状态 0正常 1删除**/
    private Integer status;
    /** 创建人**/
    private String createPid;
    /** 创建时间**/
    private Date createTime;
    /**修改人 **/
    private String modifyPid;
    /** 修改时间 **/
    private Date modifyTime;
    
    private Integer isChoose;
    
    private SysUser user;
    
    private List<String> users;
    
    public SysUserInfo(){
	}
	
	public SysUserInfo(String cid) {
		this.cid = cid;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}
	/**
	 * @param post the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the createPid
	 */
	public String getCreatePid() {
		return createPid;
	}
	/**
	 * @param createPid the createPid to set
	 */
	public void setCreatePid(String createPid) {
		this.createPid = createPid;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifyPid
	 */
	public String getModifyPid() {
		return modifyPid;
	}
	/**
	 * @param modifyPid the modifyPid to set
	 */
	public void setModifyPid(String modifyPid) {
		this.modifyPid = modifyPid;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIsChoose() {
		return isChoose;
	}

	public void setIsChoose(Integer isChoose) {
		this.isChoose = isChoose;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	/**
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	

}