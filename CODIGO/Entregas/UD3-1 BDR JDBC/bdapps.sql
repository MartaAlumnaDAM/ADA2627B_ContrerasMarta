/*
Realiza un script denominado bdapps.sql con instrucciones SQL para:
• Crea una base de datos desde Workbench llamada "bdapps".
• Crear en ella una tabla "programas" para guardar una colección de
software. En una primera aproximación guardaremos sólo tres
campos: un código, un nombre y la carpeta de instalación.
• Introducir dos datos de ejemplo y comprueba que se han almacenado
correctamente.
*/
DROP DATABASE IF EXISTS bdapps;
CREATE SCHEMA bdapps;
USE bdapps;

CREATE TABLE programas(
	código int PRIMARY KEY,
    nombre varchar(50) NOT NULL,
    carpeta_instalación varchar(100)
);

INSERT into programas VALUES
(1, "Android", "C:\Program Files\Android"),
(2, "Docker", "C:\Program Files\Docker"),
(3, "Git", "C:\Program Files\Git")
;

SELECT * FROM programas;

