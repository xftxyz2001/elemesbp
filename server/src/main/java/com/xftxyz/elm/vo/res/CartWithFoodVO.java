package com.xftxyz.elm.vo.res;

import com.xftxyz.elm.domain.Food;

import lombok.Data;

@Data
public class CartWithFoodVO {
    /**
     * 无意义编号
     */
    private Integer cartid;

    /**
     * 食品编号
     */
    private Integer foodid;

    /**
     * 所属商家编号
     */
    private Integer businessid;

    /**
     * 所属用户编号
     */
    private String userid;

    /**
     * 同一类型食品的购买数量
     */
    private Integer quantity;

    /**
     * 食品信息
     */
    private Food food;

}
