package com.itheima.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@SpringBootApplication
@EnableDiscoveryClient  // 包含了@EnableEurekaClient
@EnableFeignClients     // 开启feign调用
@EnableCircuitBreaker
@MapperScan(basePackages = "com.itheima.user.mapper")
//@SpringCloudApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
