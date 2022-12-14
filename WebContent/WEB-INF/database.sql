DROP DATABASE IF EXISTS AZIENDA2;
CREATE DATABASE AZIENDA2;
USE AZIENDA2;

DROP USER IF EXISTS 'c'@'localhost';
CREATE USER 'UserAzienda2'@'localhost' IDENTIFIED BY 'user';
GRANT ALL ON AZIENDA2.* TO 'UserAzienda2'@'localhost';

CREATE TABLE Prodotto( 
    codice      SMALLINT AUTO_INCREMENT NOT NULL,
    nome        VARCHAR(100) NOT NULL,
    tipo        ENUM ('Videogame','Console','Computer','Elettrodomestici','Altro') NOT NULL DEFAULT 'Altro', 
    descrizione VARCHAR(300) NOT NULL,
    prezzo      DOUBLE NOT NULL,
    quantita    INT NOT NULL,
	inserimento DATE,
	
    PRIMARY KEY (codice)
);

CREATE TABLE Utente( 
    nome      VARCHAR(30) NOT NULL,
    cognome   VARCHAR(30) NOT NULL,
    email     VARCHAR(30) NOT NULL,
    password  VARCHAR(20) NOT NULL,
    tipo      ENUM ('user','admin') NOT NULL,
    indirizzo VARCHAR(30),

    PRIMARY KEY (email)
);

CREATE TABLE Carta( 
	scadenza DATE NOT NULL,
	titolare VARCHAR(30) NOT NULL,
	cvc SMALLINT NOT NULL,
	numero CHAR(12) NOT NULL,
	
	PRIMARY KEY(numero)
);

CREATE TABLE Ordine( 
	idOrdine         INT AUTO_INCREMENT NOT NULL UNIQUE,
    dataOrdine       DATE NOT NULL,
    dataConsegna     DATE ,
	orarioOrdine     TIME NOT NULL,
    orarioConsegna   TIME,
    prodotto         SMALLINT NOT NULL,
    prezzoProdotto   DOUBLE NOT NULL,
    quantitaProdotto INT NOT NULL,
    ivaProdotto      INT NOT NULL,
    utente           VARCHAR(30) NOT NULL,
    indirizzoSpedizione  VARCHAR(30) NOT NULL,
    cartaUsata		 CHAR(12) NOT NULL,
    
    PRIMARY KEY (idOrdine),
    
    FOREIGN KEY (utente)   REFERENCES Utente(email) ON UPDATE CASCADE,
    FOREIGN KEY (prodotto) REFERENCES Prodotto(codice) ON UPDATE CASCADE,
    FOREIGN KEY (cartaUsata) REFERENCES Carta(numero) ON UPDATE CASCADE
);

CREATE TABLE Possiede(
	emailUtente VARCHAR(30) NOT NULL,
	numeroCarta CHAR(12) NOT NULL,
	
	PRIMARY KEY(numeroCarta),
	FOREIGN KEY (emailUtente) REFERENCES Utente(email) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (numeroCarta) REFERENCES Carta(numero) ON UPDATE CASCADE
);

CREATE TABLE Telefono( 
	utente VARCHAR(30) NOT NULL,
    numero CHAR(10) NOT NULL,

    PRIMARY KEY (numero),
    FOREIGN KEY (utente) REFERENCES Utente(email) ON UPDATE CASCADE ON DELETE CASCADE 
);

CREATE TABLE Recensione( 
	id       INT NOT NULL AUTO_INCREMENT,
	testo    VARCHAR(100) NOT NULL,
    utente   VARCHAR(30) NOT NULL,
    prodotto SMALLINT NOT NULL,
    stelle   INT,
    
    PRIMARY KEY(id),
    FOREIGN KEY (utente)   REFERENCES Utente(email)    ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (Prodotto) REFERENCES Prodotto(codice) ON UPDATE CASCADE ON DELETE CASCADE
);
