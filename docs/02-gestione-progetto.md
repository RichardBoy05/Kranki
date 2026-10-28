# 2 — Gestione del Progetto

## 2.1 Ciclo di Vita del Software

### 2.1.1 Processo di sviluppo applicato
In conformità a quanto stabilito nel *Project Plan*, il team implementa un processo di sviluppo ibrido. La fase iniziale di analisi e progettazione segue le direttive del framework RUP (*Inception* ed *Elaboration*), concentrandosi sull'ingegneria dei requisiti e sulla modellazione del dominio. La successiva fase operativa di *Construction* viene gestita attraverso l'applicazione del framework agile *Scrum*.

### 2.1.2 *Timebox* e pianificazione degli *Sprint*
La fase di stesura del codice è vincolata all'interno di *Sprint* di durata fissa pari a due settimane (14 giorni). Il calendario di sviluppo prevede quattro iterazioni principali, pianificate come segue:

| Iterazione   | Data Inizio      | Data Fine        | Obiettivo Principale |
| :----------- | :--------------- | :--------------- | :------------------- |
| **Sprint 1** | 19 Novembre 2026 | 03 Dicembre 2026 | TODO - da definire   |
| **Sprint 2** | 03 Dicembre 2026 | 17 Dicembre 2026 | TODO - da definire   |
| **Sprint 3** | 17 Dicembre 2026 | 31 Dicembre 2026 | TODO - da definire   |
| **Sprint 4** | 31 Dicembre 2026 | 14 Gennaio 2027  | TODO - da definire   |

*(Nota: Gli obiettivi dei singoli Sprint sono puramente indicativi e si adattano dinamicamente in base alle priorità del Product Backlog).*

### 2.1.3 Approccio MDA
Durante la fase di *Elaboration*, il team adotta tecniche proprie del paradigma MDA limitandone l'applicazione allo sviluppo di parte del modulo centrale (`kranki-core`). Utilizzando il software di modellazione **StarUML**, viene disegnato il *Class Diagram* relativo al dominio applicativo. In seguito, sfruttando la funzionalità di generazione del codice integrata nel tool, una porzione del diagramma viene tradotta automaticamente nello scheletro Java delle entità fondamentali del sistema (es. `Deck`, `Flashcard`, `Tag`). Questo perimetro di applicazione mirato evita la generazione di codice boilerplate inutile nei moduli UI e DB, limitando l'intervento manuale degli sviluppatori alla sola implementazione della logica di business all'interno degli Sprint.

### 2.1.4 Formalizzazione della Gestione delle *Change Request* / *Issue*
TODO - si può fare un *activity diagram*