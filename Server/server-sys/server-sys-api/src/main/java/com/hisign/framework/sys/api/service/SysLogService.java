package com.hisign.framework.sys.api.service;

import com.hisign.framework.sys.api.model.SysUser;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public interface SysLogService {

    /**
     *插入登录用户信息表
     * @Author xiaohuiwen
     * @param sysUser 用户Model
     */
    public void insertLogUserInfo(SysUser sysUser);

    /**
     * 插入操作日志
     * @param paraStr
     * @param requestPath
     * @param ip
     * @param sysUser
     * @return
     */
    public String insertOperLog(String paraStr, String requestPath, String ip, SysUser sysUser) throws Exception;
}
