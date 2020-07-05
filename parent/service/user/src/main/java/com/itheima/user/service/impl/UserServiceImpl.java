package com.itheima.user.service.impl;

import com.itheima.pojo.User;
import com.itheima.user.mapper.UserMapper;
import com.itheima.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 * @Create: 9:07 2020/7/5
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

}
