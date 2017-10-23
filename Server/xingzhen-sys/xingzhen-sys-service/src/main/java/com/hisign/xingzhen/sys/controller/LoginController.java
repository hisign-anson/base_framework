package com.hisign.xingzhen.sys.controller;

import com.google.common.collect.Maps;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.common.util.Md5Helper;
import com.hisign.xingzhen.common.util.RsaHelper;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.sys.api.model.*;
import com.hisign.xingzhen.sys.api.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author lqf
 * @Date 2017年3月30日
 */
@Api(description = "登录")
@RestController
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysModuleService sysModuleService;


    @Resource
    private SysDictService sysDictService;
    
    @Resource
    private SysLogService sysLogService;
    @Resource
    private SysParameterService sysParameterService;

    /**
     * 用户登录
     * @param user 用户对象
     * @param request 请求对象
     * @return
     */
    @ApiOperation(value = "用户登录",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult login(@RequestBody SysUser user, HttpServletRequest request) {
        JsonResult result = new JsonResult();
        result.setFlag(1);
        boolean loginFlag = false;
        String msg = "";
        String username = user.getUserName();
        String password = user.getUserPwd();
        try {
            logger.info("对用户[{}]进行登录验证..验证开始", username);
            SysUser sysUser = sysUserService.findSysUserByUserName(username);
            if (null == sysUser || (password != null && !StringUtils.equals(sysUser.getUserPwd(), Md5Helper.getMD5(password)))) {
                logger.info("对用户[{}]进行登录验证..验证未通过,用户名或密码错误", username);
                if("".equals(username)&&"".equals(password)) {
                    msg = "请输入用户名和密码！";
                }else if("".equals(username)){
                    msg = "请输入用户名！";
                }else if("".equals(password)){
                    msg = "请输入密码！";
                }else{
                    msg = "用户名或密码不正确，请重新输入！";
                }
            } else {
            	if(sysUser.getUserInfo() == null){
            		msg = "该账号未激活，请联系管理员激活账号！";
            	}else if (!"1".equals(sysUser.getOpenFlag())) {
            		msg = "该账号已被禁用，请联系管理员解禁账号！";
				}else{
            		loginFlag = true;
                    String tokenId = sysUserService.addUserToken(sysUser.getId());//添加token和用户id的关联
                    result = searchUserLimt(sysUser, tokenId);
                    sysUser.setIpAddress(this.getIpAddress(request));
                    sysLogService.insertLogUserInfo(sysUser);	
            	}
            }
        }catch(Exception ae){
            logger.error("对用户[{}]进行登录验证..验证未通过,堆栈轨迹如下", username, ae);
            msg = "无法成功登录";
        }
        //验证是否登录成功
        if(loginFlag){
            logger.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
        }else{
            result.setMsg(msg);
        }
        return result;
    }

    /**
     * 注销
    **/
    @ApiOperation(value = "注销",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/logout", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult logout(HttpServletRequest request) {
        JsonResult result = new JsonResult();
        String token = null;
        try {
            sysUserService.logout(request.getHeader(Constants.TOKEN));
            result.setFlag(1);
        } catch (Exception e) {
            logger.error("logout delete token error!token:{}", token, e);
            result.setFlag(0);
            result.setMsg("删除token出错！");
        }
        return result;
    }

    /**
     * 初始化系统标题参数
     * @return
     */
    @ApiOperation(value = "初始化系统标题参数",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/sys/dict/GXSDM",method=RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult initDictForGXSDM(@RequestParam String userUnit) {
        JsonResult result = new JsonResult();
        try {
            List<SysCommonDict> list = sysDictService.initDictForGXSDM(userUnit);
            result.setData(list);
            result.setFlag(1);
        } catch (Exception e) {
            result.setFlag(0);
            result.setMsg("获取系统参数配置出错");
            logger.error("获取系统参数配置出错", e);
        }
        return result;
    }

    /**
     * 获取登录用户的模块权限
     * @author xiaohuwien
     * @param user 登录用户对象
     * @return
     */
    @SuppressWarnings("deprecation")
	public JsonResult searchUserLimt(SysUser user,String tokenId) {
        JsonResult jsonResult = new JsonResult();
        List<SysModule> parentList = new ArrayList<SysModule>();//父id
        List<SysModule> childList = new ArrayList<SysModule>();//子id
        List<SysModule> pageLimit = new ArrayList<SysModule>();//页面权限
        List<SysModule> childNodeList = new ArrayList<SysModule>();//页面子权限
        Index indexParam = new Index();
        Map<String,List<SysModule>> tempMap = new HashMap<String,List<SysModule>>();
        try {
            List<SysModule> list = sysModuleService.findLogUserPower(user.getUserName());//查询所有页面权限
            for(int i=0 ; i<list.size();i++){
                if(null==list.get(i).getParentId()){
                    parentList.add(list.get(i));
                }else{
                    childList.add(list.get(i));
                }
            }
            for (int i=0;i<childList.size();i++){
                for(int j=0;j<childList.size();j++){
                    if(childList.get(i).getModuleId().equals(childList.get(j).getParentId())){
                        childNodeList.add(childList.get(j));
                        childList.remove(j);
                        i=0;
                        j=0;
                        break;
                    }
                }
            }
            Map<String,List<SysModule>> lists = Maps.newHashMap();
            lists.put("parentList",parentList);
            lists.put("childList",childList);
            lists.put("childNodeList",childNodeList);
            pageLimit = sysModuleService.toolsForList(lists);//拼接List
            List<SysModule> operateLimit = sysModuleService.findLogUserPowerLimt(user.getUserName());//查询所有操作权限
            List<Map<String,String>> roleList = searchUserRole(user);//获取用户角色中文
            tempMap.put("pages",pageLimit);
            tempMap.put("operates",operateLimit);
            indexParam.setToken(tokenId);//接口id
            indexParam.setLimits(tempMap);//全部页面权限
            indexParam.setRoles(roleList);//用户角色

            indexParam.setCurrentUser(user);
            SysParam sysParam = sysParameterService.getParamByName("FTPServer");
            if( sysParam != null){
            	indexParam.setFtpServer(sysParam.getValue());
            }
            //加密后的用户名和密码
            String jstr = "{\"username\":'"+user.getUserName()+"', \"password\":'"+user.getUserPwd()+"'}";
            String clientKey = URLEncoder.encode(RsaHelper.encrypt4yzsb(RsaHelper.PUK4YZSB, jstr));
            indexParam.setClientKey(clientKey);
            jsonResult.setData(indexParam);
            jsonResult.setFlag(1);
        } catch (Exception e) {
            logger.error("获取登录用户[{}]模块权限出错",user.getUserName(),e);
            jsonResult.setFlag(0);
        }
        return jsonResult;
    }

    public List<Map<String,String>> searchUserRole(SysUser user) {
        Map<String,String> map = new HashMap<String,String>();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        List<Map<String,String>> resultRist = new ArrayList<Map<String,String>>();
        try {
            list = sysModuleService.findRoleList(user.getUserName());
            for(Map<String,String> tempMap:list){
                map = new HashMap<String,String>();
                map.put("cn",tempMap.get("ROLECN"));
                map.put("en",tempMap.get("ROLEEN"));
                map.put("ROLE_NO",tempMap.get("ROLE_NO"));
                resultRist.add(map);
            }
        } catch (Exception e) {
            logger.error("获取登录用户角色[{}]出错",user.getUserName(),e);
        }
        return resultRist;
    }


    /** 
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址, 
     * 
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？ 
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 
     * 
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 
     * 192.168.1.100 
     * 
     * 用户真实IP为： 192.168.1.110 
     * 
     * @param request 
     * @return 
     */
    private  String getIpAddress(HttpServletRequest request) {
      String ip = request.getHeader("x-forwarded-for"); 
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
        ip = request.getHeader("Proxy-Client-IP"); 
      } 
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
        ip = request.getHeader("WL-Proxy-Client-IP"); 
      } 
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
        ip = request.getHeader("HTTP_CLIENT_IP"); 
      } 
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
        ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
      } 
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
        ip = request.getRemoteAddr(); 
      } 
      return ip; 
    }
}
