package com.hisign.xingzhen.xz.test.rest;

import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.param.SysUserInfoParam;
import com.hisign.xingzhen.xz.test.BaseTestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *@Author: 何建辉
 *@Description: 专案组单元测试
 *@Date: 2017/10/27 11:38
 *@Email: hejianhui@hisign.com.cn
 */
public class UserGroupRestTest extends BaseTestCase{

    private Logger log = LoggerFactory.getLogger(UserGroupRestTest.class);

    private static final String prefix = "/xz/usergroup/";

    //关联组内成员
    private static final String addUserGroupList = prefix + "addUserGroupList";
    //移除组内成员
    private static final String deleteUsergroupList = prefix + "deleteUsergroupList";
    //用户列表/组内成员列表
    private static final String getUsergroupPage = prefix + "getUsergroupPage";
    //首页成果详情-获取所有组内成员
    private static final String getGroupMemberList = prefix + "getGroupMemberList";

    /**
     *@Author: 何建辉
     *@Description: 首页成果详情-获取所有组内成员
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void getGroupMemberList() throws Exception {

        String result = mockMvc.perform(post(getGroupMemberList)
                .contentType(MediaType.APPLICATION_JSON_UTF8).param("groupId","5C80EF4519A48005E050A8C052012B71"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

    /**
     *@Author: 何建辉
     *@Description: 用户列表/组内成员列表
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void getUsergroupPage() throws Exception {
        SysUserInfoParam param = new SysUserInfoParam();
        param.setGroupId("5C80EF4519A48005E050A8C052012B71");
        param.setUserName("陈勇平");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(param);

        String result = mockMvc.perform(post(getUsergroupPage)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

    /**
     *@Author: 何建辉
     *@Description: 移除组内成员
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void deleteUsergroupList() throws Exception {
        ArrayList<Usergroup> list = new ArrayList<>();
        Usergroup usergroup = new Usergroup();
        usergroup.setId("");
        usergroup.setGroupid("5C80EF4519A48005E050A8C052012B71");
        usergroup.setUserid("1885A61F3EA34703974C6287FD60F9D5");
        usergroup.setCreator("1234");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);

        String result = mockMvc.perform(post(deleteUsergroupList)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

    /**
     *@Author: 何建辉
     *@Description: 关联组内成员
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void addUserGroupList() throws Exception {
        ArrayList<Usergroup> list = new ArrayList<>();
        Usergroup usergroup = new Usergroup();
        usergroup.setGroupid("5C80EF4519A48005E050A8C052012B71");
        usergroup.setJh("123456");
        usergroup.setUserid("BCF38C3F04DB446AB477B4E7BF0D8C03");
        usergroup.setCreator("1234");
        usergroup.setUsername("石远昆");
        usergroup.setDeparmentcode("440000190404");

        list.add(usergroup);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);

        String result = mockMvc.perform(post(addUserGroupList)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

}
