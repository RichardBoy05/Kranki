package it.unibg.kranki.ui.controller;

import java.util.Objects;

import it.unibg.kranki.core.service.StudyService;
import it.unibg.kranki.core.service.WorkspaceService;
import it.unibg.kranki.ui.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Controller for executing an active spaced-repetition study session.
 */
public class StudySessionController {

    private final StudyService studyService;
    private final WorkspaceService workspaceService;
    private final Navigator navigator;

    @FXML
    private Parent root;

    StudySessionController(StudyService studyService, WorkspaceService workspaceService, Navigator navigator) {
        this.studyService = Objects.requireNonNull(studyService, "Study service must not be null");
        this.workspaceService = Objects.requireNonNull(workspaceService, "Workspace service must not be null");
        this.navigator = Objects.requireNonNull(navigator, "Navigator must not be null");
    }

    @FXML
    private void initialize() {
        // View setup will be added during StudySession implementation
    }
}
