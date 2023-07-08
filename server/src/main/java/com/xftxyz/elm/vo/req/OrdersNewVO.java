package com.xftxyz.elm.vo.req;

import lombok.Data;

@Data
public class OrdersNewVO {
    /**
     * 商家编号
     */
    private Integer businessid;
    /**
     * 送货地址编号
     */
    private Integer daid;
}
