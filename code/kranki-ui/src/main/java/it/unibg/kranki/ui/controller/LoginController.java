package it.unibg.kranki.ui.controller;

import java.util.Objects;

import it.unibg.kranki.core.service.AuthService;
import it.unibg.kranki.ui.navigation.Navigator;
import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Controller for the user login and registration view.
 */
public class LoginController {

    private final AuthService authService;
    private final Navigator navigator;

    @FXML
    private Parent root;

    LoginController(AuthService authService, Navigator navigator) {
        this.authService = Objects.requireNonNull(authService, "Auth service must not be null");
        this.navigator = Objects.requireNonNull(navigator, "Navigator must not be null");
    }

    @FXML
    private void initialize() {
        // View setup will be added during Login implementation
    }
}
