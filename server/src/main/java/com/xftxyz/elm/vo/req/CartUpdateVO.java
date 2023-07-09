package com.xftxyz.elm.vo.req;

import com.xftxyz.elm.validation.ValidInfo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CartUpdateVO {
    /*
     * 商家id
     */
    @NotBlank(message = ValidInfo.BUSINESS_ID_NOT_NULL)
    private Integer businessid;

    /*
     * 食品id
     */
    @NotBlank(message = ValidInfo.FOOD_ID_NOT_NULL)
    private Integer foodid;

    /*
     * 数量
     */
    @NotBlank(message = ValidInfo.QUANTITY_NOT_NULL)
    private Integer quantity;
}
