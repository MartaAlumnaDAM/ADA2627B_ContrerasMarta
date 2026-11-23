CREATE SCHEMA bdagenda DEFAULT CHARACTER SET utf8mb4 ;
USE bdagenda ;
CREATE TABLE tareas (
 codigo INT(4) ZEROFILL AUTO_INCREMENT NOT NULL,
 fecha DATE,
 descripcion VARCHAR(40) DEFAULT NULL,
 completada BOOLEAN,
 PRIMARY KEY (codigo)
);
INSERT INTO tareas (fecha, descripcion, completada) VALUES
('2019-10-15', 'Instalar Netbeans', true),
('2019-10-18', 'Realizar UD3Ejer201', true),
('2019-10-20', 'Copia de Seguridad', false);
