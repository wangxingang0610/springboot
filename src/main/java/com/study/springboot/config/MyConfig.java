package com.study.springboot.config;

import com.study.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyConfig {

    @Bean
    public HelloService helloService(){

        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}
