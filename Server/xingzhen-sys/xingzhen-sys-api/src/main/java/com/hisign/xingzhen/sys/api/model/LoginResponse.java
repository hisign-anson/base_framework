package com.hisign.xingzhen.sys.api.model;

import java.io.Serializable;

/**
 * des:登录返回
 * Created by xsf
 * on 2016.09.15:11
 */

public class LoginResponse implements Serializable {
    private String token;
    private String imToken;
    private String userId;
    private String account;
    private String sysCode;
    private String tokenTime;
    private String randomVal;
    private String effectiveTime;
    private String invalidTime;
    private String createDate;
    private String hisignPn;
    /**
     * 下载服务器地址
     */
    private String fdfsDownServer;
    /**
     * 上传服务器地址
     */
    private String fdfsUpServer;
    private SysUserInfo userInfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(String tokenTime) {
        this.tokenTime = tokenTime;
    }

    public String getRandomVal() {
        return randomVal;
    }

    public void setRandomVal(String randomVal) {
        this.randomVal = randomVal;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(String invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getHisignPn() {
        return hisignPn;
    }

    public String getFdfsDownServer() {
        return fdfsDownServer;
    }

    public void setFdfsDownServer(String fdfsDownServer) {
        this.fdfsDownServer = fdfsDownServer;
    }

    public String getFdfsUpServer() {
        return fdfsUpServer;
    }

    public void setFdfsUpServer(String fdfsUpServer) {
        this.fdfsUpServer = fdfsUpServer;
    }

    public void setHisignPn(String hisignPn) {
        this.hisignPn = hisignPn;
    }

    public SysUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(SysUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
