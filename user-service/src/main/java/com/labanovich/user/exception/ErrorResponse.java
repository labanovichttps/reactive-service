package com.labanovich.user.exception;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record ErrorResponse(Instant time,
                            int httpStatus,
                            String errorMessage) {
}
