package com.xftxyz.elm.vo.req;

import com.xftxyz.elm.validation.ValidInfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterVO {
    /**
     * 用户编号
     */
    @NotBlank(message = ValidInfo.USER_ID_NOT_NULL)
    private String userid;

    /**
     * 密码
     */
    @NotBlank(message = ValidInfo.PASSWORD_NOT_NULL)
    private String password;

    /**
     * 用户名称
     */
    @NotBlank(message = ValidInfo.USER_NAME_NOT_NULL)
    private String username;

    /**
     * 用户性别（1：男； 0：女）
     */
    @NotNull(message = ValidInfo.USER_SEX_NOT_NULL)
    private Integer usersex;

}
