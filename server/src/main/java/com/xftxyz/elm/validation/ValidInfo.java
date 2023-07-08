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

}