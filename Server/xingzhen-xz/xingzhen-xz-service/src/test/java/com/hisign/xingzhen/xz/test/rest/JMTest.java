package com.hisign.xingzhen.xz.test.rest;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.group.CreateGroupResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 11:55 2017/10/27
 */
public class JMTest {

    private Logger log = LoggerFactory.getLogger(JMTest.class);

    private final String appkey="a15c1e9bb38c1607b9571eea";
    private final String masterSecret="bd4d826e1e49340aac2d05e2";

    @Test
    public void testCreateGroup() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            CreateGroupResult result = client.createGroup("test_user", "test_gname1", "description", "test_user");

        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        }
    }

    @Test
    public void testCreateUser() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            client.registerAdmins("1234","1234");
            CreateGroupResult result = client.createGroup("1234", "test_gname1", "description", "1234");

        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        }
    }


}
