package com.jaychou.kongaicode;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class},
        scanBasePackages = "com.jaychou.kongaicode"  )
        @MapperScan("com.jaychou.kongaicode.mapper")
        @EnableAspectJAutoProxy(exposeProxy = true)
        public class KongAiCodeApplication{

        public static void main(String[]args) {
    SpringApplication.run(KongAiCodeApplication.class, args);
}

}
