package com.xftxyz.elm.vo.req;

import lombok.Data;

@Data
public class DeliveryaddressVO {
    /**
     * 联系人姓名
     */
    private String contactname;

    /**
     * 联系人性别
     */
    private Integer contactsex;

    /**
     * 联系人电话
     */
    private String contacttel;

    /**
     * 送货地址
     */
    private String address;
}
