package com.hisign.xingzhen.sys.controller;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.common.util.JsonResultUtil;
import com.hisign.xingzhen.sys.api.model.SysParam;
import com.hisign.xingzhen.sys.api.model.SysParamConfig;
import com.hisign.xingzhen.sys.api.service.SysParameterService;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/sys/param")
public class ParameterController {
	private static final Logger logger = LoggerFactory.getLogger(ParameterController.class);
    /**
     * 系统参数管理接口
     */
    @Resource
    private SysParameterService sysParameterService;

    /**
     * 进入系统参数管理页面
     *
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult intoSysManager() {
        Map<String, List<SysParam>> map = new HashMap<String, List<SysParam>>();
        List<SysParamConfig> configList = new ArrayList<SysParamConfig>();
        List<SysParam> list = new ArrayList<SysParam>();
        List<SysParam> list2;
        try {
            //分组对象集合
            configList = sysParameterService.findSysParamConfigList();
            //所有参数，需要分组
            list = sysParameterService.findSysConfigList();
            for (SysParam sysparam : list) {
                if (StringUtil.isNotEmpty(sysparam.getConfigId())) {
                    if (map.get(sysparam.getConfigId()) == null) {
                        list2 = new ArrayList<SysParam>();
                    } else {
                        list2 = (List<SysParam>) map.get(sysparam.getConfigId());
                    }
                    list2.add(sysparam);
                    map.put(sysparam.getConfigId(), list2);
                }
            }
            //把分组好的参数集合放到对应的分组对象中
            for (SysParamConfig sysParamConfig : configList) {
                sysParamConfig.setSysParamList(map.get(sysParamConfig.getId()));
            }

            return JsonResultUtil.success(configList.size(), configList);
        } catch (Exception e) {
            logger.error("进入系统参数出错", e);
            return JsonResultUtil.error(e.toString());
        }
    }

    /**
     * 新增系统参数
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addSysParameter(@RequestBody SysParam sysParam) {
        try {
            String ret = sysParameterService.insertSysParameter(sysParam);
            if("error".equals(ret)){
            	return JsonResultUtil.error("英文参数名已经存在，请修改后再进行保存");
            }
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("新增[{}]参数信息出错", sysParam.getChineseName(), e);
            return JsonResultUtil.error("参数新增失败");
        }
    }

    /**
     * 修改系统参数
     */
   @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult editSysParameter(@RequestBody List<SysParam> configList) {
        try {
            for (int i = 0; i < configList.size(); i++) {
                configList.get(i).setValue(configList.get(i).getValue().trim());
            }
            sysParameterService.editSysParameter(configList);
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("修改参数信息出错", configList, e);
            return JsonResultUtil.error("修改参数信息出错");
        }
    }

    /**
     * 修改系统参数
     *
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateSysParameter(@RequestBody SysParam sysParam) {
        try {
            String ret = sysParameterService.updateSysParameter(sysParam);
            if("error".equals(ret)){
            	return JsonResultUtil.error("英文参数名已经存在，请修改后再进行保存");
            }
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("修改[{}]参数信息出错", sysParam.getParamEditId(), e);
            return JsonResultUtil.error("修改参数信息出错");
        }
    }

    


}
