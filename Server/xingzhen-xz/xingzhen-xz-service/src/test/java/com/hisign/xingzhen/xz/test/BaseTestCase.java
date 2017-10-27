package com.hisign.xingzhen.xz.test;

import com.hisign.xingzhen.xz.XZServerStartApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = XZServerStartApplication.class)
@WebAppConfiguration
public class BaseTestCase {

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

}
