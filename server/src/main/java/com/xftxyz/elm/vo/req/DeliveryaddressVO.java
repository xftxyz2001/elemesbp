package com.xftxyz.elm.vo.req;

import com.xftxyz.elm.validation.ValidInfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeliveryaddressVO {
    /**
     * 送货地址编号
     */
    private Integer daid;

    /**
     * 联系人姓名
     */
    @NotBlank(message = ValidInfo.CONTACT_NAME_NOT_NULL)
    private String contactname;

    /**
     * 联系人性别
     */
    @NotNull(message = ValidInfo.CONTACT_SEX_NOT_NULL)
    private Integer contactsex;

    /**
     * 联系人电话
     */
    @NotBlank(message = ValidInfo.CONTACT_TEL_NOT_NULL)
    private String contacttel;

    /**
     * 送货地址
     */
    @NotBlank(message = ValidInfo.ADDRESS_NOT_NULL)
    private String address;
}
