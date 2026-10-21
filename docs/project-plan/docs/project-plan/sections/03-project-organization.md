## 3. Organizzazione del progetto

Questo capitolo descrive l'organizzazione generale del progetto, definendo i rapporti con le figure esterne (committenti e utenti) e la divisione pratica dei compiti all'interno del team di sviluppo. Vengono inoltre identificate le tecnologie che richiedono uno studio preliminare da parte dei membri del gruppo.

### 3.1 Relazioni con enti esterni
Il progetto si interfaccia con le seguenti figure esterne al team di sviluppo:

* **Committenza:** Rappresentata dal Prof. Angelo Gargantini e dalla Dott.ssa Silvia Bonfanti. Valuteranno il lavoro svolto e i documenti prodotti. Le comunicazioni formali e le richieste di approvazione per i documenti principali (come questo *Project Plan*) avverranno tramite l'apertura di *Issue* sul repository GitHub ufficiale del progetto.
* **Utenti Finali:** Sono gli studenti universitari. Poiché il team stesso fa parte di questa categoria, i membri del gruppo agiranno direttamente da "esperti di dominio", basandosi sulle proprie necessità reali per definire i requisiti (es. la gestione delle scadenze d'esame) e valutare la praticità dell'applicazione.

### 3.2 Organizzazione interna del team
Il gruppo di sviluppo adotta un approccio collaborativo in cui tutti i membri partecipano attivamente alla scrittura del codice sorgente. Le attività organizzative (come l'aggiornamento della *Kanban board* e la gestione degli *Issue* su GitHub) e la stesura dei test di unità sono responsabilità condivise: ogni sviluppatore si impegna a testare e tracciare il proprio lavoro.

Tuttavia, per soddisfare i requisiti del corso e garantire un'efficiente divisione dei compiti in un gruppo da 4 persone, il codice e le funzionalità sono stati divisi in macro-aree di competenza principale:

* **Meoli Richard (Focus: Interfaccia Grafica):** Si occupa principalmente dello sviluppo del *frontend* dell'applicazione. Il suo lavoro si concentra sulla realizzazione e gestione dell'interfaccia utente (UI) utilizzando JavaFX e *Scene Builder*.
* **Pullano Gabriele (Focus: Database e Cloud):** Si occupa principalmente della persistenza dei dati. Il suo compito è gestire l'integrazione del software con Firebase, implementando l'autenticazione degli utenti e la comunicazione con il database NoSQL per il salvataggio dei mazzi.
* **Berardi Francesco (Focus: Logica Core e Algoritmi):** Si dedica allo sviluppo della logica di dominio (*Business Logic*). Il suo lavoro si concentra sulla struttura base delle classi (Mazzi, Carte) e sull'implementazione matematica del motore di *Spaced Repetition* (algoritmo SM-2).
* **Rapetti Giorgio (Focus: Logica Core e Integrazione):** Collabora allo sviluppo della logica di dominio. Si occupa principalmente dell'implementazione delle funzionalità avanzate (come l'algoritmo per la *Cram Mode* basata sulle scadenze d'esame) e dell'integrazione generale tra i vari moduli del sistema (UI, DB e Core).

### 3.3 Identificazione delle lacune di conoscenza (Training)
Poiché il progetto richiede l'uso di tecnologie non del tutto coperte dai corsi precedenti, il team dedicherà una prima fase allo studio preliminare di alcuni strumenti prima di avviare la scrittura del codice. Le aree di studio riguardano:

* **JavaFX:** Comprensione del framework e utilizzo del tool *Scene Builder* per la creazione e la gestione dei file grafici `.fxml`.
* **Firebase (NoSQL e Asincronia):** Studio dell'SDK di Firebase in ambiente Java per gestire correttamente il salvataggio dei dati sul cloud, facendo attenzione a eseguire le chiamate di rete senza bloccare l'interfaccia utente.
* **Git e GitHub:** Consolidamento delle pratiche di collaborazione sul codice, con particolare attenzione alla risoluzione dei conflitti e all'utilizzo delle *Pull Request*.

Queste conoscenze verranno acquisite tramite lo studio della documentazione ufficiale e il supporto reciproco tra i membri del team.

