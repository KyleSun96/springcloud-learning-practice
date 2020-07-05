package com.itheima.order.controller;

import com.itheima.entity.Result;
import com.itheima.order.service.OrderService;
import com.itheima.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@RestController
@RequestMapping("/order")   // 窄化请求
@RefreshScope  // bus刷新本地环境
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * @description: //TODO 根据⽤户的username查询数据库的订单
     * @param: [username]
     * @return: com.itheima.entity.Result
     * @author: KyleSun swy0907163@163.com
     */
    @GetMapping("/findOrdersByUsername/{username}")
    public Result<List<Order>> findOrdersByUsername(@PathVariable(value = "username") String username) {
        List<Order> orderList = orderService.findOrderByUsername(username);
        return new Result<>(true, "查询成功", orderList);
    }

}
