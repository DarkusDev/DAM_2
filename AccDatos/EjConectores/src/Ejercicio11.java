import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** Ejercicio 11 (MySQL): incrementa el salario de los empleados de un departamento con PreparedStatement. */
public class Ejercicio11 {
    public static void main(String[] args) {
        int dep = Teclado.entero("Nº de departamento: ");
        double subida = Teclado.decimal("Incremento de salario: ");

        String sql = "UPDATE empleados SET salario = salario + ? WHERE dept_no = ?";

        try (Connection conexion = Conexiones.mysql();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setDouble(1, subida);
            ps.setInt(2, dep);
            int filas = ps.executeUpdate();

            if (filas == 0) {
                System.out.printf("No hay empleados en el departamento %d (o no existe).%n", dep);
            } else {
                System.out.printf("Empleados modificados: %d %n", filas);
            }

        } catch (SQLException e) {
            System.out.printf("Mensaje   : %s%n", e.getMessage());
            System.out.printf("SQL estado: %s%n", e.getSQLState());
            System.out.printf("Cod error : %d%n", e.getErrorCode());
        }
    }
}
