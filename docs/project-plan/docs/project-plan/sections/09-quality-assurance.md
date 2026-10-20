## 9. Garanzia di qualità

Per assicurare che il software sviluppato rispetti elevati standard di affidabilità e manutenibilità, il team adotterà una strategia di *Quality Assurance* (QA) basata su tre pilastri fondamentali: analisi statica automatizzata, analisi dinamica tramite testing e revisione manuale.

### 9.1 Analisi statica del codice
Il controllo preventivo della qualità del codice sorgente sarà gestito attraverso la piattaforma ***SonarCloud***, integrata direttamente nel flusso di lavoro tramite Maven e supportata in locale dal plugin *SonarLint* per l'IDE Eclipse. Questo strumento fungerà da primo livello di controllo, rilevando in tempo reale *Code Smells*, bug potenziali e vulnerabilità di sicurezza. L'analisi statica provvederà inoltre a calcolare le principali metriche del software, ponendo per esempio attenzione alla misurazione della *Complessità Ciclomatica*, al fine di mantenere l'architettura del codice chiara e facilmente testabile.

### 9.2 Analisi dinamica e copertura 
La validazione funzionale del comportamento del software avverrà tramite la stesura di *Unit Test* utilizzando il framework ***JUnit***. Adottando un approccio di sviluppo tradizionale, la scrittura dei casi di test verrà effettuata a valle o contestualmente all'implementazione delle singole funzionalità. 
Per quantificare l'efficacia della suite di collaudo, la misurazione della *Code Coverage* (copertura del codice testato) sarà automatizzata attraverso l'integrazione del plugin ***JaCoCo*** all'interno del ciclo di build di Maven. I report generati da *JaCoCo* verranno trasmessi a *SonarCloud*, permettendo al team di monitorare costantemente la percentuale di codice validato dai test.

### 9.3 Revisione tra pari
Gli strumenti automatizzati saranno affiancati da un processo di validazione umana basato sulla *Code Review*. Tale revisione è obbligatoria per ogni *Pull Request* e deve essere rigorosamente effettuata da un membro del team diverso dall'autore delle modifiche. Questa ispezione incrociata agirà come un vero e proprio *Quality Gate* (cancello di qualità), garantendo l'identificazione di difetti logici, concettuali o architetturali che sfuggono alle analisi statiche e assicurando, al contempo, una conoscenza condivisa della *codebase* tra tutti gli sviluppatori.
