package com.jaychou.kongaicode;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.jaychou.kongaicode.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class KongAiCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(KongAiCodeApplication.class, args);
    }

}
