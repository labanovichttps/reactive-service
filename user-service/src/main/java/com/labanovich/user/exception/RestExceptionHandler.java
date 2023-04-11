package com.labanovich.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleEntityNotFoundException(EntityNotFoundException e) {
        log.error("EntityNotFoundException occurred: {}", e.getMessage(), e);
        return Mono.fromSupplier(() -> buildErrorResponse(e, HttpStatus.NOT_FOUND));
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(EntityNotFoundException e, HttpStatus status) {
        return new ResponseEntity<>(new ErrorResponse(Instant.now(), status.value(), e.getMessage()), status);
    }
}
