package it.unibg.kranki.db.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

/**
 * Holds Firebase configuration properties and builds REST endpoint URIs.
 */
public class FirebaseConfig {
    private static final String DEFAULT_PROPERTIES_FILE = "firebase.properties"; // standard declaration for constant
    private final String apiKey;
    private final String rtdbUrl; // added but will be implemented when developing REQ-2.
    private final String authUrl;
    private final String tokenUrl;

    /**
     * Loads the Firebase configuration from {@code firebase.properties} on the classpath.
     */
    public FirebaseConfig() {
        Properties props = loadProperties(DEFAULT_PROPERTIES_FILE);
        this.apiKey = requireNonBlank(props.getProperty("firebase.api.key"), "firebase.api.key");
        this.rtdbUrl = normalizeUrl(props.getProperty("firebase.rtdb.url"), "firebase.rtdb.url");
        this.authUrl = normalizeUrl(props.getProperty("firebase.auth.url"), "firebase.auth.url");
        this.tokenUrl = normalizeUrl(props.getProperty("firebase.token.url"), "firebase.token.url");
    }

    /**
     * Creates a configuration from explicit parameters for testing.
     */
    public FirebaseConfig(String apiKey, String rtdbUrl, String authUrl, String tokenUrl) {
        this.apiKey = requireNonBlank(apiKey, "firebase.api.key");
        this.rtdbUrl = normalizeUrl(rtdbUrl, "firebase.rtdb.url");
        this.authUrl = normalizeUrl(authUrl, "firebase.auth.url");
        this.tokenUrl = normalizeUrl(tokenUrl, "firebase.token.url");
    }

    /**
     * @return URI, standard for URLs. Distinguishes: protocol, host, path and parameters 
     */
    public URI getSignUpUri() {
        // URI.create checks that the address is syntactically valid
        return URI.create(authUrl + "/accounts:signUp?key=" + apiKey);
    }

    public URI getSignInUri() {
        return URI.create(authUrl + "/accounts:signInWithPassword?key=" + apiKey);
    }

    public URI getRefreshTokenUri() {
        return URI.create(tokenUrl + "/token?key=" + apiKey);
    }
    
    /**
     * Why static: used in constructors, static methods are guaranteed not to accidentally 
     * read an object's field that has not yet been initialized.
     */
    private static Properties loadProperties(String fileName) { 
        Properties props = new Properties();
        // Search for firebase.properties in the classpath and open an input stream
        try (InputStream input = FirebaseConfig.class.getClassLoader().getResourceAsStream(fileName)) {
            // if the file doesn't exist, getResourceAsStream returns null
            if (input == null) {
                throw new IllegalStateException("Configuration file not found: " + fileName);
            }
            props.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load configuration file: " + fileName, e);
        }
        return props;
    }

    private static String requireNonBlank(String value, String propertyName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing or blank property: " + propertyName);
        }
        return value.trim();
    }

    private static String normalizeUrl(String value, String propertyName) {
        String cleaned = requireNonBlank(value, propertyName);
        while (cleaned.endsWith("/")) {
            cleaned = cleaned.substring(0, cleaned.length() - 1);
        }
        return cleaned;
    }
}
