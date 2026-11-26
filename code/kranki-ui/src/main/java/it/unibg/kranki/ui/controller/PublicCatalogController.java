package it.unibg.kranki.ui.controller;

import java.util.Objects;

import it.unibg.kranki.core.service.SyncService;
import it.unibg.kranki.ui.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Controller for browsing and importing shared decks from the public catalog.
 */
public class PublicCatalogController {

    private final SyncService syncService;
    private final Navigator navigator;

    @FXML
    private Parent root;

    PublicCatalogController(SyncService syncService, Navigator navigator) {
        this.syncService = Objects.requireNonNull(syncService, "Sync service must not be null");
        this.navigator = Objects.requireNonNull(navigator, "Navigator must not be null");
    }

    @FXML
    private void initialize() {
        // View setup will be added during PublicCatalog implementation
    }
}
