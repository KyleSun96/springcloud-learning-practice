package com.itheima.user.controller;

import com.itheima.entity.Result;
import com.itheima.pojo.User;
import com.itheima.response.UserOrderVO;
import com.itheima.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @description: //TODO 根据主键查询用户
     * @param: [username]
     * @return: com.itheima.entity.Result
     * @author: KyleSun swy0907163@163.com
     */
    @GetMapping("/findUserById/{username}")
    public Result findUser(@PathVariable("username") String username) {
        User user = userService.findUserById(username);
        return new Result(true, "查询成功", user);
    }


    /**
     * @description: //TODO 根据主键查询用户信息和用户所有的订单信息
     * @param: [username]
     * @return: com.itheima.entity.Result
     * @author: KyleSun swy0907163@163.com
     */
    @GetMapping("/findOrderByUserId/{username}")
    public Result findOrderByUserId(@PathVariable("username") String username) {
        UserOrderVO userOrderVO = userService.findOrderByUserId(username);
        return new Result(true, "查询成功", userOrderVO);
    }

}
