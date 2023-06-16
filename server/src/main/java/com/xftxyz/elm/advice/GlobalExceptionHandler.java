package com.xftxyz.elm.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xftxyz.elm.exception.ApiException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // Api异常
    @ExceptionHandler(ApiException.class)
    public R<Object> handleApiException(ApiException e) {
        return e.handleException();
    }

    // 未知异常
    @ExceptionHandler(Exception.class)
    public R<Object> handleException(Exception e) {
        log.error("出现未知异常：", e);
        return R.fail(-1, e.getMessage());
    }
}
