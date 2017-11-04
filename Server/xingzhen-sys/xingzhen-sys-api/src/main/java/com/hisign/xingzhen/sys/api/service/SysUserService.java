package com.hisign.xingzhen.sys.api.service;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.sys.api.model.SysOrgInfo;
import com.hisign.xingzhen.sys.api.model.SysUser;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@FeignClient(name = "sysService",path = "/sys/sysUserService")
public interface SysUserService {
    /**
     * 根据用户名取得对应的用户信息
     * @param userName
     * @return
     */
    @RequestMapping(value = "/findSysUserByUserName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysUser findSysUserByUserName(@RequestParam(value = "userName") String userName) throws Exception;

    /**
     * 获得登录用户列表
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/findSysUserListByUserFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> findSysUserListByUserFilter(@RequestBody SysUser sysUser) throws Exception;

    /**
     * 删除登录用户
     * @param sysUser
     */
    @RequestMapping(value = "/deleteSysUserById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteSysUserById(@RequestParam(value = "userId") String userId) throws Exception;

    /**
     * 获得登录用户总数
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/findSysUserListByFilterForCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int findSysUserListByFilterForCount(@RequestBody SysUser sysUser) throws Exception;

    /**
     * 获得登录用户信息列表
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/findSysUserById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysUser findSysUserById(@RequestParam(value = "userId") String userId) throws Exception;

    /**
     * 获得角色用户列表
     * @param filter
     * @return
     */
    @RequestMapping(value = "/findSysUserRoleListByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> findSysUserRoleListByFilter(@RequestBody SysUser filter) throws Exception;


    /**
     * 更新用户表
     * @param sysUser
     * @param currentUser
     */
    @RequestMapping(value = "/updateSysUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void updateSysUser(@RequestBody SysUser sysUser) throws Exception;

    /**
     * 新增用户
     * @param sysUser
     * @param currentUser
     * @return
     */
    @RequestMapping(value = "/appendSysUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String appendSysUser(@RequestBody SysUser sysUser) throws Exception;

    /**
     * 根据角色id获得用户列表
     * @param roleId 角色id
     * @return 用户列表
     */
    @RequestMapping(value = "/findUserListByRoleId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> findUserListByRoleId(@RequestParam(value = "roleId") String roleId) throws Exception;

    /**
     * 新增token信息
     * @param userId 用户编号
     * @param userToken 用户token
     * @return token
     */
    @RequestMapping(value = "/addUserToken", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addUserToken(@RequestParam(value = "userId") String userId) throws Exception;

    /**
     * 用户登出
     * @param token token编号
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void logout(@RequestParam(value = "token") String token) throws Exception;

    /**
     * 根据token获得用户信息
     * @param token token编号
     * @return 用户信息
     */
    @RequestMapping(value = "/getUserByToken", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysUser getUserByToken(@RequestParam(value = "token") String token) throws Exception;

    /**
     * 修改用户密码
     * @param user 当前用户
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void updatePassword(@RequestBody SysUser user) throws Exception;


	/**
	 * 获取获取各角色用户列表
	 * @param string
	 * @return
	 */
    @RequestMapping(value = "/getUserListByRoleNo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUser> getUserListByRoleNo(@RequestParam(value = "roleNo") String roleNo,@RequestParam(value = "orgId") String orgId);


    @RequestMapping(value = "/getUserInfoListByCondition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUserInfo> getUserInfoListByCondition(@RequestBody SysUserInfo userInfo);

    @RequestMapping(value = "/getUserInfoCountByCondition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int getUserInfoCountByCondition(@RequestBody SysUserInfo userInfo);

    @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addUserInfo(@RequestBody SysUserInfo userInfo) throws Exception;

    @RequestMapping(value = "/getUserInfoByUserId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysUserInfo getUserInfoByUserId(@RequestParam(value = "userId") String userId);

    @RequestMapping(value = "/editUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult editUserInfo(@RequestBody SysUserInfo userInfo);

    @RequestMapping(value = "/delUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void delUserInfo(@RequestParam(value = "userId") String userId) throws Exception;

    @RequestMapping(value = "/addUserInfoList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addUserInfoList(@RequestBody List<SysUserInfo> userInfo) throws Exception ;

    @RequestMapping(value = "/getReceiverList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Map<String, Object>> getReceiverList(@RequestBody Map<String, List<String>> param);

    @RequestMapping(value = "/getUserInfoByIds", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysUserInfo> getUserInfoByIds(List<Object> ids);

}
