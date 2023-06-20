package com.xftxyz.elm.vo.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterVO {
    /**
     * 用户编号
     */
    @NotBlank(message = "用户编号不能为空")
    private String userid;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名称不能为空")
    private String username;

    /**
     * 用户性别（1：男； 0：女）
     */
    @NotNull(message = "用户性别不能为空")
    private Integer usersex;

}
