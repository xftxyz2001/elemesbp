package com.xftxyz.elm.vo.req;

import lombok.Data;

@Data
public class LoginVO {
    /**
     * 用户编号
     */
    private String userid;

    /**
     * 密码
     */
    private String password;

}
