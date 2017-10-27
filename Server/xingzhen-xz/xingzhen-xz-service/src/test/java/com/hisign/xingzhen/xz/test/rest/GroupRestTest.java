package com.hisign.xingzhen.xz.test.rest;

import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.param.GroupParam;
import com.hisign.xingzhen.xz.test.BaseTestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *@Author: 何建辉
 *@Description: 专案组单元测试
 *@Date: 2017/10/27 11:38
 *@Email: hejianhui@hisign.com.cn
 */
public class GroupRestTest extends BaseTestCase{

    private Logger log = LoggerFactory.getLogger(GroupRestTest.class);

    private static final String prefix = "/xz/group/";

    //添加专案组
    private static final String addGroup = prefix + "addGroup";
    //专案组查询分页
    private static final String getGroupPage = prefix + "getGroupPage";
    //查询子专案组列表
    private static final String getChildGroupList = prefix + "getChildGroupList";
    //查看专案组详情
    private static final String groupDetail = prefix + "groupDetail/{id}";
    //获取所有专案组根据用户id
    private static final String getAllGroupByUserId = prefix + "getAllGroupByUserId";


    /**
     *@Author: 何建辉
     *@Description: 添加专案组
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void addGroup() throws Exception {

        Group group = new Group();
        group.setPgroupid("5C80EF4519A48005E050A8C052012B71");
        group.setGroupname("1027测试专案组");
        group.setCreator("1234");
        group.setDeparmentcode("123456789123");
        group.setGrouptype("1");
        group.setUserId("1234");
        group.setCreatename("哈哈");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(group);

        String result = mockMvc.perform(post(addGroup)
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
     *@Description: 获取所有专案组根据用户id
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void getAllGroupByUserId() throws Exception {
        String result = mockMvc.perform(post(getAllGroupByUserId)
                .contentType(MediaType.APPLICATION_JSON_UTF8).param("userId","1234"))
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
     *@Description: 查询子专案组列表
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void groupDetail() throws Exception {
        String result = mockMvc.perform(post(groupDetail,"5C80EF4519A48005E050A8C052012B71")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

    /**
     *@Author: 何建辉
     *@Description: 查询子专案组列表
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void getChildGroupList() throws Exception {
        String result = mockMvc.perform(post(getChildGroupList)
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
     *@Description: 专案组查询分页
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void getGroupPage() throws Exception {

        GroupParam group = new GroupParam();
        group.setGroupname("1027测试专案组");
        group.setCreator("1234");
        group.setDeparmentcode("123456789123");
        group.setUserId("1234");
        group.setGroupnum("ZAZ");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(group);

        String result = mockMvc.perform(post(getGroupPage)
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
