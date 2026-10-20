## 10. Pacchetti di lavoro
L'organizzazione delle attività di sviluppo adotta una *Work Breakdown Structure* (WBS) allineata alla struttura architetturale del sistema. Il software è suddiviso in tre componenti principali, corrispondenti ad altrettanti progetti Eclipse Maven. Le attività si articolano nei seguenti *Work Packages* (WP).

*   **Core (`kranki-core`)**\
    Costituisce il nucleo logico dell'applicazione. Include principalmente la modellazione delle entità di dominio (mazzi, carte,...) e l'implementazione degli algoritmi per la *Spaced Repetition* e lo scheduling adattivo, unitamente ai vari servizi ausiliari. Il modulo non presenta alcuna dipendenza verso gli altri componenti interni del sistema.
*   **Database (`kranki-db`)**\
    Si occupa della persistenza delle informazioni, delle operazioni di serializzazione per l'importazione/esportazione dei mazzi e dell'integrazione con i servizi esterni. L'adozione di un database remoto come *Firebase* risponde all'esigenza di consentire la sincronizzazione multi-dispositivo (con i necessari meccanismi di autenticazione correlati), predisponendo l'infrastruttura anche a un'eventuale estensione in ambito mobile. Il modulo dichiara una dipendenza da `kranki-core`.
*   **UI (`kranki-ui`)**\
    Dedicato allo sviluppo dell'interfaccia grafica, con l'obiettivo di offrire un'esperienza d'uso semplice e intuitiva. Il modulo dipende sia da `kranki-core` che da `kranki-db`.

Tale ripartizione definisce la struttura e le dipendenze del software, ma non impone una rigida compartimentazione del personale durante lo sviluppo. Il team adotta infatti un modello di lavoro *cross-funzionale*: pur individuando per ciascun membro un'area di focus primario, è prevista una collaborazione trasversale sulle diverse attività.
