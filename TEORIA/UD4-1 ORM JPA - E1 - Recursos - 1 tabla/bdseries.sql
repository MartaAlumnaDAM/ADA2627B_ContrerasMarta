CREATE SCHEMA bdseries DEFAULT CHARACTER SET utf8mb4;

USE bdseries;

CREATE TABLE series (
	codigo int(11) NOT NULL AUTO_INCREMENT,
	titulo varchar(60) DEFAULT NULL,
	tv varchar(35) DEFAULT NULL,
	duracion int(11) NOT NULL,
	PRIMARY KEY (codigo)
);

INSERT INTO series (titulo, tv, duracion) VALUES
	('The Big Bang Theory', 'Neox', 22),
	('C.S.I.: Miami', 'Energy', 43);

COMMIT;

SELECT * FROM bdseries;
