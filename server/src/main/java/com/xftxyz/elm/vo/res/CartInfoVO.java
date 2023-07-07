package com.xftxyz.elm.vo.res;

import java.math.BigDecimal;

import lombok.Data;

/*
 * 购物车信息
 */
@Data
public class CartInfoVO {
    /**
     * 总数量
     */
    private Integer totalQuantity;

    /**
     * 总价格
     */
    private BigDecimal totalPrice;

    /**
     * 总结算价
     */
    private BigDecimal totalSettle;
}
