package it.unibg.kranki.ui.helper;

import it.unibg.kranki.core.types.AppLanguage;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Manages the active application language and provides the
 * corresponding {@link ResourceBundle} for JavaFX views.
 */
public class I18nManager {

    private static final String BUNDLE_BASE_NAME = "i18n.messages";

    private AppLanguage currentLanguage;

    /**
     * Creates an internationalization manager initialized to Italian.
     */
    public I18nManager() {
        this(AppLanguage.IT);
    }

    /**
     * Creates an internationalization manager with the given initial language.
     *
     * @param initialLanguage initial active language
     */
    public I18nManager(AppLanguage initialLanguage) {
        this.currentLanguage = Objects.requireNonNull(initialLanguage, "Initial language must not be null");
    }

    /**
     * Returns the currently active language.
     *
     * @return current {@link AppLanguage}
     */
    public AppLanguage getCurrentLanguage() {
        return currentLanguage;
    }

    /**
     * Updates the active language.
     *
     * @param language new {@link AppLanguage} to activate
     */
    public void setLanguage(AppLanguage language) {
        this.currentLanguage = Objects.requireNonNull(language, "Language must not be null");
    }

    /**
     * Returns the {@link Locale} matching the currently active language.
     *
     * @return current {@link Locale}
     */
    public Locale getCurrentLocale() {
        return switch (currentLanguage) {
            case IT -> Locale.ITALIAN;
            case EN -> Locale.ENGLISH;
        };
    }

    /**
     * Loads and returns the {@link ResourceBundle} for the active language.
     *
     * @return active {@link ResourceBundle}
     */
    public ResourceBundle getBundle() {
        return ResourceBundle.getBundle(BUNDLE_BASE_NAME, getCurrentLocale());
    }
}
