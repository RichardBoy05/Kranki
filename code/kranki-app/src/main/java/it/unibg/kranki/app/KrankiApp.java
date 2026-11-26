package it.unibg.kranki.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.unibg.kranki.core.service.AuthService;
import it.unibg.kranki.core.service.DeckService;
import it.unibg.kranki.core.service.StudyService;
import it.unibg.kranki.core.service.SyncService;
import it.unibg.kranki.core.service.WorkspaceService;
import it.unibg.kranki.ui.controller.ControllerFactory;
import it.unibg.kranki.ui.helper.I18nManager;
import it.unibg.kranki.ui.navigation.JavaFxNavigator;
import it.unibg.kranki.ui.navigation.Screen;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Composition Root responsible for wiring DB, CORE, and UI modules and
 * displaying the initial screen.
 */
public class KrankiApp extends Application {

    private static final Logger LOG = LogManager.getLogger(KrankiApp.class);

    @Override
    public void start(Stage primaryStage) {

        // uncaught exceptions handler
        Thread.UncaughtExceptionHandler crashHandler = (thread, throwable) -> LOG
                .fatal("Uncaught exception on thread {}", thread.getName(), throwable);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        Thread.currentThread().setUncaughtExceptionHandler(crashHandler);

        LOG.info("Starting Kranki application...");

        // TODO wire kranki-db gateways/repositories, WorkspaceNotifier, and AppSession
        AuthService authService = new AuthService();
        WorkspaceService workspaceService = new WorkspaceService();
        DeckService deckService = new DeckService();
        StudyService studyService = new StudyService();
        SyncService syncService = new SyncService();

        I18nManager i18nManager = new I18nManager();
        JavaFxNavigator navigator = new JavaFxNavigator(primaryStage, i18nManager);
        ControllerFactory controllerFactory = new ControllerFactory(authService, workspaceService, deckService,
                studyService, syncService, navigator, i18nManager);

        // TODO restore local session via AuthService and saved AppLanguage via
        // WorkspaceService
        navigator.start(controllerFactory, Screen.LOGIN);
    }

    @Override
    public void stop() {
        LOG.info("Shutting down Kranki application...");
    }
}
