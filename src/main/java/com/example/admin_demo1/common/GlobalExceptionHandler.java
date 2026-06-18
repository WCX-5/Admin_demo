package com.example.admin_demo1.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error("系统异常：", e);
        if (e instanceof AccessDeniedException) {
            return Result.error(403, "权限不足");
        }
        return Result.error("系统异常：" + e.getMessage());
    }
}