package com.hisign.framework.sys.rest;

import com.hisign.framework.sys.api.model.SysUser;
import com.hisign.framework.sys.api.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/sys/sysLogService")
@RestController
public class SysLogRest implements SysLogService {

    @Autowired
    @Resource(name = "sysLogService")
    private SysLogService sysLogService;

    @Override
    @RequestMapping(value = "/insertLogUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void insertLogUserInfo(@RequestBody SysUser sysUser) {
        sysLogService.insertLogUserInfo(sysUser);
    }

    @Override
    @RequestMapping(value = "/insertOperLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertOperLog(@RequestParam(value = "paraStr") String paraStr,@RequestParam(value = "requestPath") String requestPath,@RequestParam(value = "ip") String ip,@RequestBody SysUser sysUser) throws Exception {
        return sysLogService.insertOperLog(paraStr,requestPath,ip,sysUser);
    }
}
