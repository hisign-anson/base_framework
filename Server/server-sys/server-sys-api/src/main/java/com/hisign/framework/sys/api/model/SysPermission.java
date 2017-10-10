package com.hisign.framework.sys.api.model;

import com.hisign.framework.common.model.BaseModel;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class SysPermission extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -537799883046286860L;
     private String id;
	/**
     * 模块编号
     */
    private String moduleId;

    /**
     * 模块名
     */
    private String name;

    /**
     * 操作
     */
    private String operation;

    /**
     * 描述
     */
    private String description;

    /**
     * 启用标志
     */
    private String openFlag;

    /**
     * 授权标志
     */
    private String permissionFlag;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag == null ? null : openFlag.trim();
    }

    public String getPermissionFlag() {
        return permissionFlag;
    }

    public void setPermissionFlag(String permissionFlag) {
        this.permissionFlag = permissionFlag == null ? null : permissionFlag.trim();
    }
}