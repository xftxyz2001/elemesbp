package com.xftxyz.elm.vo.req;

import com.xftxyz.elm.validation.ValidInfo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrdersNewVO {
    /**
     * 商家编号
     */
    @NotBlank(message = ValidInfo.BUSINESS_ID_NOT_NULL)
    private Integer businessid;

    /**
     * 送货地址编号
     */
    @NotBlank(message = ValidInfo.DELIVERY_ADDRESS_ID_NOT_NULL)
    private Integer daid;
}
