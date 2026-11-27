import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejercicio 2 (SQLite): visualiza los departamentos.
 * (La parte a: crear las tablas en SQLite, está en sql/sqlite_ejemplo.sql)
 *
 * Uso: java Ejercicio02 [ruta_al_fichero.db]
 * Sin argumento usa la URL de Conexiones.SQLITE_URL.
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        try (Connection conexion = (args.length > 0)
                ? DriverManager.getConnection("jdbc:sqlite:" + args[0])
                : Conexiones.sqlite();
             Statement sentencia = conexion.createStatement();
             ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos")) {

            while (resul.next()) {
                System.out.printf("%d, %s, %s %n",
                        resul.getInt(1), resul.getString(2), resul.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
