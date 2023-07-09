package com.xftxyz.elm.validation;

public interface ValidInfo {
    // 用户ID不能为空
    String USER_ID_NOT_NULL = "用户ID不能为空";

    // 页码小于1
    String PAGE_LESS_THAN_ONE = "页码从1开始";

    // 密码最小长度
    int MIN_PASSWORD_LENGTH = 6;
    // 密码最大长度
    int MAX_PASSWORD_LENGTH = 18;

    // 密码不能为空
    String PASSWORD_NOT_NULL = "密码不能为空";

    // 用户名称不能为空
    String USER_NAME_NOT_NULL = "用户名称不能为空";

    // 用户性别不能为空
    String USER_SEX_NOT_NULL = "用户性别不能为空";

    // 商家ID能为空
    String BUSINESS_ID_NOT_NULL = "商家ID不能为空";

    // 送货地址ID不能为空
    String DELIVERY_ADDRESS_ID_NOT_NULL = "送货地址ID不能为空";

    String FOOD_ID_NOT_NULL = "食品ID不能为空";

    String QUANTITY_NOT_NULL = "数量不能为空";

    // 联系人姓名不能为空
    String CONTACT_NAME_NOT_NULL = "联系人姓名不能为空";

    // 联系人性别不能为空
    String CONTACT_SEX_NOT_NULL = "联系人性别不能为空";

    // 联系人电话不能为空
    String CONTACT_TEL_NOT_NULL = "联系人电话不能为空";

    // 送货地址不能为空
    String ADDRESS_NOT_NULL = "送货地址不能为空";

}