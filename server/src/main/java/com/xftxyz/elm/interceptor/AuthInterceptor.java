package com.xftxyz.elm.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xftxyz.elm.advice.R;
import com.xftxyz.elm.advice.ResultCode;
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
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 如果请求方式为OPTIONS
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }

        // 尝试从cookie中获取token
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ElmProperties.cookieToken.equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        // 尝试从token中获取用户信息
        User user = userService.fromToken(token);
        // 获取失败，token无效
        if (user == null) {
            // 清除cookie
            Cookie cookie = new Cookie(ElmProperties.cookieToken, "");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            // 返回未登录信息
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(R
                    .fail(ResultCode.USER_NOT_LOGIN.getCode(), ResultCode.USER_NOT_LOGIN.getMessage())));
            return false;
        }

        // 将用户信息放入request中
        request.setAttribute(ElmProperties.requestUser, user);
        return true;
    }
}
