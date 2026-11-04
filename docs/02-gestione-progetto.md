# 2. Gestione del progetto

## 2.1 Ciclo di vita del software

### 2.1.1 Processo di sviluppo
In conformità a quanto stabilito nel *Project Plan*, il team implementa un processo di sviluppo ibrido. La fase iniziale di analisi e progettazione segue le direttive del framework RUP (*Inception* ed *Elaboration*), concentrandosi sull'ingegneria dei requisiti e sulla modellazione del dominio. La successiva fase operativa di *Construction* viene gestita attraverso l'applicazione del framework agile *Scrum*. Infine, la fase di *Transition* è dedicata al testing di sistema integrato, alla risoluzione degli ultimi difetti e alla preparazione dell'applicativo per la consegna finale.

### 2.1.2 *Timebox* e pianificazione degli *Sprint*
La fase di stesura del codice è vincolata all'interno di *Sprint* di durata fissa pari a due settimane (14 giorni). Il calendario di sviluppo prevede quattro iterazioni principali, pianificate come segue:

| Iterazione   | Data Inizio      | Data Fine        | Obiettivo Principale |
| :----------- | :--------------- | :--------------- | :------------------- |
| **Sprint 1** | 19 Novembre 2026 | 03 Dicembre 2026 | TODO - da definire   |
| **Sprint 2** | 03 Dicembre 2026 | 17 Dicembre 2026 | TODO - da definire   |
| **Sprint 3** | 17 Dicembre 2026 | 31 Dicembre 2026 | TODO - da definire   |
| **Sprint 4** | 31 Dicembre 2026 | 14 Gennaio 2027  | TODO - da definire   |

*(Nota: gli obiettivi dei singoli Sprint sono puramente indicativi e si adattano dinamicamente in base alle priorità del Product Backlog).*

### 2.1.3 Approccio MDA
Durante la fase di *Elaboration*, il team adotta tecniche proprie del paradigma MDA limitandone l'applicazione allo sviluppo di parte del modulo centrale (`kranki-core`). Utilizzando il software di modellazione **StarUML**, viene disegnato il *Class Diagram* relativo al dominio applicativo. In seguito, sfruttando la funzionalità di generazione del codice integrata nel tool, una porzione del diagramma viene tradotta automaticamente nello scheletro Java delle entità fondamentali del sistema (es. `Deck`, `Flashcard`,...). Questo perimetro di applicazione mirato evita la generazione di codice *boilerplate* inutile nei moduli UI e DB, limitando l'intervento manuale degli sviluppatori alla sola implementazione della logica di business all'interno degli *Sprint*.

### 2.1.4 Formalizzazione della gestione delle *Change Request* / *Issue*
TODO - si può fare un *activity diagram*




## 2.2 Gestione della configurazione

### 2.2.1 Strumenti adottati
Come definito nelle procedure descritte all'interno del *Project Plan* (e documentate dettagliatamente nel file [CONTRIBUTING.md](https://github.com/RichardBoy05/Kranki/blob/main/CONTRIBUTING.md)), la gestione della configurazione, il versionamento del codice e la collaborazione tra i membri del team sono interamente gestiti tramite **GitHub**.
In particolare, per garantire la tracciabilità tra i requisiti e il codice effettivamente prodotto, il team sfrutta l'ecosistema integrato della piattaforma: ogni modifica al sistema è guidata da uno specifico *Issue*, il cui ciclo di vita è orchestrato visivamente tramite *Kanban Board*. Si collega l'avanzamento dei task ai relativi *branch* di sviluppo e alle *Pull Request*, assicurando un controllo totale sullo stato della configurazione del software.

### 2.2.2 Criteri di tracciamento e `.gitignore`
Per mantenere il repository pulito e privo di file generati localmente o non necessari all'esecuzione del codice su macchine diverse, è stato configurato un file `.gitignore` alla radice del progetto. Come da prassi per un progetto Java/Maven su Eclipse, il sistema è impostato per ignorare:
* I file binari compilati (`*.class`).
* Le cartelle di build generate da Maven (`target/`).
* Le impostazioni locali dell'IDE (`.settings/`).

Al contrario, i file fondamentali per l'importazione e la configurazione strutturale del progetto su altri ambienti, come i file `pom.xml` (per Maven) e il file nascosto `.project` (specifico per l'infrastruttura Eclipse), sono stati esplicitamente mantenuti.

### 2.2.3 Statistiche del repository
A dimostrazione dell'adozione continua degli strumenti di collaborazione (*Branch*, *Pull Request*, *Code Review* e *Kanban Board*), si riportano le statistiche globali del repository generate al termine della fase di sviluppo:

* **Numero totale di Commit:** [TODO: inserire numero a fine progetto]
* **Numero di *Issue* chiusi:** [TODO: inserire numero a fine progetto]





## 2.3 Gestione delle persone e organizzazione del team

### 2.3.1 Inquadramento del modello organizzativo
Il gruppo di lavoro adotta la configurazione di **Squadra Agile** declinata secondo il framework *Scrum*, scartando modelli fortemente rigidi o centralizzati. La struttura scelta si fonda sull'assenza di una gerarchia interna, su canali di comunicazione brevi e informali e su un'elevata autodisciplina dei singoli componenti. 

A integrazione dei ruoli di *Scrum Master* e *Development Team* già delineati nella pianificazione iniziale, la figura del ***Product Owner*** (responsabile della definizione delle funzionalità e della gestione del *Product Backlog*) viene assunta in modo condiviso dall'intero team di sviluppo. Essendo i membri del gruppo contemporaneamente sviluppatori ed esperti del dominio applicativo, le decisioni sulle priorità del prodotto vengono prese collettivamente.

### 2.3.2 Allocazione operativa del lavoro
Coerentemente con la natura auto-organizzata del team *Scrum*, la pianificazione e la distribuzione dei compiti durante gli *Sprint* non avvengono tramite assegnazione diretta dall'alto. All'avvio di ogni iterazione, il team si confronta per selezionare i compiti da inserire nello *Sprint Backlog*, attribuendo collettivamente a ciascun *Issue* un punteggio rappresentativo della difficoltà implementativa (*Story Points*). Questo meccanismo consente di misurare a fine *Sprint* il punteggio totale effettivamente realizzato (*Velocity*), permettendo al gruppo di verificare l'accuratezza delle proprie previsioni e di calibrare meglio il carico di lavoro per le iterazioni successive.

Una volta definito lo *Sprint Backlog*, i membri del team prelevano in autonomia gli *Issue* (auto-assegnazione). La scelta si orienta prevalentemente verso le rispettive aree di focus primario, in modo da ammortizzare le curve di apprendimento legate alle tecnologie specifiche di ciascun modulo, pur mantenendo la flessibilità necessaria per collaborare trasversalmente in caso di necessità.
