package com.hisign.framework.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by hisign on 2017/10/12.
 */
@ComponentScan(basePackages = {"com.hisign.framework"})
@SpringCloudApplication
@EnableFeignClients
public class XZServerStartApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(XZServerStartApplication.class).web(true).run(args);
    }

}
