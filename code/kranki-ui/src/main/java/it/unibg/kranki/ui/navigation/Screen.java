package it.unibg.kranki.ui.navigation;

/**
 * Enumerates all application views and maps each one to
 * its FXML resource and internationalization title key.
 */
public enum Screen {

    LOGIN("/fxml/login.fxml", "screen.login.title"),
    MAIN("/fxml/main.fxml", "screen.main.title"),
    DECK_SETTINGS("/fxml/deck_settings.fxml", "screen.deck_settings.title"),
    BROWSER("/fxml/browser.fxml", "screen.browser.title"),
    CARD_EDITOR("/fxml/card_editor.fxml", "screen.card_editor.title"),
    STUDY_SESSION("/fxml/study_session.fxml", "screen.study_session.title"),
    STATS("/fxml/stats.fxml", "screen.stats.title"),
    SETTINGS("/fxml/settings.fxml", "screen.settings.title"),
    CONFLICT_DIALOG("/fxml/conflict_dialog.fxml", "screen.conflict_dialog.title"),
    PUBLIC_CATALOG("/fxml/public_catalog.fxml", "screen.public_catalog.title");

    private final String fxmlPath;
    private final String titleKey;

    Screen(String fxmlPath, String titleKey) {
        this.fxmlPath = fxmlPath;
        this.titleKey = titleKey;
    }

    /**
     * Returns the classpath location of the FXML file for this screen.
     *
     * @return classpath-relative FXML path
     */
    public String getFxmlPath() {
        return fxmlPath;
    }

    /**
     * Returns the resource bundle key used for the window title.
     *
     * @return i18n title key
     */
    public String getTitleKey() {
        return titleKey;
    }
}
