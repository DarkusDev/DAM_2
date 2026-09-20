import java.util.Scanner;
import java.io.File;

public class Ej10 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        File dirInicial = new File(".");

        // Solo se borra la estructura creada en el Ej8, no todo el directorio actual
        File usr1 = new File(dirInicial, "usr1");
        File usr2 = new File(dirInicial, "usr2");

        try {

            borrar(usr1);
            borrar(usr2);

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        File[] contenido = dirInicial.listFiles();

        for (File f : contenido) {
            System.out.println(f);
        }
    }

    public static void borrar(File f) {

        if (!f.exists()) {
            System.out.println("No existe: " + f.getPath());
            return;
        }

        if (f.isDirectory()) {

            File[] contenido = f.listFiles();

            for (File hijo : contenido) {
                borrar(hijo);
            }

            // Se vuelve a mirar el contenido por si el usuario no ha borrado algo
            if (f.listFiles().length > 0) {
                System.out.println("El directorio " + f.getPath() + " no esta vacio, no se borra");
                return;
            }
        }

        String tipo = "";

        if (f.isDirectory()) {
            tipo = "el directorio";
        } else {
            tipo = "el fichero";
        }

        System.out.println("Quieres borrar " + tipo + " " + f.getPath() + "? (s/n)");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {

            if (f.delete()) {
                System.out.println("Borrado: " + f.getPath());
            } else {
                System.out.println("No se ha podido borrar: " + f.getPath());
            }

        } else {
            System.out.println("No se borra: " + f.getPath());
        }
    }

}
