package it.unibg.kranki.ui.navigation;

import java.util.function.Consumer;

/**
 * Navigation contract exposed to UI controllers to transition between primary
 * screens, open and close modal windows, and reload active views.
 */
public interface Navigator {

    /**
     * Replaces the current view in the primary window with the specified screen.
     *
     * @param screen target primary screen
     */
    void goTo(Screen screen);

    /**
     * Replaces the current view in the primary window with the specified screen,
     * optionally configuring the target screen's controller before displaying the
     * view.
     *
     * <p>
     * If {@code controllerSetup} is non-null, it receives the controller instance
     * created for {@code screen} (not the calling controller) after FXML injection
     * and {@code initialize()} have completed. Callers must ensure that {@code C}
     * matches the {@code fx:controller} class declared in {@code screen}'s FXML
     * file.
     *
     * @param <C>             type of the target screen's controller
     * @param screen          target primary screen
     * @param controllerSetup optional callback used to pass initialization data to
     *                        the target controller, or {@code null} if no extra
     *                        setup is needed
     * @throws ClassCastException if {@code C} does not match the controller
     *                            declared by {@code screen}
     */
    <C> void goTo(Screen screen, Consumer<C> controllerSetup);

    /**
     * Opens the specified screen inside a modal window blocking its owner.
     *
     * @param screen target modal screen
     */
    void openModal(Screen screen);

    /**
     * Opens the specified screen inside a modal window blocking its owner,
     * optionally configuring the target screen's controller before displaying the
     * window.
     *
     * <p>
     * If {@code controllerSetup} is non-null, it receives the controller instance
     * created for {@code screen} (not the calling controller) after FXML injection
     * and {@code initialize()} have completed. Callers must ensure that {@code C}
     * matches the {@code fx:controller} class declared in {@code screen}'s FXML
     * file.
     *
     * @param <C>             type of the target modal's controller
     * @param screen          target modal screen
     * @param controllerSetup optional callback used to pass initialization data to
     *                        the target controller, or {@code null} if no extra
     *                        setup is needed
     * @throws ClassCastException if {@code C} does not match the controller
     *                            declared by {@code screen}
     */
    <C> void openModal(Screen screen, Consumer<C> controllerSetup);

    /**
     * Closes the topmost currently open modal window, if any.
     */
    void closeModal();

    /**
     * Reloads the current primary view and any open modal windows using the active
     * resource bundle, preserving controller setup callbacks.
     */
    void reloadCurrentView();
}
