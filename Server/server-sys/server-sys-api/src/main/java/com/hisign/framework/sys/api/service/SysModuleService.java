package com.hisign.framework.sys.api.service;

import com.hisign.framework.sys.api.model.SysModule;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@FeignClient(value = "sysService",path = "/sys/sysModuleService")
public interface SysModuleService {
    /**
     * 查询所有模块信息
     * @Author xiaohuiwen
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/findModuleList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findModuleList() throws Exception;

    /**
     *查询模块信息
     * @Author xiaohuiwen
     * @param moduelId 模块id
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/findSysModuleInfoById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findSysModuleInfoById(@RequestParam(value = "moduleId") String moduelId) throws Exception;

    /**
     * 删除资源表
     * @Author xiaohuiwen
     * @param moduelId 模块id
     * @throws Exception
     */
    @RequestMapping(value = "/deleteResource", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteResource(@RequestParam(value = "moduleId") String moduelId) throws Exception;

    /**
     * 删除映射关系表
     * @Author xiaohuiwen
     * @param moduelId 模块id
     * @throws Exception
     */
    @RequestMapping(value = "/deletePermisRes", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deletePermisRes(@RequestParam(value = "moduleId") String moduelId) throws Exception;

    /**
     *删除权限表
     * @Author xiaohuiwen
     * @param moduelId 模块id
     * @throws Exception
     */
    @RequestMapping(value = "/deletePermission", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deletePermission(@RequestParam(value = "moduleId") String moduelId) throws Exception;

    /**
     * 删除模块表
     * @Author xiaohuiwen
     * @param moduelId 模块id
     * @throws Exception
     */
    @RequestMapping(value = "/deleteModule", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteModule(@RequestParam(value = "moduleId") String moduelId) throws Exception;

    /**
     *更新模块信息
     * @Author xiaohuiwen
     * @param sysModule 模块model
     * @throws Exception
     */
    @RequestMapping(value = "/upDateModuleInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void upDateModuleInfo(@RequestBody SysModule sysModule) throws Exception;

    /**
     * 添加模块信息
     * @Author xiaohuiwen
     * @param sysModule 模块model
     * @throws Exception
     */
    @RequestMapping(value = "/addModuleInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void addModuleInfo(@RequestBody SysModule sysModule) throws Exception;


    /**
     * 获取登录用户的权限
     * @Author xiaohuiwen
     * @param userName 用户名
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/findLogUserPower", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findLogUserPower(@RequestParam(value = "userName") String userName) throws Exception;

    /**
     * 获取登录用户的子权限
     * @Author xiaohuiwen
     * @param userName 用户名
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/findLogUserPowerLimt", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findLogUserPowerLimt(@RequestParam(value = "userName") String userName) throws Exception;

    /**
     * 工具类拼接权限list
     * @Author xiaohuiwen
     * @param parentList 页面权限
     * @param childList   二级模块权限
     * @param childNodeList 三级模块权限
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/toolsForList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> toolsForList(Map<String,List<SysModule>> lists) throws Exception;

    /**
     * 获取登录用户角色
     * @Author xiaohuiwen
     * @param userName 用户名
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/findRoleList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Map<String, String>> findRoleList(@RequestParam(value = "userName") String userName) throws Exception;
}
