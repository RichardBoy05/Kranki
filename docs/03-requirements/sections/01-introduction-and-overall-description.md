# 3. Requisiti



## 3.1 Ingegneria dei requisiti



### 3.1.1 Introduzione

Kranki è un'applicazione dedicata allo studio tramite *flashcard*, progettata per supportare, in particolare, lo studente universitario nella memorizzazione a lungo termine. A differenza delle soluzioni tradizionali, il sistema introduce un motore di *Spaced Repetition* capace di adattare i cicli di revisione a scadenze temporali rigide, come gli appelli d'esame. L'obiettivo è massimizzare l'efficienza dello studio, bilanciando la tecnica della ripetizione dilazionata con la necessità di una copertura totale del materiale entro date prestabilite.



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
| *CRUD*               | Acronimo per Create, Read, Update, Delete: le operazioni fondamentali di gestione dei dati.                     |
| *DB*                 | Modulo architettonico dedicato all'accesso ai dati e alla loro persistenza.                                     |                           |
| *Exam Mode*          | Algoritmo avanzato di compressione delle scadenze, che impone la revisione di tutte le *Flashcard* entro una data limite fissa. |
| *Flag*               | Marcatore visivo utilizzabile per evidenziare una *Flashcard*.                                                  |
| *Flashcard*          | L'unità base di studio dell'applicazione.                                                                       |
| *Fronte*             | La parte della *Flashcard* contenente la domanda.                                                   |
| *FSRS*               | Algoritmo avanzato di *Spaced Repetition* basato su un modello matematico della memoria per ottimizzare gli intervalli di ripasso.                                  |
| *UI*           | Modulo architettonico dedicato all'interfaccia grafica.                                         |
| *Image Occlusion*    | Tipologia di *Flashcard* che verifica il riconoscimento di porzioni nascoste di un'immagine.                          |
| *LaTeX*              | Linguaggio di markup utilizzato per il rendering di formule matematiche.                                        |
| *Markdown*           | Linguaggio di markup utilizzato per la formattazione avanzata del testo.                                |
| *Mazzo*              | Contenitore logico che raggruppa una specifica collezione di *Flashcard*.                                         |
| *Milestone*          | Traguardo sbloccabile in base alle statistiche di studio.                                                       |
| *Reset*              | Azione che azzera i progressi registrati per una *Flashcard*.                                    |
| *Retro*              | La parte della *Flashcard* contenente la soluzione.                                                              |
| *Rollover*           | Orario di sistema che determina lo scatto al "nuovo giorno" ai fini del calcolo delle scadenze.                 |
| *Seppellimento*      | Esclusione temporanea di una *Flashcard* dalla sessione di studio, limitata alla giornata in corso.               |
| *Sessione di studio* | Attività in cui l'utente ripassa una sequenza di *Flashcard* selezionate dal sistema.                           |
| *Set Due Date*       | Forzatura manuale della data di scadenza di una *Flashcard*, sovrascrivendo il calcolo algoritmico.                    |
| *Skip*               | Spostamento di una *Flashcard* in fondo alla coda della sessione odierna, rimandandone il ripasso.          |
| *SM-2*               | Algoritmo di *Spaced Repetition* alla base del sistema di ripasso dell'applicazione.                                           |
| *Sospensione*        | Esclusione a tempo indeterminato di una *Flashcard*, fino a riattivazione manuale.                                |
| *Spaced Repetition*  | Tecnica di apprendimento che distribuisce i ripassi a intervalli temporali crescenti.                              |
| *Streak*             | Contatore dei giorni consecutivi in cui viene registrata una specifica attività nell'applicazione.         |
| *Tag*                | Etichetta testuale applicabile a una *Flashcard* per agevolarne la classificazione.                               |
| *Type in the Answer* | Tipologia di *Flashcard* che richiede la digitazione manuale della risposta.                    |
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
| [Titolo del caso d'uso](https://markdownlivepreview.com/) | [Titolo del caso d'uso](https://markdownlivepreview.com/) |
| [Titolo del caso d'uso](https://markdownlivepreview.com/) | [Titolo del caso d'uso](https://markdownlivepreview.com/) |
| [Titolo del caso d'uso](https://markdownlivepreview.com/) | [Titolo del caso d'uso](https://markdownlivepreview.com/) |
