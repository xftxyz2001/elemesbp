package com.xftxyz.elm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.config.ElmProperties;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.UserService;
import com.xftxyz.elm.vo.req.LoginVO;
import com.xftxyz.elm.vo.req.RegisterVO;
import com.xftxyz.elm.vo.res.UserVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotBlank;

/**
 * 用户相关
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * 
     * @param loginVO  登录信息
     * @param response 响应，用于设置cookie
     * @return true:登录成功 false:登录失败
     */
    @PostMapping("/login")
    public Boolean login(@RequestBody @Validated LoginVO loginVO, HttpServletResponse response) {
        User user = userService.login(loginVO.getUserid(), loginVO.getPassword());
        Cookie cookie = new Cookie(ElmProperties.cookieToken, userService.toToken(user));
        cookie.setPath("/");
        cookie.setMaxAge(ElmProperties.cookieTokenExpire);
        response.addCookie(cookie);
        return true;
    }

    /**
     * 用户登出
     * 
     * @param response 响应，用于设置cookie
     * @return true:登出成功 false:登出失败
     */
    @PostMapping("/logout")
    public Boolean logout(HttpServletResponse response) {
        Cookie cookie = new Cookie(ElmProperties.cookieToken, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return true;
    }

    /**
     * 检查用户名是否存在
     * 
     * @param userid 用户id
     * @return true:存在 false:不存在
     */
    @GetMapping("/check/{userid}")
    public Boolean checkUserid(@PathVariable("userid") @NotBlank(message = "用户id不能为空") String userid) {
        return userService.checkUserid(userid);
    }

    /**
     * 用户注册
     * 
     * @param registerVO 注册信息
     * @return true:注册成功 false:注册失败
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody @Validated RegisterVO registerVO) {
        return userService.register(registerVO.getUserid(), registerVO.getPassword(),
                registerVO.getUsername(), registerVO.getUsersex());
    }

    // 用户修改密码
    // @PostMapping("/edit/password")

    // 用户修改信息
    // @PostMapping("/edit/info")

    /**
     * 用户注销
     * 
     * @param user 当前用户
     * @return true:注销成功 false:注销失败
     */
    @DeleteMapping("/delete")
    public Boolean deleteUser(@ModelAttribute(ElmProperties.requestUser) User user) {
        return userService.deleteUser(user);
    }

    /**
     * 用户查询（根据id）
     * 
     * @param userid 用户id
     * @return 用户信息
     */
    @GetMapping("/{userid}")
    public UserVO getUser(@PathVariable("userid") @NotBlank(message = "用户id不能为空") String userid) {
        return userService.getUserVO(userid);
    }

    /**
     * 获取当前用户信息
     * 
     * @param user 当前用户
     * @return 当前用户信息
     */
    @GetMapping("/info")
    public UserVO currentUserInfo(@ModelAttribute(ElmProperties.requestUser) User user) {
        return userService.getUserVO(user);
    }

}
