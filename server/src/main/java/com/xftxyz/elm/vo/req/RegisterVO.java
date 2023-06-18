package com.xftxyz.elm.vo.req;

import lombok.Data;

@Data
public class RegisterVO {
    /**
     * 用户编号
     */
    private String userid;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户性别（1：男； 0：女）
     */
    private Integer usersex;

}
