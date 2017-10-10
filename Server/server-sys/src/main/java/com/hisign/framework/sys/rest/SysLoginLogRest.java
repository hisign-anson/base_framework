package com.hisign.framework.sys.rest;

import com.hisign.framework.sys.api.model.SysLoginLog;
import com.hisign.framework.sys.api.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sys/sysLoginLogService")
@RestController
public class SysLoginLogRest implements SysLoginLogService {

    @Autowired
    @Resource(name = "sysLoginLogService")
    private SysLoginLogService sysLoginLogService;

    @Override
    public List<SysLoginLog> findSysLoginLogList(SysLoginLog sysLoginLog) throws Exception {
        return sysLoginLogService.findSysLoginLogList(sysLoginLog);
    }

    @Override
    public int findSysLoginLogListForCount(SysLoginLog sysLoginLog) throws Exception {
        return sysLoginLogService.findSysLoginLogListForCount(sysLoginLog);
    }
}
