package com.hisign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@ComponentScan(basePackages = {"com.hisign"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TestServerStartApplication {

    public static void main(String[] strs) {
        SpringApplication.run(TestServerStartApplication.class,strs);
//        new SpringApplicationBuilder(StartApplication.class).web(true).run(strs);
    }
}
