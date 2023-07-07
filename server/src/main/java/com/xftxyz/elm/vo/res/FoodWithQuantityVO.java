package com.xftxyz.elm.vo.res;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FoodWithQuantityVO {
    /**
     * 食品编号
     */
    private Integer foodid;

    /**
     * 食品名称
     */
    private String foodname;

    /**
     * 食品介绍
     */
    private String foodexplain;

    /**
     * 食品图片
     */
    private String foodimg;

    /**
     * 食品价格
     */
    private BigDecimal foodprice;

    /**
     * 所属商家编号
     */
    private Integer businessid;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 购物车中的数量
     */
    private Integer quantity;
}
