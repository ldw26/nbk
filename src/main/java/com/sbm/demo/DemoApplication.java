package com.sbm.demo;

//import com.alibaba.nacos.api.annotation.NacosInjected;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import com.alibaba.nacos.api.naming.pojo.Instance;
//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.annotation.PostConstruct;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.GET;



/*@NacosPropertySource是使用Nacos做配置中心后需要的注解
dataId：这个属性是需要在Nacos中配置的Data Id。
autoRefreshed：为true的话开启自动更新。
 */
//@NacosPropertySource(dataId = "springboot2-nacos-yungfund-config",autoRefreshed = true)
@EnableTransactionManagement //在Application类中开启事务管理，只需要@EnableTransactionManagement注解就行
@SpringBootApplication
@Slf4j
@EnableSwagger2 //加上注解@EnableSwagger2 表示开启Swagger
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


    //TODO 关于SpringBoot向Nacos上注册

//    @NacosInjected
//    private NamingService namingService;
//
//    @Value("${server.port}")
//    private int serverPort;
//
//    @Value("${spring.application.name}")
//    private String applicationName;
//
//    @PostConstruct
//    public void registerInstance() throws NacosException {
//        // 通过Nacos Open API 向 Nacos Server 注册一个名称为applicationName的服务
//        // curl -X PUT 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=XXX&ip=XXX&port=XXX'
//
//        namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
//    }

}
