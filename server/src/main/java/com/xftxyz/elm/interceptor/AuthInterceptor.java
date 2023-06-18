package com.xftxyz.elm.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.xftxyz.elm.config.ElmProperties;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private ElmProperties elmProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 尝试从cookie中获取token
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (elmProperties.getCookieToken().equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        // 如果token为空，说明没有登录或者登录已经过期
        if (token == null) {
            return false;
        }

        // 尝试从token中获取用户信息
        User user = userService.fromToken(token);
        // 获取失败，token无效
        if (user == null) {
            return false;
        }

        // 将用户信息放入request中
        request.setAttribute(elmProperties.getRequestUser(), user);
        return true;
    }
}
