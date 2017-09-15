package com.hisign.shuwu.sys.api.service;

import java.util.List;
import java.util.Map;

import com.hisign.shuwu.common.model.JsonResult;
import com.hisign.shuwu.sys.api.model.SysUser;
import com.hisign.shuwu.sys.api.model.SysUserInfo;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public interface SysUserService {
    /**
     * 根据用户名取得对应的用户信息
     * @param userName
     * @return
     */
    public SysUser findSysUserByUserName(String userName) throws Exception;

    /**
     * 获得登录用户列表
     * @param sysUser
     * @return
     */
    public List<SysUser> findSysUserListByUserFilter(SysUser sysUser) throws Exception;

    /**
     * 删除登录用户
     * @param sysUser
     */
    public void deleteSysUserById(String userId) throws Exception;

    /**
     * 获得登录用户总数
     * @param sysUser
     * @return
     */
    public int findSysUserListByFilterForCount(SysUser sysUser) throws Exception;

    /**
     * 获得登录用户信息列表
     * @param sysUser
     * @return
     */
    public SysUser findSysUserById(String userId) throws Exception;

    /**
     * 获得角色用户列表
     * @param filter
     * @return
     */
    public List<SysUser> findSysUserRoleListByFilter(SysUser filter) throws Exception;


    /**
     * 更新用户表
     * @param sysUser
     * @param currentUser
     */
    public void updateSysUser(SysUser sysUser) throws Exception;

    /**
     * 新增用户
     * @param sysUser
     * @param currentUser
     * @return
     */
    public String appendSysUser(SysUser sysUser) throws Exception;

    /**
     * 根据角色id获得用户列表
     * @param roleId 角色id
     * @return 用户列表
     */
    public List<SysUser> findUserListByRoleId(String roleId) throws Exception;

    /**
     * 新增token信息
     * @param userId 用户编号
     * @param userToken 用户token
     * @return token
     */
    public String addUserToken(String userId) throws Exception;

    /**
     * 用户登出
     * @param token token编号
     */
    public void logout(String token) throws Exception;

    /**
     * 根据token获得用户信息
     * @param token token编号
     * @return 用户信息
     */
    public SysUser getUserByToken(String token) throws Exception;

    /**
     * 修改用户密码
     * @param user 当前用户
     */
    public void updatePassword(SysUser user) throws Exception;


	/**
	 * 获取获取各角色用户列表
	 * @param string
	 * @return
	 */
	public List<SysUser> getUserListByRoleNo(String roleNo, String orgId);


	public List<SysUserInfo> getUserInfoListByCondition(SysUserInfo userInfo);

	public int getUserInfoCountByCondition(SysUserInfo userInfo);

	public JsonResult addUserInfo(SysUserInfo userInfo);

	public SysUserInfo getUserInfoByUserId(String userId);

	public JsonResult editUserInfo(SysUserInfo userInfo);

	public void delUserInfo(String userId) throws Exception;
	
	public JsonResult addUserInfoList(List<SysUserInfo> userInfo) throws Exception ;

	public List<Map<String, Object>> getReceiverList(Map<String, List<String>> param);
}
