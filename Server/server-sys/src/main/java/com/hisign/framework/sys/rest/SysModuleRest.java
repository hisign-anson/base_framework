package com.hisign.framework.sys.rest;

import com.hisign.framework.sys.api.model.SysModule;
import com.hisign.framework.sys.api.service.SysModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//@RequestMapping("/sys/sysModule1")
//@RestController
public class SysModuleRest implements SysModuleService {

    @Autowired
    @Resource(name = "sysModuleService")
    private SysModuleService sysModuleService;

    @Override
    @RequestMapping(value = "/findModuleList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findModuleList() throws Exception {
        return sysModuleService.findModuleList();
    }

    @Override
    @RequestMapping(value = "/findSysModuleInfoById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findSysModuleInfoById(@RequestParam(value = "moduleId") String moduelId) throws Exception {
        return sysModuleService.findSysModuleInfoById(moduelId);
    }

    @Override
    @RequestMapping(value = "/deleteResource", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteResource(@RequestParam(value = "moduleId") String moduelId) throws Exception {
        sysModuleService.deleteResource(moduelId);
    }

    @Override
    @RequestMapping(value = "/deletePermisRes", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deletePermisRes(@RequestParam(value = "moduleId") String moduelId) throws Exception {
        sysModuleService.deletePermisRes(moduelId);
    }

    @Override
    @RequestMapping(value = "/deletePermisRes", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deletePermission(@RequestParam(value = "moduleId") String moduelId) throws Exception {
        sysModuleService.deletePermission(moduelId);
    }

    @Override
    @RequestMapping(value = "/deleteModule", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteModule(@RequestParam(value = "moduleId") String moduelId) throws Exception {
        sysModuleService.deleteModule(moduelId);
    }

    @Override
    @RequestMapping(value = "/upDateModuleInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void upDateModuleInfo(@RequestBody SysModule sysModule) throws Exception {
        sysModuleService.upDateModuleInfo(sysModule);
    }

    @Override
    @RequestMapping(value = "/addModuleInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void addModuleInfo(@RequestBody SysModule sysModule) throws Exception {
        sysModuleService.addModuleInfo(sysModule);
    }

    @Override
    @RequestMapping(value = "/findLogUserPower", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findLogUserPower(@RequestParam(value = "userName") String userName) throws Exception {
        return sysModuleService.findLogUserPower(userName);
    }

    @Override
    @RequestMapping(value = "/findLogUserPowerLimt", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> findLogUserPowerLimt(@RequestParam(value = "userName") String userName) throws Exception {
        return sysModuleService.findLogUserPowerLimt(userName);
    }

    @Override
    @RequestMapping(value = "/toolsForList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysModule> toolsForList(Map<String,List<SysModule>> lists) throws Exception {
        return sysModuleService.toolsForList(lists);
    }

    @Override
    @RequestMapping(value = "/findRoleList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Map<String, String>> findRoleList(@RequestParam(value = "userName") String userName) throws Exception {
        return sysModuleService.findRoleList(userName);
    }
}
