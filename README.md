Sistema base di connessione database
Questo progetto rappresenta una prima implementazione di un sistema backend orientato alla gestione utenti con connessione a database relazionale.
Il sistema è organizzato in quattro componenti principali:
- DBConnection
Responsabile della gestione della connessione al database. Centralizza la configurazione e l’apertura delle connessioni.
- UserDAO
Si occupa dell’accesso ai dati relativi all’entità User, contiene le query SQL e gestisce le operazioni CRUD.
- UserService
Gestisce la logica applicativa. Agisce come intermediario tra il livello di presentazione e il DAO.
- User
Rappresenta il modello dati dell’utente.

Progetto sviluppato a scopo formativo per consolidare le basi della programmazione backend e comprendere il flusso completo tra applicazione e database.
