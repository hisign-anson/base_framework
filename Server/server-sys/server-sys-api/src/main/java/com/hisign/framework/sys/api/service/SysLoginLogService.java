package com.hisign.framework.sys.api.service;

import com.hisign.framework.sys.api.model.SysLoginLog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@FeignClient(name = "sysService")
public interface SysLoginLogService {
    /**
     *
     * 查询登录用户日志
     * @param sysLoginLog 登录日志model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findSysLoginLogList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysLoginLog> findSysLoginLogList(@RequestBody SysLoginLog sysLoginLog) throws Exception;

    /**
     * 查询登录用户日志Count
     * @param sysLoginLog  登录日志model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findSysLoginLogListForCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int findSysLoginLogListForCount(@RequestBody SysLoginLog sysLoginLog) throws Exception;
}
