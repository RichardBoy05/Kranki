package it.unibg.kranki.core.exception;

import java.util.Objects;

/**
 * Base checked exception for all domain and infrastructure errors in Kranki.
 * Each exception carries a {@link ErrorCode} to allow consistent handling in upper layers.
 */
public class KrankiException extends Exception{
    private static final long serialVersionUID = 1L;
    private final ErrorCode errorCode;
    
    /**
     * Constructs a new exception with the specified error code and detail message.
     *
     * @param errorCode the specific {@link ErrorCode} identifying the failure
     * @param message   the detail message explaining the error
     */
    protected KrankiException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = Objects.requireNonNull(errorCode, "errorCode must not be null"); // Must use a valid errorCode
    }
    
    /**
     * Constructs a new exception with the specified error code, detail message, and root cause.
     *
     * @param errorCode the specific {@link ErrorCode} identifying the failure
     * @param message   the detail message explaining the error
     * @param cause     the underlying cause of this exception
     */
    protected KrankiException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = Objects.requireNonNull(errorCode, "errorCode must not be null");
    }
    
    /**
     * Returns the domain error code associated with this exception.
     *
     * @return the {@link ErrorCode} of this exception
     */
    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
