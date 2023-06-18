package com.xftxyz.elm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "elm")
@Component
public class ElmProperties {
    private String cookieToken = "token"; // cookie中token的key
    private int cookieTokenExpire = 3600 * 24 * 7; // 7天
    private String requestUser = "ru"; // request中user的key
}
