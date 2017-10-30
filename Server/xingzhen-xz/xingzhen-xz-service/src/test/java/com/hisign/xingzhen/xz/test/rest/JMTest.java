package com.hisign.xingzhen.xz.test.rest;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.common.model.RegisterPayload;
import cn.jmessage.api.group.CreateGroupResult;
import cn.jmessage.api.user.UserClient;
import cn.jmessage.api.user.UserInfoResult;
import com.hisign.xingzhen.common.util.DateUtil;
import com.hisign.xingzhen.sys.api.model.SysUser;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import com.hisign.xingzhen.xz.test.BaseTestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 11:55 2017/10/27
 */
public class JMTest{

    private Logger log = LoggerFactory.getLogger(JMTest.class);

    private final String appkey="a15c1e9bb38c1607b9571eea";
    private final String masterSecret="bd4d826e1e49340aac2d05e2";

//    @Autowired
//    private SysUserService sysUserService;


    @Test
    public void testCreateGroup() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            CreateGroupResult result = client.createGroup("test_user", "test_gname1", "description", "test_user");

        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        }
    }

    @Test
    public void testCreateUser() {
        UserClient client = new UserClient(appkey, masterSecret);
        try {
            RegisterInfo info = RegisterInfo.newBuilder().setPassword("123456").setUsername("1FF443B790E44DD0B705546834BA07BD").build();
            RegisterPayload load = RegisterPayload.newBuilder().addUsers(info).build();
            client.registerUsers(load);
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        }
    }

    @Test
    public void testGetUser() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            UserInfoResult info = client.getUserInfo("0B57593C55F34514B1235C8AAB31AFD7");
            log.info(info.toString());
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        }
    }


    /*@Test
    public void addAllMember2JM() throws Exception {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setEnd(Integer.MAX_VALUE);
        List<SysUserInfo> list = sysUserService.getUserInfoListByCondition(sysUserInfo);
        RegisterInfo[] users = new RegisterInfo[list.size()];

        for (int i = 0; i < list.size(); i++) {
            SysUserInfo user = list.get(i);
            RegisterInfo info = RegisterInfo.newBuilder().setUsername(user.getUserId()).setPassword("123456").build();
            users[i]=info;
        }

        client.registerUsers(users);

        for (int i = 0; i < list.size(); i++) {
            SysUserInfo user = list.get(i);
            client.updateUserInfo(user.getUserId(),user.getUserName(), DateUtil.getDateTime(user.getBirth())
                    ,null,user.getSex(),user.getAddress(),user.getAddress());
        }

    }*/


}
