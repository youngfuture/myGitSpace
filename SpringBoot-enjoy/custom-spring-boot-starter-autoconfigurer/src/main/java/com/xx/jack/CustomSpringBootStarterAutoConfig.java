package com.xx.jack;

import com.xx.autoconfig.EnableContentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableContentService
public class CustomSpringBootStarterAutoConfig {

    public static void main(String[] args) {
        SpringApplication.run(CustomSpringBootStarterAutoConfig.class, args);
    }

}
