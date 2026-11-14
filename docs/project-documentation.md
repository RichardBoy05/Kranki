<!-- AUTO-GENERATED FILE: DO NOT EDIT MANUALLY -->

# Documentazione del progetto **Kranki**

* Introduzione al documento
* Indice dei contenuti

---

# 1. Project Plan

**Storico delle versioni**

| Versione | Data | Autori | Descrizione delle modifiche |
| :--- | :--- | :--- | :--- |
| **1.0** | 21/10/2026 | Berardi Francesco, Meoli Richard, Pullano Gabriele, Rapetti Giorgio | Redazione della prima versione completa del *Project Plan*. |

## 1.1 Introduzione

### 1.1.1 Contesto del progetto
Il presente documento costituisce il *Project Plan* relativo al progetto sviluppato nell'ambito del corso di Ingegneria del Software (A.A. 2026/2027) presso l'Università degli Studi di Bergamo, su committenza del Prof. Angelo Gargantini e della Dott.ssa Silvia Bonfanti. 
Il team responsabile dell'intero ciclo di vita del software è composto dai seguenti membri:
* Berardi Francesco
* Meoli Richard
* Pullano Gabriele
* Rapetti Giorgio

### 1.1.2 Dominio applicativo
Il progetto si colloca nell'ambito degli strumenti software a supporto dello studio, basandosi su due fondamentali principi cognitivi: l'*Active Recall* (recupero attivo) e la *Spaced Repetition* (ripetizione dilazionata). Il primo consiste nello sforzo di recuperare un'informazione dalla memoria senza l'ausilio di suggerimenti passivi (come la semplice rilettura di un testo), una pratica implementata nel software tramite l'utilizzo delle *flashcard*, ossia carte virtuali tipicamente strutturate in formato domanda/risposta. Tale sforzo di memorizzazione è però fisiologicamente ostacolato dalla naturale "curva dell'oblio", che porta alla progressiva perdita delle nozioni nel tempo. Per contrastare questo fenomeno interviene la *Spaced Repetition*, una tecnica che programma i ripassi delle *flashcard* a intervalli di tempo via via crescenti. Tale approccio algoritmico ha lo scopo di stimolare la memoria esattamente nel momento in cui un'informazione sta per essere dimenticata, massimizzando così la ritenzione a lungo termine.

### 1.1.3 Origine dell'idea
L'idea alla base del progetto nasce dall'esperienza diretta del team come studenti e utilizzatori di strumenti digitali per l'apprendimento. Le soluzioni tradizionali basate su *flashcard* sono storicamente progettate per l'acquisizione di conoscenze su un orizzonte temporale indefinito. Pur rivelandosi eccellenti per questo scopo, tale logica tende a scontrarsi con le dinamiche accademiche, caratterizzate dalla perentorietà degli appelli d'esame. L'assenza di funzionalità native per vincolare i ripassi a una scadenza fissa costringe spesso lo studente ad alterare manualmente le tempistiche di revisione a ridosso dell'esame, compromettendo l'efficienza del ripasso.

### 1.1.4 Obiettivi del progetto
Per colmare questo divario nasce **Kranki**, un ambiente di studio basato su *flashcard* concepito per adattarsi alle esigenze universitarie e implementato come applicazione Java Desktop. Pur traendo ispirazione da soluzioni open-source consolidate come Anki, l'obiettivo primario del sistema è quello di fornire un motore di *Spaced Repetition* che introduca logiche di scheduling adattive, progettate per ricalibrare i cicli di revisione in funzione di scadenze temporali rigide imposte dall'utente. A questo obiettivo si affiancherà l'integrazione di meccaniche a supporto della costanza nello studio giornaliero, attraverso elementi di tracciamento dell'attività e gratificazione volti a sostenere la motivazione dello studente.

## 1.2 Modello di processo

### 1.2.1 Approccio metodologico
Il ciclo di vita del software adotterà un approccio metodologico ibrido, integrando il rigore formale del *Rational Unified Process* (RUP) con l'agilità del framework *Scrum*. Questa scelta strategica è guidata dalla necessità di coniugare i requisiti valutativi del progetto con l'efficienza dello sviluppo. Il RUP fornisce la struttura ideale per soddisfare le richieste relative alla progettazione orientata agli oggetti e alla modellazione UML; d'altra parte, *Scrum* garantisce la flessibilità e l'adattività necessarie per la gestione pratica della stesura del codice.

### 1.2.2 Fasi del ciclo di vita
L'evoluzione del progetto è strutturata secondo le quattro macro-fasi previste dal RUP:
* ***Inception* (Ideazione):** rappresenta la fase di avvio del progetto, dedicata interamente all'ingegneria dei requisiti, alla definizione dei confini del sistema e alla formulazione degli obiettivi principali che l'applicativo dovrà soddisfare.
* ***Elaboration* (Elaborazione):** fase incentrata sulla progettazione architetturale e sulla modellazione orientata agli oggetti. I diagrammi UML fungeranno da documentazione e linea guida per lo sviluppo. Verrà inoltre effettuata una parziale adozione del paradigma *Model-Driven Architecture* (MDA), utilizzata come supporto iniziale per generare automaticamente lo scheletro di alcune classi strutturali.
* ***Construction* (Costruzione):** fase operativa in cui avviene la stesura manuale del codice sorgente. Il processo abbandona l'impostazione sequenziale per adottare dinamiche fortemente iterative governate da *Scrum*: lo sviluppo avverrà tramite cicli brevi (*Sprint*), al termine dei quali verranno prodotti incrementi di software tangibili e funzionanti.
* ***Transition* (Transizione):** fase conclusiva del ciclo di vita, successiva al consolidamento del codice. Si focalizza sulla validazione complessiva dell'applicativo, sul *bug fixing* finale e sull'ottimizzazione del prodotto e della documentazione in vista della consegna.

## 1.3 Organizzazione del progetto

Questo capitolo descrive l'organizzazione generale del progetto, definendo i rapporti con le figure esterne e la divisione pratica dei compiti all'interno del team di sviluppo.

### 1.3.1 Relazioni esterne

* **Committenza:** rappresentata dal Prof. Angelo Gargantini e dalla Dott.ssa Silvia Bonfanti. Le comunicazioni formali e le richieste di approvazione per i documenti principali (come per il *Project Plan*) avverranno tramite l'apertura di *Issue* sul repository GitHub ufficiale del progetto.
* **Utenti finali:** chiunque abbia necessità di sfruttare i principi di memorizzazione supportati da applicazioni per la *spaced repetition*, in particolare gli studenti universitari. Poiché il team stesso fa parte di questa categoria, i membri del gruppo agiranno direttamente da "esperti di dominio", basandosi sulle proprie necessità reali per definire i requisiti (es. la gestione delle scadenze d'esame) e valutare la praticità dell'applicazione.

### 1.3.2 Organizzazione interna del team

Il gruppo di sviluppo è strutturato secondo il modello **Scrum**, composto da *developer* alla pari. La figura dello *Scrum Master* è ricoperta direttamente da uno degli sviluppatori, Giorgio Rapetti.

## 1.4 Standard, linee guida, procedure

Per garantire uniformità e ordine durante l'intero ciclo di sviluppo, il team si impegna a rispettare un set definito di regole e procedure interne.

### 1.4.1 Standard linguistici
È adottata una rigorosa separazione linguistica per evitare ambiguità:
* **Inglese:** lingua esclusiva per la nomenclatura nel codice sorgente, per i commenti *in-line* e per la generazione della documentazione tecnica *JavaDoc*.
* **Italiano:** lingua designata per la documentazione formale di progetto, per le comunicazioni interne sulle piattaforme di gestione e per i messaggi di commit.

### 1.4.2 Standard di codifica e ambiente di sviluppo
Lo sviluppo del codice Java rispetterà le *Java Code Conventions* definite da Oracle. L'ambiente di sviluppo integrato (IDE) standardizzato per tutti i membri del team è Eclipse, integrato con Maven per la gestione strutturata e condivisa delle dipendenze esterne.

### 1.4.3 Procedure di versionamento e collaborazione
Per la gestione del repository GitHub il team adotta l'approccio *Feature Branch Workflow*. L'intero flusso collaborativo è regolamentato e documentato nel file interno [CONTRIBUTING.md](https://github.com/RichardBoy05/Kranki/blob/main/CONTRIBUTING.md), che funge da riferimento per gli sviluppatori.

### 1.4.4 Linee guida per i commit
Per garantire la leggibilità e l'ispezionabilità della cronologia del repository, i messaggi di commit devono essere mantenuti sintetici e strettamente descrittivi dell'azione svolta, fornendo un riepilogo immediato delle modifiche applicate.

## 1.5 Attività di gestione



### 1.5.1 Pianificazione e monitoraggio dell'avanzamento

Il monitoraggio dello stato di avanzamento del progetto è supportato nativamente dagli strumenti di tracciamento offerti dalla piattaforma GitHub. Le attività da svolgere, formalizzate sotto forma di *Issue*, sono raggruppate in specifiche *Milestone* temporali.
\
La gestione dell'operatività è demandata a una *Kanban Board* di progetto, strutturata in cinque stati di avanzamento logici:

* **Product Backlog**: raccoglitore generale dei requisiti e delle attività stimate ma non ancora pianificate.

* **Sprint Backlog**: sottoinsieme di attività selezionate e assegnate per l'iterazione di sviluppo corrente.

* **Doing**: attività attualmente in carico e in fase di elaborazione da parte dei membri del team.

* **In Review**: attività completate dal punto di vista implementativo ma in attesa di validazione. Il passaggio logico a questo stato è innescato dall'apertura di una *Pull Request*.

* **Done**: attività validate, approvate durante la revisione e integrate definitivamente nel ramo principale del progetto (*merge*), decretando la chiusura formale del task.


### 1.5.2 Coordinamento del team e cicli di sviluppo

Il flusso di lavoro si articola in cicli iterativi di sviluppo (*Sprint*). Per garantire il costante allineamento operativo del team e valutare lo stato di salute del progetto, è stata adottata una politica di coordinamento strutturata su due livelli. 
\
Durante le fasi iniziali di ingegneria dei requisiti e progettazione architetturale, sono previsti incontri formali a cadenza settimanale (tipicamente fissati nella giornata di giovedì). Tali incontri si svolgono preferibilmente in presenza, o in alternativa mediante piattaforme VoIP (come Discord). Nella successiva fase di implementazione del codice, la cadenza degli incontri formali transiterà a una frequenza bisettimanale.
\
A questi incontri si affiancano dei brevi allineamenti giornalieri, svolti prevalentemente in presenza durante le consuete attività universitarie, al fine di condividere i progressi e risolvere tempestivamente eventuali problemi.

### 1.5.3 Bilanciamento dei vincoli progettuali

Un aspetto centrale dell'attività di gestione consiste nel continuo bilanciamento tra l'estensione dei requisiti implementati e i vincoli temporali imposti dal contesto accademico. Il progetto adotta un approccio rigorosamente *time-boxed*: le date di scadenza associate alle singole *Milestone* sono considerate inalterabili.
\
In caso di scostamenti rispetto alla pianificazione originaria o di criticità nello sviluppo, la gestione interviene operando uno snellimento dinamico dello *Sprint Backlog*. Ciò si traduce nella de-prioritizzazione o posticipazione delle attività secondarie, garantendo che le risorse del team convergano in modo esclusivo verso le funzionalità architetturali, assicurando un rilascio funzionante entro le scadenze concordate.

## 1.6 Rischi

Di seguito sono riportati i principali fattori di rischio previsti per il progetto, suddivisi in tre categorie, unitamente alle relative strategie di mitigazione.

### 1.6.1 Rischi funzionali

*   **Complessità dell'algoritmo di scheduling adattivo**\
    Comprimere gli intervalli di ripasso in funzione di una data d'esame prefissata comporta una notevole complessità algoritmica.\
    *Mitigazione:* nel caso in cui lo sviluppo di tale meccanismo risultasse incompatibile con le tempistiche del corso, si ripiegherà temporaneamente sul solo modello convenzionale (basato su SM-2), rimandando le logiche più avanzate a versioni successive.
*   **_Requirements creep_**\
    La naturale tendenza a integrare funzionalità non pianificate rischia di distogliere l'attenzione dalle priorità del progetto, compromettendo la realizzazione delle parti essenziali del sistema.\
    *Mitigazione:* applicazione preventiva del metodo MoSCoW, ammettendo lo sviluppo di eventuali requisiti emersi in corso d'opera solo a seguito del completamento delle funzionalità prioritarie.

### 1.6.2 Rischi tecnologici

*   **Conflitti di sincronizzazione multi-dispositivo**\
    La modifica concorrente dei dati su dispositivi diversi comporta il rischio di conflitti durante la sincronizzazione con il database remoto.\
    *Mitigazione:* qualora la risoluzione di tali problematiche si rivelasse impraticabile, ci si affiderà al comportamento predefinito di Firebase, accettando l'eventuale rischio di sovrascrittura.
*   **Sviluppo dell'interfaccia grafica**\
    L'implementazione di elementi grafici complessi, come un editor di testo avanzato, presenta difficoltà realizzative non trascurabili.\
    *Mitigazione:* se necessario, si adotteranno soluzioni più semplici, privilegiando il corretto funzionamento del sistema piuttosto che l'estetica.

### 1.6.3 Rischi organizzativi

*   **Curve di apprendimento**\
    L'integrazione di un database remoto come Firebase e lo studio di nuovi framework per la GUI richiederanno un importante sforzo di comprensione iniziale.\
    *Mitigazione:* se una specifica tecnologia dovesse richiedere un onere di apprendimento incompatibile con le tempistiche, si opterà per l'implementazione della soluzione più semplice disponibile (valutando, ad esempio, il ripiego verso un database *embedded* locale).
*   **Sovrapposizione con le attività accademiche**\
    La necessità di conciliare le attività di progetto con gli altri impegni universitari può incidere sulla continuità del lavoro.\
    *Mitigazione:* la pianificazione sarà gestita in modo flessibile, calibrando l'assegnazione dei compiti e le scadenze interne in funzione delle esigenze dei singoli membri.

## 1.7 Personale

### 1.7.1 Dimensionamento e modello operativo
L'organico del progetto è costituito dai quattro membri del team, il cui impiego è previsto con un *effort* costante per l'intera durata dei lavori. Sebbene la responsabilità sul prodotto finale sia collettiva, il team adotta una ripartizione delle mansioni flessibile, basata sull'ottimizzazione delle competenze tecniche individuali.

### 1.7.2 Evoluzione temporale delle competenze
Il profilo delle competenze richieste al team varierà dinamicamente in funzione delle fasi del ciclo di vita del software:
* **Analisi e progettazione**: impiego corale dell'intero team nel ruolo di analisti dei requisiti e architetti software.
* **Implementazione**: transizione verso ruoli tecnici incentrati sui vari *Work Packages*.
* **Verifica e validazione**: convergenza totale del team verso attività di *Quality Assurance* ed esecuzione dei test.

### 1.7.3 Aree di competenza primarie
Si precisa esplicitamente che l'assegnazione dei ruoli in fase di implementazione ha un valore puramente **indicativo**. In coerenza con le metodologie agili, il team opererà senza rigide compartimentazioni: ogni membro potrà intervenire e contribuire trasversalmente su qualsiasi modulo del sistema. 
Tuttavia, al solo fine di ottimizzare il coordinamento tecnico, vengono individuate le seguenti aree di focus primario:
* **Giorgio Rapetti**: *Scrum Master* e focus sul modulo *Core*.
* **Francesco Berardi**: Focus sul modulo *Core*.
* **Gabriele Pullano**: Focus sul modulo *Database*.
* **Richard Meoli**: Focus sul modulo *UI*.

## 1.8 Metodi e tecniche

Questa sezione descrive le metodologie che il team adotterà durante le diverse fasi del ciclo di vita del software.

### 1.8.1 Ingegneria dei Requisiti
Per definire le funzionalità del sistema, il team adotterà quattro tecniche principali:
* **Brainstorming:** i requisiti emersi verranno discussi dal team e classificati rigorosamente utilizzando il metodo **MoSCoW** (*Must, Should, Could, Won't have*), in modo da definire un perimetro di sviluppo chiaro e compatibile con le tempistiche del corso.
* **Etnografia:** l'etnografia prevede l'osservazione diretta degli utenti nel loro ambiente naturale al fine di far emergere abitudini consolidate e requisiti taciti difficilmente individuabili tramite altre tecniche. Nel nostro caso, tale analisi verrà applicata sotto forma di auto-osservazione, essendo i membri del team utilizzatori quotidiani di questi strumenti nel contesto universitario.
* **Derivazione da un sistema esistente:** verranno analizzati i software di *spaced repetition* esistenti (in particolare soluzioni consolidate come Anki) per derivare i requisiti base e identificare le aree di miglioramento.

### 1.8.2 Progettazione
La progettazione del sistema si baserà sulla modellazione **UML**.

## 1.9 Garanzia di qualità

Per assicurare che il software sviluppato rispetti elevati standard di affidabilità e manutenibilità, il team adotterà una strategia di *Quality Assurance* (QA) basata su tre pilastri fondamentali: analisi statica automatizzata, analisi dinamica tramite testing e revisione manuale.

### 1.9.1 Analisi statica del codice
Il controllo preventivo della qualità del codice sorgente sarà gestito attraverso la piattaforma ***SonarCloud***, integrata direttamente nel flusso di lavoro tramite Maven e supportata in locale dal plugin *SonarLint* per l'IDE Eclipse. Questo strumento fungerà da primo livello di controllo, rilevando in tempo reale *Code Smells*, bug potenziali e vulnerabilità di sicurezza. L'analisi statica provvederà inoltre a calcolare le principali metriche del software, ponendo per esempio attenzione alla misurazione della *Complessità Ciclomatica*, al fine di mantenere l'architettura del codice chiara e facilmente testabile.

### 1.9.2 Analisi dinamica e copertura 
La validazione funzionale del comportamento del software avverrà tramite la stesura di *Unit Test* utilizzando il framework ***JUnit***. Adottando un approccio di sviluppo tradizionale, la scrittura dei casi di test verrà effettuata a valle o contestualmente all'implementazione delle singole funzionalità. 
Per quantificare l'efficacia della suite di collaudo, la misurazione della *Code Coverage* (copertura del codice testato) sarà automatizzata attraverso l'integrazione del plugin ***JaCoCo*** all'interno del ciclo di build di Maven. I report generati da *JaCoCo* verranno trasmessi a *SonarCloud*, permettendo al team di monitorare costantemente la percentuale di codice validato dai test.

### 1.9.3 Revisione tra pari
Gli strumenti automatizzati saranno affiancati da un processo di validazione umana basato sulla *Code Review*. Tale revisione è obbligatoria per ogni *Pull Request* e deve essere rigorosamente effettuata da un membro del team diverso dall'autore delle modifiche. Questa ispezione incrociata agirà come un vero e proprio *Quality Gate* (cancello di qualità), garantendo l'identificazione di difetti logici, concettuali o architetturali che sfuggono alle analisi statiche e assicurando, al contempo, una conoscenza condivisa della *codebase* tra tutti gli sviluppatori.

## 1.10 Pacchetti di lavoro
L'organizzazione delle attività di sviluppo adotta una *Work Breakdown Structure* (WBS) allineata alla struttura architetturale del sistema. Il software è suddiviso in tre componenti principali, corrispondenti ad altrettanti progetti Eclipse Maven. Le attività si articolano nei seguenti *Work Packages* (WP).

*   **Core (`kranki-core`)**\
    Costituisce il nucleo logico dell'applicazione. Include principalmente la modellazione delle entità di dominio (mazzi, carte,...) e l'implementazione degli algoritmi per la *Spaced Repetition* e lo scheduling adattivo, unitamente ai vari servizi ausiliari. Il modulo non presenta alcuna dipendenza verso gli altri componenti interni del sistema.
*   **Database (`kranki-db`)**\
    Si occupa della persistenza delle informazioni, delle operazioni di serializzazione per l'importazione/esportazione dei mazzi e dell'integrazione con i servizi esterni. L'adozione di un database remoto come *Firebase* risponde all'esigenza di consentire la sincronizzazione multi-dispositivo (con i necessari meccanismi di autenticazione correlati), predisponendo l'infrastruttura anche a un'eventuale estensione in ambito mobile. Il modulo dichiara una dipendenza da `kranki-core`.
*   **UI (`kranki-ui`)**\
    Dedicato allo sviluppo dell'interfaccia grafica, con l'obiettivo di offrire un'esperienza d'uso semplice e intuitiva. Il modulo dipende sia da `kranki-core` che da `kranki-db`.

Tale ripartizione definisce la struttura e le dipendenze del software, ma non impone una rigida compartimentazione del personale durante lo sviluppo. Il team adotta infatti un modello di lavoro *cross-funzionale*: pur individuando per ciascun membro un'area di focus primario, è prevista una collaborazione trasversale sulle diverse attività.

## 1.11 Risorse

Il progetto prevede l'impiego delle seguenti risorse hardware e software.

### 1.11.1 Risorse hardware

Lo sviluppo e il test avverranno sui computer personali dei membri del team.

### 1.11.2 Risorse software

* **Ambienti di sviluppo:** Eclipse IDE.
* **Tool di modellazione:** StarUML v5.
* **Database remoto:** Firebase (tier gratuito "*Spark Plan*", sufficiente per l'impiego previsto).

## 1.12 Budget e programma

### 1.12.1 Budget 
Il progetto non prevede l'allocazione di un budget finanziario, poiché verranno impiegati esclusivamente strumenti di sviluppo, framework ad accesso gratuito.
Il budget è pertanto quantificato unicamente in termini di *effort* (ore-uomo). Basandosi sulle stime fornite dalla committenza, si prevede un impiego complessivo di circa 120-160 ore-uomo (corrispondenti a un range di 30-40 ore per ciascun membro del team). 

### 1.12.2 Programma
Come già anticipato nel punto 2 del presente documento, la programmazione temporale del progetto si articolerà seguendo le quattro macro-fasi previste dal framework RUP. Lo sviluppo procederà dall'*Inception* per l'ingegneria dei requisiti, all'*Elaboration* per la progettazione architetturale, per poi passare alla fase operativa di *Construction*, che adotterà cicli iterativi (*Sprint*) per la stesura del codice. Il percorso si concluderà con la *Transition*, dedicata al testing intensivo e alla finalizzazione dei *deliverable* in vista della consegna formale.

## 1.13 Cambiamenti

Attualmente non sono presenti variazioni rispetto al piano iniziale. Eventuali modifiche future a requisiti, architettura o tempistiche verranno formalmente documentate all'interno di questa sezione.

## 1.14 Consegna

Le procedure di rilascio e consegna del progetto al committente seguiranno rigorosamente le linee guida definite per la valutazione accademica. La consegna non prevederà l'invio di archivi compressi fisici, ma coinciderà in modo trasparente con lo stato finale della repository GitHub al termine della fase di consolidamento definitivo del codice.

---

# 2. Gestione del progetto

**Storico delle versioni**

| Versione | Data | Autori | Descrizione delle modifiche |
| :--- | :--- | :--- | :--- |
| **1.0** | 04/11/2026 | Pullano Gabriele | Redazione della prima versione completa del documento *Gestione del progetto*. |

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

---

# 3. Requisiti

**Storico delle versioni**

| Versione | Data | Autori | Descrizione delle modifiche |
| :--- | :--- | :--- | :--- |
| **1.0** | 12/11/2026 | Berardi Francesco, Meoli Richard, Pullano Gabriele, Rapetti Giorgio | Redazione della prima versione completa del documento *Requisiti* e dei diagrammi dei casi d'uso associati. |

## 3.1 Ingegneria dei requisiti

### 3.1.1 Introduzione

Kranki è un'applicazione dedicata allo studio tramite *Flashcard*, progettata per supportare, in particolare, lo studente universitario nella memorizzazione a lungo termine. A differenza delle soluzioni tradizionali, il sistema introduce un motore di *Spaced Repetition* capace di adattare i cicli di revisione a scadenze temporali rigide, come gli appelli d'esame. L'obiettivo è massimizzare l'efficienza dello studio, bilanciando la tecnica della ripetizione dilazionata con la necessità di una copertura totale del materiale entro date prestabilite.
La presente sezione del documento definisce le specifiche funzionali del sistema. La specifica dei requisiti è stata redatta in conformità con i principi dello standard **IEEE 830**, al fine di ridurre possibili ambiguità interpretative tra il team di sviluppo e gli *stakeholder*.

#### Glossario

Il seguente glossario contiene le definizioni dei termini tecnici di dominio utilizzati nella specifica dei requisiti.

| Termine            | Descrizione                                                                                                     |
| ------------------ | --------------------------------------------------------------------------------------------------------------- |
| *Archiviazione*      | Stato di un mazzo che ne interrompe la generazione delle scadenze, mantenendolo consultabile.    |
| *Browser*            | Interfaccia per consultare, ricercare e gestire le *Flashcard* di uno o più mazzi.                     |
| *Carta Invertita*    | Tipologia di *Flashcard* studiabile in entrambe le direzioni: fronte → retro e retro → fronte.             |
| *Cloze*              | Tipologia di *Flashcard* basata su un testo con una o più lacune da completare.                                      |
| *CORE*               | Modulo architettonico dedicato alla logica applicativa e alle regole di dominio.                                |
| *DB*                 | Modulo architettonico dedicato all'accesso ai dati e alla loro persistenza.                                     |                           |
| *Exam Mode*          | Algoritmo avanzato di compressione delle scadenze, che impone la revisione di tutte le *Flashcard* entro una data limite fissa. |
| *Flag*               | Marcatore visivo utilizzabile per evidenziare una *Flashcard*.                                                  |
| *Flashcard*          | L'unità base di studio dell'applicazione.                                                                       |
| *Fronte*             | La parte della *Flashcard* contenente la domanda.                                                   |
| *FSRS*               | Algoritmo avanzato di *Spaced Repetition* basato su un modello matematico della memoria per ottimizzare gli intervalli di ripasso.                                  |
| *Image Occlusion*    | Tipologia di *Flashcard* che verifica il riconoscimento di porzioni nascoste di un'immagine.                          |
| *LaTeX*              | Linguaggio di markup utilizzato per il rendering di formule matematiche.                                        |
| *Markdown*           | Linguaggio di markup utilizzato per la formattazione avanzata del testo.                                |
| *Mazzo*              | Contenitore logico che raggruppa una specifica collezione di *Flashcard*.                                         |
| *Milestone*          | Traguardo sbloccabile in base alle statistiche di studio.                                                       |
| *Nuova Flashcard*   | *Flashcard* non ancora sottoposta alla prima revisione da parte dell'utente.                                                       |
| *Reset*              | Azione che azzera i progressi registrati per una *Flashcard*.                                    |
| *Retro*              | La parte della *Flashcard* contenente la soluzione.                                                              |
| *Rollover*           | Orario di sistema che determina lo scatto al "nuovo giorno" ai fini del calcolo delle scadenze.                 |
| *Seppellimento*      | Esclusione temporanea di una *Flashcard* dalla sessione di studio, limitata alla giornata in corso.               |
| *Sessione di studio* | Attività in cui l'utente ripassa una sequenza di *Flashcard* selezionate dal sistema per un determinato *Mazzo*.                           |
| *Set Due Date*       | Forzatura manuale della data di scadenza di una *Flashcard*, sovrascrivendo il calcolo algoritmico.                    |
| *Skip*               | Spostamento di una *Flashcard* in fondo alla coda della sessione odierna, rimandandone il ripasso.          |
| *SM-2*               | Algoritmo di *Spaced Repetition* alla base del sistema di ripasso dell'applicazione.                                           |
| *Sospensione*        | Esclusione a tempo indeterminato di una *Flashcard*, fino a riattivazione manuale.                                |
| *Spaced Repetition*  | Tecnica di apprendimento che distribuisce i ripassi a intervalli temporali crescenti.                              |
| *Streak*             | Contatore dei giorni consecutivi in cui viene registrata una specifica attività nell'applicazione.         |
| *Tag*                | Etichetta testuale applicabile a una *Flashcard* per agevolarne la classificazione.                               |
| *Type in the Answer* | Tipologia di *Flashcard* che richiede la digitazione manuale della risposta.                    |
| *UI*           | Modulo architettonico dedicato all'interfaccia grafica.                                         |
| *Undo/Redo*          | Sistema che consente di annullare e ripristinare le azioni eseguite.                                |

### 3.1.2 Descrizione generale

La definizione dei requisiti è il risultato di un processo iterativo e multi-metodologico. Il team ha integrato diverse tecniche di elicitazione per coprire sia gli aspetti funzionali che quelli legati alla qualità dell'esperienza d'uso.

* **Derivazione da un sistema esistente**: è stata condotta un'analisi comparativa dei software di *Spaced Repetition* esistenti, con particolare focus su Anki. Tale approccio ha permesso di derivare il set di requisiti funzionali di base e di identificare potenziali criticità sulle quali intervenire con soluzioni migliorative.
* **Brainstorming**: il team ha organizzato sessioni di gruppo per far emergere idee e funzionalità innovative. In particolare, ciascun requisito è stato classificato mediante il metodo **MoSCoW**.
* **Etnografia**: poiché i membri del team sono utilizzatori quotidiani di strumenti di studio in ambito universitario, è stata applicata una forma di auto-osservazione. Questo ha permesso di far emergere esigenze tacite e abitudini consolidate che un'analisi puramente teorica avrebbe ignorato.

#### Documentazione UML: diagrammi dei casi d'uso

Durante la fase di ingegneria dei requisiti sono stati inoltre realizzati alcuni diagrammi dei casi d’uso, consultabili ai seguenti link.

| Casi d'uso | StarUML |
| :--- | :--- |
| [Gestione del sistema e dei _Mazzi_](https://github.com/RichardBoy05/Kranki/blob/main/docs/03-requirements/resources/01-gestione-account-dati-mazzi.jpg) | [Gestione del sistema e dei _Mazzi_](https://github.com/RichardBoy05/Kranki/blob/main/docs/03-requirements/resources/01-gestione-account-dati-mazzi.mdj) |
| [Gestione delle _Flashcard_](https://github.com/RichardBoy05/Kranki/blob/main/docs/03-requirements/resources/02-gestione-flashcard.jpg) | [Gestione delle _Flashcard_](https://github.com/RichardBoy05/Kranki/blob/main/docs/03-requirements/resources/02-gestione-flashcard.mdj) |
| [_Sessione di studio_, statistiche e gamification](https://github.com/RichardBoy05/Kranki/blob/main/docs/03-requirements/resources/03-sessione-studio-statistiche-gamification.jpg) | [_Sessione di studio_, statistiche e gamification](https://github.com/RichardBoy05/Kranki/blob/main/docs/03-requirements/resources/03-sessione-studio-statistiche-gamification.mdj) |

### 3.1.3 Requisiti specifici

| ID | Requisito | Criteri di accettazione | MoSCoW | Dipendenze | Issue GitHub | Rif. Codice | Rif. Test |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **REQ&#8209;01** | **Registrazione e autenticazione**<br>Il sistema deve consentire all'utente di creare un account e di autenticarsi, al fine di garantire l'accesso esclusivo ai propri *Mazzi*. L'autenticazione primaria deve avvenire tramite credenziali standard (indirizzo e-mail e password). Il sistema potrebbe opzionalmente supportare l'autenticazione tramite provider esterni.| L'accesso al sistema è consentito esclusivamente a seguito dell'inserimento di credenziali valide. In caso risultino errate, il sistema nega l'accesso e fornisce un riscontro visivo esplicativo all'utente, permettendo un nuovo tentativo di inserimento.| ![MUST](https://img.shields.io/badge/MUST-b60205?style=flat-square) | - | [#38](https://github.com/RichardBoy05/Kranki/issues/38)&nbsp;[UI]<br> [#39](https://github.com/RichardBoy05/Kranki/issues/39)&nbsp;[DB]<br> [#40](https://github.com/RichardBoy05/Kranki/issues/40)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;02** | **Persistenza dei dati**<br>Il sistema deve implementare un meccanismo di persistenza per garantire che i dati generati dall'utente (es. *Mazzi*, *Flashcard*, progressi di studio,...) vengano salvati in modo permanente, consentendo il ripristino e l'utilizzo dell'applicazione su dispositivi multipli. Tale requisito definisce le operazioni di salvataggio generiche su cui si appoggeranno le singole entità del dominio. | Al riavvio dell'applicazione, il sistema recupera e consente di visualizzare i dati salvati dall'utente. In seguito alla richiesta di sincronizzazione, i dati locali vengono inviati in remoto, garantendo la coerenza delle informazioni tra dispositivi diversi. | ![MUST](https://img.shields.io/badge/MUST-b60205?style=flat-square)| REQ&#8209;01 | [#41](https://github.com/RichardBoy05/Kranki/issues/41)&nbsp;[DB]| *TBD* | *TBD* |
| **REQ&#8209;03** | **Risoluzione dei conflitti di sincronizzazione**<br>Il sistema potrebbe implementare un meccanismo per gestire eventuali disallineamenti tra i dati salvati localmente e quelli archiviati in remoto. Al rilevamento di uno stato di conflitto, il sistema richiede una decisione esplicita all'utente, permettendo di scegliere se sovrascrivere le informazioni remote con la versione locale oppure ripristinare i dati online. | Al verificarsi di un conflitto, l'applicazione presenta un avviso che richiede l'intervento manuale. Il sistema riprende il normale funzionamento solo a seguito di una scelta dell'utente in merito a quale delle due versioni conservare. | ![COULD](https://img.shields.io/badge/COULD-0E8A65?style=flat-square) | REQ&#8209;02 | [#42](https://github.com/RichardBoy05/Kranki/issues/42)&nbsp;[UI]<br> [#43](https://github.com/RichardBoy05/Kranki/issues/43)&nbsp;[DB] | *TBD* | *TBD* |
| **REQ&#8209;04** | **Importazione ed esportazione locale**<br>Il sistema dovrebbe permettere all'utente di esportare un proprio *Mazzo* su un file locale e di importare *Mazzi* a partire da file compatibili presenti sul dispositivo. L'esportazione dovrebbe preservare integralmente il contenuto delle *Flashcard*, inclusi il testo e gli eventuali elementi multimediali associati, garantendo la possibilità di effettuare backup manuali e di condividere il materiale di studio anche in assenza di connettività. | L'esportazione di un *Mazzo* genera un file locale conforme al formato supportato dall'applicazione. L'importazione di un file valido genera un nuovo *Mazzo* all'interno dell'applicazione, ripristinando fedelmente il contenuto delle *Flashcard* in esso contenute. A fronte di un file corrotto o non supportato, l'operazione viene annullata con un feedback visivo di errore. | ![SHOULD](https://img.shields.io/badge/SHOULD-E9963E?style=flat-square) | REQ&#8209;07 | [#44](https://github.com/RichardBoy05/Kranki/issues/44)&nbsp;[UI]<br> [#45](https://github.com/RichardBoy05/Kranki/issues/45)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;05** | **Condivisione pubblica dei _Mazzi_** <br>Il sistema potrebbe consentire di rendere pubblici i propri *Mazzi* all'interno della piattaforma, mettendoli a disposizione degli altri utenti. Attraverso una sezione dedicata, l'utente potrebbe esplorare il catalogo dei *Mazzi* condivisi e ottenerne una copia direttamente all'interno della propria libreria personale, favorendo uno scambio rapido di materiale di studio senza la necessità di trasferire manualmente file fisici. | Un *Mazzo* impostato come pubblico compare correttamente all'interno del catalogo condiviso. Il download di un elemento dal catalogo genera una copia autonoma nella schermata principale, assicurando che eventuali modifiche successive non alterino il *Mazzo* dell'autore originario. | ![COULD](https://img.shields.io/badge/COULD-0E8A65?style=flat-square) | REQ&#8209;02, REQ&#8209;07 | [#46](https://github.com/RichardBoy05/Kranki/issues/46)&nbsp;[UI]<br> [#47](https://github.com/RichardBoy05/Kranki/issues/47)&nbsp;[DB] | *TBD* | *TBD* |
| **REQ&#8209;06** | **Gestione dei _Mazzi_** <br>Il sistema deve mostrare all'utente l'interfaccia grafica principale dell'applicazione, dentro la quale è possibile creare, rinominare ed eliminare i *Mazzi*. | La creazione di un nuovo *Mazzo* o la modifica di uno esistente vanno a buon fine esclusivamente se l'utente fornisce un identificativo testuale non vuoto e non duplicato. L'operazione di eliminazione rimuove il *Mazzo* selezionato dalla vista e provoca la contestuale cancellazione di tutte le *Flashcard* associate e dei relativi storici di apprendimento. | ![MUST](https://img.shields.io/badge/MUST-b60205?style=flat-square) | - | [#48](https://github.com/RichardBoy05/Kranki/issues/48)&nbsp;[UI]<br> [#49](https://github.com/RichardBoy05/Kranki/issues/49)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;07** | **Gestione della _Flashcard_** <br>Il sistema deve consentire la creazione e la modifica di una singola *Flashcard* all'interno di un *Mazzo* precedentemente selezionato. | L'utente può salvare o aggiornare una *Flashcard* compilando i campi *Fronte* (obbligatorio) e *Retro*. Qualora il *Fronte* sia vuoto, il sistema blocca l'operazione e segnala l'errore all'utente. | ![MUST](https://img.shields.io/badge/MUST-b60205?style=flat-square) | REQ&#8209;06 | [#54](https://github.com/RichardBoy05/Kranki/issues/54)&nbsp;[UI]<br> [#55](https://github.com/RichardBoy05/Kranki/issues/55)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;08** | **Browser delle _Flashcard_** <br>Il sistema deve fornire un'interfaccia di *Browser* per permettere all'utente di ricercare, consultare, gestire e ordinare le varie *Flashcard* della collezione. | L'utente accede a un'interfaccia grafica adibita alla visualizzazione delle *Flashcard* di un *Mazzo* selezionato o dell'intera collezione. La selezione di una *Flashcard* abilita i comandi per la sua gestione. L'ordinamento avviene correttamente secondo i filtri specificati | ![MUST](https://img.shields.io/badge/MUST-b60205?style=flat-square) | REQ&#8209;07 | [#56](https://github.com/RichardBoy05/Kranki/issues/56)&nbsp;[UI] | *TBD* | *TBD* |
| **REQ&#8209;09** | **Editor di testo avanzato** <br>Il sistema dovrebbe fornire strumenti di formattazione del testo avanzati in fase di creazione e modifica di una *Flashcard*. Nello specifico, dovrebbe supportare l'utilizzo del linguaggio *Markdown* per la formattazione strutturale e del linguaggio *LaTeX* per la corretta visualizzazione di formule matematiche. | Durante l'inserimento o la modifica di una *Flashcard*, l'utente è in grado di utilizzare la sintassi avanzata e di visualizzarne un'anteprima che mostri correttamente gli elementi grafici e le formule matematiche. | ![SHOULD](https://img.shields.io/badge/SHOULD-E9963E?style=flat-square) | REQ&#8209;07 | [#57](https://github.com/RichardBoy05/Kranki/issues/57)&nbsp;[UI] | *TBD* | *TBD* |
| **REQ&#8209;10** | **Supporto multimediale nelle _Flashcard_** <br>Il sistema potrebbe estendere le capacità dell'editor di testo supportando l'inserimento di immagini all'interno delle *Flashcard* (sia nel *Fronte* che nel *Retro*). | Incollando un'immagine dagli appunti di sistema all'interno dell'editor di testo, l'applicazione processa il file e ne mostra la corretta anteprima visiva, garantendone anche la persistenza. | ![COULD](https://img.shields.io/badge/COULD-0E8A65?style=flat-square) | REQ&#8209;02, REQ&#8209;07 | [#58](https://github.com/RichardBoy05/Kranki/issues/58)&nbsp;[UI]<br> [#59](https://github.com/RichardBoy05/Kranki/issues/59)&nbsp;[DB] | *TBD* | *TBD* |
| **REQ&#8209;11** | **Tipologie di _Flashcard_ speciali** <br>Il sistema potrebbe supportare alcune varianti di *Flashcard* diverse dal classico formato *Fronte*-*Retro*. Nello specifico, potrebbe implementare i modelli *Carta Invertita* e *Type in the Answer*. | In fase di creazione, l'utente può selezionare un modello speciale per la *Flashcard*. Durante una *Sessione di studio*, il sistema riconosce il modello e adatta l'interfaccia di conseguenza. | ![COULD](https://img.shields.io/badge/COULD-0E8A65?style=flat-square) | REQ&#8209;07 | [#60](https://github.com/RichardBoy05/Kranki/issues/60)&nbsp;[UI]<br> [#61](https://github.com/RichardBoy05/Kranki/issues/61)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;12** | **Tipologie di _Flashcard_ avanzate** <br>Il sistema potrebbe estendersi per supportare modelli di *Flashcard* di difficile implementazione, tra cui i modelli *Cloze* e *Image Occlusion*. | - | ![WON'T](https://img.shields.io/badge/WON'T-A9A9A9?style=flat-square) | REQ&#8209;07 | - | - | - |
| **REQ&#8209;13** | **Algoritmo standard di _Spaced Repetition_** <br>Il sistema deve programmare dinamicamente gli intervalli di revisione per ciascuna delle *Flashcard*, basandosi sulla valutazione soggettiva espressa dall'utente durante i vari ripassi. Il motore logico consisterà in una versione adattata dell'algoritmo *SM-2*. | A seguito della valutazione di una *Flashcard* da parte dell'utente, i parametri interni e la data di scadenza della stessa vengono aggiornati secondo le regole matematiche dell'algoritmo. L'interfaccia grafica mostra correttamente un'anteprima del prossimo intervallo temporale di ripasso generato dall'algoritmo, per ciascun livello di valutazione disponibile. | ![MUST](https://img.shields.io/badge/MUST-b60205?style=flat-square) | REQ&#8209;07 | [#62](https://github.com/RichardBoy05/Kranki/issues/62)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;14** | **Algoritmo _Exam Mode_** <br>Il sistema deve fornire una modalità di programmazione dei ripassi alternativa all'algoritmo di base, ottimizzata per la gestione dello studio in presenza di scadenze inderogabili. Qualora l'utente assegni una data di scadenza a un determinato *Mazzo* (ad esempio, la data di un appello universitario), il motore algoritmico deve essere in grado di comprimere dinamicamente gli intervalli temporali di revisione, assicurandosi che tutte le *Flashcard* del *Mazzo* vengano riproposte prima del raggiungimento della data limite. | Impostata una scadenza per un *Mazzo*, a seguito di una qualsiasi valutazione su una *Flashcard*, la nuova data di revisione è matematicamente vincolata a verificarsi prima della data limite, sovrascrivendo la naturale dilazione dell'algoritmo base. | ![MUST](https://img.shields.io/badge/MUST-b60205?style=flat-square) | REQ&#8209;13 | [#63](https://github.com/RichardBoy05/Kranki/issues/63)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;15** | **Algoritmi di scheduling avanzati** <br>Il sistema potrebbe estendersi per accogliere logiche matematiche aggiuntive di ottimizzazione dei ripassi, tra cui l'algoritmo *FSRS*. | - | ![WON'T](https://img.shields.io/badge/WON'T-A9A9A9?style=flat-square) | REQ&#8209;07 | - | - | - |
| **REQ&#8209;16** | **Esecuzione della _Sessione di studio_** <br>Il sistema deve permettere all'utente di avviare una *Sessione di studio* relativa a un determinato *Mazzo*. L'interfaccia deve presentare inizialmente solo il *Fronte* della *Flashcard*. Su richiesta dell'utente, il sistema deve mostrare il *Retro* contestualmente ai pulsanti di autovalutazione, fungendo da innesco per il ricalcolo algoritmico. | Avviata una *Sessione di studio*, l'utente visualizza le *Flashcard* in scadenza, una alla volta. A seguito della pressione di un tasto di valutazione, la *Flashcard* corrente viene rimossa dalla visualizzazione, i dati vengono elaborati in background dall'algoritmo di *Spaced Repetition* e il sistema presenta la successiva *Flashcard* in coda. | ![MUST](https://img.shields.io/badge/MUST-b60205?style=flat-square) | REQ&#8209;13 | [#64](https://github.com/RichardBoy05/Kranki/issues/64)&nbsp;[UI]<br> [#65](https://github.com/RichardBoy05/Kranki/issues/65)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;17** | **Azioni di controllo avanzate sulle _Flashcard_** <br>Il sistema dovrebbe consentire all'utente di eseguire alcune azioni di controllo sulle singole *Flashcard*, sia durante una *Sessione di studio* che tramite l'interfaccia del *Browser*. Nello specifico, il sistema dovrebbe supportare le azioni di: *Sospensione*, *Seppellimento*, *Skip*, *Flag*, *Tag*, *Set Due Date* e *Reset*. | Le azioni eseguite dall'utente mutano con successo lo stato e i metadati della *Flashcard* selezionata. Durante una *Sessione di studio*, il sistema di accodamento rispetta tali variazioni, escludendo dalla visualizzazione le *Flashcard* che subiscono una *Sospensione* o un *Seppellimento*, e riproponendo solo al termine della sessione quelle marcate con *Skip*. | ![SHOULD](https://img.shields.io/badge/SHOULD-E9963E?style=flat-square) | REQ&#8209;08, REQ&#8209;16 | [#66](https://github.com/RichardBoy05/Kranki/issues/66)&nbsp;[UI]<br> [#67](https://github.com/RichardBoy05/Kranki/issues/67)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;18** | **_Sessioni di studio_ personalizzate** <br>Il sistema potrebbe estendersi permettendo la generazione di *Sessioni di studio* personalizzate o di *Mazzi* temporanei filtrati, per garantire all'utente una maggiore flessibilità. | - | ![WON'T](https://img.shields.io/badge/WON'T-A9A9A9?style=flat-square) | REQ&#8209;16 | - | - | - |
| **REQ&#8209;19** | **Impostazioni del _Mazzo_** <br>Il sistema dovrebbe consentire all'utente di personalizzare le proprietà di uno specifico *Mazzo*. Nello specifico, dovrebbe essere possibile: impostare un limite massimo giornaliero di *Nuove Flashcard*; attivare la modalità *Exam Mode* indicando una data di scadenza; procedere all'*Archiviazione* di un *Mazzo* completato. | A fronte dell'impostazione di un limite giornaliero su un *Mazzo*, il sistema non accoda ulteriori *Nuove Flashcard* nella *Sessione di studio* corrente una volta raggiunta la soglia. Un *Mazzo* posto in *Archiviazione* cessa di mostrare nuove scadenze e scompare dalle viste principali fino all'eventuale ripristino manuale da parte dell'utente. | ![SHOULD](https://img.shields.io/badge/SHOULD-E9963E?style=flat-square) | REQ&#8209;06 | [#68](https://github.com/RichardBoy05/Kranki/issues/68)&nbsp;[UI] | *TBD* | *TBD* |
| **REQ&#8209;20** | **Preferenze globali di sistema** <br>Il sistema potrebbe fornire all'utente un'interfaccia per la gestione delle preferenze globali. In tale contesto, l'utente potrebbe personalizzare la lingua del sistema (italiano o inglese) e ridefinire l'orario di *Rollover*. Il sistema potrebbe inoltre fornire opzioni per il *Seppellimento* automatico delle *Nuove Flashcard* al momento della loro creazione e un comando globale per *Seppellire* in blocco tutte le *Nuove Flashcard* presenti nella coda odierna. | La modifica della lingua comporta l'aggiornamento testuale dell'intera applicazione. La personalizzazione del *Rollover* altera correttamente l'orario del "cambio giorno". I vari comandi o automatismi inclusi svolgono correttamente il proprio compito. | ![COULD](https://img.shields.io/badge/COULD-0E8A65?style=flat-square) | - | [#69](https://github.com/RichardBoy05/Kranki/issues/69)&nbsp;[UI] | *TBD* | *TBD* |
| **REQ&#8209;21** | **Dashboard delle statistiche e timer di studio** <br>Il sistema dovrebbe permettere all'utente di consultare l'andamento del proprio studio attraverso una dashboard analitica che aggreghi vari tipi di dati storici. A supporto di tali metriche, il sistema dovrebbe implementare un timer in background attivo durante ogni *Sessione di studio*, capace di misurare il tempo di risposta per la singola *Flashcard*, con l'accortezza di sospendere il conteggio in caso di inattività prolungata per preservare l'affidabilità dei dati. | L'utente visualizza riepiloghi grafici o numerici coerenti con il reale storico delle valutazioni effettuate. Durante lo studio, il tempo registrato per la singola *Flashcard* riflette il tempo effettivo trascorso tra l'esposizione del *Fronte* e l'autovalutazione, tralasciando eventuali periodi di inattività che eccedano la soglia preimpostata dal sistema. | ![SHOULD](https://img.shields.io/badge/SHOULD-E9963E?style=flat-square) | REQ&#8209;02, REQ&#8209;16 | [#70](https://github.com/RichardBoy05/Kranki/issues/70)&nbsp;[UI]<br> [#71](https://github.com/RichardBoy05/Kranki/issues/71)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;22** | **Gamification** <br>Il sistema potrebbe integrare logiche di gamification al fine di incentivare la costanza giornaliera dell'utente, tramite meccanismi come *Streak* e *Milestone*. | Le *Streak* e le *Milestone* riflettono coerentemente l'attività di studio svolta in precedenza dall'utente. | ![COULD](https://img.shields.io/badge/COULD-0E8A65?style=flat-square) | REQ&#8209;21 | [#72](https://github.com/RichardBoy05/Kranki/issues/72)&nbsp;[UI]<br> [#73](https://github.com/RichardBoy05/Kranki/issues/73)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;23** | **Keyboard Shortcuts** <br>Il sistema dovrebbe supportare una mappatura fissa di scorciatoie da tastiera, al fine di permettere all'utente di eseguire comodamente le azioni di sistema più frequenti. | Le scorciatoie da tastiera implementate si traducono nelle azioni previste durante l'uso dell'applicazione. | ![SHOULD](https://img.shields.io/badge/SHOULD-E9963E?style=flat-square) | REQ&#8209;08, REQ&#8209;16 | [#74](https://github.com/RichardBoy05/Kranki/issues/74)&nbsp;[UI] | *TBD* | *TBD* |
| **REQ&#8209;24** | **Sistema globale di _Undo/Redo_** <br>Il sistema potrebbe implementare un meccanismo di *Undo/Redo* per annullare o ripristinare le operazioni strutturali eseguite dall'utente. Tale funzionalità opera a livello globale di applicazione, distinguendosi dal comune annullamento presente nell'editor di testo. | L'invocazione del comando di *Undo* o di *Redo* ripristina fedelmente lo stato dei dati e dell'interfaccia a quello immediatamente antecedente o successivo all'operazione eseguita dall'utente. | ![COULD](https://img.shields.io/badge/COULD-0E8A65?style=flat-square) | - | [#75](https://github.com/RichardBoy05/Kranki/issues/75)&nbsp;[CORE] | *TBD* | *TBD* |
| **REQ&#8209;25** | **Estensione a dispositivi mobili** <br>Il sistema potrebbe estendersi per essere distribuito sotto forma di applicazione nativa per dispositivi mobili o come client web. | - | ![WON'T](https://img.shields.io/badge/WON'T-A9A9A9?style=flat-square) | - | - | - | - |

## 3.2 Qualità del software

La progettazione, lo sviluppo e la valutazione qualitativa del sistema Kranki sono stati condotti adottando la **Tassonomia di McCall**, preferita allo standard ISO 9126 per la sua chiara organizzazione in macro-categorie. Tale framework permette infatti di declinare oggettivamente la qualità del software secondo tre aree distinte: il funzionamento operativo del sistema (*Product Operations*), le necessità tecniche del team di sviluppo (*Product Revision*) e il ciclo di vita del prodotto in relazione all'ambiente di esecuzione (*Product Transition*). In particolare, per il contesto del progetto, si è scelto di privilegiare i seguenti fattori di qualità.

### 3.2.1 Product operations
Questa categoria raccoglie i fattori qualitativi legati all'utilizzo quotidiano del sistema da parte dello studente.

* **Usabilità**: il sistema deve minimizzare il carico cognitivo associato all'interazione con l'interfaccia, permettendo all'utente di mantenere il focus esclusivamente sull'apprendimento.\
  *Verificabilità*: implementazione pervasiva di scorciatoie da tastiera (*keyboard shortcuts*), al fine di garantire allo studente la possibilità di completare un'intera sessione di ripasso comodamente.
* **Affidabilità**: i progressi di studio rappresentano il dato critico del sistema e non devono subire alterazioni o perdite in caso di anomalie hardware o software.\
  *Verificabilità*: adozione di meccanismi di salvataggio e persistenza sicura dei dati, in locale e in remoto.
* **Integrità**: i dati personali e i mazzi di carte dello studente devono essere protetti da accessi o manipolazioni non autorizzate.\
  *Verificabilità*: implementazione di un sistema di autenticazione mediante credenziali, atto a vincolare l'accesso ai dati salvati esclusivamente al legittimo proprietario.

### 3.2.2 Product revision
Questa categoria riflette l'attitudine del software a essere analizzato, manutenuto ed evoluto dal team di sviluppo.

* **Manutenibilità**: il codice sorgente deve prevenire il degrado architetturale, mantenendosi leggibile e rigorosamente strutturato per agevolare lo sviluppo parallelo.\
  *Verificabilità*: integrazione della piattaforma **SonarCloud** per il monitoraggio continuo della *codebase*, con l'obiettivo qualitativo di minimizzare la *Complessità Ciclomatica* e prevenire l'introduzione di difetti logici o anomalie strutturali.
* **Testabilità**: le logiche algoritmiche centrali del sistema (come il motore di *Spaced Repetition*) devono produrre risultati predicibili e agevolmente collaudabili in modo isolato.\
  *Verificabilità*: adozione del framework **JUnit** per la stesura di test unitari automatizzati, affiancato dallo strumento **JaCoCo** per la misurazione continua e oggettiva della *Code Coverage*, con focus ispettivo primario sul modulo della logica di business (`kranki-core`).

### 3.2.3 Product transition
Questa categoria valuta l'adattabilità del software ai cambiamenti ambientali e la sua capacità di integrarsi con l'esterno.

* **Riutilizzabilità**: l'architettura del software deve consentire il riuso dei suoi componenti in contesti operativi differenti, come ad esempio in future trasposizioni in ambito *mobile*.\
  *Verificabilità*: netta separazione architetturale in progetti Maven indipendenti. I moduli `kranki-core` e `kranki-db` sono progettati in modo da non avere alcuna dipendenza verso il modulo dell'interfaccia grafica desktop (`kranki-ui`), garantendone il potenziale riutilizzo isolato (così come sono) in altri applicativi.
