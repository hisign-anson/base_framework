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

@RequestMapping("/sys/sysRole")
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
    public String insertSysRole(SysRole sysRole) throws Exception {
        return null;
    }

    @Override
    public SysRole findSysRoleById(String id) throws Exception {
        return null;
    }

    @Override
    public String updateSysRoleById(SysRole sysRole) throws Exception {
        return null;
    }

    @Override
    public void insertUserRole(String id, String selectUserId) throws Exception {

    }

    @Override
    public void removeUserRole(String id, String associatedUserId) throws Exception {

    }

    @Override
    public List<SysModule> findALLSysModule() throws Exception {
        return null;
    }

    @Override
    public List<SysRolePermis> findSysRolePermisListByFilter(SysRolePermis sysRolePermis) throws Exception {
        return null;
    }

    @Override
    public List<SysPermission> findSysPermissionListByFilter(String moduleId) throws Exception {
        return null;
    }

    @Override
    public List<SysModule> findSysModuleByParentId(String moduleId) throws Exception {
        return null;
    }

    @Override
    public void updateSysRolePermisById(Map<String, String> map) throws Exception {

    }

    @Override
    public List<SysRole> findAllRole() throws Exception {
        return null;
    }
}
