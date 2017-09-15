package com.hisign.shuwu.sys.api.model;

import com.hisign.shuwu.common.model.BaseModel;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class OperationLog extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2461472315485418672L;

	/**
     * 操作用户
     */
    private String operUserName;

    /**
     * 操作数据
     */
    private String operData;

    private String ip;

    private SysUser sysUser;

    /**
     * 模块
     */
    private String module;

    /**
     * 子模块
     */
    private String moduleSon;

    /**
     * 操作日志
     */
    private String operType;

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    public String getOperData() {
        return operData;
    }

    public void setOperData(String operData) {
        this.operData = operData;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModuleSon() {
        return moduleSon;
    }

    public void setModuleSon(String moduleSon) {
        this.moduleSon = moduleSon;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }
}
