import java.util.Scanner;

/** Lectura sencilla por teclado, con reintento si el valor no es válido. */
public class Teclado {

    private static final Scanner S = new Scanner(System.in);

    public static String texto(String mensaje) {
        System.out.print(mensaje);
        return S.nextLine().trim();
    }

    public static int entero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(texto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("  Valor no válido, escribe un número entero.");
            }
        }
    }

    public static double decimal(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(texto(mensaje).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("  Valor no válido, escribe un número (ej. 100.50).");
            }
        }
    }
}
