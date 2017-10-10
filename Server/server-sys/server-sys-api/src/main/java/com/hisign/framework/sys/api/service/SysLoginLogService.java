package com.hisign.framework.sys.api.service;

import java.util.List;

import com.hisign.framework.sys.api.model.SysLoginLog;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public interface SysLoginLogService {
    /**
     *
     * 查询登录用户日志
     * @param sysLoginLog 登录日志model
     * @return
     * @throws Exception
     */
    public List<SysLoginLog> findSysLoginLogList(SysLoginLog sysLoginLog) throws Exception;

    /**
     * 查询登录用户日志Count
     * @param sysLoginLog  登录日志model
     * @return
     * @throws Exception
     */
    public int findSysLoginLogListForCount(SysLoginLog sysLoginLog) throws Exception;
}
