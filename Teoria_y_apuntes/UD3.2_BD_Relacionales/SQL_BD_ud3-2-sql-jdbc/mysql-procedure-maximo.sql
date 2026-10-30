/* Eliminar el procedimiento si ya existe */
DROP PROCEDURE IF EXISTS maximo;

/* Crear el procedimiento */
DELIMITER //
CREATE PROCEDURE maximo(IN num1 DECIMAL(11,2), 
				IN num2 DECIMAL(11,2), 
				OUT num3 DECIMAL(11,2)) 
  BEGIN
	IF (num1>num2) THEN  
		SET num3 := num1;
	ELSE 
		SET num3 := num2;		
	END IF;

  END //
DELIMITER ;
