package com.hisign.framework.sys.controller;

import com.hisign.framework.common.model.JsonResult;
import com.hisign.framework.common.util.JsonResultUtil;
import com.hisign.framework.sys.api.model.SysOrgInfo;
import com.hisign.framework.sys.api.service.SysOrgInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sys/org")
@RestController
public class OrgInfoController {
	private static final Logger logger = LoggerFactory.getLogger(OrgInfoController.class);
	@Autowired
	private SysOrgInfoService sysOrgInfoService;
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
    @RequestMapping(value ="/getOrgTreeListBySuperId",method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult getOrgTreeListBySuperId(@RequestParam String superId) {
        try {
        	List<SysOrgInfo> list= sysOrgInfoService.getOrgTreeListBySuperId(superId);
            return JsonResultUtil.success(list);
        } catch (Exception e) {
        	logger.error("获取单位信息失败", e);
            return JsonResultUtil.error("获取单位信息失败");
        }
    }
    
    
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
