package com.hisign.xingzhen.sys.controller;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.common.util.JsonResultUtil;
import com.hisign.xingzhen.sys.api.model.SysOrgInfo;
import com.hisign.xingzhen.sys.api.service.SysOrgInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Api(description = "单位信息")
@RequestMapping("/sys/org")
@RestController
public class OrgInfoController {
	private static final Logger logger = LoggerFactory.getLogger(OrgInfoController.class);
	@Resource(name="sysOrgInfoService")
	private SysOrgInfoService sysOrgInfoService;

    @ApiOperation(value = "获取单位信息",httpMethod ="POST",response = SysOrgInfo.class)
    @RequestMapping(value ="/getOrgTreeList",method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult queryListByCondition(@RequestBody SysOrgInfo param) {
        try {
            List<SysOrgInfo> list = sysOrgInfoService.queryListByCondition(param);
            return JsonResultUtil.success(list.size(), list);
        } catch (Exception e) {
        	logger.error("获取单位信息失败", e);
            return JsonResultUtil.error("获取单位信息失败");
        }
    }
    @ApiOperation(value = "获取单位信息",httpMethod ="GET",response = SysOrgInfo.class)
    @RequestMapping(value ="/getOrgInfo",method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult getOrgInfo(@RequestParam String orgId) {
        try {
            SysOrgInfo orgInfo = sysOrgInfoService.getOrgInfoByID(orgId);
            return JsonResultUtil.success(orgInfo);
        } catch (Exception e) {
        	logger.error("获取单位信息失败", e);
            return JsonResultUtil.error("获取单位信息失败");
        }
    }

    @ApiOperation(value = "获取单位信息",httpMethod ="GET",response = SysOrgInfo.class)
    @RequestMapping(value ="/getOrgTreeListBySuperId",method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult getOrgTreeListBySuperId(@RequestParam(required = false,defaultValue = "1212121212121") String superId) {
        try {
        	List<SysOrgInfo> list= sysOrgInfoService.getOrgTreeListBySuperId(superId);
            return JsonResultUtil.success(list);
        } catch (Exception e) {
        	logger.error("获取单位信息失败", e);
            return JsonResultUtil.error("获取单位信息失败");
        }
    }

    @ApiOperation(value = "获取单位信息",httpMethod ="GET",response = SysOrgInfo.class)
    @RequestMapping(value ="/getTreeListBySuperId",method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult getTreeListBySuperId(@RequestParam(required = false,defaultValue = "-1") String superId) {
        try {
            JsonResult result = sysOrgInfoService.getTreeListBySuperId(superId);
            return result;
        } catch (Exception e) {
            logger.error("获取单位信息失败", e);
            return JsonResultUtil.error("获取单位信息失败");
        }
    }

    @ApiOperation(value = "添加单位信息",httpMethod ="POST",response = SysOrgInfo.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult add(@RequestBody SysOrgInfo param) {
        try {
            return this.sysOrgInfoService.add(param);
        } catch (Exception e) {
        	logger.error("新增单位信息失败", e);
            return JsonResultUtil.error("新增单位信息失败");
        }
    }

    @ApiOperation(value = "修改单位信息",httpMethod ="POST",response = SysOrgInfo.class)
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult update(@RequestBody SysOrgInfo param) {
        try {
            return this.sysOrgInfoService.update(param);
        } catch (Exception e) {
        	logger.error("修改单位信息失败", e);
            return JsonResultUtil.error("修改单位信息失败");
        }
    }

    @ApiOperation(value = "删除单位信息",httpMethod ="DELETE",response = SysOrgInfo.class)
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delete(@PathVariable("id") String id) {
        try {
        	 this.sysOrgInfoService.deleteByKey(id);
            return JsonResultUtil.success();
        } catch (Exception e) {
        	logger.error("删除失败", e);
            return JsonResultUtil.error("删除失败");
        }
    }
    
    
}
