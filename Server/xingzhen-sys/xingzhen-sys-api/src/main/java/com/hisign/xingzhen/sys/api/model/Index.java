package com.hisign.xingzhen.sys.api.model;

import java.util.List;
import java.util.Map;

import com.hisign.xingzhen.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author lqf
 * @Date 2017年3月30日
 */
@ApiModel
public class Index extends BaseModel {
    /** **/
	private static final long serialVersionUID = -4606203926007250544L;
	/**
     * 页面权限
     */
	@ApiModelProperty(value = "页面权限")
    private List<SysModule> pageLimit;
    /**
     * 处理权限
     */
    @ApiModelProperty(value = "处理权限")
    private List<SysModule> operateLimit;
    /**
     * token
     */
    @ApiModelProperty(value = "token")
    private String token;
    /**
     * 全部权限
     */
    @ApiModelProperty(value = "全部权限")
    private Map<String,List<SysModule>> limits;
    /**
     * 全部角色
     */
    @ApiModelProperty(value = "全部角色")
    private List<Map<String,String>> roles;
   
    /**
     * 用户对象
     */
    @ApiModelProperty(value = "用户对象")
    private SysUser currentUser;
    /**
     * 加密代码
     */
    @ApiModelProperty(value = "加密代码")
    private String clientKey;
    
    private String ftpServer;


	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public List<SysModule> getPageLimit() {
        return pageLimit;
    }

    public void setPageLimit(List<SysModule> pageLimit) {
        this.pageLimit = pageLimit;
    }

    public List<SysModule> getOperateLimit() {
        return operateLimit;
    }

    public void setOperateLimit(List<SysModule> operateLimit) {
        this.operateLimit = operateLimit;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, List<SysModule>> getLimits() {
        return limits;
    }

    public void setLimits(Map<String, List<SysModule>> limits) {
        this.limits = limits;
    }


    public SysUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(SysUser currentUser) {
        this.currentUser = currentUser;
    }

    public List<Map<String, String>> getRoles() {
        return roles;
    }

    public void setRoles(List<Map<String, String>> roles) {
        this.roles = roles;
    }

	/**
	 * @return the ftpServer
	 */
	public String getFtpServer() {
		return ftpServer;
	}

	/**
	 * @param ftpServer the ftpServer to set
	 */
	public void setFtpServer(String ftpServer) {
		this.ftpServer = ftpServer;
	}
    
}
