import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Ejercicio 4 (MySQL): columnas de la tabla departamentos con getColumns().
 *  a) todas   b) las que empiezan por "d"   c) las que empiezan por "l" y tienen 3 caracteres
 *
 * Patrones: "%" = varios caracteres, "_" = un carácter.
 */
public class Ejercicio04 {
    public static void main(String[] args) {
        try (Connection conexion = Conexiones.mysql()) {
            DatabaseMetaData dbmd = conexion.getMetaData();
            String catalogo = conexion.getCatalog(); // MySQL: base de datos actual

            System.out.println("a) Todas las columnas");
            mostrarColumnas(dbmd, catalogo, null);

            System.out.println("b) Columnas que empiezan por \"d\"");
            mostrarColumnas(dbmd, catalogo, "d%");

            System.out.println("c) Columnas que empiezan por \"l\" y tienen tres caracteres");
            mostrarColumnas(dbmd, catalogo, "l__");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarColumnas(DatabaseMetaData dbmd, String catalogo, String patronColumna)
            throws SQLException {
        System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
        System.out.println("===================================");
        try (ResultSet columnas = dbmd.getColumns(catalogo, null, "departamentos", patronColumna)) {
            while (columnas.next()) {
                System.out.printf("Columna: %s, Tipo: %s, Tamaño: %d, ¿Puede ser Nula:? %s%n",
                        columnas.getString("COLUMN_NAME"),
                        columnas.getString("TYPE_NAME"),
                        columnas.getInt("COLUMN_SIZE"),
                        columnas.getString("IS_NULLABLE"));
            }
        }
        System.out.println();
    }
}
