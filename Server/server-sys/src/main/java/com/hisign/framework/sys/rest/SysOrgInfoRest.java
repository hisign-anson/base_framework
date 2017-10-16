package com.hisign.framework.sys.rest;

import com.hisign.framework.common.model.JsonResult;
import com.hisign.framework.sys.api.model.SysOrgInfo;
import com.hisign.framework.sys.api.service.SysOrgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sys/sysOrgInfo")
@RestController
public class SysOrgInfoRest implements SysOrgInfoService {

    @Autowired
    @Resource(name = "sysOrgInfoService")
    private SysOrgInfoService sysOrgInfoService;

    @Override
    @RequestMapping(value = "/queryListByCondition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysOrgInfo> queryListByCondition(@RequestBody SysOrgInfo info) {
        return sysOrgInfoService.queryListByCondition(info);
    }

    @Override
    @RequestMapping(value = "/getOrgInfoByID", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysOrgInfo getOrgInfoByID(@RequestParam(value = "orgId") String orgId) {
        return sysOrgInfoService.getOrgInfoByID(orgId);
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult add(@RequestBody SysOrgInfo info) {
        return sysOrgInfoService.add(info);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult update(@RequestBody SysOrgInfo info) {
        return sysOrgInfoService.update(info);
    }

    @Override
    @RequestMapping(value = "/deleteByKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteByKey(@RequestParam(value = "orgId") String orgId) {
        sysOrgInfoService.deleteByKey(orgId);
    }

    @Override
    @RequestMapping(value = "/getOrgTreeListBySuperId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysOrgInfo> getOrgTreeListBySuperId(@RequestParam(value = "superId") String superId) {
        return sysOrgInfoService.getOrgTreeListBySuperId(superId);
    }

    @Override
    @RequestMapping(value = "/getOrgInfoByName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysOrgInfo getOrgInfoByName(@RequestParam(value = "name") String name) {
        return sysOrgInfoService.getOrgInfoByName(name);
    }

    @Override
    @RequestMapping(value = "/getOrgNotIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysOrgInfo> getOrgNotIn(@RequestBody List<String> orgIds) {
        return sysOrgInfoService.getOrgNotIn(orgIds);
    }

    @Override
    @RequestMapping(value = "/getOrgIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysOrgInfo> getOrgIn(@RequestBody List<String> orgIds) {
        return sysOrgInfoService.getOrgIn(orgIds);
    }
}
