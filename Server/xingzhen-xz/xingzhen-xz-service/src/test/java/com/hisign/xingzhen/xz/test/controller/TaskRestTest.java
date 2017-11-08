package com.hisign.xingzhen.xz.test.controller;

import com.hisign.xingzhen.xz.api.param.TaskAddParam;
import com.hisign.xingzhen.xz.api.param.TaskMoveParam;
import com.hisign.xingzhen.xz.api.param.TaskSelectParam;
import com.hisign.xingzhen.xz.test.BaseTestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;

import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created with IntelliJ IDEA.
 * User: 刘玉兰
 * Date: 17-10-27
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 * 任务单元测试
 */
public class TaskRestTest extends BaseTestCase {

    private Logger log = LoggerFactory.getLogger(TaskRestTest.class);

    private static final String prefix = "/xz/task/";


    //新增任务
    private static final String addTask = prefix + "addTask";

    //新增任务
    private static final String deleteTaskById = prefix + "deleteTaskById";

    //分页查询
    private static final String getTaskPage = prefix + "getTaskPage";

    //任务详情
    private static final String taskDetail = prefix + "taskDetail";

    //移交任务
    private static final String moveTask = prefix + "moveTask";

    /**
     *@Author: 刘玉兰
     *@Description: 新增任务
     *@Date: 2017/10/27 14:39
     */
    @Test
    @Rollback(true)
    public void addTask() throws Exception {
        TaskAddParam taskAddParam = new TaskAddParam();
        taskAddParam.setTaskName("杀人案-fanny");
        taskAddParam.setTaskContent("追踪杀人案真相-fanny");
        taskAddParam.setGroupid("5C83F43C4161CA5EE050A8C052015A2C");
        taskAddParam.setJsrLxfs("13609794936");
        taskAddParam.setJsr("7E723A46EA984E74BB187E5215BECA81");
        taskAddParam.setJsrname("江露露");
        taskAddParam.setFkjzTime(new SimpleDateFormat("yyyyMMdd").parse("20171130"));
        taskAddParam.setFqr("A086DFFAEE494F158F3C692A4ACC079F");
        taskAddParam.setFqrLxfs("12122222222");
        taskAddParam.setFqrname("张三");
        taskAddParam.setFqrDeptCode("440000190101");
        taskAddParam.setFqrDeptName("秘书科");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(taskAddParam);

        String result = mockMvc.perform(post(addTask)
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
     *@Author: 刘玉兰
     *@Description: 删除任务
     *@Date: 2017/10/27 14:39
     */
    @Test
    @Rollback(true)
    public void deleteTaskById() throws Exception {
        String result = mockMvc.perform(get(deleteTaskById)
                .contentType(MediaType.APPLICATION_JSON_UTF8).param("id", "5C8451D5B14D37B7E050A8C0520160A2").param("userId", "A086DFFAEE494F158F3C692A4ACC079F"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

    /**
     *@Author: 刘玉兰
     *@Description: 分页查询
     *@Date: 2017/10/27 14:39
     */
    @Test
    @Rollback(true)
    public void getTaskPage() throws Exception {
        TaskSelectParam taskSelectParam = new TaskSelectParam();
        taskSelectParam.setUserId("A086DFFAEE494F158F3C692A4ACC079F");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(taskSelectParam);

        String result = mockMvc.perform(post(getTaskPage)
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
     *@Author: 刘玉兰
     *@Description: 任务详情
     *@Date: 2017/10/27 14:39
     */
    @Test
    @Rollback(true)
    public void taskDetail() throws Exception {
        String result = mockMvc.perform(get(taskDetail)
                .contentType(MediaType.APPLICATION_JSON_UTF8).param("id", "5C841FDFBC5EFB4AE050A8C052015CE9").param("userId", "7E723A46EA984E74BB187E5215BECA81"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

    /**
     *@Author: 刘玉兰
     *@Description: 任务详情
     *@Date: 2017/10/27 17:39
     */

    @Test
    @Rollback(true)
    public void moveTask() throws Exception {
        TaskMoveParam taskMoveParam = new TaskMoveParam();
        taskMoveParam.setId("5C841FDFBC5EFB4AE050A8C052015CE9");
        taskMoveParam.setJsr("88021FFBD7AQ4836870F189A0C813934");
        taskMoveParam.setJsrname("超级管理员");
        taskMoveParam.setJsrLxfs("111122");
        taskMoveParam.setCreator("A086DFFAEE494F158F3C692A4ACC079F");
        taskMoveParam.setCreatename("张三");
        taskMoveParam.setDeparmentcode("440000190101");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(taskMoveParam);

        String result = mockMvc.perform(post(moveTask)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.flag", is(1)))
                .andReturn().getResponse().getContentAsString();
        log.info("结果：",result);
    }

}
