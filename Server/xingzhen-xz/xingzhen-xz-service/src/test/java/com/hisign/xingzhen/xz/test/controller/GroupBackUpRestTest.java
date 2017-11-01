package com.hisign.xingzhen.xz.test.controller;

import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.param.GroupBackupParam;
import com.hisign.xingzhen.xz.test.BaseTestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *@Author: 何建辉
 *@Description: 专案组归档单元测试
 *@Date: 2017/10/27 11:38
 *@Email: hejianhui@hisign.com.cn
 */
public class GroupBackUpRestTest extends BaseTestCase{

    private Logger log = LoggerFactory.getLogger(GroupBackUpRestTest.class);

    private static final String prefix = "/xz/groupBackup/";

    //归档
    private static final String add = prefix + "backup";

    /**
     *@Author: 何建辉
     *@Description: 添加专案组
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void addGroup() throws Exception {

        GroupBackupParam groupBackup = new GroupBackupParam();
        groupBackup.setBackupReason("1");
        groupBackup.setCreator("1234");
        groupBackup.setBackupStatus("1");
        groupBackup.setDeparmentcode("123456789123");
        groupBackup.setGroupid("5C80EF4519A48005E050A8C052012B71");
        groupBackup.setPoliceId("12345");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(groupBackup);

        String result = mockMvc.perform(post(add)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }
}
