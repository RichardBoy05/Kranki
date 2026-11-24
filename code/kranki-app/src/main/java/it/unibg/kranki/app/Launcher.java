package it.unibg.kranki.app;

import javafx.application.Application;

/**
 * Entry point delegating application startup to {@link KrankiApp}.
 */
public final class Launcher {
	
	private Launcher(){
		// prevents instantiation
	}
	
    /**
     * Launches the JavaFX runtime.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {   	
    	Application.launch(KrankiApp.class, args);
    }
}
