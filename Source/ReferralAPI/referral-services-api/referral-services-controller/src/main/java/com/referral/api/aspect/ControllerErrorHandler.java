package com.referral.api.aspect;

import com.referral.api.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@Slf4j
@ControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> onException(final Exception e) {
        log.error("Exception is {}", ExceptionUtils.getStackTrace(e));
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    private ResponseEntity<ApiResponse> error(final Exception exception, final HttpStatus httpStatus) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new ApiResponse<>(String.format("Exception is :%s",message)), httpStatus);
    }
}
