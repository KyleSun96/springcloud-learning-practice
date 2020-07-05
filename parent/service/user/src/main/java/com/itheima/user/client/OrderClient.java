package com.itheima.user.client;

import com.itheima.entity.Result;
import com.itheima.pojo.Order;
import com.itheima.user.client.fallback.OrderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@FeignClient(name = "order-server", fallback = OrderFallback.class)
public interface OrderClient {

    /**
     * @description: //TODO 根据⽤户的username查询数据库的订单
     * @param: [username]
     * @return: com.itheima.entity.Result
     * @author: KyleSun swy0907163@163.com
     */
    @GetMapping("/order/findOrdersByUsername/{username}")
    public Result<List<Order>> findOrdersByUsername(@PathVariable(value = "username") String username);

}
