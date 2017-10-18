package com.hisign.xingzhen.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hisign.xingzhen.sys.api.model.SysLoginLog;
import com.hisign.xingzhen.sys.api.service.SysLoginLogService;
import com.hisign.xingzhen.sys.mapper.SysLoginLogMapper;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@Service("sysLoginLogService")
public class SysLoginLogServiceImpl implements SysLoginLogService {

    /**
     * 系统登录日志Mapper
     */
    @Resource
    public SysLoginLogMapper sysLoginLogMapper;

    /**
     * 查询登录用户日志
     * @Author xiaohuiwen
     * @param sysLoginLog 登录日志model
     * @return
     */
    public List<SysLoginLog> findSysLoginLogList(SysLoginLog sysLoginLog) throws Exception{
        return sysLoginLogMapper.findSysLoginLogList(sysLoginLog);
    }
    /**
     * 查询登录用户日志Count
     * @Author xiaohuiwen
     * @param sysLoginLog 登录日志model
     * @return
     */
    public int findSysLoginLogListForCount(SysLoginLog sysLoginLog) throws Exception{
        return sysLoginLogMapper.findSysLoginLogListForCount(sysLoginLog);
    }

}
