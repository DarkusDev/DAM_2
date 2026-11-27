import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Ejercicio 13 (Oracle): llama con CallableStatement al procedimiento almacenado
 * INSERTA_DEPARTAMENTO, que inserta un departamento nuevo en la tabla DEPARTAMENTOS.
 *
 * Antes hay que crear el procedimiento en Oracle: ver sql/oracle_procedimiento.sql
 */
public class Ejercicio13 {
    public static void main(String[] args) {
        int dep = Teclado.entero("Nº de departamento: ");
        String nombre = Teclado.texto("Nombre: ");
        String loc = Teclado.texto("Localidad: ");

        try (Connection conexion = Conexiones.oracle();
             CallableStatement cs = conexion.prepareCall("{call inserta_departamento(?, ?, ?)}")) {

            cs.setInt(1, dep);
            cs.setString(2, nombre);
            cs.setString(3, loc);
            cs.execute();

            System.out.printf("Departamento %d (%s, %s) insertado correctamente.%n", dep, nombre, loc);

        } catch (SQLException e) {
            System.out.println("NO SE HA INSERTADO EL DEPARTAMENTO:");
            System.out.printf("Mensaje   : %s%n", e.getMessage());
            System.out.printf("SQL estado: %s%n", e.getSQLState());
            System.out.printf("Cod error : %d%n", e.getErrorCode());
        }
    }
}
