package com.itheima.order.service.impl;

import com.itheima.order.mapper.OrderMapper;
import com.itheima.order.service.OrderService;
import com.itheima.pojo.Order;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LogManager.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;


    /**
     * @description: //TODO 根据⽤户的username查询数据库的订单
     * @return: java.util.List<com.itheima.pojo.Order>
     * @author: KyleSun swy0907163@163.com
     */
    @Override
    public List<Order> findOrderByUsername(String username) {

        // 1 校验参数
        if (StringUtils.isBlank(username)) {
            LOG.error("OrderServiceImpl findOrderByUsername is called error!");
            throw new RuntimeException("参数不能为空");
        }

        // 2 业务处理
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);

        // 3 封装结果集
        List<Order> orderList = orderMapper.selectByExample(example);
        if (orderList == null) {
            orderList = new ArrayList<>();
        }

        // 测试降级异常
        // int i = 1/0;

        return orderList;
    }
}
