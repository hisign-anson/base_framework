package com.hisign.xingzhen.sys.mapper;

import com.hisign.xingzhen.sys.api.model.OperationLog;
import com.hisign.xingzhen.sys.api.model.SysUser;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public interface SysLogMapper {


    /**
     *插入登录用户信息表
     * @Author xiaohuiwen
     * @param sysUser 用户Model
     */
    public void insertLogUserInfo(SysUser sysUser);

    /**
     * 登出时更新用户登录信息
     * @Author xiaohuiwen
     * @param sysUser 用户Model
     */
    public void updateLogUserInfo(SysUser sysUser);

    /**
     * 插入日志表
     * @param operationLog 日志module
     */
    public void insertOperLog(OperationLog operationLog);
}
