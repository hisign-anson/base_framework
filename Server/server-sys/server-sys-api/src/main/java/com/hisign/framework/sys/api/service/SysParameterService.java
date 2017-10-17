package com.hisign.framework.sys.api.service;

import com.hisign.framework.sys.api.model.SysParam;
import com.hisign.framework.sys.api.model.SysParamConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author lqf
 * @Date 2017年4月1日
 */
@FeignClient(value = "sysService",path = "/sys/sysParameterService")
public interface SysParameterService {

    /**
     * 查询系统参数配置
     */
    @RequestMapping(value = "/findSysConfigList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysParam> findSysConfigList() throws Exception;

    /**
     * 查询系统参数分组配置
     */
    @RequestMapping(value = "/findSysParamConfigList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysParamConfig> findSysParamConfigList() throws Exception;

    /**
     * 插入系统参数
     */
    @RequestMapping(value = "/insertSysParameter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertSysParameter(@RequestBody SysParam sysParam) throws Exception;

    /**
     * 修改系统参数
     */
    @RequestMapping(value = "/editSysParameter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void editSysParameter(@RequestBody List<SysParam> sysParams) throws Exception;

    /**
     * 查询字典中文
     */
    @RequestMapping(value = "/findSysDictValueByRootKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<String> findSysDictValueByRootKey(@RequestParam(value = "str") String str) throws Exception;
    
    /**
     * 根据英文名查找参数实体
     */
    @RequestMapping(value = "/getParamByName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysParam getParamByName(@RequestParam(value = "enName") String enName);

    /**
     * 更新系统参数
     */
    @RequestMapping(value = "/updateSysParameter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateSysParameter(@RequestBody SysParam sysParam) throws Exception;
}
