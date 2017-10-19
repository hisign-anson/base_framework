package com.hisign.xingzhen;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@ComponentScan(basePackages = {"com.hisign"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NtServerStartApplication extends SpringBootServletInitializer {

    public static void main(String[] strs) {
//        SpringApplication.run(applicationClass,strs);
        new SpringApplicationBuilder(NtServerStartApplication.class).web(true).run(strs);
    }
}
