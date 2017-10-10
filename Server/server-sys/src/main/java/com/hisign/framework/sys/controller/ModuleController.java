package com.hisign.framework.sys.controller;

import com.hisign.framework.common.constant.Constants;
import com.hisign.framework.common.model.JsonResult;
import com.hisign.framework.common.util.JsonResultUtil;
import com.hisign.framework.sys.api.model.SysModule;
import com.hisign.framework.sys.api.service.SysModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sys")
@RestController
public class ModuleController {
	private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);
    /**
     * 系统模块管理接口
     */
    @Resource
    private SysModuleService sysModuleService;

    /**
     * 进入系统模块管理页初始化数据
     *
     */
    @RequestMapping(value ="/module",method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult intoSysModuleManager() {
        try {
            List<SysModule> list = sysModuleService.findModuleList();
            return JsonResultUtil.success(list.size(), list);
        } catch (Exception e) {
            logger.error("进入模块管理出错", e);
            return JsonResultUtil.error(e.toString());
        }
    }

    /**
     * 查看模块信息
     *
     */
    @RequestMapping(value = "/module/{moduelId}/view",method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult viewModuleInfo(@PathVariable String moduelId) {
        try {
            List<SysModule> list = sysModuleService.findSysModuleInfoById(moduelId);
            return JsonResultUtil.success(list);
        } catch (Exception e) {
            logger.error("查看id为[{}]模块信息出错", moduelId, e);
            return JsonResultUtil.error(Constants.ERROR);
        }
    }

    /**
     * 删除模块
     *
     */
    @RequestMapping(value = "/module/{moduleId}/delete",method = RequestMethod.DELETE,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult deleteModuleInfo(@PathVariable String moduleId) {
        try {
            sysModuleService.deleteResource(moduleId);//首先删除资源表
            sysModuleService.deletePermisRes(moduleId);//其次删除映射关系表
            sysModuleService.deletePermission(moduleId);//再次删除权限表
            sysModuleService.deleteModule(moduleId); //最后删除模块表
            return JsonResultUtil.success("删除成功");
        } catch (Exception e) {
            logger.error("删除id为[{}]模块信息出错", moduleId, e);
            return JsonResultUtil.error("删除失败");
        }
    }

    /**
     * 更新模块信息
     */
    @RequestMapping(value = "/module/update", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult upDateModuleInfo(@RequestBody SysModule sysModule) {
        try {
            sysModuleService.upDateModuleInfo(sysModule);
            return JsonResultUtil.success("保存成功");
        } catch (Exception e) {
            logger.error("修改[{}]模块信息出错", sysModule.getModuleNo(), e);
            return JsonResultUtil.error("保存失败");
        }
    }

    /**
     * 新增模块
     *
     * @param sysModule 模块id
     * @param user      用户对象
     * @return
     * @Author xiaohuiwen
     */
    @RequestMapping(value = "/module/add", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult addModuleInfo(@RequestBody SysModule sysModule) {
        try {
            sysModuleService.addModuleInfo(sysModule);
            return JsonResultUtil.success("保存成功");
        } catch (Exception e) {
            logger.error("新增[{}]模块信息出错", sysModule.getModuleNo(), e);
            return JsonResultUtil.error("保存失败");
        }
    }

}
