package com.hisign.xingzhen.xz.test.rest;

import com.hisign.xingzhen.xz.test.BaseTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created with IntelliJ IDEA.
 * User: 刘玉兰
 * Date: 17-10-27
 * Time: 下午5:35
 * To change this template use File | Settings | File Templates.
 * 催办单元测试
 */
public class CbRestTest extends BaseTestCase {
    private Logger log = LoggerFactory.getLogger(CbRestTest.class);

    private static final String prefix = "/xz/cb/";

    //催办任务
    private static final String addCb = prefix + "addCb";

    /**
     *@Author: 刘玉兰
     *@Description: 催办任务
     *@Date: 2017/10/27 14:39
     */
    @Test
    @Rollback(true)
    public void addCb() throws Exception {
        String result = mockMvc.perform(get(addCb)
                .contentType(MediaType.APPLICATION_JSON_UTF8).param("taskid", "5C841FDFBC5EFB4AE050A8C052015CE9")
                .param("userId", "A086DFFAEE494F158F3C692A4ACC079F")
                .param("deparmentcode", "440000190101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }
}
