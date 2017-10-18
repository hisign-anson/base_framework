package com.hisign.xingzhen.sys.controller;

import com.alibaba.fastjson.JSON;
import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.common.util.JsonResultUtil;
import com.hisign.xingzhen.sys.api.model.*;
import com.hisign.xingzhen.sys.api.service.SysRoleService;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/sys/role")
public class RoleController {
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysUserService sysUserService;

    

    /**
     * 获得系统角色管理列表数据
     *
     * @param filter
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getSysRoleList(@RequestBody SysRole filter)  {
        try {
            logger.info("获取角色管理列表");
            if (!StringUtils.isEmpty(filter.getRoleName())) {
                filter.setRoleName(filter.getRoleName().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
            }
            if (!StringUtils.isEmpty(filter.getDescription())) {
                filter.setDescription(filter.getDescription().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
            }
            List<SysRole> list = sysRoleService.findSysRoleByFilter(filter);
            int count = sysRoleService.findSysRoleByFilterForCount(filter);
            return JsonResultUtil.success(count, list);
        } catch (Exception e) {
            logger.error("获取角色管理列表失败！", e);
            return JsonResultUtil.error("获取角色管理列表失败！");
        }
    }

    /**
     * 删除角色数据
     *
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult sysRoleDelete(@PathVariable String id)  {
        try {
            logger.info("删除id为[{}]的角色数据",id);
            sysRoleService.deleteSysRoleById(id);
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("删除id为[{}]的角色数据", id, e);
            return JsonResultUtil.error("删除角色失败！");
        }
    }

    /**
     * 新增角色管理列表数据
     *
     * @param sysRole
     * @param user
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult sysRoleAdd(@RequestBody SysRole sysRole)  {
        try {
            logger.info("新增角色名为[{}]的角色数据", sysRole.getRoleName());
            String id = sysRoleService.insertSysRole(sysRole);
            if ("error".equals(id)) {
                return JsonResultUtil.error("角色名称已存在,请重新输入!");
            } else {
                return JsonResultUtil.success();
            }
        } catch (Exception e) {
            logger.error("新增角色名为[{}]的角色数据失败", sysRole.getRoleName(), e);
            return JsonResultUtil.error("新增失败!");
        }
    }

    /**
     * 进入角色管理修改
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/_edit", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult sysRoleIntoEdit(@RequestParam(value = "id", required = true) String id)  {
        try {
            logger.info("获得id为[{}]的角色数据", id);
            return JsonResultUtil.success(sysRoleService.findSysRoleById(id));
        } catch (Exception e) {
            logger.error("获得id为[{}]的角色数据失败", id, e);
            return JsonResultUtil.error("获得数据失败!");
        }
    }

    /**
     * 提交角色管理修改
     *
     * @param sysRole
     * @param user
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult sysRoleSubmit(@RequestBody SysRole sysRole) {
        try {
            logger.info("修改id为[{}]的角色数据", sysRole.getRoleId());
            String ret = sysRoleService.updateSysRoleById(sysRole);
            if ("error".equals(ret)) {
                return JsonResultUtil.error("角色名称已存在,请重新输入!");
            } else {
                return JsonResultUtil.success();
            }
        } catch (Exception e) {
            logger.error("修改id为[{}]的角色数据失败", sysRole.getRoleId(), e);
            return JsonResultUtil.error("角色修改失败!");
        }
    }

    /**
     * 进入角色分配
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/_user", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> intoUserSelect(@RequestParam(value = "id", required = true) String id)  {
        Map<String, Object> maps = new HashMap<String, Object>();
        try {
            logger.info("获得id为[{}]的角色分配数据", id);
            SysRole sysRoleFilter = new SysRole();
            sysRoleFilter.setId(id);
            SysRole sysRole = sysRoleService.findSysRoleById(id);
            List<SysUser> associatedUserList = sysUserService.findUserListByRoleId(id);
            List<SysUser> allUserList = sysUserService.findSysUserListByUserFilter(new SysUser(id, "1"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sysRole", sysRole);
            map.put("associatedUserList", associatedUserList);
            map.put("allUserList", allUserList);
            maps.put("data", map);
            maps.put("flag", 1);
            return maps;
        } catch (Exception e) {
            logger.error("获得id为[{}]的角色分配数据失败", id, e);
            maps.put("flag", 0);
            return maps;
        }
    }	


    /**
     * 加入用户
     *
     * @param id
     * @param selectUserId
     * @param user
     * @return
     */
    @RequestMapping(value = "/add_user", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addUserSelect(@RequestBody Map<String, String> param)  {
        try {
            logger.info("对id为[{}]的角色加入用户", param.get("id"));
            sysRoleService.insertUserRole(param.get("id"), param.get("selectUserId"));
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("对id为[{}]的角色加入用户失败",  param.get("id"), e);
            return JsonResultUtil.error("加入用户失败!");
        }
    }

    /**
     * 移除用户
     *
     * @param id
     * @param associatedUserId
     * @return
     */
    @RequestMapping(value = "/remove_user", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult removeUserSelect(@RequestBody Map<String, String> param ) {
        try {
            logger.info("对id为[{}]的角色移除用户", param.get("id"));
            sysRoleService.removeUserRole(param.get("id"), param.get("associatedUserId"));
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("对id为[{}]的角色移除用户失败", param.get("id"), e);
            return JsonResultUtil.error("移除用户失败!");
        }
    }


    /**
     * 进入角色授权
     *
     * @param id
     * @param moduleId
     * @return
     */
    @RequestMapping(value = "/_permission", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult intoGivePermission(@RequestParam(value = "id", required = true) String id,
                                         @RequestParam(value = "moduleId") String moduleId)  {
        try {
            logger.info("获得id为[{}]的角色授权数据", id);
            SysRole sysRole = sysRoleService.findSysRoleById(id);
            List<SysModule> sysModuleList = sysRoleService.findALLSysModule();
            if (StringUtil.isEmpty(moduleId)) {
                moduleId = sysModuleList.get(0).getId();
            }
            List<SysRolePermis> sysRolePermisList = sysRoleService.findSysRolePermisListByFilter(new SysRolePermis(id));
            List<SysPermission> permission = sysRoleService.findSysPermissionListByFilter(moduleId);
            //查询出模块所有的子模块
            List<SysModule> moduleList = sysRoleService.findSysModuleByParentId(moduleId);
            //查询出子模块所有的权限
            for (SysModule sysModule : moduleList) {
                //查询模块的子模块
                List<SysModule> moduleSonList = sysRoleService.findSysModuleByParentId(sysModule.getId());
                //设置子模块权限
                if (!moduleSonList.isEmpty()) {
                    for (SysModule module : moduleSonList) {
                        List<SysPermission> tempPermissionList = sysRoleService.findSysPermissionListByFilter(module.getId());
                        module.setSysModulepermissionList(tempPermissionList);
                    }
                }
                //模块对应的权限
                List<SysPermission> sysModulepermissionList = sysRoleService.findSysPermissionListByFilter(sysModule.getId());
                sysModule.setSysModulepermissionList(sysModulepermissionList);
                sysModule.setSonMouleList(moduleSonList);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sysRole", sysRole);
            map.put("permission", permission);
            map.put("sysModuleList", sysModuleList);
            map.put("moduleList", moduleList);
            map.put("sysRolePermisList", sysRolePermisList);
            return JsonResultUtil.success(map);
        } catch (Exception e) {
            logger.error("获得id为[{}]的角色授权数据失败", id, e);
            return JsonResultUtil.error("获得角色授权数据失败!");
        }
    }

    /**
     * 修改角色授权
     *
     * @param roleId
     * @param sysRolePermisIds
     * @return
     */
    @RequestMapping(value = "/permission", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult submitGivePermission(@RequestBody Map<String, String> param )  {
        try {
            logger.info("修改id为[{}]的角色授权数据", JSON.toJSONString(param));
            sysRoleService.updateSysRolePermisById(param);
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("修改id为[{}]的角色授权数据失败", JSON.toJSONString(param), e);
            return JsonResultUtil.error("修改角色授权数据失败!");
        }
    }

    /**
     * 获得字典角色数据
     *
     * @return 字典角色数据
     */
    @RequestMapping(value = "/roleDict", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult findAllRole()  {
        try {
            logger.info("获得字典角色数据");
            List<SysRole> list = sysRoleService.findAllRole();
            return JsonResultUtil.success(list);
        } catch (Exception e) {
            logger.error("获得字典角色数据失败", e);
            return JsonResultUtil.error("获得字典角色数据失败!");
        }
    }


}
