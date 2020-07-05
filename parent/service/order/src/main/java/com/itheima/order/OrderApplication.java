package com.itheima.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@SpringBootApplication
@EnableCircuitBreaker // 开启Hystrix功能
@EnableDiscoveryClient // 包含了开启熔断和@EnableEurekaClient
//@EnableFeignClients(basePackages = "com.itheima.order.feign")
@MapperScan(basePackages = "com.itheima.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
