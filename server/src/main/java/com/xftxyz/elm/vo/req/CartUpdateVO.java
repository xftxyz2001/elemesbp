package com.xftxyz.elm.vo.req;

import com.xftxyz.elm.validation.ValidInfo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartUpdateVO {
    /*
     * 商家id
     */
    @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL)
    private Integer businessid;

    /*
     * 食品id
     */
    @NotNull(message = ValidInfo.FOOD_ID_NOT_NULL)
    private Integer foodid;

    /*
     * 数量
     */
    @NotNull(message = ValidInfo.QUANTITY_NOT_NULL)
    private Integer quantity;
}
