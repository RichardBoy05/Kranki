\## 8. Metodi e Tecniche



Questa sezione descrive le metodologie, i paradigmi e i processi logici che il team adotterà durante le diverse fasi del ciclo di vita del software. L'elenco degli strumenti software (IDE, librerie, servizi cloud) utilizzati per mettere in pratica queste tecniche è invece dettagliato nel Punto 11 (Risorse).



\### 8.1 Ingegneria dei Requisiti

Per definire le funzionalità del sistema, il team adotterà due tecniche principali:

\* \*\*Analisi di Dominio:\*\* Verranno analizzati i software di \*spaced repetition\* esistenti (in particolare soluzioni consolidate come Anki) per derivare i requisiti base e identificare le aree di miglioramento.

\* \*\*Brainstorming e Prioritizzazione:\*\* I requisiti emersi verranno discussi dal team e classificati rigorosamente utilizzando il metodo \*\*MoSCoW\*\* (\*Must, Should, Could, Won't have\*), in modo da definire un perimetro di sviluppo chiaro e compatibile con le tempistiche del corso.



\### 8.2 Progettazione e Architettura

La progettazione del sistema avverrà tramite la \*\*modellazione UML\*\* (Use Case, Class, Sequence e State Machine Diagram). 

A livello architetturale, il software seguirà il pattern \*\*MVC (Model-View-Controller)\*\*. Questa scelta metodologica è fondamentale per garantire la separazione degli interessi (\*Separation of Concerns\*): la logica algoritmica dei mazzi (Model) sarà mantenuta totalmente indipendente dalla sua rappresentazione grafica (View) e dalla persistenza dei dati.



\### 8.3 Implementazione

La scrittura del codice seguirà il paradigma della \*\*Programmazione Orientata agli Oggetti (OOP)\*\*. Verrà fatto ampio uso dei principi di ereditarietà e polimorfismo (ad esempio per gestire in modo flessibile diverse tipologie di \*flashcard\* senza duplicare il codice).

Inoltre, la gestione delle librerie esterne e dei moduli interni non verrà effettuata manualmente, ma seguirà la tecnica della \*\*gestione automatizzata delle dipendenze\*\*, garantendo un progetto portabile e facilmente compilabile su ogni macchina del team.



\### 8.4 Testing e Gestione delle Versioni

Per garantire la stabilità del codice e coordinare il lavoro parallelo dei 4 membri, verranno applicate le seguenti tecniche:

\* \*\*Feature Branching e Code Review:\*\* Il codice non verrà mai modificato direttamente sul ramo principale (`main`). Ogni nuova funzionalità verrà sviluppata su un ramo separato (\*branch\*) e fusa con il progetto principale solo tramite una \*Pull Request\* verificata dal team.

\* \*\*Unit Testing:\*\* La tecnica di collaudo principale sarà il test di unità (\*bottom-up\*). Invece di testare l'intera interfaccia grafica, i test si concentreranno sulla validazione matematica della \*Business Logic\* (ad esempio, verificando che l'algoritmo SM-2 calcoli correttamente gli intervalli in giorni).

