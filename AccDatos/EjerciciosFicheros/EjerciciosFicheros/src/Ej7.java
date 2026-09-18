import java.util.Scanner;
import java.io.File;

public class Ej7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre = "";
        boolean permisoLectura = false;
        boolean permisoEjecucion = false;

        System.out.println("Introduce el nombre que quieres buscar: ");
        nombre = sc.nextLine();

        File fHome = new File("/home/alumnom");

        File[] contenido = fHome.listFiles();

        try {
            for (File file : contenido) {
                if (file.getName().equals(nombre)) {

                    if (file.canExecute() && file.canRead()) {
                        file.setExecutable(false);
                        file.setReadable(false);

                        System.out.println("Archivo modficado correctamente");
                    }
                } else {
                    System.out.println("No existe fichero o no se puede leer y ejecutar");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }

    }
}
