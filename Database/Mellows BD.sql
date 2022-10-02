CREATE DATABASE mellows;
USE mellows;
CREATE TABLE Livro (
idLivro INTEGER PRIMARY KEY auto_increment,
nomeLivro VARCHAR(50),
autor VARCHAR(30),
genero VARCHAR(10),
idUsuario integer(20)
);

CREATE TABLE LI (
idLi INTEGER PRIMARY KEY auto_increment,
nivel VARCHAR(15),
nome VARCHAR(50),
genero VARCHAR(50)
);

CREATE TABLE Login (
tipoLogin VARCHAR(10),
idLogin INTEGER PRIMARY KEY auto_increment
);

CREATE TABLE Usuario (
senha VARCHAR(15),
dataNascimento DATE,
nome VARCHAR(50),
email VARCHAR(20),
idUsuario integer(20) PRIMARY KEY auto_increment,
idLogin INTEGER,
FOREIGN KEY(idLogin) REFERENCES Login (idLogin)
);

ALTER TABLE Livro ADD FOREIGN KEY(idUsuario) REFERENCES Usuario (idUsuario);


CREATE VIEW usuario_login AS
    SELECT 
        u.*, l.idLogin AS login, l.tipoLogin
    FROM
        usuario u,
        login l
    WHERE
        u.idLogin = l.idLogin;
        
	CREATE VIEW livro_usuario AS
    SELECT 
        idLivro, nomeLivro, autor, genero, u.*
    FROM
        livro l,
        usuario u
    WHERE
        l.idUsuario = u.idUsuario
    ORDER BY idLivro;
 