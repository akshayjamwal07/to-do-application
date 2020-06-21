package com.ajplay.todoutil.exception;

import com.ajplay.todoutil.exception.error.ErrorCode;
import com.ajplay.todoutil.exception.error.ErrorCoded;

public class BadRequestException extends RuntimeException implements ErrorCoded {
    private static final long serialVersionUID = -1451857018340213272L;
    /**
     * Error code that an error will be registered with.
     */
    private String errorCode = ErrorCode.BAD_REQUEST.getCode();

    public BadRequestException(final String message) {
        super(message);
    }

    public BadRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(final String message, final String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BadRequestException(final String message, final String errorCode, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
