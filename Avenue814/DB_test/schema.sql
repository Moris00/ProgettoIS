DROP TABLE IF EXISTS Utente ;
CREATE TABLE Utente(id_utente int PRIMARY KEY auto_increment not null,
                       email VarChar(30) NOT NULL,
                       passw VARCHAR(45) NOT NULL,
                       nome VARCHAR(16),
                       cognome VARCHAR(16),
                       username VARCHAR(16),
                       ruolo VARCHAR(25)
);

DROP TABLE IF EXISTS Prodotti;
CREATE TABLE Prodotti(id_prodotti int PRIMARY KEY NOT NULL auto_increment,
                      nome VARCHAR(25) ,
                      prezzo Double,
                      descrizione VARCHAR(150),
                      categoria VARCHAR(10),
                      quantita int,
                      pathImage VARCHAR(200),
                      sesso Varchar(15), 
                      proprieta int,
                      disponibilita boolean default true
);

DROP TABLE IF EXISTS Ordini ;
CREATE TABLE Ordini(id_ordini int PRIMARY KEY NOT NULL auto_increment,
					id_user int not null,
                    id_prodotto int not null,
                    indirizzo VARCHAR(30), 
                    method_pagament VARCHAR(25),
                    dataa Varchar(45)
);



