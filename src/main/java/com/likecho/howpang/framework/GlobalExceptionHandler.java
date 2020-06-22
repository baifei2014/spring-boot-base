package com.likecho.howpang.framework;

import com.likecho.howpang.constant.Response;
import com.likecho.howpang.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ApiResponse nullPointerHandler(Throwable throwable) {
        log.error("[Internal Server Error]:" + throwable.getMessage(), throwable);
        return ApiResponse.serverError("Internal Server Error! ");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResponse badRequestHandler(Throwable throwable) {
        return ApiResponse.create(Response.BAD_REQUEST, throwable.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse illegalArgumentException(Throwable throwable) {
        log.error("[Internal Server Error]:" + throwable.getMessage(), throwable);
        return ApiResponse.serverError("Internal Server Error! ");
    }
}

