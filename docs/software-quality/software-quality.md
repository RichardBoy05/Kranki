## Qualità del software

La specifica e la valutazione dei requisiti qualitativi del sistema *Kranki* sono state condotte adottando il **Modello di McCall**, preferito allo standard ISO 9126 per la sua natura spiccatamente pragmatica. Tale framework permette infatti di declinare oggettivamente la qualità del software secondo tre macro-prospettive distinte: l'interazione con l'utente finale (*Product Operations*), le necessità tecniche e ingegneristiche del team di sviluppo (*Product Revision*) e il ciclo di vita del prodotto in relazione all'ambiente di esecuzione (*Product Transition*).

### 1. Product operations
Questa categoria raccoglie i fattori qualitativi legati all'utilizzo quotidiano del sistema da parte dello studente.

* **Usabilità**: il sistema deve minimizzare il carico cognitivo associato all'interazione con l'interfaccia, permettendo all'utente di mantenere il focus esclusivamente sull'apprendimento.\
  *Verificabilità*: implementazione pervasiva di scorciatoie da tastiera (*keyboard shortcuts*), al fine di garantire allo studente la possibilità di completare un'intera sessione di ripasso e valutazione delle carte senza ricorrere a dispositivi di puntamento.
* **Affidabilità**: i progressi di studio rappresentano il dato critico del sistema e non devono subire alterazioni o perdite in caso di anomalie hardware o software.\
  *Verificabilità*: adozione di meccanismi di salvataggio transazionale e persistenza sicura dei dati in locale, eseguiti in tempo reale al termine di ogni singolo ciclo di valutazione di una *flashcard*.
* **Integrità**: i dati personali e i mazzi di carte dello studente devono essere protetti da accessi o manipolazioni non autorizzate.\
  *Verificabilità*: implementazione di un sistema di autenticazione mediante credenziali, atto a vincolare l'accesso all'applicativo e la visibilità dei dati salvati esclusivamente al legittimo proprietario.

### 2. Product revision
Questa categoria riflette l'attitudine del software a essere analizzato, manutenuto ed evoluto dal team di sviluppo.

* **Manutenibilità**: il codice sorgente deve prevenire il degrado architetturale, mantenendosi leggibile e rigorosamente strutturato per agevolare lo sviluppo parallelo.\
  *Verificabilità*: integrazione della piattaforma **SonarCloud** per il monitoraggio continuo della *codebase*, con l'obiettivo qualitativo di minimizzare la *Complessità Ciclomatica* e prevenire l'introduzione di difetti logici o anomalie strutturali.
* **Testabilità**: le logiche algoritmiche centrali del sistema (come il motore di *Spaced Repetition*) devono produrre risultati predicibili e agevolmente collaudabili in modo isolato.\
  *Verificabilità*: adozione del framework **JUnit** per la stesura di test unitari automatizzati, affiancato dallo strumento **JaCoCo** per la misurazione continua e oggettiva della *Code Coverage*, con focus ispettivo primario sul modulo della logica di business (`kranki-core`).

### 3. Product transition
Questa categoria valuta l'adattabilità del software ai cambiamenti ambientali e la sua capacità di integrarsi con l'esterno.

* **Riutilizzabilità**: l'architettura del software deve consentire il riuso dei moduli logici e di persistenza in contesti operativi differenti, come ad esempio in future trasposizioni in ambito *mobile*.\
  *Verificabilità*: netta separazione architetturale in progetti Maven indipendenti. I moduli `kranki-core` e `kranki-db` sono progettati in modo da non avere alcuna dipendenza verso il modulo dell'interfaccia grafica desktop (`kranki-ui`), garantendone il potenziale riutilizzo isolato (così come sono) in altri applicativi.