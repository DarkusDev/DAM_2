import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Ejercicio 7 (MySQL): claves ajenas EXISTENTES en una tabla, con getImportedKeys().
 *  a) tabla empleados   b) tabla departamentos
 */
public class Ejercicio07 {
    public static void main(String[] args) {
        try (Connection conexion = Conexiones.mysql()) {
            DatabaseMetaData dbmd = conexion.getMetaData();
            String catalogo = conexion.getCatalog();

            for (String tabla : new String[]{"empleados", "departamentos"}) {
                System.out.println("CLAVES ajenas en " + tabla.toUpperCase() + ":");
                System.out.println("==============================================");
                try (ResultSet fk = dbmd.getImportedKeys(catalogo, null, tabla)) {
                    boolean hay = false;
                    while (fk.next()) {
                        hay = true;
                        System.out.printf("Tabla PK: %s, Clave Primaria: %s%n",
                                fk.getString("PKTABLE_NAME"), fk.getString("PKCOLUMN_NAME"));
                        System.out.printf("Tabla FK: %s, Clave Ajena: %s%n",
                                fk.getString("FKTABLE_NAME"), fk.getString("FKCOLUMN_NAME"));
                    }
                    if (!hay) {
                        System.out.println("(esta tabla no tiene claves ajenas)");
                    }
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
