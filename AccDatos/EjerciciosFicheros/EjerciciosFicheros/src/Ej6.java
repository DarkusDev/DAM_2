import java.util.Scanner;
import java.io.File;

public class Ej6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre = "";
        String tipo = "";
        String path = "";
        Long tamaño = null;
        boolean permisoLectura = false;
        boolean permisoEscritura = false;
        boolean permisoEjecucion = false;

        System.out.println("Introduce el nombre que quieres buscar: ");
        nombre = sc.nextLine();

        File fHome = new File("/home/alumnom");

        File[] contenido = fHome.listFiles();

        for (File file : contenido) {
            if(file.getName().equals(nombre)){
                if(file.isDirectory()){
                    tipo = "Directorio";
                } else{
                    tipo = "Fichero";
                }

                if(file.canRead()){
                    permisoLectura = true;
                }

                if(file.canWrite()){
                    permisoEscritura = true;
                }

                if(file.canExecute()){
                    permisoEjecucion = true;
                }

                path = file.getAbsolutePath();

                tamaño = file.length();
            }
        }

        System.out.println("Nombre: "+ nombre);
        System.out.println("Path: "+ path);
        System.out.println("Tamaño: "+ tamaño);
        System.out.println("Fichero o directorio?: "+ tipo);
        System.out.println("Permiso lectura?: "+ permisoLectura);
        System.out.println("Permiso escritura?: "+ permisoEscritura);
        System.out.println("Permiso ejecucion?: "+ permisoEjecucion);
    }
}
