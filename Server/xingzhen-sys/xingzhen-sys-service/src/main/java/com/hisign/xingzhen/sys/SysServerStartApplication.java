package com.hisign.xingzhen.sys;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@ComponentScan(basePackages = {"com.hisign"})
@EnableFeignClients
@SpringCloudApplication
public class SysServerStartApplication {

    public static void main(String[] strs) {
//        SpringApplication.run(applicationClass,strs);
        new SpringApplicationBuilder(SysServerStartApplication.class).web(true).run(strs);
    }
}
