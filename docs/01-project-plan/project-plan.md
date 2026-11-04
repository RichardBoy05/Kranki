# Kranki — Project Plan

## 1. Introduzione

### 1.1 Contesto del progetto
Il presente documento costituisce il *Project Plan* relativo al progetto sviluppato nell'ambito del corso di Ingegneria del Software (A.A. 2026/2027) presso l'Università degli Studi di Bergamo, su committenza del Prof. Angelo Gargantini e della Dott.ssa Silvia Bonfanti. 
Il team responsabile dell'intero ciclo di vita del software è composto dai seguenti membri:
* Berardi Francesco
* Meoli Richard
* Pullano Gabriele
* Rapetti Giorgio

### 1.2 Dominio applicativo
Il progetto si colloca nell'ambito degli strumenti software a supporto dello studio, basandosi su due fondamentali principi cognitivi: l'*Active Recall* (recupero attivo) e la *Spaced Repetition* (ripetizione dilazionata). Il primo consiste nello sforzo di recuperare un'informazione dalla memoria senza l'ausilio di suggerimenti passivi (come la semplice rilettura di un testo), una pratica implementata nel software tramite l'utilizzo delle *flashcard*, ossia carte virtuali tipicamente strutturate in formato domanda/risposta. Tale sforzo di memorizzazione è però fisiologicamente ostacolato dalla naturale "curva dell'oblio", che porta alla progressiva perdita delle nozioni nel tempo. Per contrastare questo fenomeno interviene la *Spaced Repetition*, una tecnica che programma i ripassi delle *flashcard* a intervalli di tempo via via crescenti. Tale approccio algoritmico ha lo scopo di stimolare la memoria esattamente nel momento in cui un'informazione sta per essere dimenticata, massimizzando così la ritenzione a lungo termine.

### 1.3 Origine dell'idea
L'idea alla base del progetto nasce dall'esperienza diretta del team come studenti e utilizzatori di strumenti digitali per l'apprendimento. Le soluzioni tradizionali basate su *flashcard* sono storicamente progettate per l'acquisizione di conoscenze su un orizzonte temporale indefinito. Pur rivelandosi eccellenti per questo scopo, tale logica tende a scontrarsi con le dinamiche accademiche, caratterizzate dalla perentorietà degli appelli d'esame. L'assenza di funzionalità native per vincolare i ripassi a una scadenza fissa costringe spesso lo studente ad alterare manualmente le tempistiche di revisione a ridosso dell'esame, compromettendo l'efficienza del ripasso.

### 1.4 Obiettivi del progetto
Per colmare questo divario nasce **Kranki**, un ambiente di studio basato su *flashcard* concepito per adattarsi alle esigenze universitarie e implementato come applicazione Java Desktop. Pur traendo ispirazione da soluzioni open-source consolidate come Anki, l'obiettivo primario del sistema è quello di fornire un motore di *Spaced Repetition* che introduca logiche di scheduling adattive, progettate per ricalibrare i cicli di revisione in funzione di scadenze temporali rigide imposte dall'utente. A questo obiettivo si affiancherà l'integrazione di meccaniche a supporto della costanza nello studio giornaliero, attraverso elementi di tracciamento dell'attività e gratificazione volti a sostenere la motivazione dello studente.



## 2. Modello di processo

### 2.1 Approccio metodologico
Il ciclo di vita del software adotterà un approccio metodologico ibrido, integrando il rigore formale del *Rational Unified Process* (RUP) con l'agilità del framework *Scrum*. Questa scelta strategica è guidata dalla necessità di coniugare i requisiti valutativi del progetto con l'efficienza dello sviluppo. Il RUP fornisce la struttura ideale per soddisfare le richieste relative alla progettazione orientata agli oggetti e alla modellazione UML; d'altra parte, *Scrum* garantisce la flessibilità e l'adattività necessarie per la gestione pratica della stesura del codice.

### 2.2 Fasi del ciclo di vita
L'evoluzione del progetto è strutturata secondo le quattro macro-fasi previste dal RUP:
* ***Inception* (Ideazione):** rappresenta la fase di avvio del progetto, dedicata interamente all'ingegneria dei requisiti, alla definizione dei confini del sistema e alla formulazione degli obiettivi principali che l'applicativo dovrà soddisfare.
* ***Elaboration* (Elaborazione):** fase incentrata sulla progettazione architetturale e sulla modellazione orientata agli oggetti. I diagrammi UML fungeranno da documentazione e linea guida per lo sviluppo. Verrà inoltre effettuata una parziale adozione del paradigma *Model-Driven Architecture* (MDA), utilizzata come supporto iniziale per generare automaticamente lo scheletro di alcune classi strutturali.
* ***Construction* (Costruzione):** fase operativa in cui avviene la stesura manuale del codice sorgente. Il processo abbandona l'impostazione sequenziale per adottare dinamiche fortemente iterative governate da *Scrum*: lo sviluppo avverrà tramite cicli brevi (*Sprint*), al termine dei quali verranno prodotti incrementi di software tangibili e funzionanti.
* ***Transition* (Transizione):** fase conclusiva del ciclo di vita, successiva al consolidamento del codice. Si focalizza sulla validazione complessiva dell'applicativo, sul *bug fixing* finale e sull'ottimizzazione del prodotto e della documentazione in vista della consegna.


## 3. Organizzazione del progetto

Questo capitolo descrive l'organizzazione generale del progetto, definendo i rapporti con le figure esterne e la divisione pratica dei compiti all'interno del team di sviluppo.

### 3.1 Relazioni esterne

* **Committenza:** rappresentata dal Prof. Angelo Gargantini e dalla Dott.ssa Silvia Bonfanti. Le comunicazioni formali e le richieste di approvazione per i documenti principali (come per il *Project Plan*) avverranno tramite l'apertura di *Issue* sul repository GitHub ufficiale del progetto.
* **Utenti finali:** chiunque abbia necessità di sfruttare i principi di memorizzazione supportati da applicazioni per la *spaced repetition*, in particolare gli studenti universitari. Poiché il team stesso fa parte di questa categoria, i membri del gruppo agiranno direttamente da "esperti di dominio", basandosi sulle proprie necessità reali per definire i requisiti (es. la gestione delle scadenze d'esame) e valutare la praticità dell'applicazione.

### 3.2 Organizzazione interna del team

Il gruppo di sviluppo è strutturato secondo il modello **Scrum**, composto da *developer* alla pari. La figura dello *Scrum Master* è ricoperta direttamente da uno degli sviluppatori, Giorgio Rapetti.



## 4. Standard, linee guida, procedure

Per garantire uniformità e ordine durante l'intero ciclo di sviluppo, il team si impegna a rispettare un set definito di regole e procedure interne.

### 4.1 Standard linguistici
È adottata una rigorosa separazione linguistica per evitare ambiguità:
* **Inglese:** lingua esclusiva per la nomenclatura nel codice sorgente, per i commenti *in-line* e per la generazione della documentazione tecnica *JavaDoc*.
* **Italiano:** lingua designata per la documentazione formale di progetto, per le comunicazioni interne sulle piattaforme di gestione e per i messaggi di commit.

### 4.2 Standard di codifica e ambiente di sviluppo
Lo sviluppo del codice Java rispetterà le *Java Code Conventions* definite da Oracle. L'ambiente di sviluppo integrato (IDE) standardizzato per tutti i membri del team è Eclipse, integrato con Maven per la gestione strutturata e condivisa delle dipendenze esterne.

### 4.3 Procedure di versionamento e collaborazione
Per la gestione del repository GitHub il team adotta l'approccio *Feature Branch Workflow*. L'intero flusso collaborativo è regolamentato e documentato nel file interno [CONTRIBUTING.md](https://github.com/RichardBoy05/Kranki/blob/main/CONTRIBUTING.md), che funge da riferimento per gli sviluppatori.

### 4.4 Linee guida per i commit
Per garantire la leggibilità e l'ispezionabilità della cronologia del repository, i messaggi di commit devono essere mantenuti sintetici e strettamente descrittivi dell'azione svolta, fornendo un riepilogo immediato delle modifiche applicate.



## 5. Attività di gestione



### 5.1 Pianificazione e monitoraggio dell'avanzamento

Il monitoraggio dello stato di avanzamento del progetto è supportato nativamente dagli strumenti di tracciamento offerti dalla piattaforma GitHub. Le attività da svolgere, formalizzate sotto forma di *Issue*, sono raggruppate in specifiche *Milestone* temporali.
\
La gestione dell'operatività è demandata a una *Kanban Board* di progetto, strutturata in cinque stati di avanzamento logici:

* **Product Backlog**: raccoglitore generale dei requisiti e delle attività stimate ma non ancora pianificate.

* **Sprint Backlog**: sottoinsieme di attività selezionate e assegnate per l'iterazione di sviluppo corrente.

* **Doing**: attività attualmente in carico e in fase di elaborazione da parte dei membri del team.

* **In Review**: attività completate dal punto di vista implementativo ma in attesa di validazione. Il passaggio logico a questo stato è innescato dall'apertura di una *Pull Request*.

* **Done**: attività validate, approvate durante la revisione e integrate definitivamente nel ramo principale del progetto (*merge*), decretando la chiusura formale del task.


### 5.2 Coordinamento del team e cicli di sviluppo

Il flusso di lavoro si articola in cicli iterativi di sviluppo (*Sprint*). Per garantire il costante allineamento operativo del team e valutare lo stato di salute del progetto, è stata adottata una politica di coordinamento strutturata su due livelli. 
\
Durante le fasi iniziali di ingegneria dei requisiti e progettazione architetturale, sono previsti incontri formali a cadenza settimanale (tipicamente fissati nella giornata di giovedì). Tali incontri si svolgono preferibilmente in presenza, o in alternativa mediante piattaforme VoIP (come Discord). Nella successiva fase di implementazione del codice, la cadenza degli incontri formali transiterà a una frequenza bisettimanale.
\
A questi incontri si affiancano dei brevi allineamenti giornalieri, svolti prevalentemente in presenza durante le consuete attività universitarie, al fine di condividere i progressi e risolvere tempestivamente eventuali problemi.

### 5.3 Bilanciamento dei vincoli progettuali

Un aspetto centrale dell'attività di gestione consiste nel continuo bilanciamento tra l'estensione dei requisiti implementati e i vincoli temporali imposti dal contesto accademico. Il progetto adotta un approccio rigorosamente *time-boxed*: le date di scadenza associate alle singole *Milestone* sono considerate inalterabili.
\
In caso di scostamenti rispetto alla pianificazione originaria o di criticità nello sviluppo, la gestione interviene operando uno snellimento dinamico dello *Sprint Backlog*. Ciò si traduce nella de-prioritizzazione o posticipazione delle attività secondarie, garantendo che le risorse del team convergano in modo esclusivo verso le funzionalità architetturali, assicurando un rilascio funzionante entro le scadenze concordate.



## 6. Rischi

Di seguito sono riportati i principali fattori di rischio previsti per il progetto, suddivisi in tre categorie, unitamente alle relative strategie di mitigazione.

### 6.1 Rischi funzionali

*   **Complessità dell'algoritmo di scheduling adattivo**\
    Comprimere gli intervalli di ripasso in funzione di una data d'esame prefissata comporta una notevole complessità algoritmica.\
    *Mitigazione:* nel caso in cui lo sviluppo di tale meccanismo risultasse incompatibile con le tempistiche del corso, si ripiegherà temporaneamente sul solo modello convenzionale (basato su SM-2), rimandando le logiche più avanzate a versioni successive.
*   **_Requirements creep_**\
    La naturale tendenza a integrare funzionalità non pianificate rischia di distogliere l'attenzione dalle priorità del progetto, compromettendo la realizzazione delle parti essenziali del sistema.\
    *Mitigazione:* applicazione preventiva del metodo MoSCoW, ammettendo lo sviluppo di eventuali requisiti emersi in corso d'opera solo a seguito del completamento delle funzionalità prioritarie.

### 6.2 Rischi tecnologici

*   **Conflitti di sincronizzazione multi-dispositivo**\
    La modifica concorrente dei dati su dispositivi diversi comporta il rischio di conflitti durante la sincronizzazione con il database remoto.\
    *Mitigazione:* qualora la risoluzione di tali problematiche si rivelasse impraticabile, ci si affiderà al comportamento predefinito di Firebase, accettando l'eventuale rischio di sovrascrittura.
*   **Sviluppo dell'interfaccia grafica**\
    L'implementazione di elementi grafici complessi, come un editor di testo avanzato, presenta difficoltà realizzative non trascurabili.\
    *Mitigazione:* se necessario, si adotteranno soluzioni più semplici, privilegiando il corretto funzionamento del sistema piuttosto che l'estetica.

### 6.3 Rischi organizzativi

*   **Curve di apprendimento**\
    L'integrazione di un database remoto come Firebase e lo studio di nuovi framework per la GUI richiederanno un importante sforzo di comprensione iniziale.\
    *Mitigazione:* se una specifica tecnologia dovesse richiedere un onere di apprendimento incompatibile con le tempistiche, si opterà per l'implementazione della soluzione più semplice disponibile (valutando, ad esempio, il ripiego verso un database *embedded* locale).
*   **Sovrapposizione con le attività accademiche**\
    La necessità di conciliare le attività di progetto con gli altri impegni universitari può incidere sulla continuità del lavoro.\
    *Mitigazione:* la pianificazione sarà gestita in modo flessibile, calibrando l'assegnazione dei compiti e le scadenze interne in funzione delle esigenze dei singoli membri.



## 7. Personale

### 7.1 Dimensionamento e modello operativo
L'organico del progetto è costituito dai quattro membri del team, il cui impiego è previsto con un *effort* costante per l'intera durata dei lavori. Sebbene la responsabilità sul prodotto finale sia collettiva, il team adotta una ripartizione delle mansioni flessibile, basata sull'ottimizzazione delle competenze tecniche individuali.

### 7.2 Evoluzione temporale delle competenze
Il profilo delle competenze richieste al team varierà dinamicamente in funzione delle fasi del ciclo di vita del software:
* **Analisi e progettazione**: impiego corale dell'intero team nel ruolo di analisti dei requisiti e architetti software.
* **Implementazione**: transizione verso ruoli tecnici incentrati sui vari *Work Packages*.
* **Verifica e validazione**: convergenza totale del team verso attività di *Quality Assurance* ed esecuzione dei test.

### 7.3 Aree di competenza primarie
Si precisa esplicitamente che l'assegnazione dei ruoli in fase di implementazione ha un valore puramente **indicativo**. In coerenza con le metodologie agili, il team opererà senza rigide compartimentazioni: ogni membro potrà intervenire e contribuire trasversalmente su qualsiasi modulo del sistema. 
Tuttavia, al solo fine di ottimizzare il coordinamento tecnico, vengono individuate le seguenti aree di focus primario:
* **Giorgio Rapetti**: *Scrum Master* e focus sul modulo *Core*.
* **Francesco Berardi**: Focus sul modulo *Core*.
* **Gabriele Pullano**: Focus sul modulo *Database*.
* **Richard Meoli**: Focus sul modulo *UI*.


## 8. Metodi e tecniche

Questa sezione descrive le metodologie che il team adotterà durante le diverse fasi del ciclo di vita del software.

### 8.1 Ingegneria dei Requisiti
Per definire le funzionalità del sistema, il team adotterà quattro tecniche principali:
* **Brainstorming:** i requisiti emersi verranno discussi dal team e classificati rigorosamente utilizzando il metodo **MoSCoW** (*Must, Should, Could, Won't have*), in modo da definire un perimetro di sviluppo chiaro e compatibile con le tempistiche del corso.
* **Analisi di scenario:** verranno descritti casi d'uso concreti (scenari) per simulare l'interazione dell'utente con il sistema.
* **Etnografia:** l'etnografia prevede l'osservazione diretta degli utenti nel loro ambiente naturale al fine di far emergere abitudini consolidate e requisiti taciti difficilmente individuabili tramite altre tecniche. Nel nostro caso, tale analisi verrà applicata sotto forma di auto-osservazione, essendo i membri del team utilizzatori quotidiani di questi strumenti nel contesto universitario.
* **Derivazione da un sistema esistente:** verranno analizzati i software di *spaced repetition* esistenti (in particolare soluzioni consolidate come Anki) per derivare i requisiti base e identificare le aree di miglioramento.

### 8.2 Progettazione
La progettazione del sistema si baserà sulla modellazione **UML**.



## 9. Garanzia di qualità

Per assicurare che il software sviluppato rispetti elevati standard di affidabilità e manutenibilità, il team adotterà una strategia di *Quality Assurance* (QA) basata su tre pilastri fondamentali: analisi statica automatizzata, analisi dinamica tramite testing e revisione manuale.

### 9.1 Analisi statica del codice
Il controllo preventivo della qualità del codice sorgente sarà gestito attraverso la piattaforma ***SonarCloud***, integrata direttamente nel flusso di lavoro tramite Maven e supportata in locale dal plugin *SonarLint* per l'IDE Eclipse. Questo strumento fungerà da primo livello di controllo, rilevando in tempo reale *Code Smells*, bug potenziali e vulnerabilità di sicurezza. L'analisi statica provvederà inoltre a calcolare le principali metriche del software, ponendo per esempio attenzione alla misurazione della *Complessità Ciclomatica*, al fine di mantenere l'architettura del codice chiara e facilmente testabile.

### 9.2 Analisi dinamica e copertura 
La validazione funzionale del comportamento del software avverrà tramite la stesura di *Unit Test* utilizzando il framework ***JUnit***. Adottando un approccio di sviluppo tradizionale, la scrittura dei casi di test verrà effettuata a valle o contestualmente all'implementazione delle singole funzionalità. 
Per quantificare l'efficacia della suite di collaudo, la misurazione della *Code Coverage* (copertura del codice testato) sarà automatizzata attraverso l'integrazione del plugin ***JaCoCo*** all'interno del ciclo di build di Maven. I report generati da *JaCoCo* verranno trasmessi a *SonarCloud*, permettendo al team di monitorare costantemente la percentuale di codice validato dai test.

### 9.3 Revisione tra pari
Gli strumenti automatizzati saranno affiancati da un processo di validazione umana basato sulla *Code Review*. Tale revisione è obbligatoria per ogni *Pull Request* e deve essere rigorosamente effettuata da un membro del team diverso dall'autore delle modifiche. Questa ispezione incrociata agirà come un vero e proprio *Quality Gate* (cancello di qualità), garantendo l'identificazione di difetti logici, concettuali o architetturali che sfuggono alle analisi statiche e assicurando, al contempo, una conoscenza condivisa della *codebase* tra tutti gli sviluppatori.



## 10. Pacchetti di lavoro
L'organizzazione delle attività di sviluppo adotta una *Work Breakdown Structure* (WBS) allineata alla struttura architetturale del sistema. Il software è suddiviso in tre componenti principali, corrispondenti ad altrettanti progetti Eclipse Maven. Le attività si articolano nei seguenti *Work Packages* (WP).

*   **Core (`kranki-core`)**\
    Costituisce il nucleo logico dell'applicazione. Include principalmente la modellazione delle entità di dominio (mazzi, carte,...) e l'implementazione degli algoritmi per la *Spaced Repetition* e lo scheduling adattivo, unitamente ai vari servizi ausiliari. Il modulo non presenta alcuna dipendenza verso gli altri componenti interni del sistema.
*   **Database (`kranki-db`)**\
    Si occupa della persistenza delle informazioni, delle operazioni di serializzazione per l'importazione/esportazione dei mazzi e dell'integrazione con i servizi esterni. L'adozione di un database remoto come *Firebase* risponde all'esigenza di consentire la sincronizzazione multi-dispositivo (con i necessari meccanismi di autenticazione correlati), predisponendo l'infrastruttura anche a un'eventuale estensione in ambito mobile. Il modulo dichiara una dipendenza da `kranki-core`.
*   **UI (`kranki-ui`)**\
    Dedicato allo sviluppo dell'interfaccia grafica, con l'obiettivo di offrire un'esperienza d'uso semplice e intuitiva. Il modulo dipende sia da `kranki-core` che da `kranki-db`.

Tale ripartizione definisce la struttura e le dipendenze del software, ma non impone una rigida compartimentazione del personale durante lo sviluppo. Il team adotta infatti un modello di lavoro *cross-funzionale*: pur individuando per ciascun membro un'area di focus primario, è prevista una collaborazione trasversale sulle diverse attività.



## 11. Risorse

Il progetto prevede l'impiego delle seguenti risorse hardware e software.

### 11.1 Risorse hardware

Lo sviluppo e il test avverranno sui computer personali dei membri del team.

### 11.2 Risorse software

* **Ambienti di sviluppo:** Eclipse IDE.
* **Tool di modellazione:** StarUML v5.
* **Database remoto:** Firebase (tier gratuito "*Spark Plan*", sufficiente per l'impiego previsto).



## 12. Budget e programma

### 12.1 Budget 
Il progetto non prevede l'allocazione di un budget finanziario, poiché verranno impiegati esclusivamente strumenti di sviluppo, framework ad accesso gratuito.
Il budget è pertanto quantificato unicamente in termini di *effort* (ore-uomo). Basandosi sulle stime fornite dalla committenza, si prevede un impiego complessivo di circa 120-160 ore-uomo (corrispondenti a un range di 30-40 ore per ciascun membro del team). 

### 12.2 Programma
Come già anticipato nel punto 2 del presente documento, la programmazione temporale del progetto si articolerà seguendo le quattro macro-fasi previste dal framework RUP. Lo sviluppo procederà dall'*Inception* per l'ingegneria dei requisiti, all'*Elaboration* per la progettazione architetturale, per poi passare alla fase operativa di *Construction*, che adotterà cicli iterativi (*Sprint*) per la stesura del codice. Il percorso si concluderà con la *Transition*, dedicata al testing intensivo e alla finalizzazione dei *deliverable* in vista della consegna formale.



## 13. Cambiamenti

Attualmente non sono presenti variazioni rispetto al piano iniziale. Eventuali modifiche future a requisiti, architettura o tempistiche verranno formalmente documentate all'interno di questa sezione.



## 14. Consegna

Le procedure di rilascio e consegna del progetto al committente seguiranno rigorosamente le linee guida definite per la valutazione accademica. La consegna non prevederà l'invio di archivi compressi fisici, ma coinciderà in modo trasparente con lo stato finale della repository GitHub al termine della fase di consolidamento definitivo del codice.
