package com.hisign.framework.sys.api.service;

import com.hisign.framework.sys.api.model.SysUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@FeignClient(value = "sysService",path = "/sys/sysLogService")
public interface SysLogService {

    /**
     *插入登录用户信息表
     * @Author xiaohuiwen
     * @param sysUser 用户Model
     */
    @RequestMapping(value = "/insertLogUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void insertLogUserInfo(@RequestBody SysUser sysUser);

    /**
     * 插入操作日志
     * @param paraStr
     * @param requestPath
     * @param ip
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/insertOperLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertOperLog(@RequestParam(value = "paraStr") String paraStr, @RequestParam(value = "requestPath") String requestPath, @RequestParam(value = "ip") String ip, @RequestBody SysUser sysUser) throws Exception;
}
