package com.hisign.shuwu.sys.util;

import com.hisign.shuwu.common.tfs.FileUploadConfig;
import com.hisign.shuwu.common.tfs.FileUploadToolkits;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;


@Configuration
public class FileUploadToolConfig {

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
    @Value("${multipart.maxFileSize}")
    private String multipartMaxFileSize;
    @Value("${multipart.maxRequestSize}")
    private String multipartMaxRequestSize;

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
