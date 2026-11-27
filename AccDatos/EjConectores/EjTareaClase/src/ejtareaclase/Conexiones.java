/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejtareaclase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author profesor
 */
public class Conexiones {

    // ---- MySQL (XAMPP) ----
    public static final String MYSQL_URL = "jdbc:mysql://localhost/empdeptej";
    public static final String MYSQL_USUARIO = "root";
    public static final String MYSQL_CLAVE = "";

    // ---- SQLite: ruta al fichero .db (relativa o absoluta) ----
    // Ejemplo Windows: "jdbc:sqlite:F:\\_26_27_AD_DAM2\\2Conectores\\sqlite\\ejemplo.db"
    public static final String SQLITE_URL = "jdbc:sqlite:ejemplo.db";

    // ---- Oracle ----
    public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String ORACLE_USUARIO = "carlos";
    public static final String ORACLE_CLAVE = "carlos";

    public static Connection mysql() throws SQLException {
        return DriverManager.getConnection(MYSQL_URL, MYSQL_USUARIO, MYSQL_CLAVE);
    }

    public static Connection sqlite() throws SQLException {
        return DriverManager.getConnection(SQLITE_URL);
    }

    public static Connection oracle() throws SQLException {
        return DriverManager.getConnection(ORACLE_URL, ORACLE_USUARIO, ORACLE_CLAVE);
    }

    /** Devuelve la conexión según el nombre: "mysql", "sqlite" u "oracle". */
    public static Connection porNombre(String tipo) throws SQLException {
        switch (tipo.toLowerCase()) {
            case "mysql":
                return mysql();
            case "sqlite":
                return sqlite();
            case "oracle":
                return oracle();
            default:
                throw new IllegalArgumentException("Tipo de base de datos desconocido: " + tipo
                        + " (usa mysql, sqlite u oracle)");
        }
    }
}
