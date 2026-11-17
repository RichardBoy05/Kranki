### Viste architetturali

La documentazione dell'architettura di un sistema software richiede l'adozione di molteplici prospettive, in quanto un'unica rappresentazione globale risulterebbe insufficiente per comunicare efficacemente con tutti gli *stakeholder*. Per rispondere a questa esigenza, la progettazione di *Kranki* adotta il modello architetturale "4+1" ideato da Philippe **Kruchten**. Tale scelta si integra naturalmente nel ciclo di vita adottato dal team, in quanto tale modello costituisce lo standard di riferimento del processo **RUP** (*Rational Unified Process*), il quale prevede inoltre un forte orientamento all'utilizzo della notazione UML. La descrizione del sistema si articola quindi in quattro punti di vista tecnici, affiancati da una quinta prospettiva trasversale che funge da collante logico.

#### Punto di vista logico
Descrive il sistema sotto il profilo concettuale, evidenziando gli elementi di progettazione principali del dominio applicativo e le loro relazioni. Tale vista è rivolta principalmente a illustrare come l'architettura soddisfi i requisiti funzionali attesi dall'utente finale.
* Diagramma delle classi: [link immagine](), [link file]()
* Diagramma di stato: [link immagine](), [link file]()

#### Punto di vista dell'implementazione
Fornisce una visione statica orientata agli sviluppatori e alla gestione del codice sorgente, illustrando la scomposizione del sistema in termini di moduli, pacchetti e livelli architetturali.
* Diagramma dei componenti: [link immagine](), [link file]()
* Diagramma dei pacchetti: [link immagine](), [link file]()

#### Punto di vista del processo
Rappresenta il comportamento dinamico del sistema in fase di esecuzione, focalizzandosi sul flusso delle attività, sui processi e sulle dinamiche di interazione e comunicazione temporale tra gli oggetti.
* Diagramma di sequenza: [link immagine](), [link file]()
* Diagramma di attività: [link immagine](), [link file]()
* Diagramma di comunicazione: [link immagine](), [link file]()

#### Punto di vista della distribuzione
Descrive l'architettura fisica del sistema, illustrando come gli artefatti software vengono distribuiti e allocati sui rispettivi nodi di esecuzione.
* Diagramma di deployment: [link immagine](), [link file]()

#### Punto di vista degli scenari (+1)
Raccoglie l'insieme dei casi d'uso fondamentali del sistema. Questa prospettiva guida l'intero processo di progettazione architetturale e svolge un ruolo di validazione e integrazione per gli altri quattro punti di vista tecnici.
* I diagrammi dei casi d'uso sono già stati inclusi nella sezione del documento dedicata alla descrizione dei requisiti del sistema.