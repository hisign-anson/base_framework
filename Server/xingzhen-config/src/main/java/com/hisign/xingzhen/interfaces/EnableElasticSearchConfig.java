package com.hisign.xingzhen.interfaces;

import com.hisign.xingzhen.config.ElasticSearchConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 11:34 2017/11/3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({ElasticSearchConfig.class})
public @interface EnableElasticSearchConfig {
    String[] value() default {};
}
