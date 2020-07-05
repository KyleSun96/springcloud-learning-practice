package com.itheima.user.service.impl;

import com.itheima.pojo.Order;
import com.itheima.pojo.User;
import com.itheima.response.OrderVO;
import com.itheima.response.UserOrderVO;
import com.itheima.user.client.OrderClient;
import com.itheima.user.mapper.UserMapper;
import com.itheima.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 * @Create: 9:07 2020/7/5
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderClient orderClient;


    /**
     * @description: //TODO 根据主键查询用户
     * @param: [username]
     * @return: com.itheima.pojo.User
     * @author: KyleSun swy0907163@163.com
     */
    @Override
    public User findUserById(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    /**
     * @description: //TODO 根据主键查询用户信息和用户所有的订单信息
     * @param: [username]
     * @return: com.itheima.response.UserOrderVO
     * @author: KyleSun swy0907163@163.com
     */
    @Override
    public UserOrderVO findOrderByUserId(String username) {

        // 1 参数校验
        if (StringUtils.isBlank(username)) {
            throw new RuntimeException("参数非法");
        }

        // 2 业务
        // 2.1 查询用户信息
        User user = this.findUserById(username);
        if (user == null) {
            throw new RuntimeException("无当前用户信息");
        }
        // 2.2 根据用户名查询订单列表， 基于feign
        List<Order> orderList = (List<Order>) orderClient.findOrdersByUsername(user.getUsername()).getData();

        // 3 结果处理封装
        UserOrderVO userOrderVO = new UserOrderVO();
        // 先将user中的内容赋值过去
        BeanUtils.copyProperties(user, userOrderVO);

        ArrayList<OrderVO> orderVOList = new ArrayList<>();
        for (Order order : orderList) {
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(order, orderVO);
            orderVOList.add(orderVO);
        }
        userOrderVO.setOrderList(orderVOList);

        return userOrderVO;
    }

}
