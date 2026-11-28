package it.unibg.kranki.core.exception;

/**
 * Checked exception thrown when a domain invariant or user input validation
 * rule is violated.
 */
public class ValidationException extends KrankiException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a validation exception with an error code and technical message.
     *
     * @param errorCode typed validation error code
     * @param message   technical English description of the violation
     */
    public ValidationException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Creates a validation exception with an error code, technical message, and
     * cause.
     *
     * @param errorCode typed validation error code
     * @param message   technical English description of the violation
     * @param cause     underlying cause
     */
    public ValidationException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
