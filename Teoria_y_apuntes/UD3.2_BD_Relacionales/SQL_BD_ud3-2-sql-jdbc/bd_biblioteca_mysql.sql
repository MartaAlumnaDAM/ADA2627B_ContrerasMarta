CREATE SCHEMA biblioteca DEFAULT CHARACTER SET utf8mb4 
                         COLLATE utf8mb4_general_ci;

USE biblioteca ;

CREATE TABLE libros ( 
	id 		INT PRIMARY KEY AUTO_INCREMENT, 
	titulo 	VARCHAR(60), 
	autor 	VARCHAR(60)
);

INSERT INTO libros ( titulo, autor ) VALUES 
  ('Macbeth', 'William Shakespeare'),
  ('La Celestina (Tragicomedia de Calisto y Melibea)', 'Fernando de Rojas'),
  ('El Lazarillo de Tormes', 'Anónimo'),
  ('20.000 Leguas de Viaje Submarino', 'Julio Verne'),
  ('Alicia en el País de las Maravillas', 'Lewis Carrol'),
  ('Cien Años de Soledad', 'Gabriel García Márquez'),
  ('La tempestad', 'William Shakespeare');
	
COMMIT;