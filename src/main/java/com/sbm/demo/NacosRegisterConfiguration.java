//package com.sbm.demo;
//
//import com.alibaba.nacos.api.annotation.NacosInjected;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import javax.annotation.PostConstruct;
//
////TODO 本类的作用是让服务启动后，自动向Nacos注册
//@Configuration
//public class NacosRegisterConfiguration {
//
//    @Value("${server.port}")
//    private int serverPort; //服务开启的端口
//
//    @Value("${spring.application.name}")
//    private String applicationName; //服务名称
//
//    @NacosInjected
//    private NamingService namingService;
//
//    @PostConstruct //使用注解@PostConstruct，在服务启动后自动向Nacos服务注册
//    public void registerInstance() throws NacosException {
//        namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
//    }
//}
//
