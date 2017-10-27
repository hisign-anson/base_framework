package com.hisign.xingzhen.config;

import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.user.UserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Created by hisign on 2017/10/26.
 */
@Configuration
public class JMConfig {

    @Value("${jm.appkey}")
    private String appkey;

    @Value("${jm.masterSecret}")
    private String masterSecret;

    @Bean(name = "jMessageClient")
    public JMessageClient jMessageClient() throws SQLException {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        return client;
    }

    @Bean(name = "userClient")
    public UserClient userClient(){
        return new UserClient(appkey,masterSecret);
    }
}
