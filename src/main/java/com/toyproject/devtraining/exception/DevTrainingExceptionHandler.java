package com.toyproject.devtraining.exception;

import com.toyproject.devtraining.dto.DevTrainingErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class DevTrainingExceptionHandler{

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DevTrainingException.class)
    public DevTrainingErrorResponse exceptionHandler(
            DevTrainingException e,
            HttpServletRequest request) {
        log.error("errorCode: {}, url: {}, message: {}",
                e.getDevTrainingErrorCode(), request.getRequestURI(), e.getMessage());

        return new DevTrainingErrorResponse(e.getDevTrainingErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = {
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class
    })
    public DevTrainingErrorResponse handleBadRequest(
            Exception e,
            HttpServletRequest request
    ) {
        log.error("url: {}, message: {}",
                request.getRequestURI(), e.getMessage());

        return DevTrainingErrorResponse.builder()
                .errorCode(DevTrainingErrorCode.INVALID_REQUEST)
                .errorMessage(DevTrainingErrorCode.INVALID_REQUEST.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public DevTrainingErrorResponse handleException(
            Exception e,
            HttpServletRequest request
    ) {
        log.error("url: {}, message: {}",
                request.getRequestURI(), e.getMessage());

        return new DevTrainingErrorResponse(
                DevTrainingErrorCode.INTERNAL_SERVER_ERROR,
                DevTrainingErrorCode.INTERNAL_SERVER_ERROR.getMessage());
    }
}
