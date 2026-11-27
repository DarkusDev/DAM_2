import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejercicio 10 (MySQL): lanza un script SQL (scriptmysql.sql) en una base de datos nueva llamada "ies".
 * Para poder ejecutar varias sentencias de una vez se usa la propiedad allowMultiQueries=true.
 *
 * Uso: java Ejercicio10 [ruta_al_script.sql]   (por defecto: scriptmysql.sql en la carpeta actual)
 *
 * Limitación: JDBC no entiende el comando DELIMITER del cliente mysql, así que si el script
 * define procedimientos o triggers con DELIMITER, habría que ejecutarlos aparte.
 */
public class Ejercicio10 {
    public static void main(String[] args) {
        String ruta = (args.length > 0) ? args[0] : "scriptmysql.sql";
        String base = "jdbc:mysql://localhost/";

        try {
            String script = Files.readString(Path.of(ruta), StandardCharsets.UTF_8);

            // 1) Crear la base de datos ies (si no existe)
            try (Connection c = DriverManager.getConnection(base + "?allowMultiQueries=true",
                    Conexiones.MYSQL_USUARIO, Conexiones.MYSQL_CLAVE);
                 Statement st = c.createStatement()) {
                st.executeUpdate("CREATE DATABASE IF NOT EXISTS ies");
                System.out.println("Base de datos ies lista.");
            }

            // 2) Conectar a ies y lanzar todo el script de una vez
            try (Connection c = DriverManager.getConnection(base + "ies?allowMultiQueries=true",
                    Conexiones.MYSQL_USUARIO, Conexiones.MYSQL_CLAVE);
                 Statement st = c.createStatement()) {

                boolean hayResultSet = st.execute(script);
                int resultados = 0;
                // Recorremos los resultados de cada sentencia del script
                while (hayResultSet || st.getUpdateCount() != -1) {
                    resultados++;
                    hayResultSet = st.getMoreResults();
                }
                System.out.printf("Script %s ejecutado (%d sentencias con resultado).%n", ruta, resultados);
            }

        } catch (java.io.IOException e) {
            System.out.println("No se pudo leer el script '" + ruta + "': " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("ERROR al ejecutar el script:");
            System.out.printf("Mensaje   : %s%n", e.getMessage());
            System.out.printf("SQL estado: %s%n", e.getSQLState());
            System.out.printf("Cod error : %d%n", e.getErrorCode());
        }
    }
}
