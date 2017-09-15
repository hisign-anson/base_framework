package com.hisign.shuwu.sys.mapper;

import java.util.List;

import com.hisign.shuwu.sys.api.model.SysLoginLog;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public interface SysLoginLogMapper {

    /**
     * 查询登录用户日志
     * @Author xiaohuiwen
     * @param sysLoginLog    登录日志model
     * @return
     */
    public List<SysLoginLog> findSysLoginLogList(SysLoginLog sysLoginLog);

    /**
     * 查询登录用户日志Count
     * @Author xiaohuiwen
     * @param sysLoginLog    登录日志model
     * @return
     */
    public int findSysLoginLogListForCount(SysLoginLog sysLoginLog);
}
