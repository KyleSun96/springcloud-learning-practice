package com.itheima.order.service;

import com.itheima.pojo.Order;

import java.util.List;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
public interface OrderService {

    /**
     * @description: //TODO 根据⽤户的username查询数据库的订单
     * @param: [username]
     * @return: java.util.List<com.itheima.pojo.Order>
     * @author: KyleSun swy0907163@163.com
     */
    List<Order> findOrderByUsername(String username);

}
