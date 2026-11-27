import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Ejercicio 3: información de la base de datos con DatabaseMetaData.
 *
 * Uso: java Ejercicio03 [mysql|sqlite|oracle]   (por defecto: mysql)
 * Ejecútalo con "oracle" y con "sqlite" para el ejercicio.
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        String tipo = (args.length > 0) ? args[0] : "mysql";

        try (Connection conexion = Conexiones.porNombre(tipo)) {
            DatabaseMetaData dbmd = conexion.getMetaData();

            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.println("===================================");
            System.out.printf("Nombre : %s %n", dbmd.getDatabaseProductName());
            System.out.printf("Driver : %s %n", dbmd.getDriverName());
            System.out.printf("URL    : %s %n", dbmd.getURL());
            System.out.printf("Usuario: %s %n", dbmd.getUserName());
            System.out.println();

            // Para no listar tablas de sistema de otras bases de datos / esquemas:
            //  - MySQL: se limita al catálogo (base de datos) actual.
            //  - Oracle: se limita al esquema del usuario conectado.
            String catalogo = tipo.equalsIgnoreCase("mysql") ? conexion.getCatalog() : null;
            String esquema = tipo.equalsIgnoreCase("oracle") ? dbmd.getUserName() : null;
            String[] tipos = {"TABLE", "VIEW"};

            System.out.println("TABLAS Y VISTAS:");
            try (ResultSet resul = dbmd.getTables(catalogo, esquema, null, tipos)) {
                while (resul.next()) {
                    System.out.printf("Tipo: %s - Catalogo: %s, Esquema: %s, Nombre: %s %n",
                            resul.getString("TABLE_TYPE"), resul.getString("TABLE_CAT"),
                            resul.getString("TABLE_SCHEM"), resul.getString("TABLE_NAME"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
