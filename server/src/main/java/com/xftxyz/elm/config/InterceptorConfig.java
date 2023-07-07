package com.xftxyz.elm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.xftxyz.elm.interceptor.AuthInterceptor;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 排除登录接口/login /register
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
        .excludePathPatterns("/user/login", "/user/register");
    }
}
