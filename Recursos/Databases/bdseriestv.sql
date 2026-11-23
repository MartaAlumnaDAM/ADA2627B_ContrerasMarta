CREATE SCHEMA bdseriestv DEFAULT CHARACTER SET utf8mb4 ;

USE bdseriestv ;

CREATE TABLE canalestv (
 codigo varchar(4) NOT NULL,
 nombre varchar(35) DEFAULT NULL,
 PRIMARY KEY (codigo)
);

CREATE TABLE series (
 codigo int(11) NOT NULL AUTO_INCREMENT,
 titulo varchar(60) DEFAULT NULL,
 canaltv varchar(4) DEFAULT NULL,
 duracion int(11) NOT NULL,
 PRIMARY KEY (codigo),
 FOREIGN KEY (canaltv) REFERENCES canalestv(codigo)
);

INSERT INTO canalestv (codigo, nombre) VALUES
('Neox', 'Neox'),
('Engy', 'Energy'),
('NetF', 'Netflix');

INSERT INTO series (titulo, canaltv, duracion) VALUES
('The Big Bang Theory', 'Neox', 22),
('C.S.I.: Miami', 'Engy', 43);
