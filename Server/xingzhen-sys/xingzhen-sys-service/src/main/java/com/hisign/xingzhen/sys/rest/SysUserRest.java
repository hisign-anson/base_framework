package com.hisign.xingzhen.sys.rest;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.sys.api.model.SysOrgInfo;
import com.hisign.xingzhen.sys.api.model.SysUser;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/sysUserService")
@RestController
public class SysUserRest implements SysUserService {

    @Autowired
    @Resource(name = "sysUserService")
    private SysUserService sysUserService;

    @Override
    @RequestMapping(value = "/findSysUserByUserName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysUser findSysUserByUserName(@RequestParam(value = "userName") String userName) throws Exception {
        return sysUserService.findSysUserByUserName(userName);
    }

    @Override
    @RequestMapping(value = "/findSysUserListByUserFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> findSysUserListByUserFilter(@RequestBody SysUser sysUser) throws Exception {
        return sysUserService.findSysUserListByUserFilter(sysUser);
    }

    @Override
    @RequestMapping(value = "/deleteSysUserById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteSysUserById(@RequestParam(value = "userId") String userId) throws Exception {
        sysUserService.deleteSysUserById(userId);
    }

    @Override
    @RequestMapping(value = "/findSysUserListByFilterForCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int findSysUserListByFilterForCount(@RequestBody SysUser sysUser) throws Exception {
        return sysUserService.findSysUserListByFilterForCount(sysUser);
    }

    @Override
    @RequestMapping(value = "/findSysUserById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysUser findSysUserById(@RequestParam(value = "userId") String userId) throws Exception {
        return sysUserService.findSysUserById(userId);
    }

    @Override
    @RequestMapping(value = "/findSysUserRoleListByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> findSysUserRoleListByFilter(@RequestBody SysUser filter) throws Exception {
        return sysUserService.findSysUserRoleListByFilter(filter);
    }

    @Override
    @RequestMapping(value = "/updateSysUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void updateSysUser(@RequestBody SysUser sysUser) throws Exception {
        sysUserService.updateSysUser(sysUser);
    }

    @Override
    @RequestMapping(value = "/appendSysUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String appendSysUser(@RequestBody SysUser sysUser) throws Exception {
        return sysUserService.appendSysUser(sysUser);
    }

    @Override
    @RequestMapping(value = "/findUserListByRoleId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> findUserListByRoleId(@RequestParam(value = "roleId") String roleId) throws Exception {
        return sysUserService.findUserListByRoleId(roleId);
    }

    @Override
    @RequestMapping(value = "/addUserToken", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addUserToken(@RequestParam(value = "userId") String userId) throws Exception {
        return sysUserService.addUserToken(userId);
    }

    @Override
    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void logout(@RequestParam(value = "token") String token) throws Exception {
        sysUserService.logout(token);
    }

    @Override
    @RequestMapping(value = "/getUserByToken", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysUser getUserByToken(@RequestParam(value = "token") String token) throws Exception {
        return sysUserService.getUserByToken(token);
    }

    @Override
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void updatePassword(@RequestBody SysUser user) throws Exception {
        sysUserService.updatePassword(user);
    }

    @Override
    @RequestMapping(value = "/getUserListByRoleNo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> getUserListByRoleNo(@RequestParam(value = "roleNo") String roleNo,@RequestParam(value = "orgId") String orgId) {
        return sysUserService.getUserListByRoleNo(roleNo,orgId);
    }

    @Override
    @RequestMapping(value = "/getUserInfoListByCondition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUserInfo> getUserInfoListByCondition(@RequestBody SysUserInfo userInfo) {
        return sysUserService.getUserInfoListByCondition(userInfo);
    }

    @Override
    @RequestMapping(value = "/getUserInfoCountByCondition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int getUserInfoCountByCondition(@RequestBody SysUserInfo userInfo) {
        return sysUserService.getUserInfoCountByCondition(userInfo);
    }

    @Override
    @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addUserInfo(@RequestBody SysUserInfo userInfo) throws Exception {
        return sysUserService.addUserInfo(userInfo);
    }

    @Override
    @RequestMapping(value = "/getUserInfoByUserId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysUserInfo getUserInfoByUserId(@RequestParam(value = "userId") String userId) {
        return sysUserService.getUserInfoByUserId(userId);
    }

    @Override
    @RequestMapping(value = "/editUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult editUserInfo(@RequestBody SysUserInfo userInfo) {
        return sysUserService.editUserInfo(userInfo);
    }

    @Override
    @RequestMapping(value = "/delUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void delUserInfo(@RequestParam(value = "userId") String userId) throws Exception {
        sysUserService.delUserInfo(userId);
    }

    @Override
    @RequestMapping(value = "/addUserInfoList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addUserInfoList(@RequestBody List<SysUserInfo> userInfo) throws Exception {
        return sysUserService.addUserInfoList(userInfo);
    }

    @Override
    @RequestMapping(value = "/getReceiverList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Map<String, Object>> getReceiverList(@RequestBody Map<String, List<String>> param) {
        return sysUserService.getReceiverList(param);
    }

    @Override
    public List<SysUserInfo> getUserInfoByIds(List<Object> ids) {
        return sysUserService.getUserInfoByIds(ids);
    }

}
