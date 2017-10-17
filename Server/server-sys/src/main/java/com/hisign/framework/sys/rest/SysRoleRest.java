package com.hisign.framework.sys.rest;

import com.hisign.framework.sys.api.model.SysModule;
import com.hisign.framework.sys.api.model.SysPermission;
import com.hisign.framework.sys.api.model.SysRole;
import com.hisign.framework.sys.api.model.SysRolePermis;
import com.hisign.framework.sys.api.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/sysRoleService")
@RestController
public class SysRoleRest implements SysRoleService {

    @Autowired
    @Resource(name = "sysRoleService")
    private SysRoleService sysRoleService;

    @Override
    @RequestMapping(value = "/findSysRoleListByUserId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysRole> findSysRoleListByUserId(@RequestParam(value = "userId") String userId) throws Exception {
        return sysRoleService.findSysRoleListByUserId(userId);
    }

    @Override
    @RequestMapping(value = "/findSysRoleByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysRole> findSysRoleByFilter(@RequestBody SysRole filter) throws Exception {
        return sysRoleService.findSysRoleByFilter(filter);
    }

    @Override
    @RequestMapping(value = "/findSysRoleByFilterForCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int findSysRoleByFilterForCount(@RequestBody SysRole filter) throws Exception {
        return sysRoleService.findSysRoleByFilterForCount(filter);
    }

    @Override
    @RequestMapping(value = "/deleteSysRoleById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteSysRoleById(@RequestParam(value = "id") String id) throws Exception {
        sysRoleService.deleteSysRoleById(id);
    }

    @Override
    @RequestMapping(value = "/insertSysRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertSysRole(@RequestBody SysRole sysRole) throws Exception {
        return sysRoleService.insertSysRole(sysRole);
    }

    @Override
    @RequestMapping(value = "/findSysRoleById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysRole findSysRoleById(@RequestParam(value = "id") String id) throws Exception {
        return sysRoleService.findSysRoleById(id);
    }

    @Override
    @RequestMapping(value = "/updateSysRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateSysRoleById(@RequestBody SysRole sysRole) throws Exception {
        return sysRoleService.updateSysRoleById(sysRole);
    }

    @Override
    @RequestMapping(value = "/insertUserRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void insertUserRole(@RequestParam(value = "id") String id,@RequestParam(value = "selectUserId") String selectUserId) throws Exception {
        sysRoleService.insertUserRole(id,selectUserId);
    }

    @Override
    @RequestMapping(value = "/removeUserRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void removeUserRole(String id, String associatedUserId) throws Exception {
        sysRoleService.removeUserRole(id,associatedUserId);
    }

    @Override
    @RequestMapping(value = "/findALLSysModule", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findALLSysModule() throws Exception {
        return sysRoleService.findALLSysModule();
    }

    @Override
    @RequestMapping(value = "/findSysRolePermisListByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysRolePermis> findSysRolePermisListByFilter(@RequestBody SysRolePermis sysRolePermis) throws Exception {
        return sysRoleService.findSysRolePermisListByFilter(sysRolePermis);
    }

    @Override
    @RequestMapping(value = "/findSysPermissionListByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysPermission> findSysPermissionListByFilter(@RequestParam(value = "moduleId") String moduleId) throws Exception {
        return sysRoleService.findSysPermissionListByFilter(moduleId);
    }

    @Override
    @RequestMapping(value = "/findSysModuleByParentId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findSysModuleByParentId(@RequestParam(value = "moduleId") String moduleId) throws Exception {
        return sysRoleService.findSysModuleByParentId(moduleId);
    }

    @Override
    @RequestMapping(value = "/updateSysRolePermisById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void updateSysRolePermisById(@RequestBody Map<String, String> map) throws Exception {
        sysRoleService.updateSysRolePermisById(map);
    }

    @Override
    @RequestMapping(value = "/findAllRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysRole> findAllRole() throws Exception {
        return sysRoleService.findAllRole();
    }
}
