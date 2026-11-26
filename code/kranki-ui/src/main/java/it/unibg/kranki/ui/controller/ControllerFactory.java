package it.unibg.kranki.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import it.unibg.kranki.core.service.AuthService;
import it.unibg.kranki.core.service.DeckService;
import it.unibg.kranki.core.service.StudyService;
import it.unibg.kranki.core.service.SyncService;
import it.unibg.kranki.core.service.WorkspaceService;
import it.unibg.kranki.ui.helper.I18nManager;
import it.unibg.kranki.ui.navigation.Navigator;
import javafx.util.Callback;

/**
 * Factory used by {@link javafx.fxml.FXMLLoader} to instantiate UI controllers
 * with explicit constructor dependency injection.
 */
public class ControllerFactory implements Callback<Class<?>, Object> {

    private final Map<Class<?>, Supplier<Object>> factories;

    /**
     * Creates a controller factory backed by the application services and UI
     * infrastructure.
     *
     * @param authService      authentication service
     * @param workspaceService workspace service
     * @param deckService      deck and flashcard management service
     * @param studyService     study session and statistics service
     * @param syncService      synchronization and public catalog service
     * @param navigator        navigation facade
     * @param i18nManager      internationalization manager (injected only into
     *                         {@link SettingsController})
     */
    public ControllerFactory(AuthService authService, WorkspaceService workspaceService, DeckService deckService,
            StudyService studyService, SyncService syncService, Navigator navigator, I18nManager i18nManager) {
        Objects.requireNonNull(authService, "Auth service must not be null");
        Objects.requireNonNull(workspaceService, "Workspace service must not be null");
        Objects.requireNonNull(deckService, "Deck service must not be null");
        Objects.requireNonNull(studyService, "Study service must not be null");
        Objects.requireNonNull(syncService, "Sync service must not be null");
        Objects.requireNonNull(navigator, "Navigator must not be null");
        Objects.requireNonNull(i18nManager, "I18n manager must not be null");

        Map<Class<?>, Supplier<Object>> map = new HashMap<>();
        map.put(LoginController.class, () -> new LoginController(authService, navigator));
        map.put(MainController.class, () -> new MainController(authService, workspaceService, deckService, studyService,
                syncService, navigator));
        map.put(DeckSettingsController.class, () -> new DeckSettingsController(deckService, navigator));
        map.put(BrowserController.class, () -> new BrowserController(deckService, workspaceService, navigator));
        map.put(CardEditorController.class, () -> new CardEditorController(deckService, workspaceService, navigator));
        map.put(StudySessionController.class,
                () -> new StudySessionController(studyService, workspaceService, navigator));
        map.put(StatsController.class, () -> new StatsController(studyService, workspaceService, navigator));
        map.put(SettingsController.class, () -> new SettingsController(workspaceService, navigator, i18nManager));
        map.put(ConflictDialogController.class, () -> new ConflictDialogController(syncService, navigator));
        map.put(PublicCatalogController.class, () -> new PublicCatalogController(syncService, navigator));
        this.factories = Map.copyOf(map);
    }

    @Override
    public Object call(Class<?> controllerClass) {
        Objects.requireNonNull(controllerClass, "Controller class must not be null");
        Supplier<Object> supplier = factories.get(controllerClass);
        if (supplier == null) {
            throw new IllegalArgumentException("No controller factory registered for " + controllerClass.getName());
        }
        return supplier.get();
    }
}
