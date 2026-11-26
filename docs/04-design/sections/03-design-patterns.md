## 4.2 Design patterns

A completamento delle scelte architetturali, la progettazione dettagliata di **Kranki** si fonda sull'adozione mirata di quattro *design patterns* classici. Ciascun pattern risponde a specifiche esigenze di flessibilità, separazione delle responsabilità e contenimento della complessità strutturale tra i moduli del sistema.

### 4.2.1 Strategy

#### Descrizione del pattern

Il pattern comportamentale **Strategy** affronta la necessità di dotare un componente applicativo (*Context*) di un comportamento o algoritmo che possa essere sostituito dinamicamente a *runtime*. Quando diverse varianti algoritmiche coesistono all'interno del medesimo processo, l'inclusione diretta della loro logica nel *Context* comprometterebbe l'estensibilità del sistema, costringendo a intervenire sul codice del chiamante ogni volta che viene introdotto un nuovo algoritmo o modificata una variante esistente.

La soluzione prevede l'estrazione delle singole famiglie algoritmiche in classi dedicate, governate da un'astrazione comune:
* **`Strategy`:** interfaccia comune che espone il contratto operativo attraverso cui l'algoritmo viene invocato.
* **`ConcreteStrategy`:** implementazioni concrete dell'interfaccia, ciascuna delle quali realizza una specifica variante dell'algoritmo.
* **`Context`:** classe che mantiene un riferimento all'interfaccia `Strategy` e delega a essa l'esecuzione dell'elaborazione richiesta, rimanendo ignara della classe concreta utilizzata.
* **`Client`:** componente responsabile di selezionare la `ConcreteStrategy` idonea allo scenario d'uso corrente e di associarla al `Context`.

#### Punto di applicazione in Kranki

Il pattern è applicato all'interno del modulo `kranki-core` per governare le logiche di programmazione dei ripassi:
* Nel package `core.scheduling`, l'interfaccia `SchedulingStrategy` definisce il contratto comune per il calcolo degli intervalli di revisione. Le classi `Sm2Scheduler` ed `ExamModeScheduler` fungono da *ConcreteStrategy*, implementando rispettivamente la variante adattata dell'algoritmo *SM-2* e la logica di compressione temporale della modalità *Exam Mode*. 
* Nel package `core.study`, `StudySession` opera nel ruolo di *Context*: interagisce esclusivamente mediante l'interfaccia `SchedulingStrategy`, utilizzandola sia per calcolare le quattro anteprime dei prossimi intervalli di ripasso esposte sui pulsanti di autovalutazione, sia per aggiornare l'entità di stato `ReviewProgress` (`core.model`) al termine della revisione di ciascuna *Flashcard*.
* Nel package `core.service`, `StudyService` agisce da *Client* nel momento dell'avvio di una *Sessione di studio*: in base alle impostazioni del `Deck` interessato — nello specifico, verificando l'eventuale presenza di una data limite `examDeadline` — seleziona la strategia opportuna e la associa all'istanza di `StudySession`.

#### Motivazione della scelta

L'adozione del pattern **Strategy** risulta determinante per mantenere elevata la qualità strutturale del nucleo algoritmico del sistema:
* **Contenimento della complessità ciclomatica:** in assenza di questo pattern, `StudySession` o le entità di dominio dovrebbero integrare catene di costrutti condizionali per discriminare tra ripasso standard ed *Exam Mode*, mescolando la gestione della coda di studio con le formule matematiche di scheduling. Estrarre le strategie consente di mantenere bassa e controllata la complessità ciclomatica sia di `StudySession` sia dei singoli scheduler.
* **Coesione, *Information Hiding* e testabilità unitaria:** ogni *ConcreteStrategy* isola al proprio interno i dettagli matematici del corrispondente algoritmo. Ciò rende ciascun algoritmo collaudabile in modo indipendente tramite test unitari.
* ***Open/Closed Principle*:** `StudySession` rimane chiusa rispetto a future modifiche della propria struttura interna ma aperta all'estensione comportamentale. L'eventuale integrazione futura di nuovi algoritmi di *Spaced Repetition* richiederà esclusivamente l'aggiunta di una nuova classe implementante `SchedulingStrategy` e il relativo criterio di selezione in `StudyService`, senza alcun impatto sul codice di gestione della sessione.


### 4.2.2 Delegation

#### Descrizione del pattern

Il pattern **Delegation** risponde al problema del riuso comportamentale tra classi quando una classe necessita di sfruttare funzionalità già implementate da un altro componente, ma il ricorso all'ereditarietà non risulta semanticamente corretto.

Il meccanismo si basa sulla composizione esplicita tra due ruoli principali:
* **`Delegator`:** classe che espone il servizio verso l'esterno ma, invece di reimplementarne l'intera logica o ereditarla da una superclasse, inoltra l'esecuzione delle sotto-operazioni opportune a un oggetto collaboratore incapsulato.
* **`Delegate`:** classe collaboratrice detenente la logica riutilizzabile che esegue l'operazione delegata per conto del `Delegator`.


#### Punto di applicazione in Kranki

Il pattern trova applicazione all'interno del motore di scheduling in `kranki-core`. `ExamModeScheduler` (*Delegator*) riceve per composizione un riferimento a `Sm2Scheduler` (*Delegate*). In occasione di ogni calcolo di anteprima o aggiornamento di stato, `ExamModeScheduler` non replica le regole convenzionali di apprendimento, ma delega a `Sm2Scheduler` l'elaborazione base secondo il modello *SM-2*, applicando successivamente al risultato ottenuto la propria logica di compressione progressiva in funzione della scadenza.

#### Motivazione della scelta

La scelta della delega tramite composizione è guidata dalle seguenti considerazioni progettuali:
* **Rispetto della relazione *is-a*:** far estendere `Sm2Scheduler` da parte di `ExamModeScheduler` violerebbe la semantica *is-a*, poiché la modalità *Exam Mode* può comprimere e alterare significativamente la naturale dilazione di *SM-2* e, in evoluzioni successive, potrebbe adottare formule autonome o appoggiarsi a un differente modello di base. La delega preserva una gerarchia piatta, evitando gli antipattern tipici della generalizzazione impropria.
* ***Information Hiding* e assenza di duplicazione:** `ExamModeScheduler` collabora con `Sm2Scheduler` unicamente attraverso l'interfaccia pubblica di quest'ultimo, senza dipendere dalla sua rappresentazione interna. Al contempo, si azzera la duplicazione della logica algoritmica di *SM-2*, che funge da base anche per l'algoritmo _Exam Mode_.
* **Rispetto della *Legge di Demetra* e basso accoppiamento:** `ExamModeScheduler` non espone il proprio `Delegate` ai chiamanti né trasferisce loro l'onere di combinare i due calcoli; analogamente, `StudySession` interagisce unicamente con il proprio collaboratore diretto tramite `SchedulingStrategy`, evitando accessi a classi non adiacenti.

### 4.2.3 Observer

#### Descrizione del pattern

Il pattern comportamentale **Observer** risolve il problema dell'aggiornamento reattivo e coerente tra componenti che devono reagire a cambiamenti di stato di un soggetto comune, evitando di legarli tramite associazioni dirette e rigide. Quando classi appartenenti a moduli o sottosistemi differenti si conoscono reciprocamente in modo concreto, la modifica o il riutilizzo di un componente comporta inevitabilmente ripercussioni sugli altri.

Il pattern disaccoppia il produttore delle notifiche dai suoi consumatori mediante l'introduzione di un contratto astratto di osservazione:
* **`Observable`:** componente che mantiene l'elenco dinamico degli osservatori registrati (consentendone iscrizione e rimozione) e si occupa di inviare una notifica al verificarsi di variazioni rilevanti di stato.
* **`Observer`:** interfaccia astratta che espone il metodo di notifica invocato dall'`Observable` al cambio di stato.
* **`ConcreteObserver`:** implementazioni concrete interessate all'aggiornamento che si registrano presso l'`Observable` e reagiscono alle notifiche ricevute, mantenendo l'`Observable` completamente agnostico rispetto alla loro identità e al loro numero.

La comunicazione reattiva tra il nucleo di dominio e le schermate persistenti dell'interfaccia grafica è realizzata attraverso i moduli `kranki-core` e `kranki-ui`:
* **Infrastruttura di notifica (`it.unibg.kranki.core.observer`):** `WorkspaceObserver` definisce l'interfaccia *Observer*, mentre `WorkspaceNotifier` funge da *Observable* centralizzando la registrazione, la rimozione e la notifica degli osservatori. Le segnalazioni viaggiano tramite `WorkspaceEvent`, un oggetto immutabile e tipizzato da `WorkspaceEventType` che qualifica la natura dell'evento occorso senza trasportare entità di dominio mutabili.
* **Osservatori grafici e modello *Pull* (`it.unibg.kranki.ui.controller`):** tra i dieci controller presenti nello strato grafico, i soli tre controller persistenti di visualizzazione — `MainController`, `BrowserController` e `StatsController` — assumono il ruolo di *ConcreteObserver*. L'aggiornamento adotta un modello **Pull**: alla ricezione di un `WorkspaceEvent`, ciascun controller filtra l'evento in base al `WorkspaceEventType` e, se interessato, interroga il `Service` competente per acquisire i `record` aggiornati definiti in `it.unibg.kranki.core.dto`, pianificando il ridisegno dei controlli grafici sul thread applicativo di JavaFX. L'iscrizione e la disiscrizione da `WorkspaceNotifier` sono gestite automaticamente in funzione del ciclo di vita grafico delle viste tramite `sceneProperty()`, prevenendo la permanenza di riferimenti pendenti alla chiusura o sostituzione delle schermate.

#### Motivazione della scelta

La configurazione adottata risponde a precisi vincoli architetturali e di affidabilità dell'interfaccia:
* **Integrità del grafo aciclico tra moduli e assenza di dipendenze circolari:** posizionare `WorkspaceObserver` e `WorkspaceNotifier` all'interno di `kranki-core`, lasciando i *ConcreteObserver* in `kranki-ui`, garantisce che tutte le dipendenze statiche puntino esclusivamente dallo strato grafico verso il nucleo logico. In questo modo `kranki-core` non introduce alcun riferimento a JavaFX né ai controller della UI, evitando cicli tra moduli e preservando la piena riutilizzabilità degli strati inferiori.
* **Disaccoppiamento tra viste e supporto ad aggiornamenti asincroni:** senza il pattern **Observer**, i controller dovrebbero mantenere riferimenti reciproci diretti per notificarsi le modifiche. Con `WorkspaceNotifier`, variazioni originate da finestre secondarie, da scorciatoie da tastiera o da operazioni asincrone come la sincronizzazione remota si riflettono automaticamente sulle sole viste attive.
* **Efficienza e protezione dei confini tramite modello *Pull* e DTO:** la notifica leggera tramite `WorkspaceEvent` consente a ciascun controller di ignorare gli eventi non pertinenti ed evitare ricalcoli grafici superflui, mentre l'interrogazione successiva tramite i `record` immutabili di `it.unibg.kranki.core.dto` tutela l'*Information Hiding* ed evita di esporre lo stato interno modificabile del modello al thread di rendering JavaFX.

### 4.2.4 Façade

#### Descrizione del pattern

Il pattern strutturale **Façade** interviene quando un sottosistema o un insieme di package applicativi risulta articolato in numerose classi interagenti, costringendo i componenti chiamanti a conoscere e coordinare direttamente molte entità di dettaglio. Tale esposizione diretta rende complesso l'utilizzo del sottosistema e fa sì che qualsiasi modifica alla sua struttura interna obblighi a rivedere tutte le classi client che vi accedono.

Il pattern semplifica l'accesso al sottosistema interponendo un punto d'ingresso unificato:
* **`Façade`:** classe che espone un'interfaccia di livello più alto, coesa e orientata ai casi d'uso verso i client esterni, delegando e orchestrando le chiamate verso le classi interne del sottosistema.
* **Classi interne del sottosistema:** componenti specializzati che realizzano la logica dettagliata e rimangono schermati rispetto ai chiamanti esterni.

#### Punto di applicazione in Kranki

Il pattern costituisce il confine operativo primario esposto dal nucleo logico verso l'interfaccia grafica, trovando inoltre impiego in due punti tecnici circoscritti all'interno degli strati di persistenza e presentazione:
* **Facciate applicative principali (`it.unibg.kranki.core.service`):** i cinque `Service` applicativi — `AuthService`, `WorkspaceService`, `DeckService`, `StudyService` e `SyncService` — rappresentano le facciate coese per area funzionale attraverso cui `kranki-ui` interagisce con il sistema. Ciascun `Service` coordina dietro i propri metodi l'accesso allo stato applicativo, le operazioni sulle entità di dominio (`it.unibg.kranki.core.model`), la gestione della sessione di studio e degli scheduler, l'invocazione delle porte verso la persistenza (`it.unibg.kranki.core.port`) e l'emissione delle notifiche su `WorkspaceNotifier`, restituendo alla UI viste dati immutabili tramite `it.unibg.kranki.core.dto`.
* **Facciate tecniche interne di minore entità:**
  * in `it.unibg.kranki.db.firebase`, `FirebaseRestClient` funge da facciata interna per i gateway `FirebaseAuthGateway` e `FirebaseRemoteSyncGateway`, nascondendo la gestione delle richieste HTTPS, l'iniezione dei token di autenticazione e le logiche di rinnovo delle credenziali dietro un'interfaccia interna unitaria;
  * in `it.unibg.kranki.ui.navigation`, `JavaFxNavigator` funge da facciata tecnica verso i controller grafici per la transizione tra le viste, incapsulando il caricamento dichiarativo con `FXMLLoader`, la gestione di `Stage` e `Scene`, l'applicazione dei fogli di stile CSS e il collegamento con l'internazionalizzazione gestita da `I18nManager`.

#### Motivazione della scelta

L'introduzione di queste facciate è essenziale per tradurre in pratica l'architettura a 3 strati rigida definita nella sezione `4.1.1`:
* **Riduzione del *Coupling Between Objects* (`CBO`) e rispetto della *Legge di Demetra*:** interponendo i cinque `Service` tra `kranki-ui` e il cuore di `kranki-core`, i controller non devono conoscere né navigare direttamente grafi di oggetti interni. Ciò abbatte la metrica `CBO` dei controller e garantisce il rispetto della *Legge di Demetra*, isolando la UI da eventuali refactoring interni del dominio o della persistenza.
* **Uniformità del flusso transazionale e *Information Hiding*:** centralizzare l'orchestrazione nei `Service` assicura che ogni comando proveniente dall'interfaccia esegua in modo rigoroso e ripetibile la sequenza *validazione delle regole di dominio → persistenza locale immediata → notifica agli osservatori su `WorkspaceNotifier`*, impedendo che i controllori grafici alterino in modo incoerente lo stato in memoria rispetto all'archivio locale.
* **Elevata coesione contro il rischio di un gestore monolitico:** suddividere il livello di servizio in cinque facciate focalizzate per area funzionale, anziché concentrare tutte le operazioni applicative in un unico gestore centrale, mantiene elevata la coesione di ciascun `Service`, ne contiene la complessità ciclomatica e agevola la manutenzione e lo sviluppo parallelo da parte del team.

### 4.2.5 Pattern e principi architetturali complementari

A completamento dei quattro *design pattern* principali, l'architettura di **Kranki** si appoggia trasversalmente a tre principi e meccanismi semplici, adottati per far collaborare i diversi moduli mantenendoli ordinati e indipendenti tra loro:

* **`Dependency Inversion Principle (DIP)`:** i moduli centrali definiscono interfacce astratte che vengono poi realizzate dai moduli esterni. *Dove:* nelle porte di `core.port` implementate in `kranki-db`, in `WorkspaceObserver` implementata in `kranki-ui` e in `Navigator` implementata da `JavaFxNavigator`. *Motivo:* mantenere `kranki-core` isolato dai dettagli di salvataggio e grafica, evitando dipendenze circolari tra i moduli.
* **`Dependency Injection (DI)`:** invece di creare autonomamente i propri collaboratori o ricorrere a riferimenti globali nascosti, le classi li ricevono dall'esterno tramite costruttore. *Dove:* nei costruttori dei cinque `Service`, delle classi di `kranki-db` e dei controller JavaFX tramite `ControllerFactory` (registrata su `FXMLLoader`). *Motivo:* rendere chiari i legami tra le classi, collegare moduli separati rispettando il *DIP* e sostituire facilmente i collaboratori durante i test unitari.
* **`Composition Root`:** un unico punto d'avvio incaricato di creare una sola volta i componenti condivisi e di collegarli tra loro. *Dove:* nella classe `KrankiApp` all'interno del modulo `kranki-app`. *Motivo:* racchiudere la visione d'insieme di tutti i moduli in un solo punto privo di logica applicativa, lasciando il resto del sistema completamente disaccoppiato.