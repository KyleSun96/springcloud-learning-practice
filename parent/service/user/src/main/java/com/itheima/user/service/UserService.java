package com.itheima.user.service;

import com.itheima.pojo.User;
import com.itheima.response.UserOrderVO;

import java.util.Map;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
public interface UserService {

    /**
     * @description: //TODO 根据主键查询用户
     * @param: [username]
     * @return: com.itheima.pojo.User
     * @author: KyleSun swy0907163@163.com
     */
    public User findUserById(String username);


    /**
     * @description: //TODO 根据主键查询用户信息和用户所有的订单信息
     * @param: [username]
     * @return: com.itheima.response.UserOrderVO
     * @author: KyleSun swy0907163@163.com
     */
    public UserOrderVO findOrderByUserId(String username);

}
