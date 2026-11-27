import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/** Ejercicio 8 (MySQL): información de las columnas de la tabla empleados con ResultSetMetaData. */
public class Ejercicio08 {
    public static void main(String[] args) {
        try (Connection conexion = Conexiones.mysql();
             Statement sentencia = conexion.createStatement();
             ResultSet rs = sentencia.executeQuery("SELECT * FROM empleados")) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int nColumnas = rsmd.getColumnCount();
            System.out.printf("Número de columnas recuperadas: %d%n", nColumnas);

            for (int i = 1; i <= nColumnas; i++) {
                String nula = (rsmd.isNullable(i) == ResultSetMetaData.columnNoNulls) ? "NO" : "SI";
                System.out.printf("Columna %d: %n", i);
                System.out.printf("  Nombre: %s %n  Tipo: %s %n", rsmd.getColumnName(i), rsmd.getColumnTypeName(i));
                System.out.printf("  Puede ser nula?: %s %n", nula);
                System.out.printf("  Máximo ancho de la columna: %d %n", rsmd.getColumnDisplaySize(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
