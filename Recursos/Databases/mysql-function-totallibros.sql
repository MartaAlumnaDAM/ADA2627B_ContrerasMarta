/* Eliminar la función si ya existe */
DROP FUNCTION IF EXISTS totallibros;

/* Crear la función */
DELIMITER //
CREATE FUNCTION totallibros() 
	RETURNS INT
  BEGIN
	DECLARE total INT;
	
	SELECT COUNT(*) INTO total FROM libros;

	RETURN total;
  END //
DELIMITER ;