package it.unibg.kranki.core.exception;

/**
 * Defines domain-level error codes used to classify failures across the application
 * without exposing technical details to the user interface.
 */
public enum ErrorCode {
    /*
     * Authentication errors
     */
    AUTH_INVALID_CREDENTIALS, // Invalid mail/password or both
    AUTH_EMAIL_ALREADY_EXISTS, // Sing-up of an account that already exists
    AUTH_INVALID_EMAIL, // Invalid email format 
    AUTH_WEAK_PASSWORD, // Password with less than 6 characters: too short
    AUTH_USER_DISABLED, // User disabled using console
    AUTH_TOO_MANY_ATTEMPTS, // Temporary block due to too many attempts
    AUTH_SESSION_EXPIRED, // Refresh token expired/revoked
    AUTH_NETWORK_ERROR, // No connection/Timeout
    AUTH_UNEXPECTED_ERROR; // Other types of error
    
}
