## 1.13 Cambiamenti

Rispetto alla versione `1.0` approvata del *Project Plan*, nella revisione `1.1` sono state introdotte le seguenti modifiche:

* **Introduzione del modulo `kranki-app` e stratificazione rigida (Sez. 1.10):** per mantenere il pieno disaccoppiamento tra UI e persistenza anche con salvataggi locali frequenti, `kranki-ui` dipende ora esclusivamente da `kranki-core`, mentre il collegamento iniziale tra i moduli del sistema è demandato al modulo di avvio `kranki-app`.
* **Aggiornamento della strategia di fallback sui conflitti (Sez. 1.6.2):** adeguata la mitigazione all'integrazione di Firebase su Java Desktop, sostituendo il riferimento al comportamento predefinito di Firebase con una politica di sovrascrittura esplicita (es. *Last-Write-Wins*).
* **Integrazione delle risorse software (Sez. 1.11.2):** esplicitata l'adozione di JavaFX e SceneBuilder per la realizzazione dell'interfaccia grafica.
