package com.xftxyz.elm.vo.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginVO {
    /**
     * @NotEmpty注解用于验证字段不为null且长度（字符串、集合、map）大于0
     * 
     * @NotBlank注解用于验证字符串类型的字段不为null且去除前后空格后长度大于0
     */

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

}
