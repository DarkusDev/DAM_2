import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Ejercicio 6 (MySQL): claves ajenas que REFERENCIAN a una tabla, con getExportedKeys().
 *  a) tabla departamentos   b) tabla empleados
 */
public class Ejercicio06 {
    public static void main(String[] args) {
        try (Connection conexion = Conexiones.mysql()) {
            DatabaseMetaData dbmd = conexion.getMetaData();
            String catalogo = conexion.getCatalog();

            for (String tabla : new String[]{"departamentos", "empleados"}) {
                System.out.println("CLAVES ajenas que referencian a " + tabla.toUpperCase() + ":");
                System.out.println("==============================================");
                try (ResultSet fk = dbmd.getExportedKeys(catalogo, null, tabla)) {
                    boolean hay = false;
                    while (fk.next()) {
                        hay = true;
                        System.out.printf("Tabla PK: %s, Clave Primaria: %s%n",
                                fk.getString("PKTABLE_NAME"), fk.getString("PKCOLUMN_NAME"));
                        System.out.printf("Tabla FK: %s, Clave Ajena: %s%n",
                                fk.getString("FKTABLE_NAME"), fk.getString("FKCOLUMN_NAME"));
                    }
                    if (!hay) {
                        System.out.println("(ninguna clave ajena referencia a esta tabla)");
                    }
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
