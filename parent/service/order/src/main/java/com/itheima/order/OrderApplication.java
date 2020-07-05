package com.itheima.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@SpringBootApplication
@EnableDiscoveryClient // 包含了开启熔断@EnableCircuitBreaker和@EnableEurekaClient
@MapperScan(basePackages = "com.itheima.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
