package com.sbm.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.sbm.demo.mapper") //扫描Mybatis接口文件
@Slf4j
public class DemoApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("启动 Spring Boot..//.");
        SpringApplication.run(DemoApplication.class, args);
        //log.info("该服务的名称是：{}",context.getEnvironment().getProperty("spring.application.name"));
        //log.info("该服务的启动端口是：{}",context.getEnvironment().getProperty("server.port"));
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
