import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Ejercicio 12 (MySQL): con PreparedStatement muestra apellido, oficio y salario de los empleados
 * de un departamento (pedido por teclado), el nombre del departamento, el salario medio y el nº de empleados.
 * Si el departamento no existe, lo indica.
 */
public class Ejercicio12 {

    // Formato español: 2.985,00 (se fija el patrón para que siempre agrupe los miles)
    private static final DecimalFormat DINERO =
            new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.forLanguageTag("es-ES")));

    public static void main(String[] args) {
        int dep = Teclado.entero("Nº de departamento: ");

        try (Connection conexion = Conexiones.mysql()) {

            // 1) ¿Existe el departamento?
            String nombre;
            try (PreparedStatement ps = conexion.prepareStatement(
                    "SELECT dnombre FROM departamentos WHERE dept_no = ?")) {
                ps.setInt(1, dep);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        System.out.printf("El departamento %d no existe.%n", dep);
                        return;
                    }
                    nombre = rs.getString("dnombre");
                }
            }

            String linea = "======================================";
            System.out.println(linea);
            System.out.printf("DEPARTAMENTO: %d ==> %s%n", dep, nombre);
            System.out.println(linea);

            // 2) Empleados del departamento
            double suma = 0;
            int numero = 0;
            try (PreparedStatement ps = conexion.prepareStatement(
                    "SELECT apellido, oficio, salario FROM empleados WHERE dept_no = ? ORDER BY apellido")) {
                ps.setInt(1, dep);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        double salario = rs.getDouble("salario");
                        System.out.printf("%s, %s, %s%n",
                                rs.getString("apellido"), rs.getString("oficio"), DINERO.format(salario));
                        suma += salario;
                        numero++;
                    }
                }
            }

            // 3) Resumen
            double media = (numero > 0) ? suma / numero : 0;
            System.out.println(linea);
            System.out.printf("Salario Medio: %s%n", DINERO.format(media));
            System.out.printf("Número de empleados: %d%n", numero);
            System.out.println(linea);

        } catch (SQLException e) {
            System.out.printf("Mensaje   : %s%n", e.getMessage());
            System.out.printf("SQL estado: %s%n", e.getSQLState());
            System.out.printf("Cod error : %d%n", e.getErrorCode());
        }
    }
}
