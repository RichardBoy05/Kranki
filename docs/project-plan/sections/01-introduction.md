# Kranki — Project Plan

## 1. Introduzione

### 1.1 Contesto del progetto
Il presente documento costituisce il *Project Plan* relativo al progetto sviluppato nell'ambito del corso di Ingegneria del Software (A.A. 2026/2027) presso l'Università degli Studi di Bergamo, su committenza del Prof. Angelo Gargantini e della Dott.ssa Silvia Bonfanti. 
Il team responsabile dell'intero ciclo di vita del software è composto dai seguenti membri:
* Berardi Francesco
* Meoli Richard
* Pullano Gabriele
* Rapetti Giorgio

### 1.2 Dominio applicativo
Il progetto si colloca nell'ambito degli strumenti software a supporto dello studio, basandosi su due fondamentali principi cognitivi: l'*Active Recall* (recupero attivo) e la *Spaced Repetition* (ripetizione dilazionata). Il primo consiste nello sforzo di recuperare un'informazione dalla memoria senza l'ausilio di suggerimenti passivi (come la semplice rilettura di un testo), una pratica implementata nel software tramite l'utilizzo delle *flashcard*, ossia carte virtuali tipicamente strutturate in formato domanda/risposta. Tale sforzo di memorizzazione è però fisiologicamente ostacolato dalla naturale "curva dell'oblio", che porta alla progressiva perdita delle nozioni nel tempo. Per contrastare questo fenomeno interviene la *Spaced Repetition*, una tecnica che programma i ripassi delle *flashcard* a intervalli di tempo via via crescenti. Tale approccio algoritmico ha lo scopo di stimolare la memoria esattamente nel momento in cui un'informazione sta per essere dimenticata, massimizzando così la ritenzione a lungo termine.

### 1.3 Origine dell'idea
L'idea alla base del progetto nasce dall'esperienza diretta del team come studenti e utilizzatori di strumenti digitali per l'apprendimento. Le soluzioni tradizionali basate su *flashcard* sono storicamente progettate per l'acquisizione di conoscenze su un orizzonte temporale indefinito. Pur rivelandosi eccellenti per questo scopo, tale logica tende a scontrarsi con le dinamiche accademiche, caratterizzate dalla perentorietà degli appelli d'esame. L'assenza di funzionalità native per vincolare i ripassi a una scadenza fissa costringe spesso lo studente ad alterare manualmente le tempistiche di revisione a ridosso dell'esame, compromettendo l'efficienza del ripasso.

### 1.4 Obiettivi del progetto
Per colmare questo divario nasce **Kranki**, un ambiente di studio basato su *flashcard* concepito per adattarsi alle esigenze universitarie e implementato come applicazione Java Desktop. Pur traendo ispirazione da soluzioni open-source consolidate come Anki, l'obiettivo primario del sistema è quello di fornire un motore di *Spaced Repetition* che introduca logiche di scheduling adattive, progettate per ricalibrare i cicli di revisione in funzione di scadenze temporali rigide imposte dall'utente. A questo obiettivo si affiancherà l'integrazione di meccaniche a supporto della costanza nello studio giornaliero, attraverso elementi di tracciamento dell'attività e gratificazione volti a sostenere la motivazione dello studente.
