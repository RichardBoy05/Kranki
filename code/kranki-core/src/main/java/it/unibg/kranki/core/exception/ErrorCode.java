package it.unibg.kranki.core.exception;

public enum ErrorCode {
    // Deck name is null or blank.
    DECK_NAME_EMPTY("error.deck.name.empty"),

    // A deck with the same name already exists in the workspace.
    DECK_NAME_DUPLICATE("error.deck.name.duplicate"),

    // Requested deck identifier does not exist in the workspace.
    DECK_NOT_FOUND("error.deck.not_found"),

    // Flashcard front text is null or blank.
    CARD_FRONT_EMPTY("error.card.front.empty"),

    // Requested flashcard identifier does not exist in the deck.
    CARD_NOT_FOUND("error.card.not_found"),

    // Manually forced due date is invalid or null.
    CARD_INVALID_DUE_DATE("error.card.invalid_due_date");

    private final String i18nKey;

    ErrorCode(String i18nKey) {
        this.i18nKey = i18nKey;
    }

    /**
     * Returns the internationalization key associated with this error code.
     *
     * @return the i18n lookup key
     */
    public String getI18nKey() {
        return i18nKey;
    }

}
