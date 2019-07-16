package com.sbm.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置类
 * TODO 访问网址查看api接口文档：http://localhost:8888/swagger-ui.html
 * 其实这个配置类，只要了解具体能配置哪些东西就好了，毕竟这个东西配置一次之后就不用再动了。
 *  特别要注意的是里面配置了api文件也就是controller包的路径，不然生成的文档扫描不到接口。
 */
@Configuration //用@Configuration注解该类，等价于XML中配置beans；用@Bean标注方法等价于XML中配置bean。
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sbm.demo.web")) //controller包的路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("浙商银行_金融科技部_青春基金项目_接口文档")
                .description("此接口文档概述了web层接受参数与返回参数的详细内容，" +
                        "前端开发人员应该实时查看该文档，才能顺利的进行数据的交互，" +
                        "开发完成此项目") //接口文档的描述内容
                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.2")
                .build();
    }
}