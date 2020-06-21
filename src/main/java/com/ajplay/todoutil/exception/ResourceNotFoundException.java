package com.ajplay.todoutil.exception;

import com.ajplay.todoutil.exception.error.ErrorCode;
import com.ajplay.todoutil.exception.error.ErrorCoded;

public class ResourceNotFoundException extends RuntimeException implements ErrorCoded {

    private static final long serialVersionUID = -3281446097830833349L;
    /**
     * Error code that an error will be registered with.
     */
    private String errorCode = ErrorCode.RESOURCE_NOT_FOUND.getCode();

    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(final String message, final String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ResourceNotFoundException(final String message, final String errorCode, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
