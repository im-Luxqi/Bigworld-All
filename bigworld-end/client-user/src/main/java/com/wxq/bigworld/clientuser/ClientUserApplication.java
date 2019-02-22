package com.wxq.bigworld.clientuser;

import com.wxq.bigworld.clientuser.common.base.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wxq.bigworld.clientuser.web.mapper")
@EnableJpaRepositories(basePackages = {}, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class ClientUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientUserApplication.class, args);
    }
}

