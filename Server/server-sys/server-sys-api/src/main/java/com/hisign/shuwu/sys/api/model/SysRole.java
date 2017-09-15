package com.hisign.shuwu.sys.api.model;

import java.util.List;

import com.hisign.shuwu.common.model.BaseModel;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class SysRole extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5888347224431735028L;

	/**
     * 角色对应的用户列表
     */
    private List<? extends Object> users;

    private String id;

    private String roleId;
    /**
     * 角色对应的授权列表
     */
    private List<? extends Object> permissions;

    /**
     * 角色名
     */
    private String roleName = null;
    /** 角色编号 **/
    private String roleNo;

    /**
     * 角色描述
     */
    private String description = null;

    /**
     * 是否开放
     */
    private String openFlag = null;

    /**
     * 是否开放中文
     */
    private String openFlagZw;

    /**
     * 角色名英文
     */
    private String roleNameEn;
    
    /**创建人 **/
    private String createPid;
    
    /** 修改人 **/
    private String modifyPid;

    public SysRole(String id) {
        this.id = id;
    }

    public SysRole() {
    }

    public List<? extends Object> getUsers() {
        return users;
    }

    public void setUsers(List<? extends Object> users) {
        this.users = users;
    }

    public List<? extends Object> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<? extends Object> permissions) {
        this.permissions = permissions;
    }
    

    /**
	 * @return the roleNo
	 */
	public String getRoleNo() {
		return roleNo;
	}

	/**
	 * @param roleNo the roleNo to set
	 */
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleNameEn() {
        return roleNameEn;
    }

    public void setRoleNameEn(String roleNameEn) {
        this.roleNameEn = roleNameEn;
    }

    public String getOpenFlagZw() {
        return openFlagZw;
    }

    public void setOpenFlagZw(String openFlagZw) {
        this.openFlagZw = openFlagZw;
    }

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
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

	
}
