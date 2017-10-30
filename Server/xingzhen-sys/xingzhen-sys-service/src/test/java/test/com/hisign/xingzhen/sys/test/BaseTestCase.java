package test.com.hisign.xingzhen.sys.test;

import com.hisign.xingzhen.SysServerStartApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.aspectj.weaver.loadtime.definition.Definition.AdviceKind.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SysServerStartApplication.class)
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
