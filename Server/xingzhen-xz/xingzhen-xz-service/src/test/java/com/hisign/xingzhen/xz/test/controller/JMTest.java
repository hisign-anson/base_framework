package com.hisign.xingzhen.xz.test.controller;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.common.model.RegisterPayload;
import cn.jmessage.api.common.model.message.MessageBody;
import cn.jmessage.api.common.model.message.MessagePayload;
import cn.jmessage.api.group.CreateGroupResult;
import cn.jmessage.api.group.GroupInfoResult;
import cn.jmessage.api.message.MessageType;
import cn.jmessage.api.message.SendMessageResult;
import cn.jmessage.api.user.UserClient;
import cn.jmessage.api.user.UserInfoResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.ListUtils;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.xz.api.service.GroupService;
import com.hisign.xingzhen.xz.api.service.UsergroupService;
import com.hisign.xingzhen.xz.test.BaseTestCase;
import com.netflix.discovery.converters.Auto;
import io.netty.util.Constant;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 11:55 2017/10/27
 */
public class JMTest extends BaseTestCase{

    private Logger log = LoggerFactory.getLogger(JMTest.class);

    private final String appkey="a15c1e9bb38c1607b9571eea";
    private final String masterSecret="bd4d826e1e49340aac2d05e2";

    @Resource(name="groupService")
    private GroupService groupService;

    @Resource(name="usergroupService")
    private UsergroupService usergroupService;



//    @Autowired
//    private SysUserService sysUserService;


    @Test
    public void testCreateGroup() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            Conditions con = new Conditions(Group.class);
            con.setLimit(0,Integer.MAX_VALUE);
            List<GroupModel> list = groupService.getList(con);

            for (GroupModel groupModel : list) {
                Usergroup usergroup = new Usergroup();
                usergroup.setGroupid(groupModel.getId());
                JsonResult jsonResult = usergroupService.getListByEntity(usergroup);
                if (jsonResult.isSuccess()){
                    List<UsergroupModel> userGroupList = (List<UsergroupModel>) jsonResult.getData();
                    List<String> arr = new ArrayList<>();
                    for (UsergroupModel usergroupModel : userGroupList) {
                        arr.add(usergroupModel.getUserid());
                    }
                    CreateGroupResult result = client.createGroup(groupModel.getCreator(), groupModel.getGroupname(), groupModel.getId(), ListUtils.list2Array(arr));
                    if (!result.isResultOK()){
                        log.error(result.toString());
                    }else {
                        Group group = new Group();
                        BeanUtils.copyProperties(groupModel,group);
                        group.setJmgid(result.getGid().toString());
                        groupService.update(group);
                    }
                }
            }

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
            RegisterInfo info = RegisterInfo.newBuilder().setPassword(Constants.JM_PASSWORD).setUsername("1FF443B790E44DD0B705546834BA07BD").build();
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

    @Test
    public void testSendMsg() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            String content = "{\"groupId\":\"99149c54-dcd8-4996-a8e4-cb9f7f550363\",\"title\":\"关联案件\",\"msgType\":\"send_connect_case_info\",\"createName\":\"超级管理员\",\"creator\":\"88021FFBD7AQ4836870F189A0C813934\",\"caseName\":\"于水被故意损毁财物\"}";
            MessageBody body = MessageBody.newBuilder().setText(content).build();
            MessagePayload payload = MessagePayload.newBuilder().setVersion(Constants.JM_VERSION)
                    .setTargetType("group")
                    .setFromType(Constants.JM_FROM_TYPE_ADMIN)
                    .setMessageType(MessageType.CUSTOM)
                    .setTargetId("23378051")
                    .setFromId("88021FFBD7AQ4836870F189A0C813934")
                    .setMessageBody(body)
                    .build();

            SendMessageResult sendMessageResult = client.sendMessage(payload);
            log.info(sendMessageResult.toString());
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        }
    }

    @Test
    public void testGetGroup() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            GroupInfoResult groupInfo = client.getGroupInfo(23377541);
            log.info(groupInfo.toString());
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
