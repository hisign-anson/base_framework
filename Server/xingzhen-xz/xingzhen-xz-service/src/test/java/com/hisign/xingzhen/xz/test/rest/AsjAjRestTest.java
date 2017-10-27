package com.hisign.xingzhen.xz.test.rest;

import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.param.AsjAjParam;
import com.hisign.xingzhen.xz.api.param.GroupParam;
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
 *@Description: 案件 单元测试
 *@Date: 2017/10/27 11:38
 *@Email: hejianhui@hisign.com.cn
 */
public class AsjAjRestTest extends BaseTestCase{

    private Logger log = LoggerFactory.getLogger(AsjAjRestTest.class);

    private static final String prefix = "/xz/asjAj/";

    //所有案件查询分页
    private static final String getAjPage = prefix + "getAjPage";
    //组内涉及案件分页
    private static final String getAjGroupPage = prefix + "getAjGroupPage";


    /**
     *@Author: 何建辉
     *@Description: 组内涉及案件分页
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void getAjGroupPage() throws Exception {
        AsjAjParam param = new AsjAjParam();
        param.setEnd(60);
        param.setGroupId("5C80EF4519A48005E050A8C052012B71");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(param);

        String result = mockMvc.perform(post(getAjGroupPage)
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
     *@Description: 所有案件查询分页
     *@Date: 2017/10/27 11:39
     *@Email: hejianhui@hisign.com.cn
     */
    @Test
    @Rollback(true)
    public void getAjPage() throws Exception {
        AsjAjParam param = new AsjAjParam();
        param.setEnd(60);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(param);

        String result = mockMvc.perform(post(getAjPage)
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
