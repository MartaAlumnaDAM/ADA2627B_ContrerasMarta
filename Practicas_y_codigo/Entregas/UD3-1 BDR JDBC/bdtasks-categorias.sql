/*
UD3Ejer103
Escribe las instrucciones SQL sobre la BD "bdtasks" creada anteriormente
en un archivo denominado bdtasks-categorias.sql para:
• Crea una nueva tabla "categorias". Cada categoría tendrá dos
campos: un código (texto de 10, clave primaria) y la descripción
(texto de 60).
• Añade la categoría "E", "Estudios" y la categoría "O", "Ocio".
• Modifica la tabla "tasks" para añadir el código de categoría
("codcateg").
• Asigna la categoría "E" a las tareas 1 y 2.
• Muestra la descripción de todas las tareas, junto con la
descripción de la categoría a la que pertenecen, para todas las
categorías de las que se haya indicado descripción.
• Muestra la descripción de todas las tareas, junto con la
descripción de la categoría a la que pertenecen o NULL en caso de
que no se haya indicado esa categoría.
• Muestra la descripción de todas las tareas, junto con la
descripción de la categoría a la que pertenecen o "(Ninguna)" en
caso de que no se haya indicado esa categoría.
• Muestra la descripción de todas las tareas, junto con la
descripción de la categoría a la que pertenecen, para todas las
tareas (puede que alguna categoría aparezca como NULL) y para
todas las categorías (y puede que alguna tarea aparezca como NULL,
si esa categoría no tiene tareas asignadas).(Puedes usar UNION)
Ejecuta todas las instrucciones SQL desde Workbench.
*/

/* Crea la base de datos*/
DROP DATABASE IF EXISTS bdtasks;
CREATE SCHEMA bdtasks;
USE bdtasks;
DROP TABLE IF EXISTS tasks;

/* Crea única tabla */
CREATE TABLE tasks(
	codigo INT PRIMARY KEY,
    descripcion VARCHAR(50)
);

/* Añade dos tareas */
INSERT INTO tasks VALUES
	(1, "Repasar SQL"),
    (2, "Instalar NetBeans");

/* Agrega dos campos a la tabla */
ALTER TABLE tasks
	ADD fecha_prevista DATE,
	ADD terminada BOOLEAN;

/* Modifica primera tarea */
UPDATE tasks
SET fecha_prevista = "2026-10-31",
    terminada = false
WHERE codigo = 1;

/* Modifica segunda tarea */
UPDATE tasks
SET fecha_prevista = "2026-11-01",
	terminada = false
WHERE codigo = 2;

/* Agrega dos tareas más */
INSERT INTO tasks VALUES
	(3, "Estudiar JSON", "2026-11-02", false),
    (4, "Estudiar JDBC", "2026-11-03", false);

/*Muestra las tareas cuyo código sea inferior a 3*/
SELECT * FROM tasks WHERE codigo < 3;

/* Muestra las tareas donde cuya descripción contenta 'instalar'*/

SELECT * FROM tasks WHERE descripcion LIKE '%instalar%';

/* Muestra el código de la´última tarea*/
SELECT MAX(codigo) FROM tasks;

/* Muestra la cantidad de tareas almacenadas */
SELECT COUNT(codigo) FROM tasks;

/* Muestra la cantidad de tareas que hay para cada día */
SELECT fecha_prevista AS "Fecha prevista", COUNT(codigo) AS "Tareas por dìa" FROM tasks GROUP BY fecha_prevista;

/* Muestra el código de la tarea más antigua (menor código) que contenga la palabra 'Netbeans' */
SELECT MIN(codigo) AS 'Tarea antigua sobre Netbeans' FROM tasks WHERE descripcion LIKE '%Netbeans%';

/* Muestra las tareas cuyo còdigo es superior a la tarea más antigua que contiene 'Netbeans' */
SELECT descripcion, fecha_prevista FROM tasks WHERE codigo > 
	(SELECT MIN(codigo) AS 'Tarea antigua sobre Netbeans' FROM tasks WHERE descripcion LIKE '%Netbeans%');
    
/* UD3Ejer103 */

/* Crea tabla categorìas */
DROP TABLE IF EXISTS categorias;
CREATE TABLE categorias(
	codigo VARCHAR(10) PRIMARY KEY,
    descripcion VARCHAR(60)
);

/*Agrega dos categorías*/
INSERT INTO categorias VALUES
	("E", "Estudios"),
    ("O", "Ocio");

/* Agrega la categoría a la tabla tareas*/



