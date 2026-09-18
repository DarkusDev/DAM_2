import java.util.Scanner;
import java.io.File;

public class Ej9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombreDir = "";
        String nombre = "";
        String tipo = "";
        String path = "";
        Long tamaño = null;
        boolean permisoLectura = false;
        boolean permisoEscritura = false;
        boolean permisoEjecucion = false;

        System.out.println("Introduce el nombre del directorio que quieres buscar: ");
        nombreDir = sc.nextLine();

        File fHome = new File("/home/alumnom");

        File[] contenido = fHome.listFiles();

        try {
            for (File file : contenido) {
                if (file.getName().equals(nombreDir)) {

                    File[] contenidoDir = file.listFiles();

                    for (File file2 : contenidoDir) {
                        nombre = file2.getName();
                        if (file2.isDirectory()) {
                            tipo = "Directorio";
                        } else {
                            tipo = "Fichero";
                        }

                        if (file2.canRead()) {
                            permisoLectura = true;
                        }

                        if (file2.canWrite()) {
                            permisoEscritura = true;
                        }

                        if (file2.canExecute()) {
                            permisoEjecucion = true;
                        }

                        path = file2.getAbsolutePath();

                        tamaño = file2.length();

                        System.out.println("Nombre: " + nombre);
                        System.out.println("Path: " + path);
                        System.out.println("Tamaño: " + tamaño);
                        System.out.println("Fichero o directorio?: " + tipo);
                        System.out.println("Permiso lectura?: " + permisoLectura);
                        System.out.println("Permiso escritura?: " + permisoEscritura);
                        System.out.println("Permiso ejecucion?: " + permisoEjecucion);
                    }

                } else{
                    System.out.println("Directorio no encontrado");
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
