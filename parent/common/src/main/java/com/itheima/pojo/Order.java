package com.itheima.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * order实体类
 */
@Getter
@Setter
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id // 主键
    private String id;

    private Integer totalNum;

    private Integer payMoney;

    private String payType;

    private Date createTime;

    private String username;

    private String receiverContact;

    private String receiverMobile;

    private String receiverAddress;

    private String sourceType;

    private String orderStatus;

    private String payStatus;

    private String isDelete;

    private static final long serialVersionUID = 1L;

}
