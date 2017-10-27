package com.hisign.xingzhen.xz.test.rest;

import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.param.GroupParam;
import com.hisign.xingzhen.xz.test.BaseTestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *@Author: 何建辉
 *@Description: 案件专案组关联 单元测试
 *@Date: 2017/10/27 11:38
 *@Email: hejianhui@hisign.com.cn
 */
public class AjgroupRestTest extends BaseTestCase{

    private Logger log = LoggerFactory.getLogger(AjgroupRestTest.class);

    private static final String prefix = "/xz/ajgroup/";

    //关联案件列表
    private static final String addAjGroupList = prefix + "addAjGroupList";
    //移除案件
    private static final String removeAjGroupList = prefix + "removeAjGroupList";


    /**
     *@Author: 何建辉
     *@Description: 移除案件
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void removeAjGroupList() throws Exception {
        List<Ajgroup> list = new ArrayList<>();
        Ajgroup aj = new Ajgroup();
        aj.setId("2e9691f9-ea0a-4da8-bba6-144ac6effb85");
        list.add(aj);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);

        String result = mockMvc.perform(post(removeAjGroupList)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

    /**
     *@Author: 何建辉
     *@Description: 关联案件列表
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void addAjGroupList() throws Exception {
        List<Ajgroup> list = new ArrayList<>();
        Ajgroup aj = new Ajgroup();
        aj.setGroupid("5C80EF4519A48005E050A8C052012B71");
        aj.setAjbh("A4406085000002017090188");
        aj.setAjid("8aad021d5ea71a0b015ec0c1c4027287");
        aj.setCreator("1234");
        aj.setDeparmentcode("123456789123");
        list.add(aj);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);

        String result = mockMvc.perform(post(addAjGroupList)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

}
