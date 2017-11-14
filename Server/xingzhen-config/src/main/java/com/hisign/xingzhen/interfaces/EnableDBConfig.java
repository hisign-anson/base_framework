package com.hisign.xingzhen.interfaces;

import com.hisign.xingzhen.config.DatabaseConfig;
import com.hisign.xingzhen.config.JMConfig;
import com.hisign.xingzhen.config.MyBatisConfig;
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
@Import({DatabaseConfig.class, MyBatisConfig.class})
public @interface EnableDBConfig {
    String[] value() default {};
}
