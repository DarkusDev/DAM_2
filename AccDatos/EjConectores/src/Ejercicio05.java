import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Ejercicio 5 (MySQL): clave primaria de la tabla departamentos con getPrimaryKeys(). */
public class Ejercicio05 {
    public static void main(String[] args) {
        try (Connection conexion = Conexiones.mysql()) {
            DatabaseMetaData dbmd = conexion.getMetaData();

            System.out.println("CLAVE PRIMARIA TABLA DEPARTAMENTOS:");
            System.out.println("===================================");
            try (ResultSet pk = dbmd.getPrimaryKeys(conexion.getCatalog(), null, "departamentos")) {
                while (pk.next()) {
                    System.out.printf("Clave Primaria: %s%n", pk.getString("COLUMN_NAME"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
