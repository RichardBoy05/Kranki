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
