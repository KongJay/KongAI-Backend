package com.jaychou.kongaicode.config;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.jaychou.kongaicode.service.CodeQualityCheckService;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
public class CodeQualityCheckServiceFactory {

    @Resource
    private ChatModel chatModel;

    /**
     * 创建代码质量检查 AI 服务
     */
    @Bean
    public CodeQualityCheckService createCodeQualityCheckService() {
        return AiServices.builder(CodeQualityCheckService.class)
                .chatModel(chatModel)
                .build();
    }


}
