import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejercicio 1 (MySQL):
 *  a) Apellido, oficio y salario de los empleados del departamento 10.
 *  b) Apellido del empleado con salario máximo, con su salario y el nombre del departamento.
 */
public class Ejercicio01 {
    public static void main(String[] args) {
        try (Connection conexion = Conexiones.mysql();
             Statement sentencia = conexion.createStatement()) {

            // a)
            System.out.println("a) Empleados del departamento 10:");
            String sqlA = "SELECT apellido, oficio, salario FROM empleados WHERE dept_no = 10";
            try (ResultSet rs = sentencia.executeQuery(sqlA)) {
                while (rs.next()) {
                    System.out.printf("   %s, %s, %.2f%n",
                            rs.getString("apellido"), rs.getString("oficio"), rs.getDouble("salario"));
                }
            }

            // b) Se usa una subconsulta para que, si hay empates en el máximo, salgan todos
            System.out.println("b) Empleado(s) con salario máximo:");
            String sqlB = "SELECT e.apellido, e.salario, d.dnombre "
                    + "FROM empleados e JOIN departamentos d ON e.dept_no = d.dept_no "
                    + "WHERE e.salario = (SELECT MAX(salario) FROM empleados)";
            try (ResultSet rs = sentencia.executeQuery(sqlB)) {
                while (rs.next()) {
                    System.out.printf("   %s, salario: %.2f, departamento: %s%n",
                            rs.getString("apellido"), rs.getDouble("salario"), rs.getString("dnombre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
