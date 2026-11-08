/*
UD3Ejer102
Escribe las instrucciones SQL en un archivo denominado bdtasks.sql para:
• Crear una base de datos llamada "bdtasks", que usaremos para
anotar tareas.
• Crear en ella una única tabla llamada "tasks", con dos campos: el
código de la tarea (numérico, que será clave primaria) y la
descripción de la tarea.
• Añadir dos tareas: la 1 será "Repasar SQL" y la 2 será "Instalar
NetBeans".
• Modifica la tabla para añadir dos campos (al final de los ya
existentes): uno será la fecha prevista para la tarea (tipo date)
y otro será si está terminada o no (tipo boolean).
• Modifica la primera tarea para que tenga fecha de mañana y no esté
terminada, y la segunda para que tenga fecha de pasado mañana y
tampoco esté terminada.
• Añade dos tareas más.
• Muestra las tareas cuyo código sea inferior a 3.
• Muestra las tareas cuya descripcion contenga la palabra
"instalar".
• Muestra el código de la última tarea (el mayor código).
• Muestra la cantidad de tareas almacenadas.
• Muestra la cantidad de tareas que hay para cada día.
• Muestra el código de la tarea más antigua (menor código) que
contenga la palabra "NetBeans".
• Muestra la descripción y fecha_prevista de las tareas cuyo código
es superior al código de la tarea más antigua (menor código) que
contenga la palabra "NetBeans".
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
