package com.xx.autoconfig.config;


import com.xx.autoconfig.impl.ContentService;
import com.xx.autoconfig.impl.SimpleContentService;
import org.springframework.context.annotation.Bean;

public class SimpleContentConfiguration {
    @Bean
    public ContentService contentService() {
        return new SimpleContentService();
    }
}
