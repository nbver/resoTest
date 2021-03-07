package com.example.resotest;


import com.example.resotest.init.InitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class ResoTestApplication {

    @Bean(initMethod = "init")
    @PostConstruct
    public InitService testInit() {
        return new InitService();
    }

    public static void main(String[] args) {
        SpringApplication.run(ResoTestApplication.class, args);
    }

}
