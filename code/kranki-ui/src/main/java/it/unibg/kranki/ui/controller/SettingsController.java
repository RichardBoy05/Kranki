package it.unibg.kranki.ui.controller;

import java.util.Objects;

import it.unibg.kranki.core.service.WorkspaceService;
import it.unibg.kranki.ui.helper.I18nManager;
import it.unibg.kranki.ui.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Controller for global application preferences and language selection.
 */
public class SettingsController {

    private final WorkspaceService workspaceService;
    private final Navigator navigator;
    private final I18nManager i18nManager;

    @FXML
    private Parent root;

    SettingsController(WorkspaceService workspaceService, Navigator navigator, I18nManager i18nManager) {
        this.workspaceService = Objects.requireNonNull(workspaceService, "Workspace service must not be null");
        this.navigator = Objects.requireNonNull(navigator, "Navigator must not be null");
        this.i18nManager = Objects.requireNonNull(i18nManager, "I18n manager must not be null");
    }

    @FXML
    private void initialize() {
        // View setup will be added during Settings implementation
    }
}
