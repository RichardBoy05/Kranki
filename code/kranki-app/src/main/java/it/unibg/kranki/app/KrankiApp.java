package it.unibg.kranki.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KrankiApp {
	
    private static final Logger LOG = LogManager.getLogger(KrankiApp.class);

    public void start() {
    	
        Thread.UncaughtExceptionHandler crashHandler = (thread, throwable) ->
                LOG.fatal("Eccezione non gestita sul thread {}", thread.getName(), throwable);

        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        Thread.currentThread().setUncaughtExceptionHandler(crashHandler);

        LOG.info("Avvio applicazione Kranki");
        LOG.debug("Test diagnostico: questa riga deve comparire solo nel file kranki.log");
        
        // composition root
    }

    public void stop() {
        LOG.info("Chiusura applicazione Kranki");
    }
}
