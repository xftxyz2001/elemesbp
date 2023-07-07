package com.xftxyz.elm.advice;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.xftxyz.elm.exception.ApiException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
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
        return R.fail(ResultCode.UNKNOWN_ERROR.getCode(), e.getMessage());
    }

    // 请求参数校验失败异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<Object> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getFieldErrors().stream()
                .map(error -> String.format("%s : %s", error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return R.fail(ResultCode.PARAM_VALID_ERROR.getCode(), "请求参数校验失败" + errorMessages);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public R<Object> handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        List<String> errorMessages = violations.stream()
                .map(violation -> String.format("%s : %s", violation.getPropertyPath(), violation.getMessage()))
                .collect(Collectors.toList());
        return R.fail(ResultCode.PARAM_VALID_ERROR.getCode(), "请求参数校验失败" + errorMessages);
    }

    // 请求参数缺失
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return R.fail(ResultCode.PARAM_ERROR.getCode(),
                ResultCode.PARAM_ERROR.getMessage() + ": " + e.getParameterName() + "不能为空");
    }

    // HTTP消息不可读异常
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return R.fail(ResultCode.PARAM_ERROR.getCode(), ResultCode.PARAM_ERROR.getMessage());
    }

    // 请求参数异常
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public R<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return R.fail(ResultCode.PARAM_ERROR.getCode(),
                ResultCode.PARAM_ERROR.getMessage() + ": " + e.getName() + "应为" + e.getRequiredType());
    }
}
