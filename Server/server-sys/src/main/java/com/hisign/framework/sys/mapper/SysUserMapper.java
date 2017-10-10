package com.hisign.framework.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hisign.framework.sys.api.model.SysUser;
import com.hisign.framework.sys.api.model.SysUserRole;
import com.hisign.framework.sys.api.model.SysUserToken;

/**
 * 用户管理
 * @author wangping
 * @version 1.0
 * @since 2016/4/22 14:46
 */
public interface SysUserMapper {
	
	
	List<SysUser> getUserListByRoleNo(@Param("roleNo") String roleNo, @Param("orgId") String orgId);
    /**
     * 根据用户信息取得对应的列表
     * @param user
     * @return
     */
    List<SysUser> findSysUserListByFilter(SysUser user);

    /**
     * 根据用户名取得对应的用户信息
     * @param userName
     * @return
     */
    SysUser findSysUserByUserName(String userName);

    /**
     * 获得登录用户列表
     * @param sysUser
     * @return
     */
    List<SysUser> findSysUserListByUserFilter(SysUser sysUser);

    /**
     * 获得登录用户总数
     * @param sysUser
     * @return
     */
    int findSysUserListByUserFilterForCount(SysUser sysUser);

    SysUser findSysUserById(@Param("userId") String userId);

    /**
     * 删除登录用户
     * @param sysUser
     */
    int deleteSysUserById(@Param("userId") String userId);

    int deleteSysUserRoleByUserId(@Param("userId") String userId);

    /**
     * 获得角色用户列表
     * @param filter
     * @return
     */
    List<SysUser> findSysUserRoleListByFilter(SysUser filter);

    /**
     * 插入用户-角色表
     * @param sysUserRole
     */
    void insertSysUserRole(SysUserRole sysUserRole);

    /**
     * 更新用户-角色表
     * @param sysUser
     */
    int updateSysUserById(SysUser sysUser);

    /**
     * 插入用户表
     * @param sysUser
     */
    int insertSysUser(SysUser sysUser);

    /**
     * 根据角色id获得用户列表
     * @param roleId
     * @return
     */
    List<SysUser> findUserListByRoleId(String roleId);

    /**
     * 新增token
     * @param sysUserToken 当前用户
     */
    void addUserToken(SysUserToken sysUserToken);

    /**
     * 根据token获得用户信息
     * @param token token编号
     * @return 用户信息
     */
    SysUser getUserByToken(String token);

    /**
     * 删除用户token信息
     * @param token token编号
     */
    void deleteUserToken(String token);

    /**
     * 修改用户密码
     * @param user 当前用户
     */
    void updatePassword(SysUser user);

    

    /**
     * 新增用户角色表
     * @param sysUserRoles 用户角色信息
     */
    void insertSysUserRoleList(List<SysUserRole> sysUserRoles);

	/**
	 *检查账户名是否存在
	 * @param userName
	 * @return
	 */
	int checkExistByUserName(@Param("userName") String userName);
	
	int updateByUserId(@Param("userId") String userId);
	List<Map<String, Object>> getReceiverList(Map<String, List<String>> param);
}
