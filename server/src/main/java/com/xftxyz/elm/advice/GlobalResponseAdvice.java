package com.xftxyz.elm.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 全局返回值处理
 */
@RestControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果返回类型是 ResponseEntity 类型，则不进行处理
        if (ResponseEntity.class.isAssignableFrom(returnType.getParameterType())) {
            return false;
        }
        // 否则，进行处理
        return true;
    }

    @Override
    @Nullable
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        // 如果响应体是字符串类型
        if (body instanceof String) {
            try {
                // 将响应体转换为 R.ok(body) 的 JSON 字符串形式
                return objectMapper.writeValueAsString(R.ok(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        // 如果响应体是 R 类型，则直接返回响应体
        if (body instanceof R) {
            return body;
        }
        // 否则，将响应体转换为 R.ok(body) 的形式
        return R.ok(body);
    }

}