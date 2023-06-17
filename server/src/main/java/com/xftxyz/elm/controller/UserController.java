package com.xftxyz.elm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.service.UserService;

/**
 * 用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 用户登录
    // @PostMapping("/login")

    // 用户登出
    // @PostMapping("/logout")

    // 用户注册
    // @PostMapping("/register")

    // 用户修改密码
    // @PostMapping("/edit/password")

    // 用户修改信息
    // @PostMapping("/edit/info")

    // 用户注销
    // @DeleteMapping("/delete")

    // 用户查询

    // 获取当前用户信息
    // @GetMapping("/info")

}
