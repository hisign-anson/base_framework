package com.hisign.xingzhen;

import com.hisign.xingzhen.interfaces.EnableDBConfig;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"com.hisign.xingzhen"})
@EnableFeignClients
@SpringCloudApplication
@EnableDBConfig
public class SysServerStartApplication {

    public static void main(String[] strs) {
//        SpringApplication.run(applicationClass,strs);
        new SpringApplicationBuilder(SysServerStartApplication.class).web(true).run(strs);
    }
}
