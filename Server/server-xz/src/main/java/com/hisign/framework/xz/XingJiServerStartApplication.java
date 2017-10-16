package com.hisign.framework.xz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@ComponentScan(basePackages = {"com.hisign"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class XingJiServerStartApplication {

    public static void main(String[] strs) {
//        SpringApplication.run(applicationClass,strs);
        new SpringApplicationBuilder(XingJiServerStartApplication.class).web(true).run(strs);
    }
}
