package com.referral.api.aspect.exception;

import com.referral.api.dto.response.ApiResponse;
import com.referral.api.service.exception.InvalidDataRequestException;
import com.referral.api.service.exception.InvalidMetaInfoException;
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
        return exception(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataRequestException.class)
    public ResponseEntity<ApiResponse> onInvalidDataRequestException(final InvalidDataRequestException e) {
        log.error("Exception is {}", e.getMessage());
        return exception(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidMetaInfoException.class)
    public ResponseEntity<ApiResponse> onInvalidMetaInfoException(final InvalidMetaInfoException e) {
        log.error("Exception is {}", e.getMessage());
        return exception(e, HttpStatus.PRECONDITION_FAILED);
    }


    private ResponseEntity<ApiResponse> exception(final Throwable exception, final HttpStatus httpStatus) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new ApiResponse<>(message), httpStatus);
    }
}
