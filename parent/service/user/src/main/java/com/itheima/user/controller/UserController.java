package com.itheima.user.controller;

import com.itheima.entity.Result;
import com.itheima.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 * @Create: 9:07 2020/7/5
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUserById/{username}")
    public Result findUser(@PathVariable("username") String username) {
        userService.findUserById(username);
        return new Result(true, "查询成功");
    }

}
