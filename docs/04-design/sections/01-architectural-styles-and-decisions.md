## 4.1 Architettura del software

La progettazione architetturale di **Kranki** definisce la struttura globale del sistema, bilanciando i requisiti funzionali con gli attributi di qualità individuati nella Sezione 3.2. In conformità con le linee guida di progettazione architetturale, le decisioni fondamentali sono documentate in tramite schede decisionali strutturate e successivamente approfondite nei relativi aspetti tecnici.

### 4.1.1 Stile architettonico

A livello concettuale, l'architettura del sistema è organizzata in tre livelli logici principali — **Presentazione (`kranki-ui`)**, **Logica di Business (`kranki-core`)** e **Persistenza (`kranki-db`)** — le cui relazioni di dipendenza statica e la mappatura rispetto al modello *Model-View-Controller* (MVC) sono rappresentate nello schema seguente.

<p align="center">
 <img src="LINK?raw=true"
 alt="Schema dello stile architettonico">
 </p>

![Schema concettuale dell'architettura di Kranki](docs/04-design/resources/schema-architettura-concettuale.jpg)

La tabella seguente formalizza la decisione relativa allo stile architetturale adottato.

| Elemento | Descrizione |
| :--- | :--- |
| **Problema** | Definire una struttura globale che separi nettamente l'interfaccia grafica desktop, la logica di dominio (algoritmi di *Spaced Repetition*, gestione *Mazzi* e *Flashcard*, statistiche) e la persistenza dei dati (archiviazione locale offline e sincronizzazione remota), garantendo alta coesione, basso accoppiamento, testabilità unitaria isolata del dominio e predisposizione a future estensioni verso nuove interfacce utente. |
| **Decisione** | Adozione di un'architettura a **3 strati rigida** mediante applicazione del *Dependency Inversion Principle* (con il supporto di un modulo tecnico di avvio `kranki-app`), combinata con lo stile **Model-View-Controller (MVC)** per la strutturazione dello strato di presentazione e della sua interazione con il resto del sistema. |
| **Stato** | Approvato. |
| **Presupposti** | Il progetto è strutturato come applicazione Java multi-modulo gestita tramite Maven ed Eclipse (che vietano dipendenze cicliche tra moduli); le modifiche ai dati richiedono il salvataggio immediato in locale per prevenire perdite di lavoro offline; l'interfaccia grafica utilizza un approccio dichiarativo basato su JavaFX. |
| **Alternative** | **1. Solo MVC "piatto" con un unico componente *Model*:** scartata perché MVC, preso isolatamente, non separa le regole di dominio dalla tecnologia di persistenza, ostacolando il testing isolato degli algoritmi e la sostituibilità del backend.<br>**2. Architettura a 3 strati rilassata (gerarchia debole):** scartata perché, dovendo garantire il salvataggio locale ad ogni modifica significativa, quasi tutti i controllori dell'interfaccia avrebbero dovuto invocare direttamente lo strato di persistenza, diffondendo l'accoppiamento verso il database nella UI, aumentando il rischio di disallineamento tra memoria e disco e duplicando la logica di coordinamento per eventuali UI future.<br> |
| **Motivazione** | **1. Rigidità reale e basso accoppiamento:** nella versione rigida lo strato `kranki-ui` comunica esclusivamente con `kranki-core`, risultando completamente agnostico rispetto alle modalità di salvataggio locale o remoto. Il modulo `kranki-core` non dipende da alcun altro modulo del sistema, garantendo massima testabilità unitaria e riutilizzabilità.<br>**2. Integrazione non banale con MVC:** i due livelli si integrano in modo complementare (in linea con il raffinamento *3-tier → MVC* e la combinazione di stili architetturali). In particolare: (a) all'interno di `kranki-ui` si impone una netta separazione dichiarativa tra vista grafica e controllori degli eventi senza introdurre wrapper intermedi sulle entità di dominio; (b) il ruolo del *Model* di MVC non è lasciato a un blocco monolitico, ma è intenzionalmente stratificato in `kranki-core` e `kranki-db` tramite inversione delle dipendenze; (c) la struttura resta predisposta a notifiche asincrone dal *Model* verso la UI.<br>**3. Coesione dei moduli:** ciascun componente mantiene una responsabilità unica e ben delimitata, impedendo alla logica applicativa di disperdersi nei controllori grafici. |
| **Implicazioni** | **1. Modulo tecnico di bootstrap (`kranki-app`):** poiché né `kranki-ui` né `kranki-core` dipendono da `kranki-db`, è necessario un quarto micro-modulo Maven privo di logica applicativa dedicato esclusivamente all'istanziazione e al collegamento iniziale dei tre strati all'avvio (*Composition Root*).<br>**2. Astrazioni e contenimento dei gestori:** `kranki-core` deve definire le interfacce astratte verso la persistenza (implementate da `kranki-db`) e un insieme limitato e coeso di gestori applicativi, evitando di svuotare le entità di dominio della loro logica intrinseca.<br>**3. Aggiornamento documentazione di piano:** l'introduzione del modulo tecnico `kranki-app` va tracciata rispetto alla ripartizione iniziale dei pacchetti di lavoro nel *Project Plan* ed esplicitata nella vista dei pacchetti. |
| **Appunti** | Il dettaglio delle dipendenze tra i quattro moduli Maven, incluso il ruolo di `kranki-app`, è rappresentato nel *Package Diagram* e nel *Component Diagram* all'interno delle viste architetturali (Sez. 4.1.5). |.


#### Approfondimento su dipendenze statiche, flusso dinamico e integrazione MVC

Lo schema concettuale introduttivo illustra le **dipendenze statiche** tra i tre strati logici del sistema, rispecchiando fedelmente la direzione delle dipendenze tra i rispettivi moduli Maven: sia `kranki-ui` sia `kranki-db` dipendono da `kranki-core`, mentre quest'ultimo non dipende da alcun componente interno. La freccia ascendente da `DB` verso `CORE` non viola la regola gerarchica dello stile a strati, ma è il risultato dell'applicazione del ***Dependency Inversion Principle***: è lo strato centrale di logica applicativa a definire i contratti astratti di cui necessita per la persistenza, mentre lo strato inferiore di persistenza li implementa. A **runtime**, pertanto, il flusso di esecuzione scende regolarmente dall'alto verso il basso (`UI → CORE → DB`), dopo essere stato assemblato all'avvio dal modulo di bootstrap `kranki-app` (omesso nello schema concettuale poiché non costituisce uno strato funzionale del sistema, ma mero punto di ingresso tecnico).

All'interno di questa macro-architettura stratificata, la scelta di **JavaFX** consente di integrare in modo coerente lo stile **Model-View-Controller (MVC)** a un livello di astrazione complementare:
* **View** e **Controller** risiedono nello strato di presentazione (`kranki-ui`), separando la definizione visiva dichiarativa (layout FXML e fogli di stile CSS) dalla gestione degli eventi dell'utente e della navigazione (affidata ai controllori grafici);
* **Model** è rappresentato congiuntamente dagli strati sottostanti `kranki-core` e `kranki-db`, che incapsulano rispettivamente le entità di dominio, gli algoritmi di apprendimento, lo stato della sessione e i meccanismi di persistenza locale e sincronizzazione remota.

Questa combinazione evita sia la dispersione di logica di business o di database nei controllori di presentazione, sia la creazione di livelli ridondanti di adattamento dei dati tra logica e interfaccia, consentendo alla UI di leggere direttamente le entità del dominio mantenendo la modifica dello stato strettamente mediata dal Core.

#### Caratterizzazione dello stile architetturale: componenti, connettori e controllo

In accordo con la classificazione formale degli stili architetturali, il sistema è caratterizzato dai seguenti elementi ad alto livello:

* **Modello di sistema e struttura di controllo:** il sistema adotta una gerarchia rigida a tre strati in cui uno strato superiore interagisce esclusivamente con lo strato immediatamente sottostante (a runtime `UI → CORE → DB`). Il flusso di controllo principale è guidato dagli eventi generati dall'utente nell'interfaccia grafica; le operazioni interne verso la logica di dominio e il salvataggio locale procedono in modo sincrono su un unico thread di controllo per ciascuna azione, mentre le comunicazioni di rete verso i servizi remoti possono essere eseguite in modo asincrono per preservare la reattività dell'interfaccia.
* **Tipi di componenti:**
  * **Controllore:** i controllori di presentazione e il gestore della navigazione nello strato `kranki-ui`, che regolano la sequenza temporale delle interazioni dell'utente, insieme al modulo di bootstrap `kranki-app`, che coordina l'inizializzazione e il cablaggio iniziale dei componenti.
  * **Gestore (*Manager*):** i gestori applicativi e le entità con stato nello strato `kranki-core` (responsabili del mantenimento in memoria dei *Mazzi*, delle *Flashcard*, delle *Sessioni di studio* e dello storico *Undo/Redo*), i gestori di persistenza locale e sincronizzazione nello strato `kranki-db`, nonché i servizi remoti Firebase visti come gestori esterni di autenticazione e archiviazione.
  * **Computazionale:** il nucleo algoritmico per il calcolo degli intervalli e delle scadenze di ripasso (`SM-2` ed *Exam Mode*), le unità di calcolo delle statistiche e di filtraggio/ricerca in memoria, nonché i moduli di trasformazione per il rendering testuale e il ridimensionamento delle immagini.
  * **Memoria:** l'archivio locale persistente su file JSON (organizzato per singolo utente) e il database cloud *Firebase Realtime Database*, preposti al mantenimento strutturato e duraturo dei dati.
* **Tipi di connettori:**
  * **Chiamata di procedura:** connettore principale per tutte le comunicazioni interne sincrone tra `kranki-ui`, `kranki-core` e `kranki-db` (quest'ultimo invocato dal Core tramite le interfacce astratte definite nello strato di dominio).
  * **Invocazione implicita:** meccanismo ad eventi nativo dell'interfaccia grafica JavaFX tra i componenti visivi e i controllori di presentazione (incluse le scorciatoie da tastiera), affiancato da eventuali notifiche asincrone basate su eventi dallo strato logico verso la UI.
  * **Passaggio di messaggio:** comunicazione discreta su rete TCP/IP tramite protocollo HTTPS/REST con payload JSON (sincrona o asincrona) tra il modulo di persistenza `kranki-db` e i server remoti Firebase.
  * **Istanziazione:** creazione iniziale e iniezione delle dipendenze tra i macro-componenti all'avvio dell'applicazione (a carico di `kranki-app`), istanziazione controllata dei controllori grafici in `kranki-ui` e creazione a runtime delle entità di dominio (*Mazzi*, *Flashcard*, *Sessioni di studio*) in `kranki-core`.
  * **Dati condivisi:** accesso allo spazio dati persistente remoto su *Firebase Realtime Database*, condiviso tra sessioni su dispositivi diversi dello stesso utente o tra più utenti nell'ambito dell'eventuale catalogo pubblico dei mazzi.

---

### 4.1.2 Persistenza dei dati

### 4.1.3 Interfaccia grafica

### 4.1.4 Librerie esterne


