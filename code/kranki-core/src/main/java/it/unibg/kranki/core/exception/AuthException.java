package it.unibg.kranki.core.exception;

/**
 * Exception thrown when an authentication or registration operation fails.
 */
public class AuthException extends KrankiException{
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new authentication exception with the specified error code and message.
     *
     * @param errorCode the specific {@link ErrorCode} identifying the authentication failure
     * @param message   the detail message explaining the error
     */
    public AuthException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Constructs a new authentication exception with the specified error code, message, and cause.
     *
     * @param errorCode the specific {@link ErrorCode} identifying the authentication failure
     * @param message   the detail message explaining the error
     * @param cause     the underlying technical exception
     */
    public AuthException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
