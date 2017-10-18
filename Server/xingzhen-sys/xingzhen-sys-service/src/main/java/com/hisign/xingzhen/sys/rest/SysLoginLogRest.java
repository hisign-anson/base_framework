package com.hisign.xingzhen.sys.rest;

import com.hisign.xingzhen.sys.api.model.SysLoginLog;
import com.hisign.xingzhen.sys.api.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sys/sysLoginLogService")
@RestController
public class SysLoginLogRest implements SysLoginLogService {

    @Autowired
    @Resource(name = "sysLoginLogService")
    private SysLoginLogService sysLoginLogService;

    @Override
    @RequestMapping(value = "/findSysLoginLogList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysLoginLog> findSysLoginLogList(@RequestBody SysLoginLog sysLoginLog) throws Exception {
        return sysLoginLogService.findSysLoginLogList(sysLoginLog);
    }

    @Override
    @RequestMapping(value = "/findSysLoginLogListForCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int findSysLoginLogListForCount(@RequestBody SysLoginLog sysLoginLog) throws Exception {
        return sysLoginLogService.findSysLoginLogListForCount(sysLoginLog);
    }
}
