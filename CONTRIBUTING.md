# Kranki 🦑 — GitHub Development Workflow

Questo documento definisce la procedura standard che ogni membro del team deve seguire per implementare una nuova funzionalità o risolvere un bug, garantendo l'integrità dell'architettura e l'allineamento della *Kanban Board*.

---

## 🔄 FASE 0: Sincronizzazione iniziale

1. **Pull:** prima di iniziare qualsiasi nuova attività occorre aprire GitHub Desktop, posizionarsi sul branch `main` ed eseguire un `Pull origin`.

---

## 🎯 FASE 1: Presa in carico

1. **Selezione:** selezionare un Issue dalla colonna `Sprint Backlog` della *Kanban Board*.

2. **Assegnazione:** auto-assegnarsi l'Issue (campo *Assignees*), a meno che non sia già stato assegnato ad un altro membro.

3. **Aggiornamento _Kanban Board_:** trascinare manualmente la card dell'Issue dalla colonna `Sprint Backlog` alla colonna `Doing` della *Kanban Board*.


4. **Creazione Branch:** direttamente dalla pagina dell'Issue su GitHub, cliccare su `Create a branch`, lasciando il nome generato in automatico.

> **📋 REMINDER**:
> a differenza di tutti gli altri spostamenti della *Kanban Board*, il passaggio della card dalla colonna `Sprint Backlog` alla colonna `Doing` non è automatizzato e deve essere effettuato **MANUALMENTE** dallo sviluppatore.

---

## 🛠️ FASE 2: Sviluppo

1. **Sincronizzazione locale:** aprire GitHub Desktop, cliccare su `Fetch origin` e selezionare il nuovo branch appena creato.

2. **Modifiche:** scrivere il codice su Eclipse (o effettuare un altro tipo di modifica, ad esempio relativa alla documentazione).

3. **Commit & Push:** a lavoro concluso (o per salvataggi intermedi), inserire un messaggio di commit descrittivo su GitHub Desktop e cliccare su `Commit`, seguito da `Push origin`.

---

## 🔀 FASE 3: Pull Request

1. **Apertura PR:** tramite Github Desktop, cliccare su `Create a pull request`.

2. **Nomina revisore:** selezionare 1 membro del team nel campo *Reviewers*. Evitare di auto-assegnarsi le Pull Request.

> **🤖 Automazione _Kanban Board_**:
> grazie al collegamento tra Pull Request e Issue, la card dell'Issue viene spostata automaticamente nella colonna `Review`, senza necessità di un intervento manuale.

---

## 🔍 FASE 4: Code Review

1. **Code Review:** il revisore designato esamina il codice sul sito di GitHub.

2. **Approvazione:** se il codice e/o le altre modifiche sono ritenute conformi, il revisore clicca su `Approve`.

3. **Merge:** una volta approvata la PR, il revisore clicca su `Merge pull request`.

>
> - **🔒 Chiusura automatica:** il merge della Pull Request chiude automaticamente l'Issue associato. Anche l'eliminazione del Branch associato avviene in automatico.
> - **🤖 Automazione _Kanban Board_:** la card dell'Issue viene spostata automaticamente nella colonna `Done`.