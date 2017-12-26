package com.hisign.xingzhen.sys.api.model;

import com.hisign.xingzhen.common.model.BaseModel;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class SysUserRole extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4906971424129915425L;
	/**
     * 授予角色id
     */
    private String sysUserRoleIds;

    /**
     * 用户id
     */
    private String userId;

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

    public String getSysUserRoleIds() {
        return sysUserRoleIds;
    }

    public void setSysUserRoleIds(String sysUserRoleIds) {
        this.sysUserRoleIds = sysUserRoleIds;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
