package com.itheima.response;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 * @Date: 11:48 2020/7/5
 **/
@Data
public class UserOrderVO {

    private String username;
    private String nickName;
    private String headPic;
    private String sex;

    private List<OrderVO> orderList;

}
