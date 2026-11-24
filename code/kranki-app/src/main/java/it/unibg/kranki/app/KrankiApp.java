package it.unibg.kranki.app;

import it.unibg.kranki.core.types.AppLanguage;
import it.unibg.kranki.ui.helper.I18nManager;
import it.unibg.kranki.ui.navigation.Screen;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Composition Root responsible for wiring DB, CORE
 * and UI modules and displaying the initial screen.
 */
public class KrankiApp extends Application {

    private static final Logger LOG = LogManager.getLogger(KrankiApp.class);

    private static final String STYLESHEET_PATH = "/css/kranki.css";
    private static final String APP_TITLE_KEY = "app.title";
    private static final String DEFAULT_TITLE = "Kranki";
    private static final double DEFAULT_WIDTH = 1024.0;
    private static final double DEFAULT_HEIGHT = 680.0;
    private static final double MIN_WIDTH = 800.0;
    private static final double MIN_HEIGHT = 560.0;

    @Override
    public void init() {
    	
    	// uncaught exceptions handler
        Thread.UncaughtExceptionHandler crashHandler = (thread, throwable) ->
                LOG.fatal("Uncaught exception on thread {}", thread.getName(), throwable);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        Thread.currentThread().setUncaughtExceptionHandler(crashHandler);

        LOG.info("Starting Kranki application...");
        LOG.debug("Diagnostic test: this line should appear only in kranki.log");
    }

    @Override
    public void start(Stage primaryStage) {
        Objects.requireNonNull(primaryStage, "Primary stage must not be null");

        I18nManager i18nManager = new I18nManager(AppLanguage.IT);
        Screen initialScreen = Screen.LOGIN;
        ResourceBundle bundle = i18nManager.getBundle();

        Parent root = loadScreenRoot(initialScreen, bundle);
        Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        applyStylesheet(scene);

        primaryStage.setMinWidth(MIN_WIDTH);
        primaryStage.setMinHeight(MIN_HEIGHT);
        primaryStage.setTitle(resolveTitle(bundle, initialScreen));
        primaryStage.setScene(scene);
        primaryStage.show();

        LOG.info("Initial screen displayed: {}", initialScreen);
    }

    @Override
    public void stop() {
        LOG.info("Stopping Kranki application...");
    }

    private Parent loadScreenRoot(Screen screen, ResourceBundle bundle) {
        URL fxmlUrl = Screen.class.getResource(screen.getFxmlPath());
        if (fxmlUrl == null) {
            throw new IllegalStateException("FXML resource not found: " + screen.getFxmlPath());
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl, bundle);
        try {
            return loader.load();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load FXML view: " + screen.getFxmlPath(), e);
        }
    }

    private void applyStylesheet(Scene scene) {
        URL cssUrl = Screen.class.getResource(STYLESHEET_PATH);
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }
    }

    private String resolveTitle(ResourceBundle bundle, Screen screen) {
        String key = screen.getTitleKey();
        if (bundle.containsKey(key)) {
            return bundle.getString(key);
        }
        return bundle.containsKey(APP_TITLE_KEY) ? bundle.getString(APP_TITLE_KEY) : DEFAULT_TITLE;
    }
}