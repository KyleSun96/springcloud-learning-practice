package com.itheima.user.client;

import com.itheima.entity.Result;
import com.itheima.user.fallback.OrderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@FeignClient(name = "order-server", fallback = OrderFallback.class)
@RequestMapping("/order")
public interface OrderClient {

    @GetMapping("/findOrdersByUsername/{username}")
    public Result findOrdersByUsername(@PathVariable(value = "username") String username);

}
