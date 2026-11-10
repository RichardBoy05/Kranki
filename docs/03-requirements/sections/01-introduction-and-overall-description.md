# 3. Requisiti



## 3.1 Ingegneria dei requisiti



### 3.1.1 Introduzione

Kranki è un'applicazione dedicata allo studio tramite *flashcard*, progettata per supportare, in particolare, lo studente universitario nella memorizzazione a lungo termine. A differenza delle soluzioni tradizionali, il sistema introduce un motore di *Spaced Repetition* capace di adattare i cicli di revisione a scadenze temporali rigide, come gli appelli d'esame. L'obiettivo è massimizzare l'efficienza dello studio, bilanciando la tecnica della ripetizione dilazionata con la necessità di una copertura totale del materiale entro date prestabilite.



La presente sezione del documento definisce le specifiche funzionali del sistema. La specifica dei requisiti è stata redatta in conformità con i principi dello standard **IEEE 830**, al fine di ridurre possibili ambiguità interpretative tra il team di sviluppo e gli *stakeholder*.



#### Glossario

Il seguente glossario contiene le definizioni dei termini tecnici di dominio utilizzati nella specifica dei requisiti.



| Termine | Descrizione |

| :--- | :--- |

| **Archiviazione** | Stato di sospensione di un mazzo che ne interrompe la generazione di scadenze pur mantenendolo consultabile. |

| **Browser** | Interfaccia a elenco o tabella per la gestione e l'ordinamento delle flashcard di un mazzo. |

| **Carta Invertita** | Tipologia di flashcard che genera logicamente due sensi di studio: fronte → retro e retro → fronte. |

| **Cloze** | Tipologia di flashcard avanzata basata su un testo con lacune da riempire. |

| **CORE** | Modulo architettonico dedicato alla logica di business e alle regole di dominio. |

| **CRUD** | Acronimo per *Create, Read, Update, Delete*: le operazioni fondamentali di gestione dei dati. |

| **DB** | Modulo architettonico dedicato all'accesso ai dati e alla loro persistenza. |

| **Due Date** | Data di scadenza calcolata dal sistema per il prossimo ripasso di una flashcard. |

| **Exam Mode** | Algoritmo di compressione delle scadenze che impone la revisione di tutte le carte entro una data limite fissa. |

| **Flag** | Marcatore visivo applicabile a una flashcard per evidenziarla. |

| **Flashcard** | L'unità base di studio dell'applicazione. |

| **Fronte** | La faccia della flashcard contenente il quesito o lo stimolo. |

| **FSRS** | Algoritmo avanzato di scheduling basato su modelli di memoria a lungo termine. |

| **GUI / UI** | Modulo architettonico dedicato all'interfaccia di presentazione visiva. |

| **Image Occlusion** | Tipologia di flashcard in cui porzioni di un'immagine vengono oscurate vettorialmente. |

| **LaTeX** | Linguaggio di markup utilizzato per il rendering di formule matematiche. |

| **Markdown** | Linguaggio di markup leggero utilizzato per la formattazione avanzata del testo. |

| **Mazzo** | Contenitore logico che raggruppa una specifica collezione di flashcard. |

| **Milestone** | Traguardo sbloccabile in base alle statistiche di studio. |

| **Reset** | Azione di azzeramento completo dello storico dei progressi di una flashcard. |

| **Retro** | La faccia della flashcard contenente la soluzione. |

| **Rollover** | Orario di sistema che determina lo scatto al "nuovo giorno" ai fini del calcolo delle scadenze. |

| **Seppellimento** | Esclusione temporanea di una flashcard dalla sessione di studio, limitata alla giornata in corso. |

| **Sessione di Studio** | Processo attivo in cui l'utente valuta in sequenza una coda di flashcard in scadenza. |

| **Set Due Date** | Forzatura manuale della data di scadenza di una flashcard, ignorando il calcolo algoritmico. |

| **Skip** | Spostamento di una flashcard in fondo alla coda della sessione odierna, posticipandone la valutazione. |

| **SM-2** | Algoritmo matematico standard per il calcolo della spaced repetition. |

| **Sospensione** | Esclusione a tempo indeterminato di una flashcard, fino a riattivazione manuale. |

| **Spaced Repetition** | Tecnica di apprendimento che programma i ripassi a intervalli temporali crescenti. |

| **Streak** | Contatore che traccia i giorni consecutivi in cui l'utente ha effettuato almeno una sessione di studio. |

| **Tag** | Etichetta testuale applicabile a una flashcard per agevolarne la classificazione. |

| **Type in the Answer** | Tipologia di flashcard che richiede l'inserimento esplicito della risposta tramite tastiera. |

| **Undo/Redo** | Sistema globale di annullamento e ripristino delle azioni di sistema effettuate. |



### 3.1.2 Descrizione generale



La definizione dei requisiti è il risultato di un processo iterativo e multi-metodologico. Il team ha integrato diverse tecniche di elicitazione per coprire sia gli aspetti funzionali che quelli legati alla qualità dell'esperienza d'uso.



* **Derivazione da un sistema esistente**: è stata condotta un'analisi comparativa dei software di *Spaced Repetition* esistenti, con particolare focus su Anki. Tale approccio ha permesso di derivare il set di requisiti funzionali di base e di identificare potenziali criticità sulle quali intervenire con soluzioni migliorative.

* **Brainstorming**: il team ha organizzato sessioni di gruppo per far emergere idee e funzionalità innovative. In particolare, ciascun requisito è stato classificato mediante il metodo **MoSCoW**.

* **Etnografia**: poiché i membri del team sono utilizzatori quotidiani di strumenti di studio in ambito universitario, è stata applicata una forma di auto-osservazione. Questo ha permesso di far emergere esigenze tacite e abitudini consolidate che un'analisi puramente teorica avrebbe ignorato.




#### Documentazione UML: diagrammi dei casi d'uso

Durante la fase di ingegneria dei requisiti sono stati inoltre realizzati alcuni diagrammi dei casi d’uso, consultabili ai seguenti link.



* **Diagrammi UML:** [Link al repository/cartella StarUML]
* **Casi d'Uso (Overview):**
    * [Placeholder: Inserire qui il Diagramma Casi d'Uso — Libreria]
    * [Placeholder: Inserire qui il Diagramma Casi d'Uso — Sessione di Studio]
    * [Placeholder: Inserire qui il Diagramma Casi d'Uso — Sistema e Impostazioni]

