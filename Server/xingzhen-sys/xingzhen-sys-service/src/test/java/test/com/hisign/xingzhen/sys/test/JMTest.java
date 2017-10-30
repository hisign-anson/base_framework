package test.com.hisign.xingzhen.sys.test;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hisign.xingzhen.common.util.DateUtil;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 14:56 2017/10/28
 */
public class JMTest extends BaseTestCase{

    private Logger log = LoggerFactory.getLogger(JMTest.class);

    private final String appkey="a15c1e9bb38c1607b9571eea";
    private final String masterSecret="bd4d826e1e49340aac2d05e2";

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void addAllMember2JM() throws Exception {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setEnd(Integer.MAX_VALUE);
        List<SysUserInfo> list = sysUserService.getUserInfoListByCondition(sysUserInfo);
        RegisterInfo[] users = new RegisterInfo[list.size()];

        /*for (int i = 0; i < list.size(); i++) {
            SysUserInfo user = list.get(i);
            RegisterInfo info = RegisterInfo.newBuilder().setUsername(user.getUserId()).setPassword("123456").build();

            try {
                client.registerUsers(new RegisterInfo[]{info});
            } catch (APIConnectionException e) {
                e.printStackTrace();
            } catch (APIRequestException e) {
                e.printStackTrace();
            }
        }*/


        for (int i = 0; i < list.size(); i++) {
            try {
                SysUserInfo user = list.get(i);
                client.updateUserInfo(user.getUserId(),user.getUserName(), null
                        ,null,user.getSex(),user.getAddress(),user.getAddress());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
