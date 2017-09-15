package com.hisign.shuwu.web.controller.sys;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hisign.shuwu.common.model.JsonResult;
import com.hisign.shuwu.common.util.JsonResultUtil;
import com.hisign.shuwu.sys.api.model.SysLoginLog;
import com.hisign.shuwu.sys.api.service.SysLoginLogService;



@RequestMapping("/sys/login")
@RestController
public class LoginLogController {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogController.class);
    /**
     * 系统用户的路日志接口
     */
    @Resource
    public SysLoginLogService sysLoginLogService;

    /**
     * 查询登录用户日志
     *
     */
    @RequestMapping(value = "/log", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult findSysLoginLogList(@RequestBody SysLoginLog sysLoginLog) {
        List<SysLoginLog> list = new ArrayList<SysLoginLog>();
        try {
            //排序字段拼接
            if (!StringUtils.isEmpty(sysLoginLog.getSortName())) {
                sysLoginLog.setOrderByString("ORDER BY " + sysLoginLog.getSortName() + "  " + sysLoginLog.getSortOrder());
            } else {
                sysLoginLog.setOrderByString("ORDER BY LOG_TIME DESC");
            }
            sysLoginLog.setOprUser(sysLoginLog.getOprUser().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));//过滤百分号查询
            list = sysLoginLogService.findSysLoginLogList(sysLoginLog);//查询数据
            int count = sysLoginLogService.findSysLoginLogListForCount(sysLoginLog);//查询count

            return JsonResultUtil.success(count, list);
        } catch (Exception e) {
            logger.error("查询错误", sysLoginLog, e);
            return JsonResultUtil.error("数据载入异常，请联系管理员");
        }
    }
}
