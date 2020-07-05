package com.itheima.user.controller;

import com.itheima.entity.Result;
import com.itheima.pojo.User;
import com.itheima.response.UserOrderVO;
import com.itheima.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope  // bus刷新本地环境
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${test.testStr}")
    private String testStr;

    /**
     * @description: //TODO 根据主键查询用户
     * @param: [username]
     * @return: com.itheima.entity.Result
     * @author: KyleSun swy0907163@163.com
     */
    @GetMapping("/findUserById/{username}")
    public Result<User> findUser(@PathVariable("username") String username) {

        System.out.println("从git仓库获取配置文件中更改的信息：" + testStr);
        User user = userService.findUserById(username);
        return new Result<User>(true, "查询成功", user);
    }


    /**
     * @description: //TODO 根据主键查询用户信息和用户所有的订单信息
     * @param: [username]
     * @return: com.itheima.entity.Result
     * @author: KyleSun swy0907163@163.com
     */
    @GetMapping("/findOrderByUserId/{username}")
    public Result<UserOrderVO> findOrderByUserId(@PathVariable("username") String username) {
        UserOrderVO userOrderVO = userService.findOrderByUserId(username);
        return new Result<>(true, "查询成功", userOrderVO);
    }

}
