package com.sbm.demo.mybatis;


import com.alibaba.druid.pool.DruidDataSource;
import com.sbm.demo.druid.DruidBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO 访问网址：http://localhost:8888/druid  查看监控
@Configuration
public class MybatisConfig {

    @Autowired
    DruidBean druidProperties;

    /**
     * guns的数据源
     */
    private DruidDataSource dataSourceStrom() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        return dataSourceStrom();
    }


}
