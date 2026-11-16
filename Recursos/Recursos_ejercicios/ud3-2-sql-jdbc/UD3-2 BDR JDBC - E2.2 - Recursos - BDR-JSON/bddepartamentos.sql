CREATE SCHEMA bddepartamentos DEFAULT CHARACTER SET utf8mb4 ;

USE bddepartamentos ;

DROP TABLE IF EXISTS departamentos;

CREATE TABLE departamentos (
	dept_no INT(2) NOT NULL PRIMARY KEY,
	dnombre VARCHAR(15),
	loc VARCHAR(15)
);

INSERT INTO departamentos VALUES (10,'CONTABILIDAD','SEVILLA');
INSERT INTO departamentos VALUES (20,'INVESTIGACIÓN','MADRID');
INSERT INTO departamentos VALUES (30,'VENTAS','BARCELONA');
INSERT INTO departamentos VALUES (40,'PRODUCCIÓN','BILBAO');

COMMIT;

SELECT dept_no, dnombre, loc FROM departamentos;

