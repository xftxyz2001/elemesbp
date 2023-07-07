package com.xftxyz.elm.vo.req;

import lombok.Data;

@Data
public class CartUpdateVO {
    /*
     * 商家id
     */
    private Integer businessid;

    /*
     * 食品id
     */
    private Integer foodid;

    /*
     * 数量
     */
    private Integer quantity;
}
