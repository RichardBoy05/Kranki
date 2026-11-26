package it.unibg.kranki.ui.controller;

import java.util.Objects;

import it.unibg.kranki.core.service.AuthService;
import it.unibg.kranki.core.service.DeckService;
import it.unibg.kranki.core.service.StudyService;
import it.unibg.kranki.core.service.SyncService;
import it.unibg.kranki.core.service.WorkspaceService;
import it.unibg.kranki.ui.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Controller for the main workspace view hosting top actions and the deck list.
 */
public class MainController {

    private final AuthService authService;
    private final WorkspaceService workspaceService;
    private final DeckService deckService;
    private final StudyService studyService;
    private final SyncService syncService;
    private final Navigator navigator;

    @FXML
    private Parent root;

    MainController(AuthService authService, WorkspaceService workspaceService, DeckService deckService,
            StudyService studyService, SyncService syncService, Navigator navigator) {
        this.authService = Objects.requireNonNull(authService, "Auth service must not be null");
        this.workspaceService = Objects.requireNonNull(workspaceService, "Workspace service must not be null");
        this.deckService = Objects.requireNonNull(deckService, "Deck service must not be null");
        this.studyService = Objects.requireNonNull(studyService, "Study service must not be null");
        this.syncService = Objects.requireNonNull(syncService, "Sync service must not be null");
        this.navigator = Objects.requireNonNull(navigator, "Navigator must not be null");
    }

    @FXML
    private void initialize() {
        // View setup and observer registration will be added during Main implementation
    }
}
