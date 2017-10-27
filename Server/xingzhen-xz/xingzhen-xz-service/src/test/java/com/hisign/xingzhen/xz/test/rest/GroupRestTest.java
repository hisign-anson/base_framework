package com.hisign.xingzhen.xz.test.rest;

import com.hisign.xingzhen.xz.test.BaseTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by hisign on 2017/10/27.
 */
public class GroupRestTest extends BaseTestCase{

    private Logger log = LoggerFactory.getLogger(GroupRestTest.class);

    private static final String prefix = "/xz/group/";

    //添加专案组
    private static final String addGroup = prefix + "addGroup";
    //专案组查询分页
    private static final String getGroupPage = prefix + "getGroupPage";
    //查询子专案组列表
    private static final String groupDetail = prefix + "groupDetail/{id}";
    //查看专案组详情
    private static final String getCreateInfo = prefix + "getCreateInfo";
    //获取所有专案组根据用户id
    private static final String getAllGroupByUserId = prefix + "getAllGroupByUserId";


    @Test
    public void getTaskCountInfo() throws Exception {
        ResultActions resultActions = mockMvc.perform(get(addGroup)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).param("userId", "123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()));
        log.info("结果：",resultActions.andReturn().getResponse().getOutputStream().toString());
    }
}
