package com.itheima.response;

import lombok.Data;

/**
 * @Description:
 * @Author: KyleSun swy0907163@163.com
 * @Date: 14:05 2020/7/5
 **/
@Data
public class OrderVO {

    private String id;
    private Integer totalNum;
    private Integer payMoney;
    private String orderStatus;

}
