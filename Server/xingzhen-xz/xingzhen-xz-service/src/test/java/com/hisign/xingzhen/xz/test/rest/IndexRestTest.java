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
public class IndexRestTest extends BaseTestCase {

    private Logger log = LoggerFactory.getLogger(IndexRestTest.class);

    private static final String prefix = "/xz/index/";

    //待办任务
    private static final String getTaskCountInfo = prefix + "getTaskCountInfo";
    //平台成果展示
    private static final String getAchievement = prefix + "getAchievement";
    //专案组破案情况
    private static final String getSolveCaseInfo = prefix + "getSolveCaseInfo";
    //专案组创建情况
    private static final String getCreateInfo = prefix + "getCreateInfo";


    @Test
    public void getTaskCountInfo() throws Exception {
        ResultActions resultActions = mockMvc.perform(post(getTaskCountInfo)
                .contentType(MediaType.APPLICATION_JSON_UTF8).requestAttr("userId", "123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()));
        log.info("结果：",resultActions);
    }

    @Test
    public void getAchievement() throws Exception {
        ResultActions resultActions = mockMvc.perform(post(getAchievement)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()));
        log.info("结果：",resultActions);
    }

    @Test
    public void getSolveCaseInfo() throws Exception {
        ResultActions resultActions = mockMvc.perform(post(getSolveCaseInfo)
                .contentType(MediaType.APPLICATION_JSON_UTF8).requestAttr("dateType", "0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()));
        log.info("结果：",resultActions);
    }

    @Test
    public void getCreateInfo() throws Exception {
        ResultActions resultActions = mockMvc.perform(post(getCreateInfo)
                .contentType(MediaType.APPLICATION_JSON_UTF8).requestAttr("dateType", "0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.flag", is(1)))
                .andExpect(jsonPath("$.data", notNullValue()));
        log.info("结果：",resultActions);
    }

}
