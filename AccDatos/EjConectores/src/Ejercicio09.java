import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Ejercicio 9 (MySQL): inserta un empleado en la tabla EMPLEADOS pidiendo los datos al usuario.
 *
 * Comprobaciones antes de insertar:
 *  - El departamento debe existir; si no existe, se inserta.
 *  - El número de empleado no puede existir ya.
 *  - El salario debe ser positivo (mayor que 0).
 *  - APELLIDO y OFICIO no pueden ser nulos (ni vacíos).
 *  - La fecha de alta es la fecha actual.
 *  - (Según la nota del enunciado) si se indica director, debe existir como empleado.
 *
 * Para no dejar la base de datos a medias (sin transacciones todavía), TODAS las
 * validaciones del empleado se hacen ANTES de insertar el departamento nuevo.
 */
public class Ejercicio09 {

    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // ---------- 1. Pedir los datos ----------
        Integer empNo = leerEntero("Nº de empleado (EMP_NO): ", false);
        String apellido = leerTexto("Apellido: ");
        String oficio = leerTexto("Oficio: ");
        Integer dir = leerEntero("Director (DIR, número de empleado; vacío = sin director): ", true);
        Double salario = leerDecimal("Salario: ", false);
        Double comision = leerDecimal("Comisión (vacío = sin comisión): ", true);
        Integer deptNo = leerEntero("Nº de departamento (DEPT_NO): ", false);

        // ---------- 2. Validaciones que no necesitan la base de datos ----------
        if (apellido.isEmpty()) {
            System.out.println("NO SE INSERTA: el apellido no puede ser nulo.");
            return;
        }
        if (oficio.isEmpty()) {
            System.out.println("NO SE INSERTA: el oficio no puede ser nulo.");
            return;
        }
        if (salario <= 0) {
            System.out.println("NO SE INSERTA: el salario debe ser positivo (mayor que 0).");
            return;
        }

        // ---------- 3. Conexión y validaciones contra la base de datos ----------
        try (Connection conexion = Conexiones.mysql()) {

            // a) El número de empleado no debe existir
            if (existe(conexion, "SELECT 1 FROM empleados WHERE emp_no = ?", empNo)) {
                System.out.printf("NO SE INSERTA: el número de empleado %d ya existe (duplicado).%n", empNo);
                return;
            }

            // b) Si se ha indicado director, debe existir
            if (dir != null && !existe(conexion, "SELECT 1 FROM empleados WHERE emp_no = ?", dir)) {
                System.out.printf("NO SE INSERTA: el director %d no existe.%n", dir);
                return;
            }

            // c) ¿Existe el departamento? Si no, pedimos sus datos (aún no lo insertamos)
            boolean deptoExiste = existe(conexion, "SELECT 1 FROM departamentos WHERE dept_no = ?", deptNo);
            String dnombre = null;
            String loc = null;
            if (!deptoExiste) {
                System.out.printf("El departamento %d no existe, se va a crear.%n", deptNo);
                dnombre = leerTexto("  Nombre del departamento: ");
                loc = leerTexto("  Localidad: ");
            }

            // ---------- 4. Inserciones (ya está todo validado) ----------
            if (!deptoExiste) {
                String sqlDep = "INSERT INTO departamentos VALUES (?, ?, ?)";
                try (PreparedStatement ps = conexion.prepareStatement(sqlDep)) {
                    ps.setInt(1, deptNo);
                    ps.setString(2, dnombre);
                    ps.setString(3, loc);
                    ps.executeUpdate();
                    System.out.printf("Departamento %d (%s) insertado.%n", deptNo, dnombre);
                }
            }

            String sqlEmp = "INSERT INTO empleados "
                    + "(emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(sqlEmp)) {
                ps.setInt(1, empNo);
                ps.setString(2, apellido);
                ps.setString(3, oficio);
                if (dir == null) {
                    ps.setNull(4, java.sql.Types.SMALLINT);
                } else {
                    ps.setInt(4, dir);
                }
                ps.setDate(5, Date.valueOf(LocalDate.now())); // fecha de alta = hoy
                ps.setDouble(6, salario);
                if (comision == null) {
                    ps.setNull(7, java.sql.Types.FLOAT);
                } else {
                    ps.setDouble(7, comision);
                }
                ps.setInt(8, deptNo);

                int filas = ps.executeUpdate();
                System.out.printf("EMPLEADO INSERTADO CORRECTAMENTE. Filas afectadas: %d%n", filas);
            }

        } catch (SQLException e) {
            System.out.println("HA OCURRIDO UNA EXCEPCIÓN:");
            System.out.printf("Mensaje   : %s%n", e.getMessage());
            System.out.printf("SQL estado: %s%n", e.getSQLState());
            System.out.printf("Cod error : %d%n", e.getErrorCode());
        }
    }

    /** Devuelve true si la consulta (con un único parámetro entero) devuelve alguna fila. */
    private static boolean existe(Connection conexion, String sql, int valor) throws SQLException {
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, valor);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    // ---------- Lectura por teclado ----------

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine().trim();
    }

    /** Lee un entero. Si opcional es true, una línea vacía devuelve null. Repite hasta que sea válido. */
    private static Integer leerEntero(String mensaje, boolean opcional) {
        while (true) {
            String texto = leerTexto(mensaje);
            if (texto.isEmpty() && opcional) {
                return null;
            }
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("  Valor no válido, escribe un número entero.");
            }
        }
    }

    /** Lee un decimal. Si opcional es true, una línea vacía devuelve null. Repite hasta que sea válido. */
    private static Double leerDecimal(String mensaje, boolean opcional) {
        while (true) {
            String texto = leerTexto(mensaje).replace(',', '.');
            if (texto.isEmpty() && opcional) {
                return null;
            }
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("  Valor no válido, escribe un número (ej. 1500.50).");
            }
        }
    }
}
