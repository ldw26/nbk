package com.sbm.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sbm.demo.mapper") //扫描Mybatis接口文件
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot..//.");
        SpringApplication.run(DemoApplication.class, args);
        //log.info("该服务的名称是：{}",context.getEnvironment().getProperty("spring.application.name"));
        //log.info("该服务的启动端口是：{}",context.getEnvironment().getProperty("server.port"));
    }
}
