package com.itheima.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@SpringBootApplication
@EnableDiscoveryClient  // 包含了@EnableEurekaClient
@MapperScan(basePackages = "com.itheima.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
