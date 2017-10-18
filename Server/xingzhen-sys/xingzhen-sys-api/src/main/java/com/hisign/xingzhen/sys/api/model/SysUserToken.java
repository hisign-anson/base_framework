package com.hisign.xingzhen.sys.api.model;

import com.hisign.xingzhen.common.model.BaseModel;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class SysUserToken extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1008640914291922261L;
     private String id;
	/**
     * token编号
     */
    private String token;

    /**
     * 用户编号
     */
    private String userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
}
