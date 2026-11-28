package it.unibg.kranki.core.exception;

import java.util.Objects;

/**
 * Base checked exception for recoverable operational and domain errors in
 * Kranki.
 */
public abstract class KrankiException extends Exception {

    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;

    /**
     * Creates a new exception with a typed error code and technical message.
     *
     * @param errorCode typed error code (must not be {@code null})
     * @param message   technical English message for logging and debugging
     */
    protected KrankiException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = Objects.requireNonNull(errorCode, "errorCode must not be null");
    }

    /**
     * Creates a new exception with a typed error code, technical message, and
     * underlying cause.
     *
     * @param errorCode typed error code (must not be {@code null})
     * @param message   technical English message for logging and debugging
     * @param cause     underlying cause of this error
     */
    protected KrankiException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = Objects.requireNonNull(errorCode, "errorCode must not be null");
    }

    /**
     * Returns the typed error code describing this failure.
     *
     * @return the non-null {@link ErrorCode}
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
