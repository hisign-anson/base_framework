package com.hisign.xingzhen.sys.controller.app;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.common.util.JsonResultUtil;
import com.hisign.xingzhen.sys.api.model.SysOrgInfo;
import com.hisign.xingzhen.sys.api.service.SysOrgInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by hisign on 2017/10/24.
 */
@Api(description = "单位信息")
@RestController
@RequestMapping("app")
public class AppOrgInfoController {

    private static final Logger logger = LoggerFactory.getLogger(AppOrgInfoController.class);

    @Resource
    private SysOrgInfoService sysOrgInfoService;

    @ApiOperation(value = "获取单位信息",httpMethod ="GET",response = SysOrgInfo.class)
    @RequestMapping(value ="/getOrgTreeListBySuperId",method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult getOrgTreeListBySuperId(@RequestParam(required = false,defaultValue = "-1") String superId) {
        try {
            JsonResult result = sysOrgInfoService.getTreeListBySuperId(superId);
            return result;
        } catch (Exception e) {
            logger.error("获取单位信息失败", e);
            return JsonResultUtil.error("获取单位信息失败");
        }
    }
}
