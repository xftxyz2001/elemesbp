package com.xftxyz.elm.vo.res;

import java.math.BigDecimal;
import java.util.List;

import com.xftxyz.elm.domain.Business;
import com.xftxyz.elm.domain.Orders;

import lombok.Data;

@Data
public class OrdersVO {
    /**
     * 订单编号
     */
    private Integer orderid;

    /**
     * 用户编号
     */
    private String userid;

    /**
     * 商家编号
     */
    private Integer businessid;
    /**
     * 商家
     */
    private Business business;

    /**
     * 订购日期
     */
    private String orderdate;

    /**
     * 订单总价
     */
    private BigDecimal ordertotal;
    /**
     * 订单项目列表
     */
    private List<FoodWithQuantityVO> foodList;

    /**
     * 送货地址编号
     */
    private Integer daid;

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    private Integer orderstate;

    public OrdersVO(Orders orders) {
        this.orderid = orders.getOrderid();
        this.userid = orders.getUserid();
        this.businessid = orders.getBusinessid();
        this.orderdate = orders.getOrderdate();
        this.ordertotal = orders.getOrdertotal();
        this.daid = orders.getDaid();
        this.orderstate = orders.getOrderstate();
    }

}
