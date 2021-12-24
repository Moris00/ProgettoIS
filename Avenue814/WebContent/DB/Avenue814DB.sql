DROP DATABASE IF EXISTS Avenue814;

 

CREATE DATABASE Avenue814;

 

USE Avenue814;

 

drop user if exists 'admin'@'localhost';  

 

create user 'admin'@'localhost' identified by 'Avenue813';

 

GRANT ALL ON Avenue814.* to 'admin'@'localhost';

 

DROP TABLE IF EXISTS Utente ;

 

CREATE TABLE Utente(id_utente int PRIMARY KEY auto_increment not null,
                       email VarChar(30) NOT NULL,
                       passw VARCHAR(45) NOT NULL,
                       nome VARCHAR(16),
                       cognome VARCHAR(16),
                       username VARCHAR(16)
);

 


DROP TABLE IF EXISTS Prodotti ;

 

CREATE TABLE Prodotti(id_prodotti int PRIMARY KEY NOT NULL auto_increment,
                      nome VARCHAR(25) ,
                      prezzo Double,
                      descrizione VARCHAR(150),
                      categoria VARCHAR(10),
                      quantità int,
                      pathImage VARCHAR(200),
                      sesso Varchar(15)
) ;
                      
DROP TABLE IF EXISTS Ordini ;

 

CREATE TABLE Ordini(id_ordini int PRIMARY KEY NOT NULL auto_increment,
                    indirizzo VARCHAR(30), 
                    method_pagament VARCHAR(25) );

 

DROP TABLE IF EXISTS Contiene ;

 

CREATE TABLE Contiene( id_ordini int NOT NULL , 
                    id_prodotti int NOT NULL ,
                     FOREIGN KEY (id_ordini) REFERENCES Ordini(id_ordini),
                     FOREIGN KEY (id_prodotti) REFERENCES Prodotti(id_prodotti)
                     );

 

DROP TABLE IF EXISTS Effettua ;

 

CREATE TABLE Effettua( id_ordini int NOT NULL , 
                    id_utente int NOT NULL ,
                    data Date NOT NULL,
                    prezzo Double,
                     FOREIGN KEY (id_ordini) REFERENCES Ordini(id_ordini),
                     FOREIGN KEY (id_utente) REFERENCES Utente(id_utente)
                     );
                     
DROP TABLE IF EXISTS Rivenditore ;

 

CREATE TABLE Rivenditore( 
                    id_utente int NOT NULL auto_increment,
                     FOREIGN KEY (id_utente) REFERENCES Utente(id_utente)
                     );
                     
DROP TABLE IF EXISTS Gestisce ;

 

CREATE TABLE Gestisce( id_prodotti int NOT NULL , 
                    id_rivenditore int NOT NULL ,
                    disponibilità boolean default true,
                     FOREIGN KEY (id_prodotti) REFERENCES Prodotti(id_prodotti),
                     FOREIGN KEY (id_rivenditore) REFERENCES Rivenditore(id_utente)
                     );

 

DROP TABLE IF EXISTS Amministratore;

 

CREATE TABLE Amministratore( 
                    id_utente int NOT NULL auto_increment,
                     FOREIGN KEY (id_utente) REFERENCES Utente(id_utente)
                     );

 

                
        

 

insert into Utente(id_utente,email, passw, nome, cognome, username) values (123,'primo@gmail.com','cHJpbW8=','Silvio','Berlusconi','Silvio99');
insert into Utente(id_utente,email, passw, nome, cognome, username) values (258,'second@gmail.com','YWRtaW4=','Maurizio','Ricco','moris');

 

insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage, sesso) values(111,"Air Force 1 Nike Bianco", 100.00, "Preparati a volare con le nuove Nike Shoes", "Sneakers",3, "/Avenue813/immagini_prodotti/airforce1.png", "uomo");
insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage, sesso) values(222,"Felpa Fila Nera", 70.00, "Una bellissima felpa di cotone di colore nero ti attende", "Felpe",5, "/Avenue813/immagini_prodotti/felpafila.png","uomo");
insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage, sesso) values(333,"Cappello Adidas", 25.00, "Proteggiti dal caldo con un berretto Adidas", "Accessori",5, "/Avenue813/immagini_prodotti/cappelloadidas.png","uomo");
insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage, sesso) values(444,"Calzini Nike G/W/B", 12.00, "Di sicuro non sono calzini della Kappa", "Accessori",5, "/Avenue813/immagini_prodotti/calzini_gray_white_black.png","uomo");
insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage, sesso) values(555,"Ciabatte Adidas", 15.00, "Preparati ad andare al mare con Adidas", "Accessori",1, "/Avenue813/immagini_prodotti/ciabatte_adidas.png","uomo");
insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage, sesso) values(666,"T-Shirt Levi's", 35.00, "E' il momento che ti Levi's la maglia che indossi", "Maglie",3, "/Avenue813/immagini_prodotti/maglia_levis.png","uomo");
insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage, sesso) values(777,"Jeans Levi's", 75.00, "E' un pantalone incantevole", "Pantaloni",5, "/Avenue813/immagini_prodotti/pantaloni_levis.png","uomo");
/*??? sesso*/
 insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage,sesso) values(888,"Leggins Nike Gray", 65.00, "Un bellissimo leggins per le signore amanti dello sport", "Pantaloni",5, "/Avenue813/immagini_prodotti/leggins_gray.png", "donna");
 insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage,sesso)  values(999,"Tuta Adidas Completa", 70.00, "E' una semplice tuta però nero e fucsia",5, "Maglie", "/Avenue813/immagini_prodotti/adidas_tuta_completa.png", "donna");
 insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage,sesso)  values(112,"T-Shirt Fila", 23.00, "Una T-Shirt da donna con tutto rispetto", "Maglie",5, "/Avenue813/immagini_prodotti/tshirt_fila.png", "donna");
 insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage,sesso)  values(223,"Snearkers Fila Bianco", 115.00, "Beh... che FILA!", "Sneakers",10, "/Avenue813/immagini_prodotti/scarpe_fila.png", "donna");
 insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage,sesso)  values(334,"Calzini Adidas", 9.00, "Sono dei calzini petalosi", "Accessori",5, "/Avenue813/immagini_prodotti/calzini_adidas.png", "donna");
 insert into Prodotti(id_prodotti,nome, prezzo, descrizione, categoria, quantità,pathImage,sesso)  values(445,"Felpa Rosa Puma", 75.00, "Illumina i tuoi amici con la Felpa Puma Rosa", "Felpe",1, "/Avenue813/immagini_prodotti/felpa_rosa.png","donna");

 

insert into Ordini(id_ordini,indirizzo,method_pagament) values(789,"via casino n 21","carta");
insert into Ordini(id_ordini,indirizzo,method_pagament) values(987,"via macchie n 16","contanti");
insert into Ordini(id_ordini,indirizzo,method_pagament) values(456,"via roma n 33","carta");

 

insert into Contiene(id_ordini,id_prodotti) values(789,111);
insert into Contiene(id_ordini,id_prodotti) values(987,333);

 

insert into Effettua(id_ordini,id_utente,data,prezzo) values(789,123,"2021-11-14",30.5);

 

insert into Rivenditore(id_utente) values(123);

 

insert into Gestisce(id_prodotti,id_rivenditore,disponibilità) values(111,123,true);

 

insert into Amministratore(id_utente) values(258);