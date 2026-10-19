## 2. Modello di processo

### 2.1 Approccio metodologico
Il ciclo di vita del software adotterà un approccio metodologico ibrido, integrando il rigore formale del *Rational Unified Process* (RUP) con l'agilità del framework *Scrum*. Questa scelta strategica è guidata dalla necessità di coniugare i requisiti valutativi del progetto con l'efficienza dello sviluppo. Il RUP fornisce la struttura ideale per soddisfare le richieste relative alla progettazione orientata agli oggetti e alla modellazione UML; d'altra parte, Scrum garantisce la flessibilità e l'adattività necessarie per la gestione pratica della stesura del codice.

### 2.2 Fasi del ciclo di vita
L'evoluzione del progetto è strutturata secondo le quattro macro-fasi previste dal RUP:
* **Inception (Ideazione):** rappresenta la fase di avvio del progetto, dedicata interamente all'ingegneria dei requisiti, alla definizione dei confini del sistema e alla formulazione degli obiettivi principali che l'applicativo dovrà soddisfare.
* **Elaboration (Elaborazione):** fase incentrata sulla progettazione architetturale e sulla modellazione orientata agli oggetti. I diagrammi UML fungeranno da documentazione e linea guida per lo sviluppo. Verrà inoltre effettuata una parziale adozione del paradigma *Model-Driven Architecture* (MDA), utilizzata come supporto iniziale per generare automaticamente lo scheletro di alcune classi strutturali.
* **Construction (Costruzione):** fase operativa in cui avviene la stesura manuale del codice sorgente. Il processo abbandona l'impostazione sequenziale per adottare dinamiche fortemente iterative governate da Scrum: lo sviluppo avverrà tramite cicli brevi (Sprint), al termine dei quali verranno prodotti incrementi di software tangibili e funzionanti.
* **Transition (Transizione):** fase conclusiva del ciclo di vita, successiva al consolidamento del codice. Si focalizza sulla validazione complessiva dell'applicativo, sul *bug-fixing* finale e sull'ottimizzazione del prodotto e della documentazione in vista della consegna.
