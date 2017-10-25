package com.hisign.xingzhen.sys.controller.app;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.common.util.IpUtil;
import com.hisign.xingzhen.common.util.Md5Helper;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.sys.api.model.LoginResponse;
import com.hisign.xingzhen.sys.api.model.SysUser;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysLogService;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import com.hisign.xingzhen.sys.controller.LoginController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hisign on 2017/10/24.
 */
@Api(description = "App登录")
@RestController
@RequestMapping("app")
public class AppLoginRest {

    private static final Logger logger = LoggerFactory.getLogger(AppLoginRest.class);

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysLogService sysLogService;

    @ApiOperation(value = "用户登录",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestParam String userName, @RequestParam String userPwd) {
        JsonResult result = new JsonResult();
        result.setFlag(1);
        boolean loginFlag = false;
        String msg = "";
        String username = userName;
        String password = userPwd;

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
                    //获取userinfo
                    SysUserInfo userInfo = sysUserService.getUserInfoByUserId(sysUser.getUserId());

                    LoginResponse loginResponse = new LoginResponse();
                    loginResponse.setAccount(sysUser.getUserName());
                    loginResponse.setUserId(sysUser.getUserId());
                    loginResponse.setToken(tokenId);
                    loginResponse.setUserInfo(userInfo);
                    loginResponse.setSysCode(userInfo.getOrgId());
                    loginResponse.setCreateDate(sysUser.getCreateDate());
                    result.setFlag(1);
                    result.setData(loginResponse);

                    sysUser.setIpAddress(IpUtil.getRemotIpAddr(BaseController.getRequest()));
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
}
