package com.xftxyz.elm.exception;

import com.xftxyz.elm.advice.R;

/**
 * 自定义异常
 */
public abstract class ApiException extends RuntimeException {

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    protected ApiException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    // 处理异常
    public abstract R<Object> handleException();

}
