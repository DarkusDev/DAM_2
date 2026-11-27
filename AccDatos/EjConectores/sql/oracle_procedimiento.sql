-- Ejercicio 13: procedimiento almacenado que inserta un departamento nuevo.
-- Ejecutar en SQL Developer con el usuario carlos (como script, F5).
CREATE OR REPLACE PROCEDURE inserta_departamento (
    p_dept_no NUMBER,
    p_dnombre VARCHAR2,
    p_loc     VARCHAR2
) AS
BEGIN
    INSERT INTO departamentos (dept_no, dnombre, loc)
    VALUES (p_dept_no, p_dnombre, p_loc);
END inserta_departamento;
/

-- Prueba rápida desde SQL Developer (opcional):
-- EXEC inserta_departamento(50, 'COMPRAS', 'VALENCIA');
-- SELECT * FROM departamentos;
