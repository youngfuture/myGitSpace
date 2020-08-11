package com.xx.autoconfig.config;


import com.xx.autoconfig.impl.ContentService;
import com.xx.autoconfig.impl.CoreContentService;
import org.springframework.context.annotation.Bean;



public class CoreContentConfiguration {
    @Bean
    public ContentService contentService() {
        return new CoreContentService();
    }
}
