package com.xftxyz.elm.config;

// @ConfigurationProperties(prefix = "elm")
// @Component
public interface ElmProperties {
    String cookieToken = "token"; // cookie中token的key
    int cookieTokenExpire = 3600 * 24 * 7; // 7天
    String requestUser = "ru"; // request中user的key
}
