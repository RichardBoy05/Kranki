package it.unibg.kranki.ui.controller;

import java.util.Objects;

import it.unibg.kranki.core.service.DeckService;
import it.unibg.kranki.ui.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Controller for the per-deck settings modal view.
 */
public class DeckSettingsController {

    private final DeckService deckService;
    private final Navigator navigator;

    @FXML
    private Parent root;

    DeckSettingsController(DeckService deckService, Navigator navigator) {
        this.deckService = Objects.requireNonNull(deckService, "Deck service must not be null");
        this.navigator = Objects.requireNonNull(navigator, "Navigator must not be null");
    }

    @FXML
    private void initialize() {
        // View setup will be added during DeckSettings implementation
    }
}
