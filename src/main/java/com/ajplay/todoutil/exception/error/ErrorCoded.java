package com.ajplay.todoutil.exception.error;

public interface ErrorCoded {

    /**
     * Return the error code associated with this failure.
     * <p>
     * The GUI can render this any way it pleases, allowing for localization etc.
     * </p>
     *
     * @return a String error code associated with this failure, or {@code null} if not error-coded
     */
    String getErrorCode();
}
