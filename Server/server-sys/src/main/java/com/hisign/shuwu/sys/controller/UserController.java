package com.hisign.shuwu.sys.controller;


import com.hisign.shuwu.common.constant.Constants;
import com.hisign.shuwu.common.model.JsonResult;
import com.hisign.shuwu.common.util.*;
import com.hisign.shuwu.sys.api.model.SysRole;
import com.hisign.shuwu.sys.api.model.SysUser;
import com.hisign.shuwu.sys.api.model.SysUserInfo;
import com.hisign.shuwu.sys.api.model.SysUserRole;
import com.hisign.shuwu.sys.api.service.SysRoleService;
import com.hisign.shuwu.sys.api.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/user")
@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     * 用户信息接口
     */
    @Resource
    private SysUserService sysUserService;
    /**
     * 角色管理接口
     */
    @Resource
    private SysRoleService sysRoleService;
    
    
    /**
     * 获得登录用户管理列表数据
     *
     * @param filter
     * @return
     * @	
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getSysUserList(@RequestBody SysUser filter) {
        try {
            logger.info("获取登录用户列表");
            if (!StringUtils.isEmpty(filter.getUserName())) {
                filter.setUserName(filter.getUserName().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
            }
            if (!StringUtils.isEmpty(filter.getTrueName())) {
                filter.setTrueName(filter.getTrueName().replaceAll("%", "\\\\%").replaceAll("_", "\\\\_"));
            }
            List<SysUser> list = sysUserService.findSysUserListByUserFilter(filter);
            int count = sysUserService.findSysUserListByFilterForCount(filter);
            
            return JsonResultUtil.success(count, list);
        } catch (Exception e) {
            logger.error("获取登录用户列表失败", e);
            return JsonResultUtil.error("获取登录用户列表失败！");
        }
    }
    

    /**
     * 删除登录用户
     *
     * @param user
     * @return
     * @
     */
    @RequestMapping(value = "/{userId}/delete", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult deleteSysUserList(@PathVariable String userId)  {
        try {
            logger.info("删除id为[{}]的登录用户", userId);
            sysUserService.deleteSysUserById(userId);
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("删除id为[{}]的登录用户失败", userId, e);
            return JsonResultUtil.error("删除登录用户失败！");
        }
    }

    /**
     * 查看登录用户
     *
     * @param id 用户编号
     * @return 登录用户
     * @
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult findSysUser(@RequestParam(value = "id", required = true) String id)  {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        try {
            logger.info("查看id为[{}]的登录用户", id);
            return JsonResultUtil.success(sysUserService.findSysUserById(id));
        } catch (Exception e) {
            logger.error("查看id为[{}]的登录用户失败", id, e);
            return JsonResultUtil.error("查看登录用户失败！");
        }
    }

    /**
     * 获得登录用户编辑数据
     *
     * @param id
     * @return
     * @
     */
    @RequestMapping(value = "/_edit", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> intoSysUserEdit(@RequestParam(value = "id", required = true) String id) {
        Map<String, Object> maps = new HashMap<String, Object>();
        try {
            logger.info("获得id为[{}]的登录用户修改信息", id);
            SysRole sysRoleFilter = new SysRole();
            sysRoleFilter.setOpenFlag("1");
            List<SysRole> roleList = sysRoleService.findSysRoleByFilter(sysRoleFilter);
            SysUser filter = new SysUser();
            filter.setId(id);
            filter.setOpenFlag("1");
            List<SysUser> userRolelist = sysUserService.findSysUserRoleListByFilter(filter);
            String sysUserRoleIds = "";
            if (userRolelist != null && userRolelist.size() > 0) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < userRolelist.size(); i++) {
                    SysUser sysUser = userRolelist.get(i);
                    if (i == 0) {
                        sb.append(sysUser.getRoleId());
                    } else {
                        sb.append(",");
                        sb.append(sysUser.getRoleId());
                    }
                }
                sysUserRoleIds = sb.toString();
            }
            SysUser sysUser = sysUserService.findSysUserById(id);
            sysUser.setUserPwd("");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("roleList", roleList);
            map.put("sysUserRoleIds", sysUserRoleIds);
            map.put("sysUser", sysUser);
            maps.put("data", map);
            maps.put("flag", 1);
            return maps;
        } catch (Exception e) {
            logger.error("获得id为[{}]的登录用户修改信息失败", id, e);
            maps.put("flag", 0);
            maps.put("msg", "获得登录用户修改信息失败！");
            return maps;
        }
    }

    /**
     * 用户管理修改
     *
     * @param user
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult submitSysUserEdit(@RequestBody SysUser sysUser) {
        try {
            logger.info("修改id为[{}]的登录用户信息", sysUser.getId());
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(sysUser.getId());
            sysUserRole.setSysUserRoleIds(sysUser.getSysUserRoleIds());
            sysUserService.updateSysUser(sysUser);
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("修改id为[{}]的登录用户信息失败", sysUser.getId(), e);
            return JsonResultUtil.error("修改登录用户信息失败！");
        }
    }

    /**
     * 用户管理新增
     *
     * @param user
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> submitSysUserSave(@RequestBody SysUser sysUser) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            logger.info("新增用户名为[{}]的登录用户信息", sysUser.getUserName());
            String id = sysUserService.appendSysUser(sysUser);
            if ("error".equals(id)) {
                map.put("flag", 0);
                map.put("msg", "用户账号已存在，请重新输入！");
                return map;
            }
            map.put("id", id);
            map.put("flag", 1);
            return map;
        } catch (Exception e) {
            logger.error("新增用户名为[{}]的登录用户信息失败", sysUser.getUserName(), e);
            map.put("flag", 0);
            map.put("msg", "用户新增失败，请联系开发人员或管理员!");
            return map;
        }
    }

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param newPassword
     * @param user
     * @return
     */
    @RequestMapping(value = "/password", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult editPassword(@RequestBody SysUser user) {
        try {
            logger.info("修改用户名为[{}]的用户密码", user.getUserName());
            SysUser oldUser = sysUserService.findSysUserById(user.getId());
            if (!Md5Helper.getMD5(user.getUserPwd()).equals(oldUser.getUserPwd())) {
                return JsonResultUtil.error("原密码错误,请重新输入！");
            }
            user.setNewPassword(Md5Helper.getMD5(user.getNewPassword()));
            sysUserService.updatePassword(user);
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("修改用户名为[{}]的用户密码失败", user.getUserName(), e);
            return JsonResultUtil.error("修改密码失败，请联系开发人员或管理员!");
        }
    }

    /**
     * 根据token获得用户信息
     *
     * @param token token编号
     * @return 用户信息
     * @
     */
    @RequestMapping(value = "/token_info", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getUserByToken(@RequestParam(value = "token", required = true) String token)  {
        logger.info("根据token获得用户信息", token);
        try {
            SysUser sysUser = sysUserService.getUserByToken(token);

            return JsonResultUtil.success(sysUser);
        } catch (Exception e) {
            logger.error("根据token获得用户信息失败", token, e);
            return JsonResultUtil.error("根据token获得用户信息失败");
        }
    }
    
    @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addUserInfo(@RequestBody SysUserInfo param)  {
        try {
        	return  sysUserService.addUserInfo(param);
        } catch (Exception e) {
            logger.error("新增人员信息失败", e);
            return JsonResultUtil.error("新增人员信息失败！");
        }
    }
    
    @RequestMapping(value = "/editUserInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult editUserInfo(@RequestBody SysUserInfo param)  {
        try {
        	return  sysUserService.editUserInfo(param);
        } catch (Exception e) {
            logger.error("修改人员信息失败", e);
            return JsonResultUtil.error("修改人员信息失败！");
        }
    }
    
    @RequestMapping(value = "/getUserInfoListByOrgId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getUserInfoListByOrgId(@RequestBody SysUserInfo param)  {
        try {
        	List<SysUserInfo> list = sysUserService.getUserInfoListByCondition(param);
        	int count = sysUserService.getUserInfoCountByCondition(param);
            return JsonResultUtil.success(count,list);
        } catch (Exception e) {
            logger.error("获取用户信息失败", e);
            return JsonResultUtil.error("获取用户信息失败");
        }
    }
    
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getUserInfo(@RequestParam String userId)  {
        try {
        	SysUserInfo sysUserInfo = sysUserService.getUserInfoByUserId(userId);
            return JsonResultUtil.success(sysUserInfo);
        } catch (Exception e) {
            logger.error("获取用户信息失败", e);
            return JsonResultUtil.error("获取用户信息失败");
        }
    }
    
    @RequestMapping(value = "/{userId}/delUserInfo", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delUserInfo(@PathVariable String userId)  {
        try {
        	sysUserService.delUserInfo(userId);
            return JsonResultUtil.success();
        } catch (Exception e) {
            logger.error("删除失败", e);
            return JsonResultUtil.error("删除失败");
        }
    }
    
    @RequestMapping(value = "/choosePerson", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult choosePerson(@RequestBody SysUserInfo param)  {
        try {
        	param.setIsChoose(1);
        	List<SysUserInfo> list = sysUserService.getUserInfoListByCondition(param);
        	if (ListUtils.isEmpty(list)) {
				list = new ArrayList<SysUserInfo>();
			}
        	int count = sysUserService.getUserInfoCountByCondition(param);
            return JsonResultUtil.success(count,list);
        } catch (Exception e) {
            logger.error("获取用户信息失败", e);
            return JsonResultUtil.error("获取用户信息失败");
        }
    }
    
    /**
     * 类名: UserController.java
     * 描述: 人员信息导入
     * 公司: 北京海鑫科金高科技股份有限公司
     * 作者: 何建辉
     * 版本: 
     * 创建时间: 2017年4月28日
     * 最后修改时间: 2017年4月28日
     */
    @SuppressWarnings("deprecation")
	@RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public JsonResult importExcel(@RequestParam("file")MultipartFile file)  {
        try {
        	if (file.isEmpty()) {
        		return JsonResultUtil.error("请选择文件上传");
			}
        	String originalFilename = file.getOriginalFilename();
        	
        	List<List<String>> list = ExcelUtils.excel2List(originalFilename, file.getInputStream());
        	if (list==null || list.size()<1) {
        		return JsonResultUtil.error("文件中不包含有效内容，请按照格式填写");
			}
        	
        	List<SysUserInfo> userList = new ArrayList<SysUserInfo>();
        	for (List<String> li : list) {
        		SysUserInfo info = new SysUserInfo();
        		SysUser user = new SysUser();
        		if (li.size()>=8) {
        			info.setSuperId(li.get(0));//上级机构名称需要转id
        			info.setOrgName(li.get(1));//需要转成机构id
        			String name = li.get(2).replace(" ", "");
					info.setUserName(name);
					String sexs = li.get(3);
					int sex = 1;
					if ("男".equals(sexs)) {
						sex = 1;
					}else if ("女".equals(sexs)) {
						sex = 2;
					}else {
						sex = 3;
					}
					info.setSex(sex);
					info.setCid(li.get(5));
					info.setPhone(li.get(6));
					info.setPost(li.get(7));
					info.setStatus(Constants.UserInfoStatus.NORMAL);
					//生日
					if (!StringUtils.isEmpty(info.getCid())) {
						String cid = info.getCid();
						cid = cid.substring(6, 14);
						int year = Integer.valueOf(cid.substring(0, 4));
						int month = Integer.valueOf(cid.substring(4, 6));
						int day = Integer.valueOf(cid.substring(6));
						Date date = new Date(year, month, day);
						info.setBirth(date);
					}
					
					//分配账号
					user.setUserName(li.get(4));//警号作为账号
					if (StringUtils.isEmpty(li.get(4))) {
						//用姓名小写作为警号
						user.setUserName(PingYinUtil.getPingYin(li.get(2)));
					}
					user.setPoliceId(li.get(4));//警号
					user.setTrueName(name);//真是姓名
					user.setCreateUser("超级管理员");
					user.setRoleName(li.get(8));
					user.setUserLevel("1");
					user.setOpenFlag("1");
					user.setDefaultModule("0");
					
					info.setUser(user);
					userList.add(info);
				}
			}
        	return sysUserService.addUserInfoList(userList);
        } catch (Exception e) {
            logger.error("导入文件失败，请稍后再试", e);
            return JsonResultUtil.error("导入文件失败，请稍后再试");
        }
    }
    
}
