package com.xftxyz.elm.vo.res;

import lombok.Data;

@Data
public class UserVO {
    /**
     * 用户编号
     */
    private String userid;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户性别（1：男； 0：女）
     */
    private Integer usersex;

    /**
     * 用户头像
     */
    private String userimg;

}
