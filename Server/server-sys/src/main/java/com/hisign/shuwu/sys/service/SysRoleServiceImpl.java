package com.hisign.shuwu.sys.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.util.StringUtil;
import com.hisign.shuwu.sys.api.model.SysModule;
import com.hisign.shuwu.sys.api.model.SysPermission;
import com.hisign.shuwu.sys.api.model.SysRole;
import com.hisign.shuwu.sys.api.model.SysRolePermis;
import com.hisign.shuwu.sys.api.model.SysUserRole;
import com.hisign.shuwu.sys.api.service.SysRoleService;
import com.hisign.shuwu.sys.mapper.SysRoleMapper;
import com.hisign.shuwu.sys.mapper.SysUserMapper;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 根据用户id获得角色列表
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> findSysRoleListByUserId(String userId) throws Exception {
        return sysRoleMapper.findSysRoleListByUserId(userId);
    }

    /**
     * 根据查询条件获得角色列表
     * @param filter
     * @return
     */
    @Override
    public List<SysRole> findSysRoleByFilter(SysRole filter) throws Exception {
        return sysRoleMapper.findSysRoleByFilter(filter);
     }

    /**
     * 获得列表数量
     * @param filter
     * @return
     */
    @Override
    public int findSysRoleByFilterForCount(SysRole filter){
        return sysRoleMapper.findSysRoleByFilterForCount(filter);
    }

    /**
     * 删除角色
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysRoleById(String id) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("roleId",id);
        sysRoleMapper.deleteSysRoleById(id);
        sysRoleMapper.deleteSysRolePermisByRoleId(map);
        sysRoleMapper.deleteSysUserRoleByRoleId(id);
    }

    /**
     * 新增角色
     * @param sysRole
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insertSysRole(SysRole sysRole) throws Exception {
        int count = sysRoleMapper.checkExistByRoleName(sysRole.getRoleName());
        if(count > 0) {
            return "error";
        }
        String id = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        sysRole.setId(id);
        sysRoleMapper.insertSysRole(sysRole);
        return id;
    }

    /**
     * 获得角色列表
     * @param sysRole
     * @return
     */
    @Override
    public SysRole findSysRoleById(String id) throws Exception{
        return sysRoleMapper.findSysRoleById(id);
    }

    /**
     * 更新角色列表
     * @param sysRole
     * @param user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateSysRoleById(SysRole sysRole) throws Exception{
    	SysRole oldRole = sysRoleMapper.findSysRoleById(sysRole.getRoleId());
    	if(!oldRole.getRoleName().equals(sysRole.getRoleName())){
    		 int count = sysRoleMapper.checkExistByRoleName(sysRole.getRoleName());
    	        if(count > 0) {
    	            return "error";
    	        }
    	}
        sysRoleMapper.updateSysRoleById(sysRole);
        if ("0".equals(sysRole.getOpenFlag())) {
            String id = sysRole.getRoleId();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("roleId",id);
            sysRoleMapper.deleteSysRolePermisByRoleId(map);
            sysRoleMapper.deleteSysUserRoleByRoleId(id);
        }
        return "success";
    }

    /**
     * 用户角色表新增数据
     * @param id
     * @param selectUserId
     * @param user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUserRole(String id, String selectUserId) throws Exception {
        if(StringUtils.isEmpty(selectUserId)) 
        	return;
        String[] strs = selectUserId.split(",");
        List<SysUserRole> sysUserRoles = new ArrayList<SysUserRole>(strs.length);
        for (int i = 0; i < strs.length; i++) {
			SysUserRole ur =  new SysUserRole(); 
			ur.setUserId(strs[i]);
			ur.setRoleId(id);
			sysUserRoles.add(ur);
		}
        sysUserMapper.insertSysUserRoleList(sysUserRoles);
    }


    /**
     * 移除用户角色数据
     * @param id
     * @param associatedUserId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeUserRole(String id, String associatedUserId) throws Exception {
        if(StringUtil.isNotEmpty(associatedUserId)) {
            String[] strs = associatedUserId.split(",");
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("roleId",id);
            map.put("userIds", Arrays.asList(strs));
            sysRoleMapper.deleteUserRoleByUserRoleId(map);
        }
    }

    /**
     * 获得系统模块数据
     * @return
     */
    @Override
    public List<SysModule> findALLSysModule() throws Exception {
        return sysRoleMapper.findALLSysModule();
    }

    /**
     * 根据条件获得角色权限数据
     * @param sysRolePermis
     * @return
     */
    @Override
    public List<SysRolePermis> findSysRolePermisListByFilter(SysRolePermis sysRolePermis) throws Exception {
        return sysRoleMapper.findSysRolePermisListByFilter(sysRolePermis);
    }

    /**
     * 根据条件获得系统权限数据
     * @param moduleId
     * @return
     */
    @Override
    public List<SysPermission> findSysPermissionListByFilter(String moduleId) throws Exception {
        return sysRoleMapper.findSysPermissionListByFilter(moduleId);
    }

    /**
     * 根据父模块id获得系统模块
     * @param moduleId
     * @return
     */
    @Override
    public List<SysModule> findSysModuleByParentId(String moduleId) throws Exception {
        return sysRoleMapper.findSysModuleByParentId(moduleId);
    }

    /**
     *根据id更新角色权限表
     * @param map
     * @param user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysRolePermisById(Map<String, String> map) throws Exception {
    	String currentRolePermisIds = map.get("currentRolePermisIds");
    	if(StringUtil.isNotEmpty(currentRolePermisIds)){
    		Map<String,Object> param = new HashMap<String, Object>();
    		param.put("roleId", map.get("roleId"));
    		param.put("currentRolePermisIds", Arrays.asList(currentRolePermisIds.split(",")));
    		sysRoleMapper.deleteSysRolePermisByRoleId(param);
    	}
    	String sysRolePermisIds = map.get("sysRolePermisIds");
    	String roleId =  map.get("roleId");
    	String userName = map.get("userName");
        if(StringUtil.isNotEmpty(sysRolePermisIds)){
        	String[] permissionIds = sysRolePermisIds.split(",");
            List<SysRolePermis> list = new ArrayList<SysRolePermis>(permissionIds.length);
            for(int i=0;i<permissionIds.length;i++){
            	SysRolePermis  sysRolePerm = new SysRolePermis();
                sysRolePerm.setRoleId(roleId);
                sysRolePerm.setPermissionId(permissionIds[i]);
                sysRolePerm.setCreatePid(userName);
                sysRolePerm.setModifyPid(userName);
                list.add(sysRolePerm);
            }
            sysRoleMapper.insertSysRolePermis(list);
        }
    }

    /**
     * 获得字典角色数据
     * @return 字典角色数据
     */
    @Override
    public List<SysRole> findAllRole() throws Exception {
        return sysRoleMapper.findAllRole();
    }


}
