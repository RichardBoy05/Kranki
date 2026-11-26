package it.unibg.kranki.ui.navigation;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.SequencedMap;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.unibg.kranki.ui.helper.I18nManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * JavaFX-based implementation of {@link Navigator} managing the primary stage,
 * modal window stack, FXML loading, resource bundles, and global styling.
 */
public class JavaFxNavigator implements Navigator {

    private static final Logger LOG = LogManager.getLogger(JavaFxNavigator.class);
    private static final String STYLESHEET_PATH = "/css/kranki.css";

    private final Stage primaryStage;
    private final I18nManager i18nManager;
    private final SequencedMap<Stage, Runnable> modalWindows = new LinkedHashMap<>();

    private Callback<Class<?>, Object> controllerFactory;
    private Screen currentPrimaryScreen;
    private Consumer<FXMLLoader> currentPrimarySetup;

    /**
     * Creates a navigator bound to the given primary stage and i18n manager.
     *
     * @param primaryStage main application window
     * @param i18nManager  internationalization manager supplying active bundles
     */
    public JavaFxNavigator(Stage primaryStage, I18nManager i18nManager) {
        this.primaryStage = Objects.requireNonNull(primaryStage, "Primary stage must not be null");
        this.i18nManager = Objects.requireNonNull(i18nManager, "I18n manager must not be null");
    }

    /**
     * Initializes the navigator with the controller factory and displays the
     * initial screen. Intended to be invoked exclusively during application
     * bootstrap.
     *
     * @param controllerFactory factory used by {@link FXMLLoader} to instantiate
     *                          controllers
     * @param initialScreen     first screen to display in the primary window
     */
    public void start(Callback<Class<?>, Object> controllerFactory, Screen initialScreen) {
        this.controllerFactory = Objects.requireNonNull(controllerFactory, "Controller factory must not be null");
        Objects.requireNonNull(initialScreen, "Initial screen must not be null");

        goTo(initialScreen);
        primaryStage.show();
        primaryStage.centerOnScreen();
        LOG.info("Navigator started with initial screen {}", initialScreen);
    }

    @Override
    public void goTo(Screen screen) {
        goTo(screen, null);
    }

    @Override
    public <C> void goTo(Screen screen, Consumer<C> controllerSetup) {
        Objects.requireNonNull(screen, "Screen must not be null");
        Consumer<FXMLLoader> setup = controllerSetup == null ? null
                : fxmlLoader -> controllerSetup.accept(fxmlLoader.getController());

        Parent root = loadRoot(screen, setup);

        // closes all modal views
        while (!modalWindows.isEmpty()) {
            modalWindows.pollLastEntry().getKey().close();
        }

        if (primaryStage.getScene() == null) {
            Scene scene = new Scene(root);
            applyStylesheet(scene);
            primaryStage.setScene(scene);
        } else {
            primaryStage.getScene().setRoot(root);
            if (!primaryStage.isMaximized()) {
                primaryStage.sizeToScene();
            }
        }

        primaryStage.setTitle(resolveTitle(screen));
        currentPrimaryScreen = screen;
        currentPrimarySetup = setup;
        LOG.debug("Navigated to primary screen {}", screen);
    }

    @Override
    public void openModal(Screen screen) {
        openModal(screen, null);
    }

    @Override
    public <C> void openModal(Screen screen, Consumer<C> controllerSetup) {
        Objects.requireNonNull(screen, "Screen must not be null");
        Consumer<FXMLLoader> setup = controllerSetup == null ? null
                : fxmlLoader -> controllerSetup.accept(fxmlLoader.getController());

        Parent root = loadRoot(screen, setup);
        Stage owner = modalWindows.isEmpty() ? primaryStage : modalWindows.lastEntry().getKey();

        Stage modalStage = new Stage();
        modalStage.initOwner(owner);
        modalStage.initModality(Modality.WINDOW_MODAL);
        modalStage.setTitle(resolveTitle(screen));

        Scene modalScene = new Scene(root);
        applyStylesheet(modalScene);
        modalStage.setScene(modalScene);

        modalWindows.put(modalStage, () -> reloadModal(modalStage, screen, setup));
        modalStage.setOnHidden(_ -> {
            modalWindows.remove(modalStage);
            modalStage.setScene(null);
            LOG.debug("Closed modal screen {}", screen);
        });
        modalStage.show();
        LOG.debug("Opened modal screen {}", screen);
    }

    @Override
    public void closeModal() {
        var topEntry = modalWindows.pollLastEntry();
        if (topEntry != null) {
            topEntry.getKey().close();
        }
    }

    @Override
    public void reloadCurrentView() {
        if (currentPrimaryScreen == null) {
            LOG.warn("Ignoring view reload because no primary screen is active");
            return;
        }

        Parent primaryRoot = loadRoot(currentPrimaryScreen, currentPrimarySetup);
        primaryStage.getScene().setRoot(primaryRoot);
        primaryStage.setTitle(resolveTitle(currentPrimaryScreen));
        if (!primaryStage.isMaximized()) {
            primaryStage.sizeToScene();
        }

        for (Runnable reloadAction : List.copyOf(modalWindows.values())) {
            reloadAction.run();
        }
        LOG.debug("Reloaded active views for language {}", i18nManager.getCurrentLanguage());
    }

    /**
     * Loads the FXML root for the given screen and runs the optional controller
     * setup.
     *
     * @param screen target screen to load
     * @param setup  optional loader-level callback invoking target controller
     *               configuration
     * @return loaded root node
     */
    private Parent loadRoot(Screen screen, Consumer<FXMLLoader> setup) {
        if (controllerFactory == null) {
            throw new IllegalStateException("Navigator has not been started yet");
        }

        URL fxmlUrl = getClass().getResource(screen.getFxmlPath());
        if (fxmlUrl == null) {
            throw new IllegalStateException("FXML resource not found: " + screen.getFxmlPath());
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl, i18nManager.getBundle());
        loader.setControllerFactory(controllerFactory);

        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            LOG.error("Failed to load FXML view '{}' for screen {}", screen.getFxmlPath(), screen, e);
            throw new IllegalStateException("Unable to load FXML view: " + screen.getFxmlPath(), e);
        }

        if (setup != null) {
            if (loader.getController() == null) {
                throw new IllegalStateException("FXML view has no controller assigned: " + screen.getFxmlPath());
            }
            setup.accept(loader);
        }
        return root;
    }

    /**
     * Reloads an open modal stage with the active resource bundle while preserving
     * its setup.
     *
     * @param modalStage modal window to refresh
     * @param screen     screen displayed inside the modal
     * @param setup      optional controller setup callback to re-apply
     */
    private void reloadModal(Stage modalStage, Screen screen, Consumer<FXMLLoader> setup) {
        Parent modalRoot = loadRoot(screen, setup);
        modalStage.getScene().setRoot(modalRoot);
        modalStage.setTitle(resolveTitle(screen));
        if (!modalStage.isMaximized()) {
            modalStage.sizeToScene();
        }
    }

    /**
     * Attaches the global CSS stylesheet to the given scene if present on the
     * classpath.
     *
     * @param scene scene to style
     */
    private void applyStylesheet(Scene scene) {
        URL cssUrl = getClass().getResource(STYLESHEET_PATH);
        if (cssUrl == null) {
            LOG.warn("Stylesheet '{}' not found on classpath", STYLESHEET_PATH);
            return;
        }
        scene.getStylesheets().add(cssUrl.toExternalForm());
    }

    /**
     * Resolves the localized window title for the given screen from the active
     * bundle.
     *
     * @param screen target screen
     * @return localized title string, or {@code screen.name()} as fallback
     */
    private String resolveTitle(Screen screen) {
        ResourceBundle bundle = i18nManager.getBundle();
        String titleKey = screen.getTitleKey();
        if (bundle.containsKey(titleKey)) {
            return bundle.getString(titleKey);
        }
        LOG.warn("Missing i18n title key '{}' for screen {}", titleKey, screen);
        return screen.name();
    }
}
