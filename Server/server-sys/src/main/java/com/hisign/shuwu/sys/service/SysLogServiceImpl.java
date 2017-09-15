package com.hisign.shuwu.sys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hisign.shuwu.sys.api.model.OperationLog;
import com.hisign.shuwu.sys.api.model.SysUser;
import com.hisign.shuwu.sys.api.service.SysLogService;
import com.hisign.shuwu.sys.mapper.SysLogMapper;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;


    /**
     *插入登录用户信息表
     * @Author xiaohuiwen
     * @param sysUser 用户Model
     */
    public void insertLogUserInfo(SysUser sysUser){
        sysLogMapper.insertLogUserInfo(sysUser);
    }

    /**
     * 登出时更新用户登录信息
     * @Author xiaohuiwen
     * @param sysUser 用户Model
     */
    public void updateLogUserInfo(SysUser sysUser){
        sysLogMapper.updateLogUserInfo(sysUser);
    }

    /**
     * 插入操作日志
     * @param paraStr
     * @param requestPath
     * @param ip
     * @param sysUser
     * @return
     */
    public String insertOperLog(String paraStr,String requestPath,String ip,SysUser sysUser) throws Exception{
        String[] arr = requestPath.split("/");
        OperationLog operationLog = new OperationLog();
        operationLog.setModule(arr[0]);
        operationLog.setModuleSon(arr[1]);
        operationLog.setOperType(arr[2]);
        operationLog.setOperData(paraStr);
        operationLog.setSysUser(sysUser);
        operationLog.setIp(ip);
        sysLogMapper.insertOperLog(operationLog);
        return "success";
    }
}
