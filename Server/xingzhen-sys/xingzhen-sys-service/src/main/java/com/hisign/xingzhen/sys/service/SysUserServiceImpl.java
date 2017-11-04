package com.hisign.xingzhen.sys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import cn.jiguang.common.resp.ResponseWrapper;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.common.model.RegisterPayload;
import cn.jmessage.api.common.model.UserPayload;
import cn.jmessage.api.user.UserClient;
import com.hisign.xingzhen.common.util.*;
import com.hisign.xingzhen.sys.mapper.SysLogMapper;
import com.hisign.xingzhen.sys.mapper.SysUserInfoMapper;
import com.hisign.xingzhen.sys.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.sys.api.model.SysDict;
import com.hisign.xingzhen.sys.api.model.SysOrgInfo;
import com.hisign.xingzhen.sys.api.model.SysRole;
import com.hisign.xingzhen.sys.api.model.SysUser;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.model.SysUserRole;
import com.hisign.xingzhen.sys.api.model.SysUserToken;
import com.hisign.xingzhen.sys.api.service.SysDictService;
import com.hisign.xingzhen.sys.api.service.SysOrgInfoService;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import com.hisign.xingzhen.sys.mapper.SysOrgInfoMapper;
import com.hisign.xingzhen.sys.mapper.SysRoleMapper;

/**
 * @author liangqifu
 *
 *         2017年3月29日
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Resource
	private SysUserMapper sysUserMapper;
	
	@Resource
	private SysUserInfoMapper sysUserInfoMapper;
	
	@Resource
	private SysLogMapper sysLogMapper;
	
	@Resource
	private SysRoleMapper sysRoleMapper;
	
	@Resource
	private SysOrgInfoService sysOrgInfoService;
	
	@Resource
	private SysDictService sysDictService;

	@Resource
	private SysOrgInfoMapper sysOrgInfoMapper;

	@Autowired
	UserClient userClient;

	@Autowired
	JMessageClient jMessageClient;

	@Override
	public SysUser findSysUserByUserName(String userName) throws Exception {
		SysUser sysUser = sysUserMapper.findSysUserByUserName(userName);
		if(sysUser!=null && StringUtils.isNotBlank(sysUser.getUserId())){
			SysUserInfo userInfo = sysUserInfoMapper.selectByKey(sysUser.getUserId());
			sysUser.setUserInfo(userInfo);
			if(userInfo != null){
				sysUser.setOrgInfo(sysOrgInfoMapper.selectByKey(userInfo.getOrgId()));
			}
			
		}
		return sysUser;
	}

	/**
	 * 获得登录用户列表
	 * 
	 * @param sysUser
	 * @return
	 */
	@Override
	public List<SysUser> findSysUserListByUserFilter(SysUser sysUser)
			throws Exception {
		if (StringUtils.isNotBlank(sysUser.getSortName())
				&& StringUtils.isNotBlank(sysUser.getSortOrder())) {
			sysUser.setOrderByString(sysUser.getSortName() + " "
					+ sysUser.getSortOrder());
		} else {
			sysUser.setOrderByString("createDatetime desc");
		}
		return sysUserMapper.findSysUserListByUserFilter(sysUser);
	}

	/**
	 * 获得登录用户总数
	 * 
	 * @param sysUser
	 * @return
	 */
	@Override
	public int findSysUserListByFilterForCount(SysUser sysUser)
			throws Exception {
		return sysUserMapper.findSysUserListByUserFilterForCount(sysUser);
	}

	/**
	 * 删除登录用户
	 * 
	 * @param sysUser
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteSysUserById(String userId) throws Exception {
		sysUserMapper.deleteSysUserById(userId);
		sysUserMapper.deleteSysUserRoleByUserId(userId);
	}

	/**
	 * 获得登录用户信息列表
	 * 
	 * @param sysUser
	 * @return
	 */
	@Override
	public SysUser findSysUserById(String userId) throws Exception {
		return sysUserMapper.findSysUserById(userId);
	}

	/**
	 * 获得角色用户列表
	 * 
	 * @param filter
	 * @return
	 */
	@Override
	public List<SysUser> findSysUserRoleListByFilter(SysUser filter)
			throws Exception {
		return sysUserMapper.findSysUserRoleListByFilter(filter);
	}



	/**
	 * 更新用户表
	 * 
	 * @param sysUser
	 * @param currentUser
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateSysUser(SysUser sysUser)
			throws Exception {
		if (!StringUtils.isEmpty(sysUser.getNewPassword())) {
			sysUser.setNewPassword(Md5Helper.getMD5(sysUser.getNewPassword()));
		}
		sysUser.setUserLevel("1");
		sysUserMapper.updateSysUserById(sysUser);
		if (!StringUtils.isEmpty(sysUser.getSysUserRoleIds())) {
			sysUserMapper.deleteSysUserRoleByUserId(sysUser.getId());
			String[] strs = sysUser.getSysUserRoleIds().split(",");
			List<SysUserRole> sysUserRoles = new ArrayList<SysUserRole>(strs.length); 
			for (int i = 0; i < strs.length; i++) {
				SysUserRole ur =  new SysUserRole(); 
				ur.setUserId(sysUser.getId());
				ur.setRoleId(strs[i]);
				sysUserRoles.add(ur);
			}
			sysUserMapper.insertSysUserRoleList(sysUserRoles);
		}
	}

	/**
	 * 新增用户
	 * 
	 * @param sysUser
	 *            用户信息
	 * @param currentUser
	 *            当前用户
	 * @return 用户编号
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String appendSysUser(SysUser sysUser)
			throws Exception {
		// MD5加密
		if (!StringUtils.isEmpty(sysUser.getUserPwd()))
			sysUser.setUserPwd(Md5Helper.getMD5(sysUser.getUserPwd()));
		int count = sysUserMapper.checkExistByUserName(sysUser.getUserName());
		if (count > 0)
			return "error";
		String id = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		sysUser.setId(id);
		sysUser.setUserLevel("1");
		sysUser.setDefaultModule("0");
		sysUserMapper.insertSysUser(sysUser);
		return id;
	}

	/**
	 * 根据角色id获得角色列表
	 * 
	 * @param roleId
	 * @return
	 */
	@Override
	public List<SysUser> findUserListByRoleId(String roleId) throws Exception {
		return sysUserMapper.findUserListByRoleId(roleId);
	}

	

	/**
	 * 新增token信息
	 * 
	 * @param userId
	 *            用户编号
	 * @return token
	 */
	@Override
	public String addUserToken(String userId) throws Exception {
		SysUserToken sysUserToken = new SysUserToken();
		// 生成token
		String token = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		sysUserToken.setToken(token);
		sysUserToken.setUserId(userId);
		sysUserMapper.addUserToken(sysUserToken);
		return token;
	}

	/**
	 * 根据token获得用户信息
	 * 
	 * @param token
	 *            token编号
	 * @return 用户信息
	 */
	@Override
	public SysUser getUserByToken(String token) throws Exception {
		return sysUserMapper.getUserByToken(token);
	}

	/**
	 * 删除用户token信息
	 * 
	 * @param token
	 *            token编号
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void logout(String token) throws Exception {
		SysUser sysUser = sysUserMapper.getUserByToken(token);
		if(sysUser != null ){
			sysLogMapper.updateLogUserInfo(sysUser);
		}
		sysUserMapper.deleteUserToken(token);
	}

	/**
	 * 修改用户密码
	 * 
	 * @param user
	 *            当前用户
	 */
	public void updatePassword(SysUser user) throws Exception {
		sysUserMapper.updatePassword(user);
	}


	@Override
	public List<SysUser> getUserListByRoleNo(String roleNo,String orgId) {
		return sysUserMapper.getUserListByRoleNo(roleNo,orgId);
	}

	@Override
	public List<SysUserInfo> getUserInfoListByCondition(SysUserInfo userInfo) {
		List<SysUserInfo> list = sysUserInfoMapper.queryListByCondition(userInfo);
		if (list!=null && list.size()>0) {
			SysDict sysDict = new SysDict();
			sysDict.setRoot(Constants.FLDZWDM);
			List<SysDict> dictList = sysDictService.getDictListByRootKey(sysDict);
			for (SysUserInfo sysUserInfo : list) {
				for (SysDict dict : dictList) {
					if (sysUserInfo.getPost().equals(dict.getKey())) {
						sysUserInfo.setPost(dict.getValue());
					}
				}
			}
			
		}else {
			return null;
		}
		return list;
	}

	@Override
	public int getUserInfoCountByCondition(SysUserInfo userInfo) {
		return sysUserInfoMapper.queryCountByCondition(userInfo);
	}

	@Override
	@Transactional
	public JsonResult addUserInfo(SysUserInfo userInfo) throws Exception {
		int count = sysUserInfoMapper.queryCountByCondition(new SysUserInfo(userInfo.getCid()));
		if(count > 0){
			return JsonResultUtil.error("身份证号已存在,请重新输入");
		}
		sysUserInfoMapper.insert(userInfo);

		RegisterInfo registerInfo = RegisterInfo.newBuilder().setUsername(userInfo.getUserId()).setPassword("1234").build();
		ResponseWrapper response = userClient.registerAdmins(registerInfo);
		if (!response.isServerResponse()){
			log.error("极光注册用户失败",response);
			throw new Exception("新增用户信息错误");
		}
		//更新极光上用户的信息
		UserPayload userPayload = UserPayload.newBuilder().setAddress(userInfo.getAddress())
				.setNickname(userInfo.getUserName()).build();
		response = userClient.updateUserInfo(userInfo.getUserId(), userPayload);
				if (!response.isServerResponse()){
			log.error("极光注册用户失败",response);
			throw new Exception("更新用户信息错误");
		}
		return JsonResultUtil.success(userInfo.getUserId());
	}
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public JsonResult addUserInfoList(List<SysUserInfo> list) throws Exception {
		SysDict sysDict = new SysDict();
		sysDict.setParentKey(Constants.FLDZWDM);
		List<SysDict> dicts = sysDictService.getDictListByParentKey(sysDict);
		
		SysOrgInfo soi = new SysOrgInfo();
		soi.setEnd(2);
		//角色
		List<SysUserRole> roleList = new ArrayList<SysUserRole>();
		for (SysUserInfo sysUserInfo : list) {
			//获取所有职务
			//根据机构名称获取机构id
			//获取上级机构
			SysUser sysUser = sysUserInfo.getUser();
			soi.setOrgName(sysUserInfo.getSuperId());
			soi.setBegin(1);
			soi.setEnd(1);
			soi.setSuperId(null);
			List<SysOrgInfo> slist = sysOrgInfoMapper.queryListByCondition(soi);
			if (ListUtils.isEmpty(slist)) {
				throw new Exception(sysUserInfo.getSuperId()+" 机构不存在");
			}
			SysOrgInfo ssysOrgInfo = slist.get(0);//上级机构
			//获取所属机构
			if (StringUtils.isNotBlank(sysUserInfo.getOrgName())) {
				soi.setOrgName(sysUserInfo.getOrgName());
				soi.setSuperId(ssysOrgInfo.getOrgId());
				List<SysOrgInfo> orglist = sysOrgInfoMapper.queryListByCondition(soi);
				if (ListUtils.isEmpty(orglist)) {
					throw new Exception(sysUserInfo.getOrgName()+" 机构不存在");
				}
				SysOrgInfo bean = orglist.get(0);
				sysUserInfo.setOrgId(bean.getOrgId());
			}else{
				//没有填，则默认一级机构
				sysUserInfo.setOrgId(ssysOrgInfo.getOrgId());
				sysUserInfo.setOrgName(ssysOrgInfo.getOrgName());
			}
			
			List<SysUserInfo> userInfos = sysUserInfoMapper.queryListByCondition(new SysUserInfo(sysUserInfo.getCid()));
			for (SysDict sd : dicts) {
				if (sd.getValue().equals(sysUserInfo.getPost().trim())) {
					sysUserInfo.setPost(sd.getKey());
					break;
				}
			}
			if (!ListUtils.isEmpty(userInfos)) {
				//已存在，则更新信息
				SysUserInfo oldInfo = userInfos.get(0);
				sysUserInfo.setUserId(oldInfo.getUserId());
				BeanUtils.copyProperties(sysUserInfo, oldInfo);
				sysUserInfo = oldInfo;
				sysUserInfoMapper.updateNotNull(sysUserInfo);
				//修改极光上的用户信息
				//String nickname, String birthday, String signature, int gender, String region, String address, String avatar
			}else {
				//不存在，则添加
				String userId = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
				sysUserInfo.setUserId(userId);
				JsonResult result = addUserInfo(sysUserInfo);
				if (!result.isSuccess()) {
					throw new Exception("新增用户信息错误");
				}

				RegisterInfo registerInfo = RegisterInfo.newBuilder().setUsername(userId).setPassword("1234").build();
				ResponseWrapper response = userClient.registerAdmins(registerInfo);
				if (!response.isServerResponse()){
					log.error("极光注册用户失败",response);
					throw new Exception("新增用户信息错误");
				}
			}
			//更新极光上用户的信息
			UserPayload userPayload = UserPayload.newBuilder().setAddress(sysUserInfo.getAddress()).setBirthday(DateUtil.getDateTime(sysUserInfo.getBirth()))
					.setNickname(sysUserInfo.getUserName()).build();
			ResponseWrapper response = userClient.updateUserInfo(sysUserInfo.getUserId(), userPayload);
			if (!response.isServerResponse()){
				log.error("极光注册用户失败",response);
				throw new Exception("更新用户信息错误");
			}

			//更新或者新增账号sysUser
			sysUser.setCreateUserId("admin");
			sysUser.setUserPwd("1234");
			sysUser.setUserId(sysUserInfo.getUserId());
			
			JsonResult jsonResult = editUser(sysUser);
			
			if (!jsonResult.isSuccess()) {
				throw new Exception("新增用户信息错误");
			}
			sysUser.setId((String)jsonResult.getData());
			
			//默认角色
			SysRole role = null;
			if (StringUtils.isNotBlank(sysUser.getRoleName())) {
				role = sysRoleMapper.findRoleByRoleName(sysUser.getRoleName());
			}
			if(role==null){
				role = sysRoleMapper.findRoleByRoleName("单位普通权限");
			}
			//已存在的用户，不重新新增角色
			if (role!=null && StringUtils.isNotBlank(sysUser.getId())) {
				SysUserRole sysUserRole = new SysUserRole();
			    sysUserRole.setUserId(sysUser.getId());
			    sysUserRole.setRoleId(role.getId());
			    roleList.add(sysUserRole);
			}
		}
		if (!ListUtils.isEmpty(roleList)) {
			sysUserMapper.insertSysUserRoleList(roleList);
		}
		return JsonResultUtil.success();
	}
	
	
	public JsonResult editUser(SysUser user) throws Exception{
		String id = "";
		SysUser oldUser = sysUserMapper.findSysUserByUserName(user.getUserName());
		if (oldUser!=null){
			user.setId(oldUser.getId());
			sysUserMapper.updateSysUserById(user);
		}else{
			id = appendSysUser(user);
		}
		if ("error".equals(id)) {
			id = "";
		}
		return JsonResultUtil.success(id); 
		
	}

	@Override
	public SysUserInfo getUserInfoByUserId(String userId) {
		return sysUserInfoMapper.selectByKey(userId);
	}

	@Override
	public JsonResult editUserInfo(SysUserInfo userInfo) {
		SysUserInfo oldSysUserInfo = sysUserInfoMapper.selectByKey(userInfo.getUserId());
		if (oldSysUserInfo==null) {
			return JsonResultUtil.error("该用户不存在，请刷新页面再试");
		}
		
		if(!oldSysUserInfo.getCid().equals(userInfo.getCid())){
			int count = sysUserInfoMapper.queryCountByCondition(new SysUserInfo(userInfo.getCid()));
			if(count > 0){
				return JsonResultUtil.error("身份证号已存在,请重新输入");
			}
		}
		sysUserInfoMapper.update(userInfo);

		//更新极光上用户的信息
		try {
			UserPayload userPayload = UserPayload.newBuilder().setAddress(userInfo.getAddress()).setBirthday(DateUtil.getDateTime(userInfo.getBirth()))
                    .setNickname(userInfo.getUserName()).build();
			ResponseWrapper response = userClient.updateUserInfo(userInfo.getUserId(), userPayload);
			if (!response.isServerResponse()){
                log.error("极光修改用户失败",response);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delUserInfo(String userId) throws Exception{
		
		sysUserInfoMapper.deleteByKey(userId);
		sysUserMapper.updateByUserId(userId);
	}

	@Override
	public List<Map<String, Object>> getReceiverList(Map<String, List<String>> param) {
		List<Map<String, Object>> list = sysUserMapper.getReceiverList(param);
		return list;
	}


	public List<SysUserInfo> getUserInfoByIds(List<Object> ids){
		return sysUserInfoMapper.findByIds(ids);
	}

}
