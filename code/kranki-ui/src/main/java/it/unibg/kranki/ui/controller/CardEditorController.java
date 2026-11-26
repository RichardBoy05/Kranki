package it.unibg.kranki.ui.controller;

import java.util.Objects;

import it.unibg.kranki.core.service.DeckService;
import it.unibg.kranki.core.service.WorkspaceService;
import it.unibg.kranki.ui.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Controller for creating and editing flashcards.
 */
public class CardEditorController {

    private final DeckService deckService;
    private final WorkspaceService workspaceService;
    private final Navigator navigator;

    @FXML
    private Parent root;

    CardEditorController(DeckService deckService, WorkspaceService workspaceService, Navigator navigator) {
        this.deckService = Objects.requireNonNull(deckService, "Deck service must not be null");
        this.workspaceService = Objects.requireNonNull(workspaceService, "Workspace service must not be null");
        this.navigator = Objects.requireNonNull(navigator, "Navigator must not be null");
    }

    @FXML
    private void initialize() {
        // View setup will be added during CardEditor implementation
    }
}
