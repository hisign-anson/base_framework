package com.hisign.xingzhen.xz.test.rest;

import com.hisign.xingzhen.xz.api.param.TaskFkAddParam;
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
 * Created with IntelliJ IDEA.
 * User: 刘玉兰
 * Date: 17-10-27
 * Time: 下午5:34
 * To change this template use File | Settings | File Templates.
 * 反馈单元测试
 */
public class TaskFkRestTest extends BaseTestCase {
    private Logger log = LoggerFactory.getLogger(TaskFkRestTest.class);

    private static final String prefix = "/xz/taskFK/";

    //催办任务
    private static final String addTaskFk = prefix + "addTaskFk";

    /**
     *@Author: 刘玉兰
     *@Description: 任务反馈
     *@Date: 2017/10/27 14:39
     */
    @Test
    @Rollback(true)
    public void addTaskFk() throws Exception {
        TaskFkAddParam taskFkAddParam = new TaskFkAddParam();
        taskFkAddParam.setTaskid("5C841FDFBC5EFB4AE050A8C052015CE9");
        taskFkAddParam.setFkxs("经核实，张三没有杀人");
        taskFkAddParam.setCreator("88021FFBD7AQ4836870F189A0C813934");
        taskFkAddParam.setCreatename("超级管理员");
        taskFkAddParam.setDeparmentcode("440000190101");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(taskFkAddParam);

        String result = mockMvc.perform(post(addTaskFk)
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
