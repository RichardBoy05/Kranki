## 5. Attività di gestione



### 5.1 Pianificazione e monitoraggio dell'avanzamento

Il monitoraggio dello stato di avanzamento del progetto è supportato nativamente dagli strumenti di tracciamento offerti dalla piattaforma GitHub. Le attività da svolgere, formalizzate sotto forma di *Issue*, sono raggruppate in specifiche *Milestone* temporali.

La gestione dell'operatività è demandata a una *Kanban Board* di progetto, strutturata in cinque stati di avanzamento logici:

* **Product Backlog**: raccoglitore generale dei requisiti e delle attività stimate ma non ancora pianificate;

* **Sprint Backlog**: sottoinsieme di attività selezionate e assegnate per l'iterazione di sviluppo corrente;

* **Doing**: attività attualmente in carico e in fase di elaborazione da parte dei membri del team;

* **In Review**: attività completate dal punto di vista implementativo ma in attesa di validazione. Il passaggio logico a questo stato è innescato dall'apertura di una *Pull Request*;

* **Done**: attività validate, approvate durante la revisione e integrate definitivamente nel ramo principale del progetto (*merge*), decretando la chiusura formale del task.


### 5.2 Coordinamento del team e cicli di sviluppo

Il flusso di lavoro si articola in cicli iterativi di sviluppo (*Sprint*). Per garantire il costante allineamento operativo del team e valutare lo stato di salute del progetto, è stata adottata una politica di coordinamento strutturata su due livelli. 

Durante le fasi iniziali di ingegneria dei requisiti e progettazione architetturale, sono previsti incontri formali di sincronizzazione a cadenza settimanale (tipicamente fissati nella giornata di giovedì). Tali incontri si svolgono preferibilmente in presenza, o in alternativa mediante piattaforme VoIP (come Discord). Nella successiva fase di implementazione del codice, la cadenza degli incontri formali transiterà a una frequenza bisettimanale.

A questi incontri formali si affiancano dei brevi allineamenti giornalieri, svolti prevalentemente in presenza durante le consuete attività universitarie, al fine di condividere i progressi e risolvere tempestivamente eventuali problemi.

### 5.3 Bilanciamento dei vincoli progettuali

Un aspetto centrale dell'attività di gestione consiste nel continuo bilanciamento tra l'estensione dei requisiti implementati e i vincoli temporali imposti dal contesto accademico. Il progetto adotta un approccio rigorosamente *time-boxed*: le date di scadenza associate alle singole *Milestone* sono considerate inalterabili.

In caso di scostamenti rispetto alla pianificazione originaria o di criticità nello sviluppo, la gestione interviene operando uno snellimento dinamico dello *Sprint Backlog*. Ciò si traduce nella de-prioritizzazione o posticipazione delle attività secondarie, garantendo che le risorse del team convergano in modo esclusivo verso le funzionalità architetturali, assicurando un rilascio funzionante entro le scadenze concordate.

