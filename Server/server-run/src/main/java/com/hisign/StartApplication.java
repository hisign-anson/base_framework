package com.hisign;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.hisign.shuwu.common.tfs.FileUploadConfig;
import com.hisign.shuwu.common.tfs.FileUploadToolkits;

@ComponentScan(basePackages = {"com.hisign"})
@SpringBootApplication
public class StartApplication extends SpringBootServletInitializer {
    @Value("${multipart.maxFileSize}")
    private String multipartMaxFileSize;
    @Value("${multipart.maxRequestSize}")
    private String multipartMaxRequestSize;
    @Value("${upload.mode}")
    private String mode;
    @Value("${upload.host}")
    private String host;
    @Value("${upload.port}")
    private String port;
    @Value("${upload.user}")
    private String user;
    @Value("${upload.password}")
    private String password;
    @Value("${upload.root.path}")
    private String rootPath;
    @Value("${upload.thumb.width}")
    private int thumbWidth = 160;
    @Value("${upload.thumb.height}")
    private int thumbHeight = 160;

    public static void main(String[] strs) {
//        SpringApplication.run(applicationClass,strs);
        new SpringApplicationBuilder(StartApplication.class).web(true).run(strs);
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();

        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setFeatures(SerializerFeature.PrettyFormat);//.setFastJsonConfig(fastJsonConfig);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
        HttpMessageConverter<?> converter = fastConverter;

        return new HttpMessageConverters(converter);
    }
    @Bean
    public FileUploadToolkits fileUploadToolkits(){
        FileUploadConfig fileUploadConfig = new FileUploadConfig(mode, host, port, user, password, rootPath, thumbWidth, thumbHeight);
        return new FileUploadToolkits(fileUploadConfig);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(multipartMaxFileSize);
        factory.setMaxRequestSize(multipartMaxRequestSize);
        return factory.createMultipartConfig();
    }
}
