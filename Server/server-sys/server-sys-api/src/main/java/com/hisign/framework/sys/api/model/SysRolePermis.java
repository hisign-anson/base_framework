package com.hisign.framework.sys.api.model;

import com.hisign.framework.common.model.BaseModel;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class SysRolePermis extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3189275621049038061L;

	/**
     * 编号
     */
    private String id;

    /**
     * 角色编号
     */
    private String roleId;

    /**
     * 权限编号
     */
    private String permissionId;
    
    private String createPid;
    
    private String modifyPid;

    public SysRolePermis(String roleId) {
        this.roleId = roleId;
    }

    public SysRolePermis() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
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