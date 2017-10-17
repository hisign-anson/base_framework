package com.hisign.framework.sys.api.service;

import com.hisign.framework.sys.api.model.SysModule;
import com.hisign.framework.sys.api.model.SysPermission;
import com.hisign.framework.sys.api.model.SysRole;
import com.hisign.framework.sys.api.model.SysRolePermis;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@FeignClient(value = "sysService",path = "/sys/sysRoleService")
public interface SysRoleService {
    /**
     * 根据用户id获得角色列表
     * @param userId 用户编号
     * @return 角色列表
     */
    @RequestMapping(value = "/findSysRoleListByUserId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysRole> findSysRoleListByUserId(@RequestParam(value = "userId") String userId) throws Exception;

    /**
     * 根据查询条件获得角色列表
     * @param filter 角色列表查询条件
     * @return 角色列表
     */
    @RequestMapping(value = "/findSysRoleByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysRole> findSysRoleByFilter(@RequestBody SysRole filter) throws Exception;

    /**
     * 获得列表数量
     * @param filter
     * @return
     */
    @RequestMapping(value = "/findSysRoleByFilterForCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int findSysRoleByFilterForCount(@RequestBody SysRole filter) throws Exception;

    /**
     * 删除角色
     * @param id
     */
    @RequestMapping(value = "/deleteSysRoleById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteSysRoleById(@RequestParam(value = "id") String id) throws Exception;

    /**
     * 新增角色
     * @param sysRole
     * @param user
     * @return
     */
    @RequestMapping(value = "/insertSysRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertSysRole(@RequestBody SysRole sysRole) throws Exception;

    /**
     * 获得角色列表
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/findSysRoleById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysRole findSysRoleById(@RequestParam(value = "id") String id) throws Exception;

    /**
     * 更新角色列表
     * @param sysRole
     * @param user
     */
    @RequestMapping(value = "/updateSysRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateSysRoleById(@RequestBody SysRole sysRole) throws Exception;

    /**
     * 用户角色表新增数据
     * @param id
     * @param selectUserId
     * @param user
     */
    @RequestMapping(value = "/insertUserRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void insertUserRole(@RequestParam(value = "id") String id,@RequestParam(value = "selectUserId") String selectUserId) throws Exception;

    /**
     * 移除用户角色数据
     * @param id
     * @param associatedUserId
     */
    @RequestMapping(value = "/removeUserRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void removeUserRole(String id, String associatedUserId) throws Exception;

    /**
     * 获得系统模块数据
     * @return
     */
    @RequestMapping(value = "/findALLSysModule", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findALLSysModule() throws Exception;

    /**
     * 根据条件获得角色权限数据
     * @param sysRolePermis 角色权限查询条件
     * @return 角色权限数据
     */
    @RequestMapping(value = "/findSysRolePermisListByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysRolePermis> findSysRolePermisListByFilter(@RequestBody SysRolePermis sysRolePermis) throws Exception;

    /**
     * 根据条件获得系统权限数据
     * @param moduleId
     * @return
     */
    @RequestMapping(value = "/findSysPermissionListByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysPermission> findSysPermissionListByFilter(@RequestParam(value = "moduleId") String moduleId) throws Exception;

    /**
     * 根据父模块id获得系统模块
     * @param moduleId
     * @return
     */
    @RequestMapping(value = "/findSysModuleByParentId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findSysModuleByParentId(@RequestParam(value = "moduleId") String moduleId) throws Exception;

    /**
     *根据id更新角色权限表
     * @param map
     * @param user
     */
    @RequestMapping(value = "/updateSysRolePermisById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void updateSysRolePermisById(@RequestBody Map<String, String> map) throws Exception;

    /**
     * 获得字典角色数据
     * @return 字典角色数据
     */
    @RequestMapping(value = "/findAllRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysRole> findAllRole() throws Exception;
}
