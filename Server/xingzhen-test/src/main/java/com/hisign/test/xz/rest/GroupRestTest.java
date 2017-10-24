package com.hisign.test.xz.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hisign.test.base.BaseTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

/**
 * Created by hisign on 2017/10/24.
 */
public class GroupRestTest extends BaseTestCase{

    Logger logger = LoggerFactory.getLogger(GroupRestTest.class);

    @Test
    public void getRatioOfMaleAndFemale() throws Exception{

        ObjectMapper map = new ObjectMapper();
//        Family family = new Family();
//        family.setId("123");
//        family.setCarNo("12333");
//        String param = map.writeValueAsString(family);

        MvcResult mvcResult = mockMvc.perform(post("/index/stat/getRatioOfMaleAndFemale")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        logger.debug("-----------status:"+mvcResult.getResponse().getStatus());
        logger.debug("-----------content:"+content);
    }

}
