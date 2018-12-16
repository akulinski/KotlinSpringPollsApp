package com.akulinski.poolsapplication;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class PoolsapplicationApplication extends WebMvcAutoConfiguration {

    @Autowired
    private DataMockUp dataMockUp;

    public static void main(String[] args) {
        SpringApplication.run(PoolsapplicationApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            dataMockUp.addTestData(30);
        };
    }

}

