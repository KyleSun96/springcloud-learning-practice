package com.itheima.user.client.fallback;

import com.itheima.entity.Result;
import com.itheima.pojo.Order;
import com.itheima.user.client.OrderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 * @Date: 14:54 2020/7/5
 **/
@Component
@Slf4j
public class OrderFallback implements OrderClient {

    @Override
    public Result<List<Order>> findOrdersByUsername(String username) {

        log.error("OrderFallback findOrdersByUsername is effective for Hystrix username:{}", username);

        List<Order> list = new ArrayList<>();
        Order order = new Order();
        order.setId("-1");
        list.add(order);

        return new Result<>(true, "order服务降级", list);
    }
}
